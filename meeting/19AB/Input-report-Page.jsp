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
request.setCharacterEncoding("shift-jis");

/*** �p�X���[�h�F��(START) ***/

//�Z�b�V�����ϐ��̎擾
String user = (String)session.getAttribute("user");
String pass = (String)session.getAttribute("pass");
//���[�U���ɑΉ�����p�X���[�h
String sendPass = "";
//�F��
db.getQuery("select userpass from " + ClassDefine.userpass + " where username='" + user + "';");
if(db.getNext()){
sendPass = db.getResult("userpass");
if(!pass.equals(sendPass)){
%>
<jsp:forward page="attention.jsp" />
<%
}
}
else {
%>
<jsp:forward page="attention.jsp" />
<%
}
/*** �p�X���[�h�F��(END) ***/

/*** ���b�N�̗L���m�F ***/
db.getQuery("select * from " + ClassDefine.lock_table + " where lock_id = 0;");
db.getNext();
String lock_user = db.getResult("lock_user");
if(lock_user.equals(user) || lock_user.equals("dummy")){
db.exeQuery("update " + ClassDefine.lock_table + " set lock_user='" + user + "' where lock_id = 0;");
/*** ������擾 ***/
String ope = request.getParameter("ope");
if(ope == null || ope.equals("0")){
/*** �o�^�����擾 ***/
int kensu = 1;
if(request.getParameter("kensu") != null && !request.getParameter("kensu").equals("")){
kensu = Integer.parseInt(request.getParameter("kensu"));
}

%>
<html>
<head>
<title>��ʓ��͉��</title>
</head>
<body>
<center>
<form action="Input-kind-Page.jsp" method="post">
<input type="submit" value="�X�V">  <input type="reset" value="���Z�b�g"> <br><br>
<input type="hidden" name="kensu" value="<%=kensu%>">
<table border="2" cellspacing=0 bordercolor="#666666">
<tr><td align="center">ID</td>
<td align="center">���</td></tr>
<%
db.getQuery("select * from " + ClassDefine.topic_kind + ";");
int i = 0;
while(db.getNext()){
%>
<!- /*** �g�s�b�NID ***/ ->
<tr><td align="center"><input type="hidden" name="topic_id[<%= i%>]" value="<%= db.getResult("kind_id")%>"><%= db.getResult("kind_id")%></td>
<!- /*** ��� ***/ ->
<!- /*** ��ʂ�\�� ***/ ->
<td>
<input name="topic_kind[<%= i%>]" type="text" value="<%= db.getResult("kind")%>" size="30"></input>
</td>
<tr>
<%
i++;
}
/*** ���̃g�s�b�NID���擾 ***/
int n = 0;
idDB.getQuery("select kind_id from " + ClassDefine.next_id + " order by kind_id;");
idDB.getNext();
n = Integer.parseInt(idDB.getResult("kind_id"));
for(;i<kensu+n;i++){
%>
<!- /*** �g�s�b�NID ***/ ->
<tr><td align="center"><input type="hidden" name="topic_id[<%= i%>]" value=""><%= i%></td>
<%
idDB.closeDB();
%>
<!- /*** ��� ***/ ->
<!- /*** ��ʂ�\�� ***/ ->
<td>
<input name="topic_kind[<%= i%>]" type="text" value="" size="30"></input>
</td>
<tr>
<%
}
%>
</table>
<!- /*** ���� ***/ ->
<input name="ope" type="hidden" value="1">
</form>
<center>
</body>
</html>
<%
}
else {
/*** �o�^�����擾 ***/
int kensu = 0;
if(request.getParameter("kensu") != null && !request.getParameter("kensu").equals("")){
kensu = Integer.parseInt(request.getParameter("kensu"));
}
/*** ���̃g�s�b�NID���擾 ***/
int n = 0;

idDB.getQuery("select kind_id from " + ClassDefine.next_id + ";");
idDB.getNext();
n = Integer.parseInt(idDB.getResult("kind_id"));
String topic_kind = null;
String kind_id = null;
int i;
for(i=0;i<kensu+n;i++){
topic_kind = request.getParameter("topic_kind[" + i + "]");
if(topic_kind != null && !topic_kind.equals("")){
if(i < n){
kind_id = request.getParameter("topic_id[" + i + "]");
db.exeQuery("update " + ClassDefine.topic_kind + " set kind = '" + topic_kind + "' where kind_id = " + kind_id +";");
} else {
db.exeQuery("insert into " + ClassDefine.topic_kind + " values(" + i + ",'" + topic_kind + "');");
}
}else {
break;
}
}
idDB.exeQuery("update " + ClassDefine.next_id + " set kind_id=" + i + ";");
db.exeQuery("update " + ClassDefine.lock_table + " set lock_user = 'dummy' where lock_id = 0;");
%>
<jsp:forward page="Master-Page.jsp" />
<%
idDB.closeDB();
}
}
else {
db.getQuery("select name from userpass where username='" + lock_user + "';");
db.getNext();
%>
<%= db.getResult("name")%>�ɂ���ēo�^�������s���Ă��܂�
<%
}
db.closeDB();
%>