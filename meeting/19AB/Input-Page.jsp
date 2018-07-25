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
String date = (cal.getTime()).toString();

/*** ロックの有無確認 ***/
db.getQuery("select * from " + ClassDefine.lock_table + " where lock_id = 0;");
db.getNext();
String lock_user = db.getResult("lock_user");
if(lock_user.equals(user) || lock_user.equals("dummy")){
db.exeQuery("update " + ClassDefine.lock_table + " set lock_user='" + user + "' where lock_id = 0;");
/*** 登録件数取得 ***/
int kensu = 1;
if(request.getParameter("kensu") != null && !request.getParameter("kensu").equals("")){
kensu = Integer.parseInt(request.getParameter("kensu"));
}

%>
<html>
<head>
<title>課題管理ページ入力画面</title>
<SCRIPT 
src="jkl-calendar.js" 
type=text/javascript charset=Shift_JIS></SCRIPT>
</head>
<body>
<center>
<FONT COLOR="Crimson">現日付：<%= cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.DATE)%></FONT>
<form id=formid action="Master-Page.jsp" method="post">
<input type="submit" value="更新">  <input type="reset" value="リセット"> <br><br>
<input type="hidden" name="search" value="0">
<input type="hidden" name="kensu" value="<%=kensu%>">
<table border="2" cellspacing=0 bordercolor="#666666">
<tr><td align="center">ID</td>
<td align="center">項番</td>
<td align="center">トピック名</td>
<td align="center">工程</td>
<td align="center">種別</td><td align="center" >状態</td>
<td align="center">開始予定日</td><td align="center">完了予定日</td>
<td align="center">最終更新日</td><td align="center">完了日</td>
<td align="center">担当者</td>
<td align="center">操作</td></tr>
<%
/*** 次のトピックIDを取得 ***/
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
<!- /*** トピックID ***/ ->
<tr><td align="center"><input type="hidden" name="topic_id[<%= i%>]" value=""><%= n + i%></td>
<!- /*** トピック名 ***/ ->
<td><input name="kouban[<%= i%>]" type="text" value="" size="20" maxlength="40"></input>
<!- /*** トピック名 ***/ ->
<td><input name="topic_name[<%= i%>]" type="text" value="" size="70" maxlength="40"></input>
</td>
<!- /*** 子IDを表示 ***/ ->
<td><select name="topic_sub_id[<%= i%>]">
<option value="0">要件定義</option>
<option value="1">基本設計</option>
<option value="2">概要設計</option>
<option value="3">詳細設計</option>
<option value="4">製造</option>
<option value="5">単体試験</option>
<option value="6">結合試験</option>
<option value="7">安定化試験</option>
<option value="8">維持管理</option>
<option value="9">その他</option>
</select>
</td>
<!- /*** 種別 ***/ ->
<!- /*** 種別を表示 ***/ ->
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
/*** 状態を判定 ***/
%>
<!- /*** 状態を表示 ***/ ->
<td>
<select name="state_id[<%= i%>]">
<option value="4">新規</option>
<!- /*** 着手予定を表示 ***/ ->
<td>
<DIV id=date1_<%= i%>></DIV>
<input onclick="date1_<%= i%>.hide(); date1_<%= i%>.write();" onchange="date1_<%= i%>.getFormValue(); date1_<%= i%>.hide();" name="plan_topic_date[<%= i%>]" type="text" value="" size="13"></td>
<!- /*** 完了予定を表示 ***/ ->
<td>
<DIV id=date2_<%= i%>></DIV>
<input onclick="date2_<%= i%>.hide(); date2_<%= i%>.write();" onchange="date2_<%= i%>.getFormValue(); date2_<%= i%>.hide();" name="plan_limit_date[<%= i%>]" type="text" value="" size="13"><br></td>
<!- /*** 開始日を表示 ***/ ->
<td><!-input name="topic_datetime_limit[<%= i%>]" type="text" value="" size="13"-><br></td>
<!- /*** 期限 ***/ ->
<td><!- input name="time_limit[<%= i%>]" type="text" value="" size="13"-><br></td>
<!-/*** 担当者の入力欄 ***/ ->
<%
/*** 担当者を判定 ***/
%>
<!- /*** 担当者を表示 ***/ ->
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
<!- /*** 操作 ***/ ->
<td><input name="topic_ope[<%= i%>]" type="hidden" value="3">新規</td><tr>
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
<%= db.getResult("name")%>によって登録処理が行われています
<%
}
db.closeDB();
%>
