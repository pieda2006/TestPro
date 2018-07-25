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
request.setCharacterEncoding("shift-jis");

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

%>
<html>
<head>
<title>ユーザ登録結果</title>
</head>
<body>

<%
String user_name = request.getParameter("user_name");
String user_namejp = request.getParameter("user_namejp");
String user_pass = request.getParameter("user_pass");

db.exeQuery("insert into " + ClassDefine.user_info + " values('" + user_name + "','" + user_namejp + "','" + user_pass + "',0);");
db.exeQuery("insert into " + ClassDefine.userpass + " values('" + user_name + "','" + user_pass + "','" + user_namejp + "',0);");
db.getQuery("select * from " + ClassDefine.userpass + ";");

%>

<table>
<tr><td>ユーザID</td><td>ユーザ名</td><td>パスワード</td></tr>
<%
while(db.getNext()){
%>
    <tr><td><%= db.getResult("username")%></td><td><%= db.getResult("name")%></td><td><%= db.getResult("userpass")%></td></tr>
<%
}
%>
</table>
</body>

<a href=createuser.jsp><font size=2 color="black">ユーザ登録に戻る</font></a>

</html>
<%
db.closeDB();
%>