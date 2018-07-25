package javax.servlet;

public class Escape_String{
	public String editReturn(String s){
		s = s.replaceAll("\n","<br>");
		int strlen;
		int i;
		String st="";
		char[] pchar = new char[1];
		strlen = s.length();
		for(i=0;i<strlen;i++){
			pchar[0] = s.charAt(i);
			if(pchar[0] == '\''){
				pchar[0] = '\\';
				st = st.concat("\\\'");
			}
			else {
				st = st.concat(new String(pchar));
			}
		}
		return st;
	}
	public String undoReturn(String s){
		s = s.replaceAll("<br>","\n");
		return s;
	}
 public String convertCsv(String s){
  s = s.replaceAll("<br>","\n");
  s = s.replaceAll("&nbsp;"," ");
  s = s.replaceAll("&gt;",">");
  s = s.replaceAll("&lt;","<");
  s = s.replaceAll("&quot;","\"\"");
  s = s.replaceAll("\"","\"\"");
  s = s.replaceAll("<b>","");
  s = s.replaceAll("</b>","");
  return s;
 }
}