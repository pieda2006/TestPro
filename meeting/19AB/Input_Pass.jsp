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
final int max_Number = 100;
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

String new_pass = request.getParameter("new_pass");
String more_pass = request.getParameter("more_pass");
String new_name = request.getParameter("new_name");
String sql = "update userpass set ";//データベースを更新するSQL文

if(new_pass != null || more_pass != null || new_name != null){
if(new_name.equals("")){
if(more_pass.equals(new_pass) && !new_pass.equals("") && !more_pass.equals("")){
sql = sql.concat("userpass='" + new_pass + "' where username='" + user + "';");
db.exeQuery(sql);
session.setAttribute("pass",new_pass);
}
}
else {
sql = sql.concat("name='" + new_name + "'");
if(more_pass.equals(new_pass) && !new_pass.equals("") && !more_pass.equals("")){
sql = sql.concat(",userpass='" + new_pass + "' where username='" + user + "';");
db.exeQuery(sql);
session.setAttribute("pass",new_pass);
}
else {
sql = sql.concat(" where username='" + user + "';");
db.exeQuery(sql);
}
}
}

%>

<%/*** HTML ***/%>

<html>
<head>
<title>パスワード変更</title>
</head>
<body>
<%
if(new_pass == null || more_pass == null || new_name == null){
%>
<form action="Input_Pass.jsp" method="post">
<br>
<br>
新しい名前:<input type="text" name="new_name" value="" size="20">
<br>
<br>
新しいパスワード:<input type="password" name="new_pass" value="" size="20">
<br>
<br>
パスワードの確認:<input type="password" name="more_pass" value="" size="20">
<br>
<br>
<input type="submit" value="送信する">
</form>
</center>
<br>
<a href="kubun.jsp">戻る</a>
<%
}
else {
%>
以下の更新を行いました<br>
<%
if(!new_name.equals("")){
%>
名前:<%= new_name%>
<%
}
if(!new_pass.equals("") && !more_pass.equals("") && new_pass.equals(more_pass)){
%>
パスワード
<%
}
%>
<br>
<a href="Input_Pass.jsp">戻る</a>
<%
}
%>
</body>
</html>
