package main

import(
  "fmt"
  "context"
  "encoding/json"
)

type MyInput struct {
  Name string `json:"Name"`
}

type MyInput2 struct {
  ConvertName string `json:"Name"`
}

func NewInput() ( interface{} ){
  return new(MyInput)
}

func MyFunction( ctx context.Context, inputParam interface{} ) (bool, error) {
  l_InputParam := inputParam.(*MyInput)
  l_InputByte,_ := json.Marshal(inputParam)
  var l_InputParam2 MyInput2
  json.Unmarshal(l_InputByte, &l_InputParam2)
  fmt.Println( "l_InputParam.Name: ",l_InputParam.Name )
  fmt.Println( "l_InputParam2.Name:",l_InputParam2.ConvertName )
  fmt.Println( "ctx.Value(Request).(string)",ctx.Value("Request").(string) )

  return true , nil
}
