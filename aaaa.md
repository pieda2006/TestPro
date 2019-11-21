# Class図
![](./001.png)

```
@startuml
skinparam componentStyle uml2
skinparam linetype ortho

class ActionFactory

class ExecuteBase {
  void executeAction(JsonNode reqJson, ObjectNode ansJson, ObjectNode distJson, JsonNode actionJson, JsonNode operationJson)
  public void setParameterFromJson(JsonNode operationjson)
}
class ExecuteJavaScript {
  static engineManager = null
  String ScriptType = null
  JsonNode Variable = null
  JsonNode VariableType = null
  String Script = null
  void executeAction(JsonNode reqJson, ObjectNode ansJson, ObjectNode distJson, JsonNode actionJson, JsonNode operationJson)  
  public void setParameterFromJson(JsonNode operationjson)
}
class JavaScriptFactory {
  private static JavaScriptFactory myinstance = null
  JavaScriptObject createScript(String script)
  public static JavaScriptFactory getInstance()
}
class JavaScriptManager {
  private static JavaScriptManager myinstance = null
  HashMap<String,JavaScriptObject> scriptMap = null
  public static JavaScriptManager getInstance()
  void createScript(String type, String script)
}
class JavaScriptObject {
  ScriptEngine engine
  CompiledScript cscript
  JavaScriptObject(ScriptEngine en, CompiledScript cs)
}
class ScriptEngineManager {
  ScriptEngineManager()
  public ScriptEngine getEngineByName(String shortName)
}

class ScriptEngine{
　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　
}
class CompiledScript
class Compilable {
  CompiledScript compile(String script)
}

ScriptEngine -r-|> Compilable:実装
JavaScriptFactory ..> Compilable:use
JavaScriptFactory ..> ScriptEngineManager:create
JavaScriptFactory ..> ScriptEngine:use
JavaScriptFactory ..> JavaScriptObject:create
JavaScriptObject o-- ScriptEngine
JavaScriptObject o-- CompiledScript
JavaScriptManager ..> JavaScriptFactory
JavaScriptManager o-l- JavaScriptObject
ActionFactory ..> ExecuteJavaScript:create
ExecuteBase <|-- ExecuteJavaScript
ExecuteJavaScript ..> JavaScriptManager
ScriptEngineManager ..> ScriptEngine:create
ExecuteJavaScript ..> JavaScriptObject

@enduml
```

# Sequence図
![](./002.png)
```
@startuml
skinparam componentStyle uml2
skinparam linetype ortho

activate ActionFactory
ActionFactory -> ExecuteJavaScript: setParameterFromJson(JsonNode operationjson)
activate ExecuteJavaScript
  rnote over ExecuteJavaScript #white
    種別をJsonデータから取得。
  end rnote
  rnote over ExecuteJavaScript #white
    変数情報の格納pathを
    Jsonデータから取得。
  end rnote
  rnote over ExecuteJavaScript #white
    変数情報の格納バッファを
    Jsonデータから取得。
  end rnote
  rnote over ExecuteJavaScript #white
    Script文字列を
    Jsonデータから取得。
  end rnote
  ExecuteJavaScript -> JavaScriptManager:getInstance()
  activate JavaScriptManager
    opt インスタンス未生成の場合
      JavaScriptManager -> JavaScriptManager : new JavaScriptManager()
      activate JavaScriptManager
        rnote over JavaScriptManager #white
          javascriptオブジェクト
          格納用のハッシュ作成
        end rnote
      JavaScriptManager <-- JavaScriptManager
      deactivate JavaScriptManager
    end
  ExecuteJavaScript <-- JavaScriptManager
  deactivate JavaScriptManager
  ExecuteJavaScript -> JavaScriptManager: createScript(String type, String script)
  activate JavaScriptManager
    JavaScriptManager -> JavaScriptFactory:getInstance()
    activate JavaScriptFactory
      opt インスタンス未生成の場合
        JavaScriptFactory -> JavaScriptFactory : new JavaScriptManager()
        activate JavaScriptFactory
          JavaScriptFactory -> ScriptEngineManager:new ScriptEngineManager()
          activate ScriptEngineManager
          JavaScriptFactory <-- ScriptEngineManager
          deactivate ScriptEngineManager
        JavaScriptFactory <-- JavaScriptFactory
        deactivate JavaScriptFactory
      end
    JavaScriptManager <-- JavaScriptFactory
    deactivate JavaScriptFactory
    JavaScriptManager -> JavaScriptFactory:createScript(String script)
    activate JavaScriptFactory
      JavaScriptFactory -> ScriptEngineManager:getEngineByName(String shortName)
      activate ScriptEngineManager
      JavaScriptFactory <-- ScriptEngineManager:ScriptEngine
      deactivate ScriptEngineManager
      JavaScriptFactory -> Compilable:compile(String script)
      activate Compilable
      JavaScriptFactory <-- Compilable:CompiledScript
      deactivate Compilable
      JavaScriptFactory -> JavaScriptObject:new JavaScriptObject(ScriptEngine en, CompiledScript cs)
      activate JavaScriptObject
      JavaScriptFactory <-- JavaScriptObject
      deactivate JavaScriptObject
    JavaScriptManager <-- JavaScriptFactory:JavaScriptObject
    deactivate JavaScriptFactory
    rnote over JavaScriptManager #white
      JavaScriptObjectをハッシュ登録
    end rnote
  ExecuteJavaScript <-- JavaScriptManager
  deactivate JavaScriptManager
ActionFactory <-- ExecuteJavaScript
deactivate ExecuteJavaScript

@enduml
```