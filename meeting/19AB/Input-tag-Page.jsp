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

DB_Operation idDB = new DB_Operation();
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

/*** ロックの有無確認 ***/
db.getQuery("select * from " + ClassDefine.lock_table + " where lock_id = 1;");
db.getNext();
String lock_user = db.getResult("lock_user");
if(lock_user.equals(user) || lock_user.equals("dummy")){
db.exeQuery("update " + ClassDefine.lock_table + " set lock_user='" + user + "' where lock_id = 1;");
/*** 操作を取得 ***/
String ope = request.getParameter("ope");
if(ope == null || ope.equals("0")){
/*** 登録件数取得 ***/
int kensu = 1;
if(request.getParameter("kensu") != null && !request.getParameter("kensu").equals("")){
kensu = Integer.parseInt(request.getParameter("kensu"));
}

%>
<html>
<head>
<title>種別入力画面</title>
</head>
<body>
<center>
<form action="Input-tag-Page.jsp" method="post">
<input type="submit" value="更新">  <input type="reset" value="リセット"> <br><br>
<input type="hidden" name="kensu" value="<%=kensu%>">
<table border="2" cellspacing=0 bordercolor="#666666">
<tr><td align="center">ID</td>
<td align="center">種別</td>
<td align="center">親ID</td>
<td nowrap>フルパス</td></tr>
<%
db.getQuery("select * from " + ClassDefine.tag + " order by full_dir;");
int i = 0;
while(db.getNext()){
%>
<!- /*** トピックID ***/ ->
<tr><td align="center"><input type="hidden" name="topic_id[<%= i%>]" value="<%= db.getResult("tag_id")%>"><%= db.getResult("tag_id")%></td>
<!- /*** 種別 ***/ ->
<!- /*** 種別を表示 ***/ ->
<td>
<input name="tag[<%= i%>]" type="text" value="<%= db.getResult("tag")%>" size="30"></input>
</td>
<td>
<input name="parent_id[<%= i%>]" type="text" value="<%= db.getResult("parent_id")%>" size="5"></input>
</td>
<td nowrap><%= db.getResult("full_dir")%></td>
</tr>
<%
i++;
}
/*** 次のトピックIDを取得 ***/
int n = 0;
idDB.getQuery("select message_id from " + ClassDefine.next_id + " order by message_id;");
idDB.getNext();
n = Integer.parseInt(idDB.getResult("message_id"));
for(;i<kensu+n;i++){
%>
<!- /*** トピックID ***/ ->
<tr><td align="center"><input type="hidden" name="topic_id[<%= i%>]" value=""><%= i%></td>
<%
idDB.closeDB();
%>
<!- /*** 種別 ***/ ->
<!- /*** 種別を表示 ***/ ->
<td>
<input name="tag[<%= i%>]" type="text" value="" size="30"></input>
</td>
<td>
<input name="parent_id[<%= i%>]" type="text" value="" size="5"></input>
</td>
<tr>
<%
}
%>
</table>
<!- /*** 操作 ***/ ->
<input name="ope" type="hidden" value="1">
</form>
<center>
</body>
</html>
<%
}
else {
/*** 登録件数取得 ***/
int kensu = 0;
if(request.getParameter("kensu") != null && !request.getParameter("kensu").equals("")){
kensu = Integer.parseInt(request.getParameter("kensu"));
}
/*** 次のトピックIDを取得 ***/
int n = 0;

idDB.getQuery("select message_id from " + ClassDefine.next_id + ";");
idDB.getNext();
n = Integer.parseInt(idDB.getResult("message_id"));
String tag = null;
String tag_id = null;
String parent_id = null;
int i;
for(i=0;i<kensu+n;i++){
String fulldir = "";
tag = request.getParameter("tag[" + i + "]");
if(tag != null && !tag.equals("")){
if(i < n){
tag_id = request.getParameter("topic_id[" + i + "]");
parent_id = request.getParameter("parent_id[" + i + "]");
fulldir = tag + "/" + fulldir;
directryDB.getQuery("select * from " + ClassDefine.tag + " where tag_id =" + parent_id + ";");
while(directryDB.getNext()){
fulldir = directryDB.getResult("tag") + "/" + fulldir;
directryDB.getQuery("select * from " + ClassDefine.tag + " where tag_id =" + directryDB.getResult("parent_id") + ";");
}
fulldir = "TOP/" + fulldir;
db.exeQuery("update " + ClassDefine.tag + " set tag = '" + tag + "',parent_id = " + parent_id + ",full_dir = '" + fulldir + "' where tag_id = " + tag_id +";");
} else {
parent_id = request.getParameter("parent_id[" + i + "]");
fulldir = tag + "/" + fulldir;
directryDB.getQuery("select * from " + ClassDefine.tag + " where tag_id =" + parent_id + ";");
while(directryDB.getNext()){
fulldir = directryDB.getResult("tag") + "/" + fulldir;
directryDB.getQuery("select * from " + ClassDefine.tag + " where tag_id =" + directryDB.getResult("parent_id") + ";");
}
fulldir = "TOP/" + fulldir;
db.exeQuery("insert into " + ClassDefine.tag + " values(" + i + ",'" + tag + "'," + parent_id + ",'" + fulldir +"');");
}
}else {
if(n<=i){
break;
}
}
}
idDB.exeQuery("update " + ClassDefine.next_id + " set message_id=" + i + ";");
db.exeQuery("update " + ClassDefine.lock_table + " set lock_user = 'dummy' where lock_id = 1");
%>
<jsp:forward page="Kubun_A_Browse.jsp" />
<%
idDB.closeDB();
}
}
else {
db.getQuery("select name from userpass where username='" + lock_user + "';");
db.getNext();
%>
<%= db.getResult("name")%>によって登録処理が行われています
<%
}
db.closeDB();
directryDB.closeDB();
%>