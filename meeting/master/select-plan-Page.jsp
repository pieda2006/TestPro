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
Date day = cal.getTime();
Day_Operation dayop = new Day_Operation();
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy'/'MM'/'dd' 'HH':'mm':'ss");

//課題内容表示用
DB_Operation topic_db = new DB_Operation();
//ユーザ表示用
DB_Operation user_db = new DB_Operation();
DB_Operation kindDB = new DB_Operation();
String currentdate = null;

//CSV出力用
Escape_String convert_csv = new Escape_String();
WriteCSV writeFile = new WriteCSV(ClassDefine.file_dir + user + "_topic_plan.csv");
/*** 操作を取得 ***/
String ope = request.getParameter("ope");
/*** 2012/05/09 S ***/
String complete_date = null;
String view_complete_date = null;
/*** 2012/05/09 E ***/
String topic_kind = null;
long alerttime = 0;
if(ope == null || ope.equals("0") || ope.equals("2")){
if(ope != null && ope.equals("2")){
session.setAttribute("search_word_10",request.getParameter("search_word_10"));
session.setAttribute("search_word_11",request.getParameter("search_word_11"));
session.setAttribute("search_word_12",request.getParameter("search_word_12"));
session.setAttribute("search_word_19",request.getParameter("search_word_19"));
session.setAttribute("topic_user_plan_1",request.getParameter("topic_user_plan_1"));
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
String search_word_19 = (String)session.getAttribute("search_word_19");
if(search_word_19 == null || search_word_19.equals("null")){
search_word_19 = "0";
}
String topic_user_plan_1 = (String)session.getAttribute("topic_user_plan_1");
%>
<html>
<head>
<title>作業計画表示画面</title>
<SCRIPT 
src="jkl-calendar.js" 
type=text/javascript charset=Shift_JIS></SCRIPT>
</head>
<body>
<center>
<a href="update-plan-Page.jsp"><font size=2 color="black">作業予定更新画面</font></a>
<FONT COLOR="Crimson">現日付：<%= cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.DATE)%></FONT><br>
<form id=formid action="select-plan-Page.jsp" method="post">
<SCRIPT><!--
    var search_10 = new JKL.Calendar("search_10","formid","search_word_10");
	search_10.setStyle( "frame_color", "#3333CC" );
    var search_12 = new JKL.Calendar("search_12","formid","search_word_12");
	search_12.setStyle( "frame_color", "#CC3333" );
//--></SCRIPT>
<TABLE><TR><TD>
<TD><FONT COLOR="Crimson">検索日1：</FONT></TD>
<TD><DIV id=search_10></DIV></TD>
<TD><input type="text" onclick="search_10.hide(); search_10.write(); " onchange="search_10.getFormValue(); search_10.hide();" name="search_word_10" value="<%=search_word_10%>" size="30" maxlength="30"></TD>
<TD><FONT COLOR="Crimson">検索日2：</FONT></TD>
<TD><DIV id=search_12></DIV></TD>
<TD><input type="text" onclick="search_12.hide(); search_12.write();" onchange="search_12.getFormValue(); search_12.hide();" name="search_word_12" value="<%=search_word_12%>" size="30" maxlength="30"></TD>
<TD><FONT COLOR="Crimson">ID：</FONT></TD>
<TD><input type="text" name="search_word_11" value="<%=search_word_11%>" size="3" maxlength="30"></TD>
<TD><FONT COLOR="Crimson">担当：</FONT>	</TD>
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
<TD><FONT COLOR="Crimson">アラート：</FONT></TD>
<TD><select name="search_word_19">
<option value="<%=search_word_19%>">
<%
if(search_word_19==null || search_word_19.equals("") || search_word_19.equals("0")){
%>
OFF
<%
} else {
%>
ON
<%
}
%>
</option>
<option value="0">OFF</option>
<option value="1">ON</option>
</select></TD>
<TD><input name="ope" type="hidden" value="2"></TD>
<TD><input type="submit" value="検索">  <input type="reset" value="抽出条件リセット">
</TD></TR></TABLE>
</form>
<a href="PDF_File/<%= user%>_topic_plan.csv"><font size=2 color="black">作業計画ダウンロード</font></a>
<%
if(ope != null && ope.equals("2") && (!search_word_10.equals("") || !search_word_12.equals(""))){
if(!search_word_10.equals("") && search_word_12.equals("")){
/*** 2012/05/09 S ***/
db.getQuery("select * from " + ClassDefine.topic_plan + " where date >= '" + search_word_10 + " 00:00:00' order by date,id;");
} else if(search_word_10.equals("") && !search_word_12.equals("")){
db.getQuery("select * from " + ClassDefine.topic_plan + " where date <= '" + search_word_12 + " 23:59:59' order by date,id;");
} else {
db.getQuery("select * from " + ClassDefine.topic_plan + " where date >= '" + search_word_10 + " 00:00:00' and date <= '" + search_word_12 + " 23:59:59' order by date,id;");
}
} else if (ope.equals("2") && !search_word_11.equals("")){
db.getQuery("select * from " + ClassDefine.topic_plan + " where id=" + Integer.parseInt(search_word_11) + " order by date,id;");
/*** 2012/05/09 E ***/
}
int i = 0;
%>
<table><tr><td valign="top">
<table border="2" cellspacing=0 bordercolor="#666666">
<tr bgcolor="#ffff99" nowrap>
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
</tr>
<%
/*** 2012/05/09 S ***/
writeFile.writeString("\"開始予定\",\"完了予定\",\"ID\",\"課題内容\",\"工程\",\"種別\",\"担当者\",\"備考\"");
/*** 2012/05/09 E ***/
while(db.getNext()){
if((topic_user_plan_1 == null || topic_user_plan_1.equals("-1") || topic_user_plan_1.equals(db.getResult("user_name"))) &&
   (search_word_11 == null || search_word_11.equals("") ||  db.getResult("id").equals(search_word_11))){
topic_db.getQuery("select topic_name,kind_id,topic_sub_id from " + ClassDefine.topic_info + " where topic_id=" + db.getResult("id") + ";");
topic_db.getNext();
user_db.getQuery("select user_name from " + ClassDefine.user_info + " where user_id='" + db.getResult("user_name") + "';");
user_db.getNext();
if(currentdate != null && !currentdate.equals(db.getResult("date").substring(0,10))){
%>
</table>
<br>
<table border="2" cellspacing=0 bordercolor="#666666">
<tr bgcolor="#ffff99" nowrap>
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
</tr>
<%
}
currentdate = db.getResult("date").substring(0,10);
/*** 2012/05/09 S ***/
if(day.after(sdf1.parse(dayop.editDate(db.getResult("complete_date"))))){
%>
<tr bgcolor="#FFFF00">
<%
} else {
%>
<tr>
<%
}
/*** 2012/05/09 E ***/
kindDB.getQuery("select * from " + ClassDefine.topic_kind + " where kind_id = " + topic_db.getResult("kind_id") + ";");
kindDB.getNext();
topic_kind = kindDB.getResult("kind");
/*** 2012/05/09 S ***/
complete_date = db.getResult("complete_date");
view_complete_date = db.getResult("complete_date");
if(complete_date.equals("1111-11-11 00:00:00")){
complete_date = "";
view_complete_date = "<br>";
}
String topic_sub_id_current = topic_db.getResult("topic_sub_id");
String topic_sub_id =null;
if(topic_sub_id_current.equals("0")){
topic_sub_id = "要件定義";
} else if(topic_sub_id_current.equals("1")){
topic_sub_id = "基本設計";
}  else if(topic_sub_id_current.equals("2")){
topic_sub_id = "概要設計";
}  else if(topic_sub_id_current.equals("3")){
topic_sub_id = "詳細設計";
}  else if(topic_sub_id_current.equals("4")){
topic_sub_id = "製造";
}  else if(topic_sub_id_current.equals("5")){
topic_sub_id = "単体試験";
}  else if(topic_sub_id_current.equals("6")){
topic_sub_id = "結合試験";
}  else if(topic_sub_id_current.equals("7")){
topic_sub_id = "安定化試験";
}  else if(topic_sub_id_current.equals("8")){
topic_sub_id = "維持管理";
}  else if(topic_sub_id_current.equals("9")){
topic_sub_id = "その他";
}
%>
<td nowrap><%= dayop.editDate(db.getResult("date").substring(0,10))%></td>
<td nowrap><%= db.getResult("date").substring(11,13) + ":" + db.getResult("date").substring(14,16)%></td>
<td nowrap><%= view_complete_date.substring(11,13) + ":" + view_complete_date.substring(14,16)%></td>
<td nowrap><%= db.getResult("id")%></td>
<td nowrap><%= topic_db.getResult("topic_name")%></td>
<td nowrap><%= topic_sub_id%></td>
<td nowrap><%= topic_kind%></td>
<td nowrap><%= user_db.getResult("user_name")%></td>
<td nowrap><%= db.getResult("shinchoku")%></td>
<td nowrap><%= convert_csv.editReturn(db.getResult("biko"))%></td>
<%
if(search_word_19.equals("1")){
alerttime = sdf1.parse(dayop.editDate(db.getResult("complete_date"))).getTime() - day.getTime();
if(alerttime > 0) {
%>
<script language="JavaScript">
function timeout<%= db.getResult("id")%>(){
window.focus();
//timerid_<%= db.getResult("id")%> = setTimeout( "timeout<%= db.getResult("id")%>()", 10000)
//window_object = window.open("comform.jsp");
//window_object.focus();
//if(window.confirm("[課題<%= db.getResult("id")%>：<%= topic_db.getResult("topic_name")%>]の作業時間が終了しました。")){
//clearTimeout(timerid_<%= db.getResult("id")%>);
//}
alert("[課題<%= db.getResult("id")%>：<%= topic_db.getResult("topic_name")%>]の作業時間が終了しました。");
}

setTimeout( "timeout<%= db.getResult("id")%>()", <%= sdf1.parse(dayop.editDate(db.getResult("complete_date"))).getTime() - day.getTime() %>)

</script>
<%
}
}
%>
</tr>
<%
writeFile.writeString("\"" + db.getResult("date") + "\",\"" + complete_date + "\",\"" + db.getResult("id") + "\",\"" + topic_db.getResult("topic_name") + "\",\"" + topic_sub_id + "\",\"" + topic_kind + "\",\"" + user_db.getResult("user_name") + "\",\"" + convert_csv.convertCsv(db.getResult("biko")) + "\"");
/*** 2012/05/09 E ***/
}
i++;
}
%>
</table></td></tr></table>
<input type="hidden" name="kensu" value="<%=i%>"></input>
<!- /*** 操作 ***/ ->
<input name="ope" type="hidden" value="1">
<center>
</body>
</html>
<%
}
db.closeDB();
topic_db.closeDB();
user_db.closeDB();
writeFile.writeClose();
%>