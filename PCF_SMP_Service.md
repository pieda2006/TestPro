# SMPサービス

## MariaDB設定

### mariadbのdocker imageを取得

```
docker pull mariadb
```

### mariadbのコンテナ起動

```
docker run -p 11200:3306 --name some-mariadb -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mariadb
```

### mariadbコンテナログイン

```
docker exec -it some-mariadb bash
```

### mariadbログイン

```
mysql -u root -p
Enter password:
```

### DataBase作成

- DataBase作成。

    ```
    create database PCF
    ```

- DataBaseへ移動

    ```
    use PCF
    ```

### CONFIG用Table作成

```
CREATE TABLE `CONFIG` (
`ID` INT NOT NULL,
`VALUE` JSON DEFAULT NULL,
PRIMARY KEY (`ID`)
) ENGINE=InnoDB;
```

### CONFIG登録

```
REPLACE INTO CONFIG VALUES(1,'
{
  "EvaluateClass": [
    {
      "OperationType" : 0,
      "ClassName" : "fivegc.pcf.smp.domain.service.api.EvaluateCompare"
    },
    {
      "OperationType" : 1,
      "ClassName" : "fivegc.pcf.smp.domain.service.api.EvaluateCompare"
    },
    {
      "OperationType" : 2,
      "ClassName" : "fivegc.pcf.smp.domain.service.api.EvaluateLogical"
    },
    {
      "OperationType" : 3,
      "ClassName" : "fivegc.pcf.smp.domain.service.api.EvaluateLogical"
    },
    {
      "OperationType" : 4,
      "ClassName" : "fivegc.pcf.smp.domain.service.api.EvaluateElement"
    },
    {
      "OperationType" : 5,
      "ClassName" : "fivegc.pcf.smp.domain.service.api.EvaluateElement"
    },
    {
      "OperationType" : 6,
      "ClassName" : "fivegc.pcf.smp.domain.service.api.EvaluateElement"
    }
  ],
  "ExecuteClass" : [
    {
      "OperationType" : 0,
      "ClassName" : "fivegc.pcf.smp.domain.service.api.ExecuteDBAccess"
    },
    {
      "OperationType" : 1,
      "ClassName" : "fivegc.pcf.smp.domain.service.api.ExecuteDBAccess"
    },
    {
      "OperationType" : 2,
      "ClassName" : "fivegc.pcf.smp.domain.service.api.ExecuteDBAccess"
    },
    {
      "OperationType" : 3,
      "ClassName" : "fivegc.pcf.smp.domain.service.api.ExecuteDBAccess"
    },
    {
      "OperationType" : 4,
      "ClassName" : "fivegc.pcf.smp.domain.service.api.ExecuteOperationJson"
    },
    {
      "OperationType" : 6,
      "ClassName" : "fivegc.pcf.smp.domain.service.api.ExecuteArithmetic"
    },
    {
      "OperationType" : 7,
      "ClassName" : "fivegc.pcf.smp.domain.service.api.ExecuteArithmetic"
    },
    {
      "OperationType" : 8,
      "ClassName" : "fivegc.pcf.smp.domain.service.api.ExecuteArithmetic"
    },
    {
      "OperationType" : 9,
      "ClassName" : "fivegc.pcf.smp.domain.service.api.ExecuteArithmetic"
    },
    {
      "OperationType" : 10,
      "ClassName" : "fivegc.pcf.smp.domain.service.api.ExecuteRandom"
    },
    {
      "OperationType" : 12,
      "ClassName" : "fivegc.pcf.smp.domain.service.api.ExecuteStringOperation"
    },
    {
      "OperationType" : 13,
      "ClassName" : "fivegc.pcf.smp.domain.service.api.ExecuteOperationPrint"
    },
    {
      "OperationType" : 20,
      "ClassName" : "fivegc.pcf.smp.domain.service.api.ExecuteRedisAccess"
    },
    {
      "OperationType" : 21,
      "ClassName" : "fivegc.pcf.smp.domain.service.api.ExecuteRedisAccess"
    },
    {
      "OperationType" : 22,
      "ClassName" : "fivegc.pcf.smp.domain.service.api.ExecuteRedisAccess"
    }
  ]
}
');
```

### Service Plan用Table作成

```
CREATE TABLE `SERVICE_PLAN` (
`PLANID` CHAR(255) NOT NULL,
`VALUE` JSON DEFAULT NULL,
PRIMARY KEY (`PLANID`)
) ENGINE=InnoDB;
```

### Service Plan登録

動作確認用のお試しサービスプラン。

```
REPLACE INTO SERVICE_PLAN VALUES('/sm-policies',
'{
  "ConditionType":0,
  "REQUEST_TYPE":"AUTHENTICATION_STEP_ONE",
  "TrueAction":[
    {
      "ActionType":2,
      "TABLENAME":"UE_DATA",
      "KEY":"IMSI"
    }
  ],
  "FalseAction":null,
  "TrueNextCondition":null,
  "FalseNextCondition":null
}');
```

### Condition用Table作成

```
CREATE TABLE `CONDITION_TABLE` (
`CONDITIONID` INT NOT NULL,
`VALUE` JSON DEFAULT NULL,
PRIMARY KEY (`CONDITIONID`)
) ENGINE=InnoDB;
```

### Condition登録

動作確認用のお試しCondition。

```
REPLACE INTO CONDITION_TABLE VALUES(0,
'{
  "OperationType":0,
  "Operation":[
    {
      "OperationType":4,
      "ParamName":[
        "REQUEST_TYPE"
      ],
      "ParamType":1
    },
    {
      "OperationType":5,
      "ParamName":[
        "REQUEST_TYPE"
      ],
      "ParamType":1
    }
  ]
}');
```
### Action用のTable作成

```
CREATE TABLE `ACTION_TABLE` (
`ACTIONID` INT NOT NULL,
`VALUE` JSON DEFAULT NULL,
PRIMARY KEY (`ACTIONID`)
) ENGINE=InnoDB;
```

### Actionの登録

動作確認用のアクション登録。

```
replace into ACTION_TABLE values(2,
'{
    "Operation":[
        {
            "OperationType":0,
            "TableName":[
                "TABLENAME"
            ],
            "TableKind":1,
            "Value":[
                "IMSI"
            ],
            "ValueKind":0,
            "Key":[
                "KEY"
            ],
            "KeyKind":1,
            "Data":[
                "ResponseInfo"
            ],
            "DataKind":3
        }
    ]
}');
```

## packageファイル作成

一旦テストはスキップ。

```
mvn clean package -Dmaven.test.skip=true
```

## テストDB設定

### テーブル作成

```
CREATE TABLE `UE_DATA` (
`IMSI` INT NOT NULL,
`VALUE` JSON DEFAULT NULL,
PRIMARY KEY (`IMSI`)
) ENGINE=InnoDB;
```

### データ登録

```
REPLACE INTO UE_DATA VALUES(1,
'{
  "Test" : "TEST"
}');
```

## Spring起動

## Curl実行

```
curl -H 'Content-Type:application/json' -X POST http://localhost:11201/sm-policies --data '{ "REQUEST_TYPE" : "AUTHENTICATION_STEP_ONE", "IMSI" : 1}'
```

## メモ書き

### ログ出力追加時

以下クラスをインポート。

```
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
```

ログ出力対象のクラスに以下を定義。

```
private static final Logger log = LoggerFactory.getLogger(ServicePlanFactory.class);
※ServicePlanFactoryはログ出力クラスに置き換え。
```
### デバッグログをONにする

以下を「src/main/resources/application.properties」に設定する。

```
logging.level.fivegc.pcf.smp.controller.api=DEBUG
※fivegc.pcf.smp.controller.apiはデバッグログ主力を行うPKG名に置き換え。
```

# 課題

|通番|概要|発生日|状況|解決日|詳細|対処内容|
|---|---|---|---|---|---|---|
|1|Tomcatの起動に失敗。|9/21|対処済|9/21|以下のエラーが発生<br>Failed to auto-configure a DataSource: 'spring.datasource.url' is not specified and no embedded datasource could be auto-configured.|src/main/resources/application.properties<br>上記ファイルに以下記載追加。<br>spring.datasource.url=jdbc:mysql://localhost:11200/PCF<br>spring.datasource.username=root<br>spring.datasource.password=my-secret-pw<br>spring.datasource.driverClassName=com.mysql.jdbc.Driver<br>spring.jpa.database=MYSQL<br>spring.jpa.hibernate.ddl-auto=update
|2|Conditionが生成されていない|9/21|対処済み|9/21|Condition生成後の出力ログがでない。<br>クラス生成時にExceptionが発生している可能性あり。<br>ClassNotFoundExceptionが発生していた。|クラス名をパッケージ名込みで記載。|
|3|DBアクセスアクションに失敗する|9/23|対処中|9/23|DBアクセス時にアクセス対象のテーブルを読み込めてない。|派生クラス側でも同じ変数を定義している。<br>派生クラス側は必要ないため削除。|
|4|DBアクセスアクションに失敗する|9/23|対処中|---|DBアクセス時にアクセス対象のキー名を読み取れていない。|intとtextしか取得してなかった。|
|5|DBアクセス後に結果を格納できていない。|-|---|---|---|---|

DBアクセス結果の格納場所を読み取れてない。
→this.変数名で代入するようにした。

結果格納の際にNullの場合が存在する。