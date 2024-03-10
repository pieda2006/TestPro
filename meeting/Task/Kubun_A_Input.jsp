<%@
page import = "java.io.*"
import = "javax.servlet.*"
import = "javax.servlet.http.*"
import = "java.util.*"
pageEncoding="shift-jis"
contentType = "text/html; charset = shift-jis"
%>
<%

//マックスのデータ数
final int max_Number = 10000;
int i;//カウンタとして使用
DB_Operation db = new DB_Operation();

String uri_name = request.getRequestURI().split("/",0)[2];
ClassDefine ClassDefine = new ClassDefine();
ClassDefine.topic_info = ClassDefine.topic_info + "_" + uri_name;
ClassDefine.next_id = ClassDefine.next_id + "_" + uri_name;
ClassDefine.user_info = ClassDefine.user_info + "_" + uri_name;
ClassDefine.topic_kind = ClassDefine.topic_kind + "_" + uri_name;
ClassDefine.topic_state = ClassDefine.topic_state + "_" + uri_name;
ClassDefine.lock_table = ClassDefine.lock_table + "_" + uri_name;
ClassDefine.topic_plan = ClassDefine.topic_plan + "_" + uri_name;
ClassDefine.topic_report = ClassDefine.topic_report + "_" + uri_name;
ClassDefine.query = ClassDefine.query + "_" + uri_name;
ClassDefine.userpass = ClassDefine.userpass + "_" + uri_name;
ClassDefine.tag = ClassDefine.tag + "_" + uri_name;
ClassDefine.file_dir = ClassDefine.file_dir_part1 + uri_name + ClassDefine.file_dir_part2;
ClassDefine.bbs_dir = ClassDefine.bbs_dir_part1 + uri_name + ClassDefine.bbs_dir_part2;
ClassDefine.bbs_htbbs_dir = ClassDefine.bbs_htbbs_dir_part1 + uri_name + ClassDefine.bbs_htbbs_dir_part2;
ClassDefine.file_htbbs_dir = ClassDefine.file_htbbs_dir_part1 + uri_name + ClassDefine.file_htbbs_dir_part2;

/*** パスワード認証(START) ***/

//セッション変数の取得
String user = (String)session.getAttribute("user");
String pass = (String)session.getAttribute("pass");
//ユーザ名に対応するパスワード
String sendPass = "";
//認証
db.getQuery("select userpass from " + ClassDefine.userpass + " where username='" + user + "';");
if(db.getNext()){
sendPass = db.getResult("userpass");
if(!pass.equals(sendPass)){
db.closeDB();
%>
<jsp:forward page="attention.jsp" />
<%
}
}
else {
db.closeDB();
%>
<jsp:forward page="attention.jsp" />
<%
}
request.setCharacterEncoding("shift-jis");
DB_Num number = new DB_Num();
number.set_Table(ClassDefine.query);
number.numGet();
int e_no = 0;
for(i=0;i<max_Number;i++){
if(number.numBool(i)){
e_no = i;
break;
}
}
String no = Integer.toString(e_no);
String query = request.getParameter("text");
int new_row = 1;
String tag = request.getParameter("tag");;
String file = "";
int backupNum = 0;
GregorianCalendar cal = new GregorianCalendar();
String day = (cal.getTime()).toString();
String sercret = "0";

db.exeQuery("insert into " + ClassDefine.query + " values('" + day + "','" + user + "'," + new_row + "," + no + ",'" + query + "'," + tag + "," + sercret + ",1,'" + file + "');");

File delete_file = new File(ClassDefine.file_dir + "htbbsf" + no + ".log");
if (delete_file.exists()){
    delete_file.delete();
}
Htbbsf writebbs = new Htbbsf();
writebbs.writeHtbbsf(Integer.parseInt(no),ClassDefine.file_dir,"資料",ClassDefine.file_htbbs_dir);
db.closeDB();
%>

<jsp:forward page="Kubun_A_Browse.jsp" />
