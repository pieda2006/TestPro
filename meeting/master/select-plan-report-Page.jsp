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
DB_Operation stateDB = new DB_Operation();
DateFormat df = DateFormat.getDateInstance();
String currentdate = null;
/*** 2015/01/18 S ***/
DB_Operation topic2_db = new DB_Operation();
/*** 2015/01/18 E ***/
//CSV�o�͗p
Escape_String convert_csv = new Escape_String();
WriteCSV writeFile = new WriteCSV(ClassDefine.file_dir + user + "_topic_plan.csv");
/*** ������擾 ***/
String ope = request.getParameter("ope");
/*** 2012/05/09 S ***/
String complete_date = null;
String view_complete_date = null;
/*** 2012/05/09 E ***/
String topic_kind = null;
String subid = null;
long alerttime = 0;
if(ope == null || ope.equals("0") || ope.equals("2")){
if(ope != null && ope.equals("2")){
session.setAttribute("search_word_20",request.getParameter("search_word_20"));
session.setAttribute("search_word_21",request.getParameter("search_word_21"));
session.setAttribute("search_word_22",request.getParameter("search_word_22"));
session.setAttribute("search_word_23",request.getParameter("search_word_23"));
session.setAttribute("search_word_24",request.getParameter("search_word_24"));
session.setAttribute("search_word_25",request.getParameter("search_word_25"));
session.setAttribute("search_word_26",request.getParameter("search_word_26"));
session.setAttribute("search_word_27",request.getParameter("search_word_27"));
session.setAttribute("search_word_28",request.getParameter("search_word_28"));
session.setAttribute("topic_user_plan_2",request.getParameter("topic_user_plan_2"));
}
if(ope == null){
ope = "2";
}
String search_word_20 = (String)session.getAttribute("search_word_20");
if(search_word_20 == null || search_word_20.equals("null")){
search_word_20 = "";
}
String search_word_21 = (String)session.getAttribute("search_word_21");
if(search_word_21 == null || search_word_21.equals("null")){
search_word_21 = "";
}
String search_word_22 = (String)session.getAttribute("search_word_22");
if(search_word_22 == null || search_word_22.equals("null")){
search_word_22 = "";
}
String search_word_23 = (String)session.getAttribute("search_word_23");
if(search_word_23 == null || search_word_23.equals("null")){
search_word_23 = "0";
}
String search_word_24 = (String)session.getAttribute("search_word_24");
if(search_word_24 == null || search_word_24.equals("null")){
search_word_24 = "";
}
String search_word_25 = (String)session.getAttribute("search_word_25");
if(search_word_25 == null || search_word_25.equals("null")){
search_word_25 = "0";
}
String search_word_26 = (String)session.getAttribute("search_word_26");
if(search_word_26 == null || search_word_26.equals("null")){
search_word_26 = "0";
}
String search_word_27 = (String)session.getAttribute("search_word_27");
if(search_word_27 == null || search_word_27.equals("null")){
search_word_27 = "";
}
String search_word_28 = (String)session.getAttribute("search_word_28");
if(search_word_28 == null || search_word_28.equals("null")){
search_word_28 = "";
}
String topic_user_plan_2 = (String)session.getAttribute("topic_user_plan_2");
%>
<html>
<head>
<title>��ƌv����ѕ\�����</title>
<SCRIPT 
src="jkl-calendar.js" 
type=text/javascript charset=Shift_JIS></SCRIPT>
<script type="text/javascript" src="fixed_midashi.js"></script>
</head>
<body onLoad="FixedMidashi.create();">
<center>
<FONT COLOR="Crimson">�����t�F<%= cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.DATE)%></FONT><br>
<form id=formid action="select-plan-report-Page.jsp" method="post">
<SCRIPT><!--
    var search_10 = new JKL.Calendar("search_10","formid","search_word_20");
	search_10.setStyle( "frame_color", "#3333CC" );
    var search_12 = new JKL.Calendar("search_12","formid","search_word_22");
	search_12.setStyle( "frame_color", "#CC3333" );
//--></SCRIPT>
<TABLE><TR><TD>
<TD nowrap><FONT COLOR="Crimson">������1�F</FONT></TD>
<TD nowrap><DIV id=search_10></DIV></TD>
<TD nowrap><input type="text" onclick="search_10.hide(); search_10.write();" onchange="search_10.getFormValue(); search_10.hide();" name="search_word_20" value="<%=search_word_20%>" size="30" maxlength="30"></TD>
<TD nowrap><FONT COLOR="Crimson">������2�F</FONT></TD>
<TD nowrap><DIV id=search_12></DIV></TD>
<TD nowrap><input type="text" onclick="search_12.hide(); search_12.write();" onchange="search_12.getFormValue(); search_12.hide();" name="search_word_22" value="<%=search_word_22%>" size="30" maxlength="30"></TD>
<TD nowrap><FONT COLOR="Crimson">ID�F</FONT></TD>
<TD nowrap><input type="text" name="search_word_21" value="<%=search_word_21%>" size="5" maxlength="30"></TD>
<TD nowrap><FONT COLOR="Crimson">���ԁF</FONT></TD>
<TD nowrap><input type="text" name="search_word_27" value="<%=search_word_27%>" size="5" maxlength="30"></TD>
<TD nowrap><FONT COLOR="Crimson">�\���`���F</FONT></TD>
<TD nowrap><select name="search_word_28">
<%
if(search_word_28 != null && !search_word_28.equals("")){
%>
<option value="1">�\��</option>
<%
} else {
%>
<option value=""></option>
<%
}
%>
<option value=""></option>
<option value="1">�\��</option>
</select></TD>
<TD nowrap><FONT COLOR="Crimson">�S���F</FONT>	</TD>
<TD nowrap><select name="topic_user_plan_2">
<%
if(topic_user_plan_2 != null && !topic_user_plan_2.equals("")){
db.getQuery("select * from " + ClassDefine.user_info + " where user_id = '" + topic_user_plan_2 + "';");
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
<TD nowrap><FONT COLOR="Crimson">�\���F</FONT></TD>
<TD nowrap><select name="search_word_23">
<option value="<%=search_word_23%>">
<%
if(search_word_23==null || search_word_23.equals("") || search_word_23.equals("0")){
%>
�i��
<%
} else {
%>
�H��
<%
}
%>
</option>
<option value="0">�i��</option>
<option value="1">�H��</option>
</select></TD>
<TD nowrap><input name="ope" type="hidden" value="2"></TD>

<TD nowrap><FONT COLOR="Crimson">�H���F</FONT>
<select name="search_word_24">
<%
if(search_word_24 == null || search_word_24.equals("")){
%>
<option value=""></option>
<%
} else if(search_word_24.equals("0")){
%>
<option value="0">�v����`</option>
<%
} else if(search_word_24.equals("1")){
%>
<option value="1">��{�݌v</option>
<%
} else if(search_word_24.equals("2")){
%>
<option value="2">�T�v�݌v</option>
<%
} else if(search_word_24.equals("3")){
%>
<option value="3">�ڍא݌v</option>
<%
} else if(search_word_24.equals("4")){
%>
<option value="4">����</option>
<%
} else if(search_word_24.equals("5")){
%>
<option value="5">�P�̎���</option>
<%
} else if(search_word_24.equals("6")){
%>
<option value="6">��������</option>
<%
} else if(search_word_24.equals("7")){
%>
<option value="7">���艻����</option>
<%
} else if(search_word_24.equals("8")){
%>
<option value="8">�ێ��Ǘ�</option>
<%
} else if(search_word_24.equals("9")){
%>
<option value="9">���̑�</option>
<%
} else if(search_word_24.equals("10")){
%>
<option value="10">���̑�</option>
<%
}
%>
<option value=""></option>
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
<option value="10">���̑�</option>
</select></TD>
<TD nowrap><FONT COLOR="Crimson">PJ�F</FONT>
<select name="search_word_25">
<%
if(search_word_25 != null && !search_word_25.equals("")){
db.getQuery("select * from " + ClassDefine.topic_kind + " where kind_id='" + search_word_25 + "';");
if(db.getNext()){
%>
<option value="<%= db.getResult("kind_id")%>">
<%=  db.getResult("kind")%>
</option>
<%
}
}
%>
<option value="-1"></option>
<%
db.getQuery("select * from " + ClassDefine.topic_kind + " order by kind;");
while(db.getNext()){
%>
<option value="<%= db.getResult("kind_id")%>">
<%=  db.getResult("kind")%>
</option>
<%
}
%>
</select>
</TD>
<TD nowrap><FONT COLOR="Crimson">�폜�ۑ�F</FONT>
<select name="search_word_26">
<%
if(search_word_26 == null || search_word_26.equals("") || search_word_26.equals("0")){
%>
<option value="0">�܂܂Ȃ�</option>
<%
} else if(search_word_26.equals("1")){
%>
<option value="1">�܂�</option>
<%
} else if(search_word_26.equals("2")){
%>
<option value="2">�����ȊO</option>
<%
}
%>
<option value="0">�܂܂Ȃ�</option>
<option value="1">�܂�</option>
<option value="2">�����ȊO</option>
</select></TD>
</TR>
<TR><TD align="center" colspan=15><input type="submit" value="����">  <input type="reset" value="���o�������Z�b�g">
</TD></TR></TABLE>
</form>
<a href="update-plan-report-Page.jsp" ><font size=2 color="black">�ҏW�p�y�[�W</font></a><br><br>
<%
/*
if(ope != null && ope.equals("2") && (!search_word_20.equals("") || !search_word_22.equals(""))){
if(!search_word_20.equals("") && search_word_22.equals("")){
db.getQuery("select * from " + ClassDefine.topic_plan + " where date >= '" + search_word_20 + " 00:00:00' union all select * from " + ClassDefine.topic_report + " where date >= '" + search_word_20 + " 00:00:00' order by date;");
} else if(search_word_20.equals("") && !search_word_22.equals("")){
db.getQuery("select * from " + ClassDefine.topic_plan + " where date <= '" + search_word_22 + " 23:59:59' union all select * from " + ClassDefine.topic_report + " where date <= '" + search_word_22 + " 23:59:59' order by date,id;");
} else {
db.getQuery("select * from " + ClassDefine.topic_plan + " where date >= '" + search_word_20 + " 00:00:00' and date <= '" + search_word_22 + " 23:59:59' union all select * from " + ClassDefine.topic_report + " where date >= '" + search_word_20 + " 00:00:00' and date <= '" + search_word_22 + " 23:59:59' order by date,id;");
}
} else {
db.getQuery("select * from " + ClassDefine.topic_plan + " union all select * from " + ClassDefine.topic_report + " order by date,id;");
}
*/
db.getQuery("select topic_id,user_id,topic_sub_id,kind_id,kouban,plan_topic_date,plan_limit_date from " + ClassDefine.topic_info + " order by kouban,kind_id,topic_sub_id,plan_limit_date,topic_id;");

if((!search_word_20.equals("") && !search_word_22.equals(""))){
/*** ����̍ő吔��ǂ݂���***/
int query[] = new int[999999];
Date dateFrom = sdf2.parse(search_word_20);
Date dateTo = sdf2.parse(search_word_22);
Date dateFrom2;
// ���t��long�l�ɕϊ����܂��B
long dateTimeTo = dateTo.getTime();
long dateTimeFrom = dateFrom.getTime();
// �����̓������Z�o���܂��B
long dayDiff = ( dateTimeTo - dateTimeFrom  ) / (1000 * 60 * 60 * 24 );
String tempcompdate = "";
long tempshinchoku = 0;
int preYEAR = 0;
int preMON = 0;
long sumPlanValue[] = new long[(int)dayDiff+1];
for(int i=0; i<=dayDiff; i++){
sumPlanValue[i]=0;
}
long sumReportValue[] = new long[(int)dayDiff+1];
for(int i=0; i<=dayDiff; i++){
sumReportValue[i]=0;
}

Calendar cal2 = Calendar.getInstance();
cal2.setTime(dateFrom);
%>
<table border="1" style="border: 1px solid #666666; border-collapse: collapse;" _fixedhead="rows:4; cols:10">
<%
for(int dispcount=0; dispcount<4; dispcount++){
  cal2.setTime(dateFrom);
%>
<tr bgcolor="#ffff99">
<%
if(dispcount == 0){
%>
<td nowrap rowspan="4">ID</td>
<td nowrap rowspan="4" colspan="9">���ږ�</td>
<td nowrap rowspan="4">�H��</td>
<td nowrap rowspan="4">���</td>
<td nowrap rowspan="4">�S��</td>
<td nowrap rowspan="4">���</td>
<td nowrap rowspan="4">����</td>
<td nowrap rowspan="4">����</td>
<td nowrap>�N</td>
<%
} else if(dispcount == 1){
%>
<td nowrap>��</td>
<%
} else if(dispcount == 2){
%>
<td nowrap>��</td>
<%
}  else if(dispcount == 3){
%>
<td nowrap>�j��</td>
<%
}
for(int daycounter=0;daycounter<=dayDiff;daycounter++){
if(dispcount == 0){
%>
<td nowrap><%= cal2.get(Calendar.YEAR)%></td>
<%
} else if(dispcount == 1){
%>
<td nowrap><%= cal2.get(Calendar.MONTH)+1%></td>
<%
} else if(dispcount == 2){
%>
<td nowrap><%= cal2.get(Calendar.DATE)%></td>
<%
} else if(dispcount == 3){
switch (cal2.get(Calendar.DAY_OF_WEEK)) { 
    case Calendar.SUNDAY:     // Calendar.SUNDAY:1 �i�l�B�Ӗ��͂Ȃ��j
        //���j��
%>
<td nowrap><%= "��"%></td>
<%
        break;
    case Calendar.MONDAY:     // Calendar.MONDAY:2
        //���j��
%>
<td nowrap><%= "��"%></td>
<%
        break;
    case Calendar.TUESDAY:    // Calendar.TUESDAY:3
        //�Ηj��
%>
<td nowrap><%= "��"%></td>
<%
        break;
    case Calendar.WEDNESDAY:  // Calendar.WEDNESDAY:4
        //���j��
%>
<td nowrap><%= "��"%></td>
<%
        break;
    case Calendar.THURSDAY:   // Calendar.THURSDAY:5
        //�ؗj��
%>
<td nowrap><%= "��"%></td>
<%
        break;
    case Calendar.FRIDAY:     // Calendar.FRIDAY:6
        //���j��
%>
<td nowrap><%= "��"%></td>
<%
        break;
    case Calendar.SATURDAY:   // Calendar.SATURDAY:7
        //�y�j��
%>
<td nowrap><%= "�y"%></td>
<%
        break;
}
}
cal2.add(Calendar.DATE, 1);
}
if(dispcount == 0){
%>
<td nowrap rowspan="4">���v</td>
<%
}
%>
</tr>
<%
}
while(db.getNext()){
if((topic_user_plan_2 == null || topic_user_plan_2.equals("-1") || topic_user_plan_2.equals(db.getResult("user_id"))) &&
   (search_word_21 == null || search_word_21.equals("") ||  db.getResult("topic_id").equals(search_word_21)) &&
   (search_word_24 == null || search_word_24.equals("") ||  db.getResult("topic_sub_id").equals(search_word_24)) &&
   (search_word_25 == null || search_word_25.equals("") || search_word_25.equals("-1") ||  db.getResult("kind_id").equals(search_word_25)) &&
   (((search_word_27 == null) || search_word_27.equals("")) || (db.getResult("kouban").matches("^" + search_word_27 + ".*")))){

int daycounter = 0;
long addshinchoku = 0;
if(query[Integer.parseInt(db.getResult("topic_id"))] == 0){
if(!search_word_20.equals("") && search_word_22.equals("")){
topic_db.getQuery("select * from " + ClassDefine.topic_plan + " where id = " + db.getResult("topic_id") + " and date >= '" + search_word_20 + " 00:00:00' order by date;");
} else if(search_word_20.equals("") && !search_word_22.equals("")){
topic_db.getQuery("select * from " + ClassDefine.topic_plan + " where id = " + db.getResult("topic_id") + " and  date <= '" + search_word_22 + " 23:59:59' order by date;");
} else {
topic_db.getQuery("select * from " + ClassDefine.topic_plan + " where id = " + db.getResult("topic_id") + " and date >= '" + search_word_20 + " 00:00:00' and date <= '" + search_word_22 + " 23:59:59' order by date;");
}
query[Integer.parseInt(db.getResult("topic_id"))] = 1;
cal2.setTime(dateFrom);
topic2_db.getQuery("select * from " + ClassDefine.topic_info + " where topic_id=" + db.getResult("topic_id") + ";");
topic2_db.getNext();
if(((search_word_26 == null || search_word_26.equals("0")) && topic2_db.getResult("topic_delete").equals("0")) ||
    (search_word_26 != null && search_word_26.equals("1")) ||
   ((search_word_26 != null && search_word_26.equals("2")) && (topic2_db.getResult("topic_delete").equals("0") && !topic2_db.getResult("state_id").equals("2")))){
user_db.getQuery("select user_name from " + ClassDefine.user_info + " where user_id='" + db.getResult("user_id") + "';");
user_db.getNext();
kindDB.getQuery("select * from " + ClassDefine.topic_kind + " where kind_id = " + topic2_db.getResult("kind_id") + ";");
kindDB.getNext();
stateDB.getQuery("select * from " + ClassDefine.topic_state + " where state_id = " + topic2_db.getResult("state_id") + ";");
stateDB.getNext();

if(search_word_28 != null && !search_word_28.equals("")){
%>
<tr><td nowrap rowspan=2><%= db.getResult("topic_id")%></td>

<%
String[] split_koban = db.getResult("kouban").split("-", 9);
for(int count = 0; count < split_koban.length; count++){
%>
<td align="left" nowrap rowspan=2>
<%= split_koban[count]%></td>
<%
}
%>

<td nowrap rowspan=2 colspan="<%= 9 - split_koban.length%>"><%= topic2_db.getResult("topic_name")%></td>



<td nowrap rowspan=2>
<%
if(topic2_db.getResult("topic_sub_id").equals("0")){
subid = "�v����`";
}else if(topic2_db.getResult("topic_sub_id").equals("1")){
subid = "��{�݌v";
}else if(topic2_db.getResult("topic_sub_id").equals("2")){
subid = "�T�v�݌v";
}else if(topic2_db.getResult("topic_sub_id").equals("3")){
subid = "�ڍא݌v";
}else if(topic2_db.getResult("topic_sub_id").equals("4")){
subid = "����";
}else if(topic2_db.getResult("topic_sub_id").equals("5")){
subid = "�P�̎���";
}else if(topic2_db.getResult("topic_sub_id").equals("6")){
subid = "��������";
}else if(topic2_db.getResult("topic_sub_id").equals("7")){
subid = "���艻����";
}else if(topic2_db.getResult("topic_sub_id").equals("8")){
subid = "�ێ��Ǘ�";
}else {
subid = "���̑�";
}
%>
<%= subid%></td>
<td nowrap rowspan=2><%= kindDB.getResult("kind")%></td>
<td nowrap rowspan=2><%= user_db.getResult("user_name")%></td>
<td nowrap rowspan=2><%= stateDB.getResult("topic_state")%></td>
<td nowrap rowspan=2><%= topic2_db.getResult("shinchoku")%></td>
<td nowrap rowspan=2><%= topic2_db.getResult("shinchoku2")%></td>
<%
} else {
%>
<tr><td nowrap><%= db.getResult("topic_id")%></td>
<%
String[] split_koban = db.getResult("kouban").split("-", 9);
for(int count = 0; count < split_koban.length; count++){
%>
<td align="left" nowrap>
<%= split_koban[count]%></td>
<%
}
%>

<td nowrap colspan="<%= 9 - split_koban.length%>"><%= topic2_db.getResult("topic_name")%></td>
<td nowrap>
<%
if(topic2_db.getResult("topic_sub_id").equals("0")){
subid = "�v����`";
}else if(topic2_db.getResult("topic_sub_id").equals("1")){
subid = "��{�݌v";
}else if(topic2_db.getResult("topic_sub_id").equals("2")){
subid = "�T�v�݌v";
}else if(topic2_db.getResult("topic_sub_id").equals("3")){
subid = "�ڍא݌v";
}else if(topic2_db.getResult("topic_sub_id").equals("4")){
subid = "����";
}else if(topic2_db.getResult("topic_sub_id").equals("5")){
subid = "�P�̎���";
}else if(topic2_db.getResult("topic_sub_id").equals("6")){
subid = "��������";
}else if(topic2_db.getResult("topic_sub_id").equals("7")){
subid = "���艻����";
}else if(topic2_db.getResult("topic_sub_id").equals("8")){
subid = "�ێ��Ǘ�";
}else if(topic2_db.getResult("topic_sub_id").equals("9")){
subid = "���̑�";
}else {
subid = "�폜";
}
%>
<%= subid%></td>
<td nowrap><%= kindDB.getResult("kind")%></td>
<td nowrap><%= user_db.getResult("user_name")%></td>
<td nowrap><%= stateDB.getResult("topic_state")%></td>
<td nowrap><%= topic2_db.getResult("shinchoku")%></td>
<td nowrap><%= topic2_db.getResult("shinchoku2")%></td>
<%
}
%>
<td nowrap>�\��</td>
<%
while(topic_db.getNext()){
    if(tempcompdate.equals("")){
        tempcompdate = topic_db.getResult("date").substring(0,10);
        if(search_word_23.equals("0")){
            if(!topic_db.getResult("shinchoku").equals("")){
                tempshinchoku = Integer.parseInt(topic_db.getResult("shinchoku"));
                addshinchoku = addshinchoku + Integer.parseInt(topic_db.getResult("shinchoku"));
            }
        } else {
            dateFrom2 = sdf1.parse(dayop.editDate(topic_db.getResult("date")));
            dateTo = sdf1.parse(dayop.editDate(topic_db.getResult("complete_date")));
            // ���t��long�l�ɕϊ����܂��B
            dateTimeTo = dateTo.getTime();
            dateTimeFrom = dateFrom2.getTime();
            // �����̓������Z�o���܂��B
            tempshinchoku = ( dateTimeTo - dateTimeFrom  ) / (1000 * 60 * 15);
            addshinchoku = addshinchoku + ( dateTimeTo - dateTimeFrom  ) / (1000 * 60 * 15);
        }
        continue;
    } else if(tempcompdate.equals(topic_db.getResult("date").substring(0,10))){
        if(search_word_23.equals("0")){
            if(!topic_db.getResult("shinchoku").equals("")){
                tempshinchoku = tempshinchoku + Integer.parseInt(topic_db.getResult("shinchoku"));
                addshinchoku = addshinchoku + Integer.parseInt(topic_db.getResult("shinchoku"));
                }
        } else {
            dateFrom2 = sdf1.parse(dayop.editDate(topic_db.getResult("date")));
            dateTo = sdf1.parse(dayop.editDate(topic_db.getResult("complete_date")));
            // ���t��long�l�ɕϊ����܂��B
            dateTimeTo = dateTo.getTime();
            dateTimeFrom = dateFrom2.getTime();
            tempshinchoku = tempshinchoku + ( dateTimeTo - dateTimeFrom  ) / (1000 * 60 * 15);
            addshinchoku = addshinchoku + ( dateTimeTo - dateTimeFrom  ) / (1000 * 60 * 15);
        }
        continue;
    }
    for(;daycounter<=dayDiff;daycounter++){
        if(cal2.getTime().equals(sdf2.parse(dayop.editDate(tempcompdate)))){
            %>
                <td nowrap bgcolor="blue"><FONT color="white"><%= tempshinchoku%></FONT></td>
            <%
            sumPlanValue[daycounter] = sumPlanValue[daycounter] + tempshinchoku;
            tempcompdate = topic_db.getResult("date").substring(0,10);
            if(search_word_23.equals("0")){
                if(!topic_db.getResult("shinchoku").equals("")){
                    tempshinchoku = Integer.parseInt(topic_db.getResult("shinchoku"));
                    addshinchoku = addshinchoku + Integer.parseInt(topic_db.getResult("shinchoku"));
                }
            } else {
                dateFrom2 = sdf1.parse(dayop.editDate(topic_db.getResult("date")));
                dateTo = sdf1.parse(dayop.editDate(topic_db.getResult("complete_date")));
                // ���t��long�l�ɕϊ����܂��B
                dateTimeTo = dateTo.getTime();
                dateTimeFrom = dateFrom2.getTime();
                // �����̓������Z�o���܂��B
                tempshinchoku = ( dateTimeTo - dateTimeFrom  ) / (1000 * 60 * 15);
                addshinchoku = addshinchoku + ( dateTimeTo - dateTimeFrom  ) / (1000 * 60 * 15);
            }
            daycounter++;
            cal2.add(Calendar.DATE, 1);
            break;
        } else {
        	Date startDate = df.parse(dayop.editDate(db.getResult("plan_topic_date")));
        	Date endDate = df.parse(dayop.editDate(db.getResult("plan_limit_date")));
            if((cal2.getTime().equals(startDate) || cal2.getTime().after(startDate)) &&
               (cal2.getTime().equals(endDate) || cal2.getTime().before(endDate))){
                %>
                    <td nowrap bgcolor="#00FFFF"> &nbsp </td>
                <%
            } else {
                %>
                    <td nowrap> &nbsp </td>
                <%
            }
        }
        cal2.add(Calendar.DATE, 1);
    }
}
if(!tempcompdate.equals("")){
    for(;daycounter<=dayDiff;daycounter++){
        if(cal2.getTime().equals(sdf2.parse(dayop.editDate(tempcompdate)))){
            %>
                <td nowrap bgcolor="blue"><FONT color="white"><%= tempshinchoku%></FONT></td>
            <%
            sumPlanValue[daycounter] = sumPlanValue[daycounter] + tempshinchoku;
            tempcompdate = "";
            tempshinchoku = 0;
            daycounter++;
            cal2.add(Calendar.DATE, 1);
            break;
        } else {
        	Date startDate = df.parse(dayop.editDate(db.getResult("plan_topic_date")));
        	Date endDate = df.parse(dayop.editDate(db.getResult("plan_limit_date")));
            if((cal2.getTime().equals(startDate) || cal2.getTime().after(startDate)) &&
               (cal2.getTime().equals(endDate) || cal2.getTime().before(endDate))){
                %>
                    <td nowrap bgcolor="#00FFFF"> &nbsp </td>
                <%
            } else {
                %>
                    <td nowrap> &nbsp </td>
                <%
            }
        }
        cal2.add(Calendar.DATE, 1);
    }
}

for(;daycounter<=dayDiff;daycounter++){
    Date startDate = df.parse(dayop.editDate(db.getResult("plan_topic_date")));
    Date endDate = df.parse(dayop.editDate(db.getResult("plan_limit_date")));
    if((cal2.getTime().equals(startDate) || cal2.getTime().after(startDate)) &&
       (cal2.getTime().equals(endDate) || cal2.getTime().before(endDate))){
        %>
            <td nowrap bgcolor="#00FFFF"> &nbsp </td>
        <%
    } else {
        %>
            <td nowrap> &nbsp </td>
        <%
    }
    cal2.add(Calendar.DATE, 1);
}
%>
<td><%= addshinchoku%></td>
</tr>
<%
if(search_word_28 != null && !search_word_28.equals("")){
%>
<tr>

<%
addshinchoku = 0;
/* ���� */
cal2.setTime(dateFrom);
daycounter = 0;
if(!search_word_20.equals("") && search_word_22.equals("")){
topic_db.getQuery("select * from " + ClassDefine.topic_report + " where id = " + db.getResult("topic_id") + " and date >= '" + search_word_20 + " 00:00:00' order by date;");
} else if(search_word_20.equals("") && !search_word_22.equals("")){
topic_db.getQuery("select * from " + ClassDefine.topic_report + " where id = " + db.getResult("topic_id") + " and  date <= '" + search_word_22 + " 23:59:59' order by date;");
} else {
topic_db.getQuery("select * from " + ClassDefine.topic_report + " where id = " + db.getResult("topic_id") + " and date >= '" + search_word_20 + " 00:00:00' and date <= '" + search_word_22 + " 23:59:59' order by date;");
}
topic2_db.getQuery("select * from " + ClassDefine.topic_info + " where topic_id=" + db.getResult("topic_id") + ";");
topic2_db.getNext();
user_db.getQuery("select user_name from " + ClassDefine.user_info + " where user_id='" + db.getResult("user_id") + "';");
user_db.getNext();
kindDB.getQuery("select * from " + ClassDefine.topic_kind + " where kind_id = " + topic2_db.getResult("kind_id") + ";");
kindDB.getNext();
stateDB.getQuery("select * from " + ClassDefine.topic_state + " where state_id = " + topic2_db.getResult("state_id") + ";");
stateDB.getNext();
%>
<td nowrap>����</td>
<%
while(topic_db.getNext()){
if(tempcompdate.equals("")){
tempcompdate = topic_db.getResult("date").substring(0,10);
if(search_word_23.equals("0")){
tempshinchoku = Integer.parseInt(topic_db.getResult("shinchoku"));
addshinchoku = addshinchoku + Integer.parseInt(topic_db.getResult("shinchoku"));
} else {
if(!topic_db.getResult("complete_date").equals("1111-11-11 00:00:00")){
dateFrom2 = sdf1.parse(dayop.editDate(topic_db.getResult("date")));
dateTo = sdf1.parse(dayop.editDate(topic_db.getResult("complete_date")));
// ���t��long�l�ɕϊ����܂��B
dateTimeTo = dateTo.getTime();
dateTimeFrom = dateFrom2.getTime();
// �����̓������Z�o���܂��B
tempshinchoku = ( dateTimeTo - dateTimeFrom  ) / (1000 * 60 * 15);
addshinchoku = addshinchoku + ( dateTimeTo - dateTimeFrom  ) / (1000 * 60 * 15);

}
}
continue;
} else if(tempcompdate.equals(topic_db.getResult("date").substring(0,10))){
if(search_word_23.equals("0")){
tempshinchoku = tempshinchoku + Integer.parseInt(topic_db.getResult("shinchoku"));
addshinchoku = addshinchoku + Integer.parseInt(topic_db.getResult("shinchoku"));
} else {
if(!topic_db.getResult("complete_date").equals("1111-11-11 00:00:00")){
dateFrom2 = sdf1.parse(dayop.editDate(topic_db.getResult("date")));
dateTo = sdf1.parse(dayop.editDate(topic_db.getResult("complete_date")));
// ���t��long�l�ɕϊ����܂��B
dateTimeTo = dateTo.getTime();
dateTimeFrom = dateFrom2.getTime();
tempshinchoku = tempshinchoku + ( dateTimeTo - dateTimeFrom  ) / (1000 * 60 * 15);
addshinchoku = addshinchoku + ( dateTimeTo - dateTimeFrom  ) / (1000 * 60 * 15);
}
}
continue;
}
for(;daycounter<=dayDiff;daycounter++){
if(cal2.getTime().equals(sdf2.parse(dayop.editDate(tempcompdate)))){
%>
<td nowrap bgcolor="blue"><FONT color="white"><%= tempshinchoku%></FONT></td>
<%
sumReportValue[daycounter] = sumReportValue[daycounter] + tempshinchoku;
tempcompdate = topic_db.getResult("date").substring(0,10);
if(search_word_23.equals("0")){
tempshinchoku = Integer.parseInt(topic_db.getResult("shinchoku"));
addshinchoku = addshinchoku + Integer.parseInt(topic_db.getResult("shinchoku"));
} else {
if(!topic_db.getResult("complete_date").equals("1111-11-11 00:00:00")){
dateFrom2 = sdf1.parse(dayop.editDate(topic_db.getResult("date")));
dateTo = sdf1.parse(dayop.editDate(topic_db.getResult("complete_date")));
// ���t��long�l�ɕϊ����܂��B
dateTimeTo = dateTo.getTime();
dateTimeFrom = dateFrom2.getTime();
// �����̓������Z�o���܂��B
tempshinchoku = ( dateTimeTo - dateTimeFrom  ) / (1000 * 60 * 15);
addshinchoku = addshinchoku + ( dateTimeTo - dateTimeFrom  ) / (1000 * 60 * 15);
}
}
daycounter++;
cal2.add(Calendar.DATE, 1);
break;
} else {
%>
<td nowrap>
&nbsp
</td>
<%
}
cal2.add(Calendar.DATE, 1);
}
}
if(!tempcompdate.equals("")){
for(;daycounter<=dayDiff;daycounter++){
if(cal2.getTime().equals(sdf2.parse(dayop.editDate(tempcompdate)))){
%>
<td nowrap bgcolor="blue"><FONT color="white"><%= tempshinchoku%></FONT></td>
<%
sumReportValue[daycounter] = sumReportValue[daycounter] + tempshinchoku;
tempcompdate = "";
tempshinchoku = 0;
daycounter++;
cal2.add(Calendar.DATE, 1);
break;
} else {
%>
<td nowrap>
&nbsp
</td>
<%
}
cal2.add(Calendar.DATE, 1);
}
}

for(;daycounter<=dayDiff;daycounter++){
%>
<td nowrap>
&nbsp
</td>
<%
}
%>
<td><%= addshinchoku%></td>
</tr>
<%
}
}
}
}
}
%>
<tr>
<td nowrap colspan="10"></td>
<td nowrap colspan="7">���v(�\��)</td>
<%
for(int daycounter=0; daycounter<=dayDiff; daycounter++){
%>
<td> <%= sumPlanValue[daycounter]%></td>
<%
}
%>
</tr>
<tr>
<td nowrap colspan="10"></td>
<td nowrap colspan="7">���v(����)</td>
<%
for(int daycounter=0; daycounter<=dayDiff; daycounter++){
%>
<td> <%= sumReportValue[daycounter]%></td>
<%
}
%>
</tr>
</table>
<%

}
%>
<!- /*** ���� ***/ ->
<input name="ope" type="hidden" value="1">
</center>
</body>
</html>
<%
}
db.closeDB();
topic_db.closeDB();
user_db.closeDB();
topic2_db.closeDB();
kindDB.closeDB();
stateDB.closeDB();
writeFile.writeClose();
%>