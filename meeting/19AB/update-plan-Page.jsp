<%@
page import = "java.io.*"
import = "javax.servlet.*"
import = "javax.servlet.http.*"
import = "java.util.*"
import = "java.text.*"
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
Date day = cal.getTime();
Day_Operation dayop = new Day_Operation();
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy'/'MM'/'dd' 'HH':'mm':'ss");
SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy'/'MM'/'dd");

//�ۑ���e�\���p
DB_Operation topic_db = new DB_Operation();
//���[�U�\���p
DB_Operation user_db = new DB_Operation();
DB_Operation kindDB = new DB_Operation();
String[] strarray = null;
/*** 2012/4/4 S ***/
String currentdate = null;
/*** 2012/4/4 E ***/

/*** ������擾 ***/
String ope = request.getParameter("ope");
if(ope != null && ope.equals("2")){
session.setAttribute("search_word_10",request.getParameter("search_word_10"));
session.setAttribute("search_word_11",request.getParameter("search_word_11"));
session.setAttribute("search_word_12",request.getParameter("search_word_12"));
session.setAttribute("topic_user_plan_1",request.getParameter("topic_user_plan_1"));
session.setAttribute("calender1",request.getParameter("calender1"));
}
if(ope == null){
ope = "2";
}
String search_word_10 = (String)session.getAttribute("search_word_10");
if(search_word_10 == null || search_word_10.equals("null")){
search_word_10 = "";
}
String search_word_11 = (String)session.getAttribute("search_word_11");
if(search_word_11 == null || search_word_11.equals("null")){
search_word_11 = "";
}
String search_word_12 = (String)session.getAttribute("search_word_12");
if(search_word_12 == null || search_word_12.equals("null")){
search_word_12 = "";
}
String topic_user_plan_1 = (String)session.getAttribute("topic_user_plan_1");
String calender = (String)session.getAttribute("calender1");//�\���͈�
String operation = (String)session.getAttribute("operation");
if(operation != null && operation.equals("1")){
if((search_word_10 != null && !search_word_10.equals("null") && !search_word_10.equals("")) ||
   (search_word_11 != null && !search_word_11.equals("null") && !search_word_11.equals("")) ||
   (search_word_11 != null && !search_word_12.equals("null") && !search_word_12.equals(""))){
ope = "2";
} else {
ope = "0";
}
}
if(ope == null || ope.equals("0") || ope.equals("2")){
session.setAttribute("operation",request.getParameter("0"));
%>
<html>
<head>
<title>��ƌv��m�F���</title>
<SCRIPT 
src="jkl-calendar.js" 
type=text/javascript charset=Shift_JIS></SCRIPT>
</head>
<body>
<center>
<a href="select-plan-Page.jsp"><font size=2 color="black">��Ɨ\��\�����</font></a>
<FONT COLOR="Crimson">�����t�F<%= cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.DATE)%></FONT>
<form id=formid action="update-plan-Page.jsp" method="post">
<SCRIPT><!--
    var search_10 = new JKL.Calendar("search_10","formid","search_word_10");
	search_10.setStyle( "frame_color", "#3333CC" );
    var search_12 = new JKL.Calendar("search_12","formid","search_word_12");
	search_12.setStyle( "frame_color", "#CC3333" );
//--></SCRIPT>
<TABLE><TR><TD>
<TD><FONT COLOR="Crimson">������1�F</FONT></TD>
<TD><DIV id=search_10></DIV></TD>
<TD><input type="text" onclick="search_10.hide(); search_10.write();" onchange="search_10.getFormValue(); search_10.hide();" name="search_word_10" value="<%=search_word_10%>" size="30" maxlength="30"></TD>
<TD><FONT COLOR="Crimson">������2�F</FONT></TD>
<TD><DIV id=search_12></DIV></TD>
<TD><input type="text" onclick="search_12.hide(); search_12.write();" onchange="search_12.getFormValue(); search_12.hide();" name="search_word_12" value="<%=search_word_12%>" size="30" maxlength="30"></TD>
<TD><FONT COLOR="Crimson">ID�F</FONT></TD>
<TD><input type="text" name="search_word_11" value="<%=search_word_11%>" size="3" maxlength="30"></TD>
<TD><FONT COLOR="Crimson">�S���F</FONT></TD>
<TD><select name="topic_user_plan_1">
<%
if(topic_user_plan_1 != null && !topic_user_plan_1.equals("")){
db.getQuery("select * from " + ClassDefine.user_info + " where user_id = '" + topic_user_plan_1 + "';");
if(db.getNext()){
%>
<option value="<%= db.getResult("user_id")%>">
<%=  db.getResult("user_name")%>
</option>
<%
}
}
%>
<option value="-1"></option>
<%
db.getQuery("select * from " + ClassDefine.user_info + " order by user_name;");
while(db.getNext()){
%>
<option value="<%= db.getResult("user_id")%>">
<%=  db.getResult("user_name")%>
</option>
<%
}
%>
</select></TD>
<TD><input name="ope" type="hidden" value="2"></TD>
<TD><FONT COLOR="Crimson">�J�����_�[�F</FONT>
</TD>
<TD><select name="calender1">
<%
if(calender == null || calender.equals("") || calender.equals("0")){
%>
<option value="0">OFF</option>
<%
} else if(calender != null&& calender.equals("1")){
%>
<option value="1">ON</option>
<%
}
%>
<option value="0">OFF</option>
<option value="1">ON</option>
</select>
</TD>
</TR>
<TR><TD align="center" colspan=15><input type="submit" value="����">  <input type="reset" value="���o�������Z�b�g"></TD>
</TR></TABLE>
</form>
<form id=formid1 action="update-plan-Page.jsp" method="post">

<table><tr><td valign="top">
<table border="2" cellspacing=0 bordercolor="#666666">
<tr bgcolor="#ffff99">
<td align="center">���t</td>
<td align="center">�J�n��</td>
<td align="center">������</td>
<td align="center">ID</td>
<td align="center">�ۑ薼</td>
<td align="center">�H��</td>
<td align="center">���</td>
<td align="center">�S��</td>
<td align="center">�i��</td>
<td align="center">���l</td>
<td align="center">�X�V</td>
</tr>
<%
if(ope != null && ope.equals("2") && (!search_word_10.equals("") || !search_word_12.equals(""))){
if(!search_word_10.equals("") && search_word_12.equals("")){
db.getQuery("select * from " + ClassDefine.topic_plan + " where date >= '" + search_word_10 + " 00:00:00' order by date,id;");
} else if(search_word_10.equals("") && !search_word_12.equals("")){
db.getQuery("select * from " + ClassDefine.topic_plan + " where date <= '" + search_word_12 + " 23:59:59' order by date,id;");
} else {
db.getQuery("select * from " + ClassDefine.topic_plan + " where date >= '" + search_word_10 + " 00:00:00' and date <= '" + search_word_12 + " 23:59:59' order by date,id;");
}
} else if (ope.equals("2") && !search_word_11.equals("")){
db.getQuery("select * from " + ClassDefine.topic_plan + " where id=" + Integer.parseInt(search_word_11) + " order by date,id;");
}
int i = 0;
while(db.getNext()){
if((topic_user_plan_1 == null || topic_user_plan_1.equals("-1") || topic_user_plan_1.equals(db.getResult("user_name"))) && 
   (search_word_11 == null || search_word_11.equals("") ||  db.getResult("id").equals(search_word_11))){
/*** 2012/4/4 S ***/
if(currentdate != null && !currentdate.equals(db.getResult("date").substring(0,10))){
%>
</table><br>
<table border="2" cellspacing=0 bordercolor="#666666">
<tr bgcolor="#ffff99">
<td align="center">���t</td>
<td align="center">�J�n��</td>
<td align="center">������</td>
<td align="center">ID</td>
<td align="center">�ۑ薼</td>
<td align="center">�H��</td>
<td align="center">���</td>
<td align="center">�S��</td>
<td align="center">�i��</td>
<td align="center">���l</td>
<td align="center">�X�V</td>
</tr>

<%
}
currentdate = db.getResult("date").substring(0,10);
/*** 2012/4/4 E ***/
if(day.after(sdf1.parse(dayop.editDate(db.getResult("complete_date"))))){
%>
<tr bgcolor="#FFFF00">
<%
} else {
%>
<tr>
<%
}
%>
<!- /*** ������\�� ***/ ->


<td align="center">
<%
if(calender != null && !calender.equals("") && !calender.equals("0")){
%>
<SCRIPT><!--
    var topic_date_<%= i%> = new JKL.Calendar("topic_date_<%= i%>","formid1","topic_date[<%= i%>]");
	topic_date_<%= i%>.setStyle( "frame_color", "#3333CC" );
//--></SCRIPT>
<DIV id=topic_date_<%= i%>></DIV>
<input onclick="topic_date_<%= i%>.hide(); topic_date_<%= i%>.write();" onchange="topic_date_<%= i%>.getFormValue(); topic_date_<%= i%>.hide();" name="topic_date[<%= i%>]" type="text" value="<%= dayop.editDate(db.getResult("date").substring(0,10))%>" size="30">
<%
} else {
%>
<input name="topic_date[<%= i%>]" type="text" value="<%= dayop.editDate(db.getResult("date").substring(0,10))%>" size="30">
<%
}
%>
</td>
<td nowrap>
<select name = "topic_date_hour[<%= i%>]">
<option value="<%= db.getResult("date").substring(11,13)%>"><%=db.getResult("date").substring(11,13)%></option>
<option value="00">00</option>
<option value="01">01</option>
<option value="02">02</option>
<option value="03">03</option>
<option value="04">04</option>
<option value="05">05</option>
<option value="06">06</option>
<option value="07">07</option>
<option value="08">08</option>
<option value="09">09</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
<option value="13">13</option>
<option value="14">14</option>
<option value="15">15</option>
<option value="16">16</option>
<option value="17">17</option>
<option value="18">18</option>
<option value="19">19</option>
<option value="20">20</option>
<option value="21">21</option>
<option value="22">22</option>
<option value="23">23</option>
</select>
<select name = "topic_date_min[<%= i%>]">
<option value="<%= db.getResult("date").substring(14,16)%>"><%= db.getResult("date").substring(14,16)%></option>
<option value="00">00</option>
<option value="15">15</option>
<option value="30">30</option>
<option value="45">45</option>
</select>
<input type="hidden" name="old_topic_date[<%= i%>]" value="<%= db.getResult("date")%>"></input>
</td>
<td nowrap>
<select name = "complete_date_hour[<%= i%>]">
<%
if(!db.getResult("complete_date").equals("1111-11-11 00:00:00")){
%>
<option value="<%= db.getResult("complete_date").substring(11,13)%>"><%=db.getResult("complete_date").substring(11,13)%></option>
<%
}
%>
<option value="00">00</option>
<option value="01">01</option>
<option value="02">02</option>
<option value="03">03</option>
<option value="04">04</option>
<option value="05">05</option>
<option value="06">06</option>
<option value="07">07</option>
<option value="08">08</option>
<option value="09">09</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
<option value="13">13</option>
<option value="14">14</option>
<option value="15">15</option>
<option value="16">16</option>
<option value="17">17</option>
<option value="18">18</option>
<option value="19">19</option>
<option value="20">20</option>
<option value="21">21</option>
<option value="22">22</option>
<option value="23">23</option>
</select>
<select name = "complete_date_min[<%= i%>]">
<%
if(!db.getResult("complete_date").equals("1111-11-11 00:00:00")){
%>
<option value="<%= db.getResult("complete_date").substring(14,16)%>"><%= db.getResult("complete_date").substring(14,16)%></option>
<%
}
%>
<option value="00">00</option>
<option value="15">15</option>
<option value="30">30</option>
<option value="45">45</option>
</select>
</td>
<input type="hidden" name="old_comp_topic_date[<%= i%>]" value="<%= db.getResult("complete_date")%>"></input>
<!- /*** ID��\�� ***/ ->
<td align="center">
<input type="hidden" name="id[<%= i%>]" value="<%= db.getResult("id")%>"><%= db.getResult("id")%></input>
</td>
<!- /*** �ۑ薼��\�� ***/ ->
<td nowrap>
<%
topic_db.getQuery("select topic_name,kind_id,topic_sub_id from " + ClassDefine.topic_info + " where topic_id=" + db.getResult("id") + ";");
topic_db.getNext();
%>
<%= topic_db.getResult("topic_name")%>
</td>
<td nowrap>
<%
String topic_sub_id_current = topic_db.getResult("topic_sub_id");
if(topic_sub_id_current.equals("0")){
%>
�v����`
<%
} else if(topic_sub_id_current.equals("1")){
%>
��{�݌v
<%
}  else if(topic_sub_id_current.equals("2")){
%>
�T�v�݌v
<%
}  else if(topic_sub_id_current.equals("3")){
%>
�ڍא݌v
<%
}  else if(topic_sub_id_current.equals("4")){
%>
����
<%
}  else if(topic_sub_id_current.equals("5")){
%>
�P�̎���
<%
}  else if(topic_sub_id_current.equals("6")){
%>
��������
<%
}  else if(topic_sub_id_current.equals("7")){
%>
���艻����
<%
}  else if(topic_sub_id_current.equals("8")){
%>
�ێ��Ǘ�
<%
}  else if(topic_sub_id_current.equals("9")){
%>
���̑�
<%
}
%>
</td>
<!- /*** ��ʂ�\�� ***/ ->
<td nowrap>
<%
kindDB.getQuery("select * from " + ClassDefine.topic_kind + " where kind_id = " + topic_db.getResult("kind_id") + ";");
kindDB.getNext();
%>
<%= kindDB.getResult("kind")%>
</td>
<td align="center" nowrap>
<%
user_db.getQuery("select * from " + ClassDefine.user_info + " where user_id='" + db.getResult("user_name") + "';");
user_db.getNext();
%>
<select name="new_user_name[<%= i%>]">
<option value= "<%= user_db.getResult("user_id")%>"><%= user_db.getResult("user_name")%></option>
<%
user_db.getQuery("select * from " + ClassDefine.user_info + " order by user_name;");
while(user_db.getNext()){
%>
<option value="<%= user_db.getResult("user_id")%>">
<%=  user_db.getResult("user_name")%>
</option>
<%
}
%>
</select>
<input type="hidden" name="user_name[<%= i%>]" value="<%= db.getResult("user_name")%>"></input>
</td>
<td align="center"><input type="text" name="topic_shinchoku[<%= i%>]" value="<%= db.getResult("shinchoku")%>" size="5"></input></td>
<td>
<%
strarray = db.getResult("biko").split("\n");
%>
<textarea rows="<%= strarray.length%>" cols="50" name="biko[<%= i%>]" wrap=hard><%= db.getResult("biko")%></textarea>
</td>
<td nowrap><input type="submit" value="�X�V"><input type="reset" value="���Z�b�g"></td>
<tr>
<%
i++;
}
}
%>
</table><br>
<table border="1" cellspacing=0 bordercolor="#666666">
<tr bgcolor="#ffff99">
<td align="center">���t</td>
<td align="center">�J�n��</td>
<td align="center">������</td>
<td align="center">ID</td>
<td align="center">�ۑ薼</td>
<td align="center">�H��</td>
<td align="center">���</td>
<td align="center">�S��</td>
<td align="center">�i��</td>
<td align="center">���l</td>
<td align="center">�X�V</td>
</tr>
<%
for(int j = 0;j < 6;j++){
%>
<!- /*** ������\�� ***/ ->
<tr>
<td align="center">
<%
if(calender != null && !calender.equals("") && !calender.equals("0")){
%>
<SCRIPT><!--
    var topic_date_<%= i%> = new JKL.Calendar("topic_date_<%= i%>","formid1","topic_date[<%= i%>]");
	topic_date_<%= i%>.setStyle( "frame_color", "#3333CC" );
//--></SCRIPT>
<DIV id=topic_date_<%= i%>></DIV>
<input onclick="topic_date_<%= i%>.hide(); topic_date_<%= i%>.write();" onchange="topic_date_<%= i%>.getFormValue(); topic_date_<%= i%>.hide();" name="topic_date[<%= i%>]" type="text" value="" size="30">
<%
} else {
%>
<input name="topic_date[<%= i%>]" type="text" value="" size="30">
<%
}
%>
</td>
<td nowrap>
<select name = "topic_date_hour[<%= i%>]">
<option value="00">00</option>
<option value="01">01</option>
<option value="02">02</option>
<option value="03">03</option>
<option value="04">04</option>
<option value="05">05</option>
<option value="06">06</option>
<option value="07">07</option>
<option value="08">08</option>
<option value="09">09</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
<option value="13">13</option>
<option value="14">14</option>
<option value="15">15</option>
<option value="16">16</option>
<option value="17">17</option>
<option value="18">18</option>
<option value="19">19</option>
<option value="20">20</option>
<option value="21">21</option>
<option value="22">22</option>
<option value="23">23</option>
</select>
<select name = "topic_date_min[<%= i%>]">
<option value="00">00</option>
<option value="15">15</option>
<option value="30">30</option>
<option value="45">45</option>
</select>
<input type="hidden" name="old_topic_date[<%= i%>]" value=""></input>
</td>
<td nowrap>
<select name = "complete_date_hour[<%= i%>]">
<option value="00">00</option>
<option value="01">01</option>
<option value="02">02</option>
<option value="03">03</option>
<option value="04">04</option>
<option value="05">05</option>
<option value="06">06</option>
<option value="07">07</option>
<option value="08">08</option>
<option value="09">09</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
<option value="13">13</option>
<option value="14">14</option>
<option value="15">15</option>
<option value="16">16</option>
<option value="17">17</option>
<option value="18">18</option>
<option value="19">19</option>
<option value="20">20</option>
<option value="21">21</option>
<option value="22">22</option>
<option value="23">23</option>
</select>
<select name = "complete_date_min[<%= i%>]">
<option value="00">00</option>
<option value="15">15</option>
<option value="30">30</option>
<option value="45">45</option>
</select>
</td>
<!- /*** ID��\�� ***/ ->
<td align="center">
<input type="text" name="id[<%= i%>]" value="" size="4"></input>
</td>
<td><br></td>
<td><br></td><td><br></td>
<td align="center" nowrap>
<select name="user_name[<%= i%>]">
<%
user_db.getQuery("select * from " + ClassDefine.user_info + " order by user_name;");
while(user_db.getNext()){
%>
<option value="<%= user_db.getResult("user_id")%>">
<%=  user_db.getResult("user_name")%>
</option>
<%
}
%>
</select>
</td>
<td><br></td>
<td><br></td>
<td nowrap><input type="submit" value="�X�V"><input type="reset" value="���Z�b�g"></td>
<tr>
<%
i++;
}
%>
</table></td></tr></table>
<input type="hidden" name="kensu" value="<%=i%>"></input>
<!- /*** ���� ***/ ->
<input name="ope" type="hidden" value="1">
</form>
<center>
</body>
</html>
<%
}
else {
session.setAttribute("operation","1");
/*** �o�^�����擾 ***/
int kensu = 0;
if(request.getParameter("kensu") != null && !request.getParameter("kensu").equals("")){
kensu = Integer.parseInt(request.getParameter("kensu"));
}
/*** ���̃g�s�b�NID���擾 ***/
String topic_date = null;
String topic_hour = null;
String topic_min = null;
String old_topic_date = null;
String topic_comp_date = null;
String complete_date_hour = null;
String complete_date_min = null;
String old_comp_topic_date = null;
String id = null;
String user_name = null;
String new_user_name = null;
String kind = null;
String biko = null;
String topic_shinchoku = null;
Date dateFrom2;
Calendar cal2 = Calendar.getInstance();
int i=0;

for(i=0;i<kensu;i++){
topic_date = request.getParameter("topic_date[" + i + "]");
old_topic_date = request.getParameter("old_topic_date[" + i + "]");
topic_hour = request.getParameter("topic_date_hour[" + i + "]");
topic_min = request.getParameter("topic_date_min[" + i + "]");
complete_date_hour = request.getParameter("complete_date_hour[" + i + "]");
complete_date_min = request.getParameter("complete_date_min[" + i + "]");
if(topic_date != null && old_topic_date != null && topic_date.equals("") && !old_topic_date.equals("")){
topic_date="1111-11-11";
}
if(topic_hour == null || topic_hour.equals("")){
topic_hour="00";
}
if(topic_min == null || topic_min.equals("")){
topic_min="00";
}
if(complete_date_hour == null || complete_date_hour.equals("")){
complete_date_hour="00";
}
if(complete_date_min == null || complete_date_min.equals("")){
complete_date_min="00";
}
if(complete_date_hour.equals("00") && complete_date_min.equals("00") && topic_date != null && !topic_date.equals("")){
dateFrom2 = sdf2.parse(dayop.editDate(topic_date));
cal2.setTime(dateFrom2);
cal2.add(Calendar.DATE, 1);
topic_comp_date = cal2.get(Calendar.YEAR) + "/" + (cal2.get(Calendar.MONTH) + 1) + "/" + cal2.get(Calendar.DATE) + " " + complete_date_hour + ":" + complete_date_min;
} else {
topic_comp_date = topic_date + " " + complete_date_hour + ":" + complete_date_min;
}
if(topic_date != null && !topic_date.equals("")){
topic_date = topic_date + " " + topic_hour + ":" + topic_min;
}

kind = request.getParameter("kind[" + i + "]");
biko = request.getParameter("biko[" + i + "]");
if(biko == null){
biko = "";
}
topic_shinchoku = request.getParameter("topic_shinchoku[" + i + "]");
if(topic_shinchoku == null){
topic_shinchoku = "0";
}
if(topic_date != null && !topic_date.equals("") && old_topic_date != null && !old_topic_date.equals("")){
id = request.getParameter("id[" + i + "]");
user_name = request.getParameter("user_name[" + i + "]");
new_user_name = request.getParameter("new_user_name[" + i + "]");
db.exeQuery("update " + ClassDefine.topic_plan + " set date = '" + topic_date + "',complete_date='" + topic_comp_date + "',biko = '" + biko + "', shinchoku = " + topic_shinchoku + ", user_name='" + new_user_name + "' where id = " + id +" and date='" + old_topic_date + "' and user_name='" + user_name + "';");
}else if(topic_date != null && !topic_date.equals("") && old_topic_date.equals("") && topic_comp_date != null && !topic_comp_date.equals("")){
id = request.getParameter("id[" + i + "]");
user_name = request.getParameter("user_name[" + i + "]");
db.exeQuery("insert into " + ClassDefine.topic_plan + " values('" + topic_date + "','" + topic_comp_date + "'," + id + ",'" + user_name + "','" + biko + "'," + topic_shinchoku + ");");
}
}
db.exeQuery("delete from " + ClassDefine.topic_plan + " where date='1111-11-11 00:00:00'");
db.closeDB();
topic_db.closeDB();
user_db.closeDB();
%>
<jsp:forward page="update-plan-Page.jsp" />
<%
}
db.closeDB();
topic_db.closeDB();
user_db.closeDB();
%>