<%@
page import = "java.io.*"
import = "javax.servlet.*"
import = "javax.servlet.http.*"
import = "java.util.*"
pageEncoding="shift-jis"
contentType = "text/html; charset = shift-jis"
%>
<%
//request.setCharacterEncoding("shift-jis");
//�}�b�N�X�̃f�[�^��
final int max_Number = 10000;
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

Day_Operation day = new Day_Operation();

/*** �p�X���[�h�F��(START) ***/

//�Z�b�V�����ϐ��̎擾
String user = (String)session.getAttribute("user");
String pass = (String)session.getAttribute("pass");
//���[�U���ɑΉ�����p�X���[�h
String sendPass = "";
String kubun = "";
//�F��
db.getQuery("select userpass,kubun from " + ClassDefine.userpass + " where username='" + user + "';");
if(db.getNext()){
sendPass = db.getResult("userpass");
kubun = db.getResult("kubun");
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
String nowday = (cal.getTime()).toString();

//���b�N���[�U�\���p
DB_Operation user_db = new DB_Operation();
DB_Operation tag_db = new DB_Operation();
DB_Operation parent_tag_db = new DB_Operation();

//�����������擾
String buttom_Date = null;
String top_Date = null;
String search_word_5 = null;
String search_word_6 = null;
String before_search_word_6 = null;
String search_word_7 = null;
String search_word_8 = null;
String search_word_9 = null;
String search_word_9_id = null;
String current = null;
String view = null;
/*** ���������̗L�� ***/
String search = null;
/*** �������ǂ������m�F ***/
search = request.getParameter("search");
if(search != null && search.equals("1")){

//�����������擾
buttom_Date = request.getParameter("buttom_Date");
top_Date = request.getParameter("top_Date");
view = request.getParameter("view");

/*** ������ ***/
search_word_5 = request.getParameter("search_word_5");//������1
search_word_6 = (String)session.getAttribute("search_word_6");//������2
before_search_word_6 = search_word_6;
search_word_6 = request.getParameter("search_word_6");//������2
search_word_7 = request.getParameter("search_word_7");//������3
search_word_8 = request.getParameter("search_word_8");//������4
search_word_9 = request.getParameter("search_word_9");//������4
if(search_word_9 != null && !search_word_9.equals("")){
tag_db.getQuery("select * from " + ClassDefine.tag + " where full_dir='" + search_word_9 +"';");
if(tag_db.getNext()){
search_word_6 = tag_db.getResult("tag_id");
search_word_9 = "";
}
}
// �Z�b�V�����ϐ��̊i�[
session.setAttribute("search_word_5",search_word_5);
session.setAttribute("search_word_6",search_word_6);
session.setAttribute("search_word_7",search_word_7);
session.setAttribute("search_word_8",search_word_8);
session.setAttribute("search_word_9",search_word_9);
session.setAttribute("buttom_Date",buttom_Date);
session.setAttribute("top_Date",top_Date);
session.setAttribute("view",view);
}
else{
buttom_Date = (String)session.getAttribute("buttom_Date");
if(buttom_Date == null){
buttom_Date = "";
}
top_Date = (String)session.getAttribute("top_Date");
if(top_Date == null){
top_Date = "";
}
search_word_5 = (String)session.getAttribute("search_word_5");//������1
if(search_word_5 == null){
search_word_5 = "";
}
search_word_6 = (String)session.getAttribute("search_word_6");//������2
search_word_7 = (String)session.getAttribute("search_word_7");//������3
if(search_word_7 == null){
search_word_7 = "";
}
search_word_8 = (String)session.getAttribute("search_word_8");//������4
search_word_9 = (String)session.getAttribute("search_word_9");//������4
if(search_word_9 == null){
search_word_9 = "";
}
view = (String)session.getAttribute("view");
if(view == null){
view = "";
}
}

//SQL�����i�[����ϐ�
String sql = "select * from " + ClassDefine.query;
if(buttom_Date != null && top_Date != null){
if(!buttom_Date.equals("") || !top_Date.equals("")){
//���t����������̂ǂ��炩�����Ȃ炸���͂���Ă���ꍇ
if(!buttom_Date.equals("") && !top_Date.equals("")){
//��������ǂ�������͂���Ă���ꍇ
sql = sql.concat(" where date >= '" + day.undoDate(buttom_Date) + "' and date <= '" + day.undoDate(top_Date) + "'");
}
else if(!buttom_Date.equals("")){
//�����݂̂����͂���Ă���ꍇ
sql = sql.concat(" where date >= '" + day.undoDate(buttom_Date) + "'");
}
else if(!top_Date.equals("")){
//����݂̂����͂���Ă���ꍇ
sql = sql.concat(" where date <= '" + day.undoDate(top_Date) + "'");
}
sql = sql.concat(" order by date desc,username");
}
else {
//���t�̌������������͂���Ȃ������ꍇ
sql = sql.concat(" order by date desc,username");
}
}
else {
sql = sql.concat(" order by date desc,username");
}
if(view != null && !view.equals("") && view.equals("1")){
db.getQuery(sql);
}
//�f�[�^�x�[�X����query��ǂݍ���
//out.println(sql);
%>
<html>
<head>
<title>  �����Ǘ��y�[�W </title>
<SCRIPT 
src="jkl-calendar.js" 
type=text/javascript charset=Shift_JIS></SCRIPT>
</head>
<body>
<center>
<form id=formid action="Kubun_A_Browse.jsp" method="post">
<SCRIPT><!--
    var buttom = new JKL.Calendar("buttom","formid","buttom_Date");
	buttom.setStyle( "frame_color", "#3333CC" );
    var top = new JKL.Calendar("top","formid","top_Date");
	top.setStyle( "frame_color", "#CC3333" );
//--></SCRIPT>
<br>
<TABLE><TR>
<TD><input type="hidden" name="search" value="1"></TD>
<TD><FONT COLOR="Crimson">������F</FONT></TD>
<TD><input type="text" name="search_word_5" value="<%= search_word_5%>" size="30" maxlength="30"></TD>
<TD><FONT COLOR="Crimson">ID�F</FONT></TD>
<TD><input type="text" name="search_word_7" value="<%= search_word_7%>" size="5" maxlength="30"></TD>
<TD><FONT COLOR="Crimson">�\���F</FONT></TD>
<TD><select name="search_word_8">
<%
if(search_word_8 == null || search_word_8.equals("") || search_word_8.equals("0")){
%>
<option value="0">�S��</option>
<%
} else if(search_word_8.equals("1")){
%>
<option value="1">���b�N��</option>
<%
}
%>
<option value="0">�S��</option>
<option value="1">���b�N��</option>
</select></TD>
<TD><FONT COLOR="Crimson">�t���p�X�w��F</FONT></TD>
<TD><input type="text" name="search_word_9" value="<%= search_word_9%>" size="30" maxlength="1000"></TD></TR></TABLE>
<TABLE><TR>
<TD><FONT COLOR="Crimson">�������F<%=nowday%></FONT></TD>
<TD><FONT COLOR="Crimson">�X�V��</FONT></TD>
<TD><DIV id=buttom></DIV></TD>
<TD><input type="text" onclick="buttom.hide(); buttom.write();" onchange="buttom.getFormValue(); buttom.hide();" name="buttom_Date" value="<%= buttom_Date%>" size="15" maxlength="10"></TD>
<TD>�`</TD>
<TD><DIV id=top></DIV></TD>
<TD><input type="text" onclick="top.hide(); top.write();" onchange="top.getFormValue(); top.hide();" name="top_Date" value="<%= top_Date%>" size="15" maxlength="10"><FONT COLOR="Crimson"></TD>
<TD><FONT COLOR="Crimson">�f�B���N�g���ړ��F</FONT></TD>
<TD><select name="search_word_6">
<%
if(search_word_6 == null || search_word_6.equals("")){
tag_db.getQuery("select * from " + ClassDefine.tag + " where parent_id = " + -1 + " order by tag;");
current = "TOP/";
} else if (search_word_6.equals("-2")){
if(before_search_word_6 != null && !before_search_word_6.equals("")){
tag_db.getQuery("select * from " + ClassDefine.tag + " where tag_id = " + before_search_word_6 + ";");
tag_db.getNext();
search_word_6 = tag_db.getResult("parent_id");
if(search_word_6 != null && !search_word_6.equals("") && !search_word_6.equals("-1")){
tag_db.getQuery("select * from " + ClassDefine.tag + " where tag_id = " + search_word_6 + " order by tag;");
tag_db.getNext();
%>
<option value="<%= tag_db.getResult("tag_id")%>"><%= tag_db.getResult("tag")%></option>
<%
current = tag_db.getResult("full_dir");
}
tag_db.getQuery("select * from " + ClassDefine.tag + " where parent_id = " + search_word_6 + " order by tag;");
if(search_word_6.equals("-1")) {
search_word_6 = "";
current = "TOP/";
}
session.setAttribute("search_word_6",search_word_6);
} else {
search_word_6 = "";
session.setAttribute("search_word_6",search_word_6);
tag_db.getQuery("select * from " + ClassDefine.tag + " where parent_id = " + -1 + " order by tag;");
current = "TOP/";
}
} else {
tag_db.getQuery("select * from " + ClassDefine.tag + " where tag_id = " + search_word_6 + " order by tag;");
tag_db.getNext();
%>
<option value="<%= tag_db.getResult("tag_id")%>"><%= tag_db.getResult("tag")%></option>
<%
current = tag_db.getResult("full_dir");
tag_db.getQuery("select * from " + ClassDefine.tag + " where parent_id = " + search_word_6 + " order by tag;");
}
%>
<option value="">TOP</option>
<option value="-2">���</option>
<%
while(tag_db.getNext()){
%>
<option value="<%= tag_db.getResult("tag_id")%>"><%= tag_db.getResult("tag")%></option>
<%
}
%>
</select></TD></TR></TABLE>
<TABLE><TR>
<TD><FONT COLOR="Crimson">�J�����g�f�B���N�g���F</FONT><%= current%></TD>
</td>
<td nowrap>
<%
if(view == null || view.equals("") || view.equals("0")){
%>
�@��\��<input type="radio" name="view" value="0" checked>
�\��<input type="radio" name="view" value="1">
<%
} else if(view.equals("1")){
%>
�@��\��<input type="radio" name="view" value="0">
�\��<input type="radio" name="view" value="1" checked>
<%
}
%>
</td>
</TR></TABLE>
<input type="submit" value="����">  <input type="reset" value="���o�������Z�b�g"></form>
<form action="Input-tag-Page.jsp" method="post" style="display: inline">�o�^�����F<input name="kensu" type="text" value="" size="5"><input type="submit" value="�^�O�o�^"></form>
<FONT COLOR="Crimson">
<a href="tag_view.jsp" target="_blank"><font size=2 color="black">�f�B���N�g���ꗗ</font></a>
<a href="file_view.jsp" target="_blank"><font size=2 color="black">�t�@�C���ꗗ</font></a>
<a href="Kubun_A_Browse_View.jsp"><font size=2 color="black">�\���p</font></a>
<%
int num = 0;//�f�[�^�̌�
%>
<table border="1" cellspacing=0 bordercolor="#666666">

<tr>
<td align="center" nowrap bgcolor="#e8e8e8">ID</td>
<td align="center" nowrap bgcolor="#e8e8e8">���t</td>
<td align="center" nowrap bgcolor="#e8e8e8">�T�v</td>
<td align="center" nowrap bgcolor="#e8e8e8">�f�B���N�g��</td>
<td align="center" nowrap bgcolor="#e8e8e8">�\���ݒ�</td>
<td align="center" nowrap bgcolor="#e8e8e8">���b�N</td>
<td align="center" nowrap bgcolor="#e8e8e8">delete</td>
<td align="center" nowrap bgcolor="#e8e8e8">File</td>
<td align="center" nowrap bgcolor="#e8e8e8">����</td>
<td align="center" nowrap bgcolor="#e8e8e8">���M�t�@�C��</td>
<td align="center" nowrap width="100" bgcolor="#e8e8e8">�X�V</td>
</tr>
<tr>
<form action="Kubun_A_Input.jsp" method="post">
<td nowrap><input type="hidden" name="no" value="-"></td>
<td nowrap> </td>
<td nowrap><input type="text" name="text" value="" size="70" maxlength="40">
<%/*<textarea rows="1" cols="70" name="text"></textarea>*/%>
</td>
<%
if((search_word_6 == null || search_word_6.equals("")) && (search_word_9 == null || search_word_9.equals(""))){
%>
<td nowrap align="center"><select name="tag">
<%
tag_db.getQuery("select * from " + ClassDefine.tag + " order by full_dir;");
while(tag_db.getNext()){
%>
<option value="<%= tag_db.getResult("tag_id")%>"><%= tag_db.getResult("full_dir")%></option>
<%
}
%>
</select></td>
<%
} else if(search_word_6 != null && !search_word_6.equals("")){
tag_db.getQuery("select * from " + ClassDefine.tag + " where tag_id = " + search_word_6 + ";");
tag_db.getNext();
%>
<td nowrap><input type="hidden" name="tag" value="<%= tag_db.getResult("tag_id")%>"><%= tag_db.getResult("full_dir")%></td>
<%
} else if(search_word_9 != null && !search_word_9.equals("")){
tag_db.getQuery("select * from " + ClassDefine.tag + " where full_dir = '" + search_word_9 + "';");
tag_db.getNext();
%>
<td nowrap><input type="hidden" name="tag" value="<%= tag_db.getResult("tag_id")%>"><%= tag_db.getResult("full_dir")%></td>
<%
} 
%>
<td align="center" nowrap><select name="sercret">
<option value="0"> </option>
<option value="1">�V�[�N���b�g</option>
</select></td>
<td align="center" nowrap><input type="hidden" name="row" value="0"><br></td>
<td align="center" nowrap><br></td>
<td nowrap><br></td>
<td align="center" nowrap><br></td>
<td nowrap><input type="file" name="file"  nowrap></td>
<td nowrap><input type="submit" value="���M" nowrap><input type="reset" value="���Z�b�g"></td>
</form>
</tr>
<%
tag_db.getQuery("select * from " + ClassDefine.tag + " where full_dir = '" + search_word_9 + "';");
if(tag_db.getNext()){
search_word_9_id = tag_db.getResult("tag_id");
}
while(db.getNext()){
if((((search_word_5 == null) || search_word_5.equals("")) || (db.getResult("text").indexOf(search_word_5) != -1)) &&
   /*(((search_word_6 == null) || search_word_6.equals("")) || (db.getResult("check1").equals(search_word_6))) && */
   (((((search_word_9 != null) && !search_word_9.equals("")) || ((search_word_5 != null) && !search_word_5.equals("")) || ((search_word_7 != null) && !search_word_7.equals("")) || ((search_word_8 != null) && search_word_8.equals("1"))) && (search_word_6 == null || search_word_6.equals(""))) || (db.getResult("check1").equals(search_word_6))) &&
   (((search_word_7 == null) || search_word_7.equals("")) || (Integer.parseInt(db.getResult("no")) == Integer.parseInt(search_word_7))) &&
   (((search_word_8 == null) || search_word_8.equals("")) ||  (db.getResult("username").equals(user) && search_word_8.equals("1")) || search_word_8.equals("0")) &&
   (((search_word_9 == null) || search_word_9.equals("")) || db.getResult("check1").equals(search_word_9_id)) &&
   (db.getResult("check2").equals("0") || (db.getResult("check2").equals("1") && (db.getResult("username").equals(user) || db.getResult("username").equals("dummy"))))){
%>
<tr>
<%
int row = 1;
if(!db.getResult("kubun").equals("0")){
row = Integer.parseInt(db.getResult("kubun"));
}
%>
<form action="Kubun_A_Input_file.jsp" enctype="multipart/form-data" method="post" >
<td align="left" nowrap><input type="hidden" name="no" value="<%= db.getResult("no")%>">
<a href="PDF_File/htbbs<%= db.getResult("no")%>.jsp" target="_blank"><%= db.getResult("no")%></a>
</td>
<td nowrap><%= day.editDate(db.getResult("date"))%></td>
<td>
<input type="text" name="text" value="<%= db.getResult("text")%>" size="70" maxlength="40">
<%/*<textarea rows="*/%><%/*= row*/%><%/*" cols="70" name="text">*/%><%/*= db.getResult("text")*/%><%/*</textarea>*/%>
</td>
<td nowrap>
<%
tag_db.getQuery("select * from " + ClassDefine.tag + " where tag_id = " + db.getResult("check1") + ";");
tag_db.getNext();
%>
<input type="hidden" name="tag" value="<%= tag_db.getResult("tag_id")%>"><%= tag_db.getResult("full_dir")%></td>
<td align="center" nowrap><select name="sercret">
<%
if(db.getResult("check2").equals("1")){
%>
<option value="1">�V�[�N���b�g</option>
<option value="0"> </option>
<%
} else {
%>
<option value="0"> </option>
<option value="1">�V�[�N���b�g</option>
<%
}
%>
</select></td>
<td align="center" nowrap><select name="row">
<%
//if(!db.getResult("kubun").equals("0")){
if(!db.getResult("username").equals("dummy")){
user_db.getQuery("select name from " + ClassDefine.userpass + " where username='" + db.getResult("username") + "';");
user_db.getNext();
%>
<option value="1"><%= user_db.getResult("name")%></option>
<option value="0">���b�N����</option>
<%
}
else {
%>
<option value="0">���b�N����</option>
<%
}
%>
</select></td>
<td align="center" nowrap>
<select name="ope">
<option value="0"> </option>
<option value="1">�폜</option>
</select>
</td>
<%
if(!db.getResult("file").equals("")){
%>
<td nowrap><a href="PDF_File/<%= db.getResult("file")%>"><%= db.getResult("file")%></a></td>
<%
}
else {
%>
<td width="50" nowrap><br></td>
<%
}
%>
<td align="center" nowrap><input type="text" name="check3" value="<%= db.getResult("check3")%>" size="3"></td>
<td nowrap><input type="file" name="file" ></td>
<%
if(!db.getResult("username").equals("dummy")){
%>
<td nowrap><input type="submit" value="�o�^"><input type="reset" value="���Z�b�g"></td>
<%
} else{
%>
<td nowrap><input type="submit" value="���b�N"><input type="reset" value="���Z�b�g"></td>
<%
}
%>
</form>
</tr>
<%
num++;
}
}
%>
</table>
</center>
</body>
</html>
<%
db.closeDB();
user_db.closeDB();
tag_db.closeDB();
parent_tag_db.closeDB();
%>
