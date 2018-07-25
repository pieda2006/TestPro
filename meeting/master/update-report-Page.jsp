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

/*** 現在の日時を取得 ***/
/*** 日付をシステム変数から取得するオブジェクト宣言 ***/
GregorianCalendar cal = new GregorianCalendar();
//String day = (cal.getTime()).toString();
//課題内容表示用
DB_Operation topic_db = new DB_Operation();
//ユーザ表示用
DB_Operation user_db = new DB_Operation();
DB_Operation kindDB = new DB_Operation();
Day_Operation dayop = new Day_Operation();
SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy'/'MM'/'dd");

String[] strarray = null;
/*** 2012/4/4 S ***/
String currentdate = null;
/*** 2012/4/4 E ***/

/*** 操作を取得 ***/
String ope = request.getParameter("ope");
if(ope != null && ope.equals("2")){
session.setAttribute("search_word_16",request.getParameter("search_word_16"));
session.setAttribute("search_word_17",request.getParameter("search_word_17"));
session.setAttribute("search_word_18",request.getParameter("search_word_18"));
session.setAttribute("topic_user_report_1",request.getParameter("topic_user_report_1"));
session.setAttribute("calender2",request.getParameter("calender2"));
}
if(ope == null){
ope = "2";
}

String search_word_16 = (String)session.getAttribute("search_word_16");
if(search_word_16 == null || search_word_16.equals("null")){
search_word_16 = "";
}
String search_word_17 = (String)session.getAttribute("search_word_17");
if(search_word_17 == null || search_word_17.equals("null")){
search_word_17 = "";
}
String search_word_18 = (String)session.getAttribute("search_word_18");
if(search_word_18 == null || search_word_18.equals("null")){
search_word_18 = "";
}
String topic_user_report_1 = (String)session.getAttribute("topic_user_report_1");
String calender = (String)session.getAttribute("calender2");//表示範囲
String operation = (String)session.getAttribute("operation");
if(operation != null && operation.equals("1")){
if((search_word_16 != null && !search_word_16.equals("null") && !search_word_16.equals("")) ||
   (search_word_17 != null && !search_word_17.equals("null") && !search_word_17.equals("")) ||
   (search_word_18 != null && !search_word_18.equals("null") && !search_word_18.equals(""))){
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
<title>作業内容確認画面</title>
<SCRIPT 
src="jkl-calendar.js" 
type=text/javascript charset=Shift_JIS></SCRIPT>
    <link id="calendar_style" href="stylesheets/simple.css" media="screen" rel="Stylesheet" type="text/css" />
    <script src="lib/prototype.js" type="text/javascript"></script>
    <script src="lib/effects.js" type="text/javascript"></script>
    <script src="javascripts/protocalendar.js" type="text/javascript"></script>
    <script src="javascripts/lang_ja.js" type="text/javascript"></script>
    <script src="javascripts/lang_zh-cn.js" type="text/javascript"></script>
    <script src="javascripts/lang_zh-tw.js" type="text/javascript"></script>
</head>
<body>
<center>
<a href="select-report-Page.jsp"><font size=2 color="black">作業内容表示画面</font></a>
<FONT COLOR="Crimson">現日付：<%= cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.DATE)%></FONT>
<form id=formid action="update-report-Page.jsp" method="post">
<SCRIPT><!--
    var search_16 = new JKL.Calendar("search_16","formid","search_word_16");
	search_16.setStyle( "frame_color", "#3333CC" );
    var search_18 = new JKL.Calendar("search_18","formid","search_word_18");
	search_18.setStyle( "frame_color", "#CC3333" );
//--></SCRIPT>
<TABLE><TR>
<TD><FONT COLOR="Crimson">検索日1：</FONT></TD>
<TD><DIV id=search_16></DIV></TD>
<TD><input type="text" onclick="search_16.hide(); search_16.write();" onchange="search_16.getFormValue(); search_16.hide();" name="search_word_16" value="<%=search_word_16%>" size="30" maxlength="30"></TD>
<TD><FONT COLOR="Crimson">検索日2：</FONT></TD>
<TD><DIV id=search_18></DIV></TD>
<TD><input type="text" onclick="search_18.hide(); search_18.write();" onchange="search_18.getFormValue(); search_18.hide();" name="search_word_18" value="<%=search_word_18%>" size="30" maxlength="30"></TD>
<TD><FONT COLOR="Crimson">ID：</FONT></TD>
<TD><input type="text" name="search_word_17" value="<%=search_word_17%>" size="3" maxlength="30"></TD>
<TD><FONT COLOR="Crimson">担当：</FONT></TD>
<TD><select name="topic_user_report_1">
<%
if(topic_user_report_1 != null && !topic_user_report_1.equals("")){
db.getQuery("select * from " + ClassDefine.user_info + " where user_id = '" + topic_user_report_1 + "';");
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
<TD><FONT COLOR="Crimson">カレンダー：</FONT></TD>
<TD><select name="calender2">
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
<TR><TD align="center" colspan=15><input type="submit" value="検索">  <input type="reset" value="抽出条件リセット"></TD></TR></TABLE>
</form>

<form id=formid1 action="update-report-Page.jsp" method="post">
<table><tr><td valign="top">
<table border="2" cellspacing=0 bordercolor="#666666">
<tr bgcolor="#ffff99">
<td align="center">日付</td>
<td align="center">開始時</td>
<td align="center">完了時</td>
<td align="center">ID</td>
<td align="center">課題名</td>
<td align="center">工程</td>
<td align="center">種別</td>
<td align="center">担当</td>
<td align="center">進捗</td>
<td align="center">備考</td>
<td align="center">更新</td>
</tr>
<%
if(ope != null && ope.equals("2") && (!search_word_16.equals("") || !search_word_18.equals(""))){
if(!search_word_16.equals("") && search_word_18.equals("")){
db.getQuery("select * from " + ClassDefine.topic_report + " where date >= '" + search_word_16 + " 00:00:00' order by date,id;");
} else if(search_word_16.equals("") && !search_word_18.equals("")){
db.getQuery("select * from " + ClassDefine.topic_report + " where date <= '" + search_word_18 + " 23:59:59' order by date,id;");
} else {
db.getQuery("select * from " + ClassDefine.topic_report + " where date >= '" + search_word_16 + " 00:00:00' and date <= '" + search_word_18 + " 23:59:59' order by date,id;");
}
} else if (ope.equals("2") && !search_word_17.equals("")){
db.getQuery("select * from " + ClassDefine.topic_report + " where id=" + Integer.parseInt(search_word_17) + " order by date,id;");
}
int i = 0;

while(db.getNext()){
if((topic_user_report_1 == null || topic_user_report_1.equals("-1") || topic_user_report_1.equals(db.getResult("user_name"))) &&
   (search_word_17 == null || search_word_17.equals("") ||  db.getResult("id").equals(search_word_17))){
/*** 2012/4/4 S ***/
if(currentdate != null && !currentdate.equals(db.getResult("date").substring(0,10))){
%>
</table><br>
<table border="2" cellspacing=0 bordercolor="#666666">
<tr bgcolor="#ffff99">
<td align="center">日付</td>
<td align="center">開始時</td>
<td align="center">完了時</td>
<td align="center">ID</td>
<td align="center">課題名</td>
<td align="center">工程</td>
<td align="center">種別</td>
<td align="center">担当</td>
<td align="center">進捗</td>
<td align="center">備考</td>
<td align="center">更新</td>
</tr>
<%
}
currentdate = db.getResult("date").substring(0,10);
/*** 2012/4/4 E ***/
%>
<!- /*** 日時を表示 ***/ ->

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
<input onclick="topic_date_<%= i%>.hide(); topic_date_<%= i%>.write();" onchange="topic_date_<%= i%>.getFormValue(); topic_date_<%= i%>.hide();" name="topic_date[<%= i%>]" type="text" value="<%= dayop.editDate(db.getResult("date").substring(0,10))%>" size="10">
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
<!- /*** IDを表示 ***/ ->
<td align="center">
<input type="hidden" name="id[<%= i%>]" value="<%= db.getResult("id")%>"><%= db.getResult("id")%></input>
</td>
<!- /*** 課題名を表示 ***/ ->
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
要件定義
<%
} else if(topic_sub_id_current.equals("1")){
%>
基本設計
<%
}  else if(topic_sub_id_current.equals("2")){
%>
概要設計
<%
}  else if(topic_sub_id_current.equals("3")){
%>
詳細設計
<%
}  else if(topic_sub_id_current.equals("4")){
%>
製造
<%
}  else if(topic_sub_id_current.equals("5")){
%>
単体試験
<%
}  else if(topic_sub_id_current.equals("6")){
%>
結合試験
<%
}  else if(topic_sub_id_current.equals("7")){
%>
安定化試験
<%
}  else if(topic_sub_id_current.equals("8")){
%>
維持管理
<%
}  else if(topic_sub_id_current.equals("9")){
%>
その他
<%
}
%>
</td>
<!- /*** 種別を表示 ***/ ->
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
<td nowrap><input type="submit" value="更新"><input type="reset" value="リセット"> </td>
<tr>
<%
i++;
}
}
%>
</table><br>
<table border="2" cellspacing=0 bordercolor="#666666">
<tr bgcolor="#ffff99">
<td align="center">日付</td>
<td align="center">開始時</td>
<td align="center">完了時</td>
<td align="center">ID</td>
<td align="center">課題名</td>
<td align="center">工程</td>
<td align="center">種別</td>
<td align="center">担当</td>
<td align="center">進捗</td>
<td align="center">備考</td>
<td align="center">更新</td>
</tr>
<%
for(int j = 0;j < 6;j++){
%>
<!- /*** 日時を表示 ***/ ->
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
<input onclick="topic_date_<%= i%>.hide(); topic_date_<%= i%>.write();" onchange="topic_date_<%= i%>.getFormValue(); topic_date_<%= i%>.hide();" name="topic_date[<%= i%>]" type="text" value="" size="10">
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
<!- /*** IDを表示 ***/ ->
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
<td nowrap><input type="submit" value="更新"><input type="reset" value="リセット"></td>
<tr>
<%
i++;
}
%>
</table></td></tr></table>
<input type="hidden" name="kensu" value="<%=i%>"></input>
<!- /*** 操作 ***/ ->
<input name="ope" type="hidden" value="1">
</form>
<center>
</body>
</html>
<%
}
else {
session.setAttribute("operation","1");
/*** 登録件数取得 ***/
int kensu = 0;
if(request.getParameter("kensu") != null && !request.getParameter("kensu").equals("")){
kensu = Integer.parseInt(request.getParameter("kensu"));
}
/*** 次のトピックIDを取得 ***/
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
String topic_shinchoku = null;
String biko = null;
String new_user_name = null;
String kind = null;
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
db.exeQuery("update " + ClassDefine.topic_report + " set date = '" + topic_date + "',complete_date='" + topic_comp_date + "',biko = '" + biko + "', shinchoku = " + topic_shinchoku + ", user_name='" + new_user_name + "' where id = " + id +" and date='" + old_topic_date + "' and user_name='" + user_name + "';");
}else if(topic_date != null && !topic_date.equals("") && old_topic_date.equals("") && topic_comp_date != null && !topic_comp_date.equals("")){
id = request.getParameter("id[" + i + "]");
user_name = request.getParameter("user_name[" + i + "]");
db.exeQuery("insert into " + ClassDefine.topic_report + " values('" + topic_date + "','" + topic_comp_date + "'," + id + ",'" + user_name + "','" + biko + "'," + topic_shinchoku + ");");
}
}
db.exeQuery("delete from " + ClassDefine.topic_report + " where date='1111-11-11 00:00:00'");
db.closeDB();
topic_db.closeDB();
user_db.closeDB();
%>
<jsp:forward page="update-report-Page.jsp" />
<%
}
db.closeDB();
topic_db.closeDB();
user_db.closeDB();
%>