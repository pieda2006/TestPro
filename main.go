package main

import (
  "fmt"
  "reflect"
  "encoding/json"
  "plugin"
  "context"
)

func main() {
  //Request受信
  //Context生成
  ctx := context.Background()
  //ライブラリ読み込み
  //ファイル名はユーザに入力してもらう。(今回は決め打ち)
  l_Plugin, _ := plugin.Open("./solib.so")
  l_Function, _ := l_Plugin.Lookup("MyFunction")
  l_Input, _ := l_Plugin.Lookup("NewInput")
  fmt.Println("reflect.TypeOf(l_Input): ",reflect.TypeOf(l_Input))
  l_NewInterface := l_Input.( func() ( interface{} ) )()
  fmt.Println("reflect.TypeOf(l_NewInterface): ",reflect.TypeOf(l_NewInterface))
  //InputとなるJsonデータ
  jsonString := `{"Name":"test"}`

  ctx = context.WithValue( ctx, "Request", jsonString)

  json.Unmarshal([]byte(jsonString), l_NewInterface)
  fmt.Println("l_NewInterface: ",l_NewInterface)

  l_bool,_ := l_Function.( func( context.Context, interface{} ) ( bool,error ) )( ctx, l_NewInterface )
  fmt.Println("Function Result: ", l_bool )

  fmt.Println( "ctx.Value( Request ).(string): ", ctx.Value( "Request" ).(string) )

}
