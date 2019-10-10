# メモ書き

- 指定するパラメータ
    - チェック条件となる要素配列の配置場所。とバッファ種別。
    - チェック対象となる要素群の指定場所。とバッファ種別。

条件に合ったデータを抽出してResultInfoのActionInfoに格納する。
それ以外のResultInfoの情報は下位のEvaluateの結果を引き継ぐ。
このためEvaluateTreeの先頭に記載すること。
どのActionの情報として格納するかはConditionBaseが保持するActionTypeに登録する。

```
ActionInfo:{
  "1":[
    [
      {XXX},
      {YYY}
    ],
    [
      {XXX},
      {YYY}
    ],
    [
      {XXX},
      {YYY}
    ]
  ]
  "2":[
    ・・・
  ]
}
```
ActionBaseはActionInfoから起動対象のActionTypeを検索し、取得した配列の行数分だけActionを実行する。検索でヒットしなかったら一度だけ実行する。

# plantumlのフォーマット

```plantuml
@startuml
skinparam linetype ortho
skinparam componentStyle uml2

@enduml
```