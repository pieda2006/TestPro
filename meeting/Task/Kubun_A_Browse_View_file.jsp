<%@
page import = "java.io.*"
import = "javax.servlet.*"
import = "javax.servlet.http.*"
import = "java.util.*"
pageEncoding="shift-jis"
contentType = "text/html; charset = shift-jis"
%>
<%
request.setCharacterEncoding("shift-jis");
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
String rireki = null;

/*** ���������̗L�� ***/
String search = null;
/*** �������ǂ������m�F ***/
Vector dataList = null;
Hashtable data = null;
int size = 0;
String biko = null;
Escape_String convert = new Escape_String();

search = request.getParameter("search");
if(search != null && search.equals("1")){

//�����������擾
buttom_Date = request.getParameter("buttom_Date");
top_Date = request.getParameter("top_Date");
view = request.getParameter("view");
rireki = request.getParameter("rireki");

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
session.setAttribute("rireki",rireki);
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
rireki = (String)session.getAttribute("rireki");
if(rireki == null){
rireki = "";
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

//�f�[�^�x�[�X����query��ǂݍ���
if(view != null && !view.equals("") && view.equals("1")){
db.getQuery(sql);
}
//out.println(sql);
%>
<html>
<head>
<title>  �����Ǘ��y�[�W�\���p </title>
<SCRIPT 
src="jkl-calendar.js" 
type=text/javascript charset=Shift_JIS></SCRIPT>
</head>
<body>
<center>
<form id=formid action="Kubun_A_Browse_View.jsp" method="post">
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
<td nowrap>
<%
if(rireki == null || rireki.equals("") || rireki.equals("0")){
%>
�@�����\��<input type="radio" name="rireki" value="0" checked>
����\��<input type="radio" name="rireki" value="1">
<%
} else if(rireki.equals("1")){
%>
�@�����\��<input type="radio" name="rireki" value="0">
����\��<input type="radio" name="rireki" value="1" checked>
<%
}
%>
</td>
</TR></TABLE>
<input type="submit" value="����">  <input type="reset" value="���o�������Z�b�g"></form>

<FONT COLOR="Crimson">
<a href="tag_view.jsp" target="_blank"><font size=2 color="black">�f�B���N�g���ꗗ</font></a>
<a href="file_view.jsp" target="_blank"><font size=2 color="black">�t�@�C���ꗗ</font></a>
<a href="Kubun_A_Browse.jsp"><font size=2 color="black">�ҏW�p</font></a>
<%
int num = 0;//�f�[�^�̌�
%>
<table border="1" cellspacing=0 bordercolor="#666666">

<tr>
<td nowrap align="center" nowrap bgcolor="#e8e8e8">ID</td>
<td nowrap align="center" nowrap bgcolor="#e8e8e8">���t</td>
<td nowrap align="center" nowrap bgcolor="#e8e8e8">�T�v</td>
<td nowrap align="center" nowrap bgcolor="#e8e8e8">�f�B���N�g��</td>
<td nowrap align="center" nowrap bgcolor="#e8e8e8">�\���ݒ�</td>
<td nowrap align="center" nowrap bgcolor="#e8e8e8">���b�N</td>
<td nowrap align="center" nowrap bgcolor="#e8e8e8">File</td>
<%
if(rireki != null && !rireki.equals("") && !rireki.equals("0")){ 
%>
<td nowrap align="center" nowrap bgcolor="#e8e8e8">����</td>
<%
}
%>
<td nowrap align="center" nowrap bgcolor="#e8e8e8">���l</td>
<td nowrap align="center" nowrap bgcolor="#e8e8e8">update</td>
</tr>
<tr>
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
<form action="Kubun_A_Input_file.jsp" enctype="multipart/form-data" method="post">
<td nowrap><%= db.getResult("no")%><input type="hidden" name="no" value=<%= db.getResult("no")%>></td>
<td nowrap><%= day.editDate(db.getResult("date"))%></td>
<td nowrap><%= db.getResult("text")%><input type="hidden" name="text" value="<%= db.getResult("text")%>"></td>
<%
tag_db.getQuery("select * from " + ClassDefine.tag + " where tag_id = " + db.getResult("check1") + ";");
tag_db.getNext();
%>
<td nowrap><%= tag_db.getResult("full_dir")%><input type="hidden" name="tag" value="<%= tag_db.getResult("tag_id")%>"></td>
<td nowrap align="center">
<%
if(db.getResult("check2").equals("1")){
%>
�V�[�N���b�g
<%
} else {
%>
<br>
<%
}
%>
</td>
</select><input type="hidden" name="check3" value="<%= db.getResult("check3")%>"></td>
<td nowrap align="center">
<%
if(!db.getResult("username").equals("dummy")){
user_db.getQuery("select name from " + ClassDefine.userpass + " where username='" + db.getResult("username") + "';");
user_db.getNext();
%>
<%= user_db.getResult("name")%>
<%
}
else {
%>
���b�N����
<%
}
%>
<input type="hidden" name="ope" value=0></td>
<%
if(!db.getResult("file").equals("")){
%>
<td nowrap><a href="PDF_File/<%= db.getResult("file")%>"><%= db.getResult("file")%></a><input type="file" name="file" ></td>
<%
}
else {
%>
<td nowrap width="50"><input type="file" name="file" ></td>
<%
}
%>

<%
if(rireki != null && !rireki.equals("") && !rireki.equals("0")){ 
if(!db.getResult("file").equals("")){
%>
<td nowrap>
<%
int backupNum = Integer.parseInt(db.getResult("check3").trim());
String backupName = "";
for(int rireki_count = 1;rireki_count < backupNum;rireki_count++){
backupName = db.getResult("file") + ".bak" + rireki_count;
%>
<a href="PDF_File/<%= backupName%>"><%= backupName%></a><br>
<%
}
%>
</td>
<%
}
else {
%>
<td nowrap width="50"><br></td>
<%
}
}
%>
<%
dataList = readData(ClassDefine.file_dir + "htbbsf" + db.getResult("no") + ".log", null);
size = dataList.size();
if(size > 0){
biko="";
data = (Hashtable)dataList.get(0);
biko = biko.concat("�y" + (String)data.get("date") + " " + (String)data.get("name") +"�z<br>");
biko = biko.concat((String)data.get("comment") + "<br>");
/*biko = convert.convertCsv(biko);*/
}
else {
biko = "<br>";
}
%>
<td nowrap>
<%= biko%>
</td>
<td nowrap>
<input type="submit" value="regist">
<input type="reset" value="reset">
</td>
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
<%!
/*** 2008/06/17 �f�[�^�̎擾 ���\�b�h start***/

private Vector readData(String logPath , String no) {
  Vector dataList = new Vector();
  try {
    ObjectInputStream in = new ObjectInputStream(new FileInputStream(logPath));
    dataList = (Vector)in.readObject();
    in.close();
  } catch (Exception e) {
  }
  return dataList;
}

/*** 2008/06/17 �f�[�^�̎擾 ���\�b�h end***/
%>
