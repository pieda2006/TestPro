import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.File;
import java.util.Map;
import java.util.ArrayList;
import java.util.Iterator;

class ExtractionElement {

  JsonNode paramName = null;
    
  void extractionJson() throws Exception {
    //ファイルの読み込み
    ObjectMapper mapper = new ObjectMapper();
    JsonNode root = mapper.readTree(new File("test.json"));

    //比較対象のJson
    JsonNode resJson = mapper.readTree(new File("resut.json"));

    ArrayNode arrayRes = null;
    if(resJson instanceof ArrayNode){
      arrayRes = (ArrayNode)resJson;
    } else {
      return;
    }

    //分割対象のデータ
    paramName = mapper.readTree(new File("element.json"));

    if(!paramName.isArray()){
      return ;
    }
    
    ArrayNode pathArray = (ArrayNode)paramName;
    int pathsize = pathArray.size();

    //OutPut用のArrayNode作成
    JsonNodeFactory factory = JsonNodeFactory.instance;
    ArrayNode arrayData = new ArrayNode(factory); 
    for (int count = 0; count < pathsize; count++){
      arrayData.add(new ArrayNode(factory));
    }

    ArrayNode tmpArray1 = null;
    ArrayNode tmpArray2 = null;
    int deletelistsize = getCondMatchJson(root, 0, arrayData);

    ArrayList<Boolean> deletelist = new ArrayList<Boolean>(deletelistsize);
    for(int count = 0; count < deletelistsize; count++){
        deletelist.add(count,false);
    }
    
    for(int pathcount = 0; pathcount < pathsize; pathcount++) {
      tmpArray1 = (ArrayNode)arrayRes.get(pathcount);
      tmpArray2 = (ArrayNode)arrayData.get(pathcount);
      for(int elemcount = 0; elemcount < tmpArray2.size(); elemcount++){
        for(int compcount = 0; compcount < tmpArray1.size(); compcount++){
          if(!tmpArray2.get(elemcount).path(tmpArray1.get(compcount).get(0).asText()).equals(tmpArray1.get(compcount).get(1))){
              deletelist.set(elemcount, true);
          }
        }
      }
    }
    for(int count = deletelist.size() - 1; 0 <= count; count--){
       if(deletelist.get(count)){
         for(int pathcount = 0; pathcount < pathsize; pathcount++){
           tmpArray1 = (ArrayNode)arrayData.get(pathcount);
           tmpArray1.remove(count);
         }
       }
     }

     System.out.println("arrayData : " + arrayData.toString() );
     System.out.println("root : " + root.toString());

  }

public int getCondMatchJson(JsonNode findJson, int currentdepth, ArrayNode array){
    int boolnum = 0;
    int sumboolnum = 0;
    boolean retbool = false;
    int nextdepth = currentdepth + 1;
    boolean nextpathbool = paramName.has(nextdepth);
    String paramString = paramName.get(currentdepth).asText();
    ArrayNode tmpArray = null;
    JsonNode tmpJson = null;

    if(paramString.equals("*")){
      Map.Entry<String,JsonNode> jsonmap = null;
      Iterator<Map.Entry<String,JsonNode>> jsonIte = findJson.fields();
      while (jsonIte.hasNext()) {
        jsonmap = jsonIte.next();
        if(nextpathbool){
          boolnum = getCondMatchJson(jsonmap.getValue(),  nextdepth, array);
        } else {
          boolnum = 1;
        }
        for(int count = 0; count < boolnum; count++){
          tmpJson = array.get(currentdepth);
          if (tmpJson instanceof ArrayNode){
            tmpArray = (ArrayNode)tmpJson;
            tmpArray.add(jsonmap.getValue());
          }
        }
        sumboolnum = sumboolnum + boolnum;
      }
      return sumboolnum;
    } else {
      if(nextpathbool){
        boolnum = getCondMatchJson(findJson.path(paramString), nextdepth, array);
      } else {
        boolnum = 1;
      }
      for(int count = 0; count < boolnum; count++){
        tmpJson = array.get(currentdepth);
        if (tmpJson instanceof ArrayNode){
          tmpArray = (ArrayNode)tmpJson;
          tmpArray.add(findJson.path(paramString));
        }
      }
      return boolnum;
    }
}
}
