import com.sun.javadoc.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;

public class MyDoclet {

        String className = null;
        String beforTag = null;
        static final String CSV_TEST_FILE = "TEST_TABLE.csv";
        static FileWriter f = null;
        static PrintWriter p = null;

	public static boolean start(RootDoc root) {
               try {
               f = new FileWriter(CSV_TEST_FILE, false);
               } catch (Exception e){
                   System.out.println(e.toString());
               }
               p = new PrintWriter(new BufferedWriter(f));

		MyDoclet doclet = new MyDoclet();
		doclet.list(root);
                p.close();
                String path = System.getProperty("user.dir");
                System.out.println("[INFO] ======= TEST_TABLE OUTPUT : "+ path + " =======");
                return true;
	}

	public void list(RootDoc root) {
		ClassDoc[] classes = root.classes();
		for (int i = 0; i < classes.length; ++i) {
			listClass(classes[i]);
		}
	}

	private void listClass(ClassDoc classDoc) {

		showDoc(classDoc);
		FieldDoc[] fields = classDoc.fields();
		for (int i = 0; i < fields.length; i++) {
			showDoc(fields[i]);
		}

		MethodDoc[] methods = classDoc.methods();
		for (int i = 0; i < methods.length; i++) {
			showDoc(methods[i]);
		}
	}

	private void showDoc(Doc doc) {
                if(doc.isMethod()){
		  p.print("\"\n\"" + className + "\",\"" + doc.name());
		  //System.out.print(doc.commentText());
		  showTags(doc.tags());
                } else if(doc.isClass()){
                  className = doc.name();
                }
	}

	private void showTags(Tag[] tags) {
		for (int i = 0; i < tags.length; i++) {
			showTag(tags[i]);
		}
	}

	private void showTag(Tag tag) {
                if(beforTag == null || !beforTag.equals(tag.name())){
		    p.print("\",\"" + tag.text());
                    beforTag = tag.name();
                } else {
                    p.print("\n" + tag.text());
                    beforTag = tag.name();
                }
	}

}
