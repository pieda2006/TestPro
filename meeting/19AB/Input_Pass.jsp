<%@
page import = "java.io.*"
import = "javax.servlet.*"
import = "javax.servlet.http.*"
import = "java.util.*"
pageEncoding="shift-jis"
contentType = "text/html; charset = shift-jis"
%>
<%
//�}�b�N�X�̃f�[�^��
final int max_Number = 100;
int i;//�J�E���^�Ƃ��Ďg�p
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

/*** �p�X���[�h�F��(END) ***/

String new_pass = request.getParameter("new_pass");
String more_pass = request.getParameter("more_pass");
String new_name = request.getParameter("new_name");
String sql = "update userpass set ";//�f�[�^�x�[�X���X�V����SQL��

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
<title>�p�X���[�h�ύX</title>
</head>
<body>
<%
if(new_pass == null || more_pass == null || new_name == null){
%>
<form action="Input_Pass.jsp" method="post">
<br>
<br>
�V�������O:<input type="text" name="new_name" value="" size="20">
<br>
<br>
�V�����p�X���[�h:<input type="password" name="new_pass" value="" size="20">
<br>
<br>
�p�X���[�h�̊m�F:<input type="password" name="more_pass" value="" size="20">
<br>
<br>
<input type="submit" value="���M����">
</form>
</center>
<br>
<a href="kubun.jsp">�߂�</a>
<%
}
else {
%>
�ȉ��̍X�V���s���܂���<br>
<%
if(!new_name.equals("")){
%>
���O:<%= new_name%>
<%
}
if(!new_pass.equals("") && !more_pass.equals("") && new_pass.equals(more_pass)){
%>
�p�X���[�h
<%
}
%>
<br>
<a href="Input_Pass.jsp">�߂�</a>
<%
}
%>
</body>
</html>
