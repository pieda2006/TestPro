<%@
page import = "java.io.*"
import = "javax.servlet.*"
import = "javax.servlet.http.*"
import = "java.util.*"
pageEncoding="shift-jis"
contentType = "text/html; charset = shift-jis"
%>
<%
/*** データベース操作を行うオブジェクト ***/
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

/*** セッション変数の取得 ***/
String user = (String)session.getAttribute("user");
String pass = (String)session.getAttribute("pass");
/*** ユーザ名に対応するパスワード ***/
String sendPass = "";
/*** 認証 ***/
db.getQuery("select userpass from " + ClassDefine.userpass + " where username='" + user + "';");
%>
<!-/*** HTML部分 ***/->
<html>
<head>
<title>パスワード認証</title>
</head>
<body>
<%
if(db.getNext()){
sendPass = db.getResult("userpass");
if(!pass.equals(sendPass)){
%>
パスワードが違います。
<a href="index.jsp"><font size=4 color="black">ユーザ名入力画面</font></a>
<%
}
}
else {
%>
ユーザ名とパスワードを入力しなおしてください。
<a href="index.jsp"><font size=4 color="black">ユーザ名入力画面</font></a>
<%
}
db.closeDB();
%>
</body>
</html>

