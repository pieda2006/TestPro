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

/*** ���݂̓������擾 ***/
/*** ���t���V�X�e���ϐ�����擾����I�u�W�F�N�g�錾 ***/
GregorianCalendar cal = new GregorianCalendar();
String date = (cal.getTime()).toString();

/*** ���b�N�̗L���m�F ***/
db.getQuery("select * from " + ClassDefine.lock_table + " where lock_id = 0;");
db.getNext();
String lock_user = db.getResult("lock_user");
if(lock_user.equals(user) || lock_user.equals("dummy")){
db.exeQuery("update " + ClassDefine.lock_table + " set lock_user='" + user + "' where lock_id = 0;");
/*** �o�^�����擾 ***/
int kensu = 1;
if(request.getParameter("kensu") != null && !request.getParameter("kensu").equals("")){
kensu = Integer.parseInt(request.getParameter("kensu"));
}

%>
<html>
<head>
<title>�ۑ�Ǘ��y�[�W���͉��</title>
<SCRIPT 
src="jkl-calendar.js" 
type=text/javascript charset=Shift_JIS></SCRIPT>
</head>
<body>
<center>
<FONT COLOR="Crimson">�����t�F<%= cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.DATE)%></FONT>
<form id=formid action="Master-Page.jsp" method="post">
<input type="submit" value="�X�V">  <input type="reset" value="���Z�b�g"> <br><br>
<input type="hidden" name="search" value="0">
<input type="hidden" name="kensu" value="<%=kensu%>">
<table border="2" cellspacing=0 bordercolor="#666666">
<tr><td align="center">ID</td>
<td align="center">����</td>
<td align="center">�g�s�b�N��</td>
<td align="center">�H��</td>
<td align="center">���</td><td align="center" >���</td>
<td align="center">�J�n�\���</td><td align="center">�����\���</td>
<td align="center">�ŏI�X�V��</td><td align="center">������</td>
<td align="center">�S����</td>
<td align="center">����</td></tr>
<%
/*** ���̃g�s�b�NID���擾 ***/
int n = 0;
DB_Operation idDB = new DB_Operation();
DB_Operation kindDB = new DB_Operation();
DB_Operation stateDB = new DB_Operation();
DB_Operation userDB = new DB_Operation();
idDB.getQuery("select topic_id from " + ClassDefine.next_id + ";");
idDB.getNext();
n = Integer.parseInt(idDB.getResult("topic_id"));
idDB.closeDB();
for(int i=0;i<kensu;i++){
%>
<SCRIPT><!--
    var date1_<%= i%> = new JKL.Calendar("date1_<%= i%>","formid","plan_topic_date[<%= i%>]");
	date1_<%= i%>.setStyle( "frame_color", "#3333CC" );
    var date2_<%= i%> = new JKL.Calendar("date2_<%= i%>","formid","plan_limit_date[<%= i%>]");
	date2_<%= i%>.setStyle( "frame_color", "#3333CC" );
//--></SCRIPT>
<!- /*** �g�s�b�NID ***/ ->
<tr><td align="center"><input type="hidden" name="topic_id[<%= i%>]" value=""><%= n + i%></td>
<!- /*** �g�s�b�N�� ***/ ->
<td><input name="kouban[<%= i%>]" type="text" value="" size="20" maxlength="40"></input>
<!- /*** �g�s�b�N�� ***/ ->
<td><input name="topic_name[<%= i%>]" type="text" value="" size="70" maxlength="40"></input>
</td>
<!- /*** �qID��\�� ***/ ->
<td><select name="topic_sub_id[<%= i%>]">
<option value="0">�v����`</option>
<option value="1">��{�݌v</option>
<option value="2">�T�v�݌v</option>
<option value="3">�ڍא݌v</option>
<option value="4">����</option>
<option value="5">�P�̎���</option>
<option value="6">��������</option>
<option value="7">���艻����</option>
<option value="8">�ێ��Ǘ�</option>
<option value="9">���̑�</option>
</select>
</td>
<!- /*** ��� ***/ ->
<!- /*** ��ʂ�\�� ***/ ->
<td>
<select name="kind_id[<%= i%>]">
<%
kindDB.getQuery("select * from " + ClassDefine.topic_kind + " order by kind;");
while(kindDB.getNext()){
%>
<option value="<%= kindDB.getResult("kind_id")%>">
<%=  kindDB.getResult("kind")%>
</option>
<%
}
%>
</td>
<%
/*** ��Ԃ𔻒� ***/
%>
<!- /*** ��Ԃ�\�� ***/ ->
<td>
<select name="state_id[<%= i%>]">
<option value="4">�V�K</option>
<!- /*** ����\���\�� ***/ ->
<td>
<DIV id=date1_<%= i%>></DIV>
<input onclick="date1_<%= i%>.hide(); date1_<%= i%>.write();" onchange="date1_<%= i%>.getFormValue(); date1_<%= i%>.hide();" name="plan_topic_date[<%= i%>]" type="text" value="" size="13"></td>
<!- /*** �����\���\�� ***/ ->
<td>
<DIV id=date2_<%= i%>></DIV>
<input onclick="date2_<%= i%>.hide(); date2_<%= i%>.write();" onchange="date2_<%= i%>.getFormValue(); date2_<%= i%>.hide();" name="plan_limit_date[<%= i%>]" type="text" value="" size="13"><br></td>
<!- /*** �J�n����\�� ***/ ->
<td><!-input name="topic_datetime_limit[<%= i%>]" type="text" value="" size="13"-><br></td>
<!- /*** ���� ***/ ->
<td><!- input name="time_limit[<%= i%>]" type="text" value="" size="13"-><br></td>
<!-/*** �S���҂̓��͗� ***/ ->
<%
/*** �S���҂𔻒� ***/
%>
<!- /*** �S���҂�\�� ***/ ->
<td>
<select name="user_id[<%= i%>]">
<%
userDB.getQuery("select * from " + ClassDefine.user_info + " where user_id='" + user + "';");
if(userDB.getNext()){
%>
<option value="<%= userDB.getResult("user_id")%>">
<%=  userDB.getResult("user_name")%>
</option>
<%
}
userDB.getQuery("select * from " + ClassDefine.user_info + ";");
while(userDB.getNext()){
%>
<option value="<%= userDB.getResult("user_id")%>">
<%=  userDB.getResult("user_name")%>
</option>
<%
}
%>
</select>
</td>
<!- /*** ���� ***/ ->
<td><input name="topic_ope[<%= i%>]" type="hidden" value="3">�V�K</td><tr>
<%
}
%>
</table>
</form>
<center>
</body>
</html>
<%
kindDB.closeDB();
stateDB.closeDB();
userDB.closeDB();
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
