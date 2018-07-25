<%@
page import = "java.io.*"
import = "javax.servlet.*"
import = "javax.servlet.http.*"
import = "java.util.*"
pageEncoding="shift-jis"
contentType = "text/html; charset = shift-jis"
%>
<%
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

DB_Operation directryDB = new DB_Operation();
request.setCharacterEncoding("shift-jis");

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
/*** パスワード認証(END) ***/

WriteCSV writeFile = new WriteCSV(ClassDefine.file_dir + "directory.csv");

%>
<html>
<head>
<title>ディレクトリ一覧</title>
</head>
<body>
<center>
<a href="PDF_File/directory.csv"><font size=2 color="black">ディレクトリ一覧ダウンロード</font></a>
<table border="2" cellspacing=0 bordercolor="#666666">
<tr><td align="center">ID</td>
<td nowrap>フルパス</td></tr>
<%
writeFile.writeString("\"ID\",\"フルパス\"");
db.getQuery("select * from " + ClassDefine.tag + " order by full_dir;");
while(db.getNext()){
%>
<!- /*** トピックID ***/ ->
<tr><td align="center" nowrap><%= db.getResult("tag_id")%></td>
<!- /*** 種別 ***/ ->
<!- /*** 種別を表示 ***/ ->
<td nowrap><%= db.getResult("full_dir")%></td>
</tr>
<%
writeFile.writeString("\"" + db.getResult("tag_id") + "\",\"" + db.getResult("full_dir") + "\"");
}
%>
</table>
<center>
</body>
</html>
<%
writeFile.writeClose();
db.closeDB();
directryDB.closeDB();
%>