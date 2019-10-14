import java.util.HashMap;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.modelmapper.ModelMapper;
import java.util.Set;

public class Main {
 
    public static void main(String[] args) {
        Main mainobj = new Main();
        mainobj.mainFunc();
    }
    public void mainFunc(){
       /* クラスインスタンスのリフレクションの実験 */
       try {
          Object lTest = Class.forName("Test").newInstance();
          Class.forName("Test").getMethod("setNum",Class.forName("java.lang.Integer")).invoke(lTest, 3);
       } catch (Exception e) {
           System.out.println("Exception");
       }
       /* Jsonの要素分割の実験 */
       try {
           ExtractionElement extElm = new ExtractionElement();
           extElm.extractionJson();
           extElm.extractionJson();
           extElm.extractionJson();
           extElm.extractionJson();
           extElm.extractionJson();

       } catch (Exception e) {
           System.out.println(e.toString());
       }
    }
}

