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

Htbbsf writebbs = new Htbbsf();
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

Day_Operation day = new Day_Operation();
DB_Operation idDB = new DB_Operation();
DB_Operation new_num = new DB_Operation();
/*Tree sort_Tree = new Tree();
Topic_Struct topic_struct = new Topic_Struct();*/

/*** 質問の最大数を読みこむ***/
int max = 999999;

/*** 送信されてきたメッセージを取得 ***/

String topic_ope = null;
String topic_id = null;
String topic_sub_id = null;
String topic_name = null;
String kind_id = null;
String time_limit = null;
String state_id = null;
String topic_date = null;
String user_id = null;
String plan_topic_date = null;
String plan_limit_date = null;
int topic_count = 0;
String topic_now = null;
int bgcolor=0;
Vector dataList = null;
Hashtable data = null;
int size = 0;
String biko = null;
Escape_String convert = new Escape_String();
/*Tree_Struct tree_Struct = null;*/

/*** 現在の日時を取得 ***/
/*** 日付をシステム変数から取得するオブジェクト宣言 ***/
GregorianCalendar cal = new GregorianCalendar();
Date currentdate = cal.getTime();
String date = currentdate.toString();
DateFormat df = DateFormat.getDateInstance();
db.getQuery("select master_auth from " + ClassDefine.user_info + " where user_id ='" + user + "'");
if(db.getNext()){
topic_now = db.getResult("master_auth");
}

/*** 変更を読みこむ ***/
int i = 0;
int kensu = 0;
if(request.getParameter("kensu") != null && !request.getParameter("kensu").equals("")){
kensu = Integer.parseInt(request.getParameter("kensu"));
}
topic_ope = request.getParameter("topic_ope[" + i + "]");
/*** トピックの登録がされているところまでを読みこむ(データの存在個数を確認) ***/
while(topic_ope != null){
/*** データの変更を行なう ***/
if(topic_ope.equals("1")){
/*** 変更するデータを取得 ***/
topic_id = request.getParameter("topic_id[" + i + "]");
topic_sub_id = request.getParameter("topic_sub_id[" + i + "]");
topic_name = request.getParameter("topic_name[" + i + "]");
kind_id = request.getParameter("kind_id[" + i + "]");
time_limit = request.getParameter("time_limit[" + i + "]");
state_id = request.getParameter("state_id[" + i + "]");
topic_date = request.getParameter("topic_date[" + i + "]");
user_id = request.getParameter("user_id[" + i + "]");
plan_topic_date = request.getParameter("plan_topic_date[" + i + "]");
plan_limit_date = request.getParameter("plan_limit_date[" + i + "]");
if(plan_topic_date == null || plan_topic_date.equals("")){
plan_topic_date = "1111/11/11";
}
if(plan_limit_date == null || plan_limit_date.equals("")){
plan_limit_date = "1111/11/11";
}
if(topic_date == null || topic_date.equals("")){
topic_date = "1111/11/11";
}
if(time_limit == null || time_limit.equals("")){
time_limit = "1111/11/11";
}

if(state_id.equals("3")){
if(topic_now.equals("0")){
topic_now=topic_id;
db.exeQuery("update " + ClassDefine.user_info + " set master_auth=" + topic_id + " where user_id='" + user + "';");
db.exeQuery("insert into topic_report values('" + date + "','1111-11-11'," + topic_id + ",'" + user + "','');");
db.exeQuery("update " + ClassDefine.topic_info + " set topic_sub_id=" + topic_sub_id + ",topic_name='" + topic_name + "',kind_id=" + kind_id + ",time_limit='" + day.undoDate(time_limit) + "',state_id=" + state_id + ",topic_date='" + day.undoDate(topic_date) + "',user_id='" + user_id + "',topic_delete=" + 0 + ",plan_topic_date ='" + day.undoDate(plan_topic_date) + "',plan_limit_date ='" + day.undoDate(plan_limit_date) + "' where topic_id=" + topic_id +  ";");
}
else if(topic_now.equals(topic_id)){
db.exeQuery("update " + ClassDefine.topic_info + " set topic_sub_id=" + topic_sub_id + ",topic_name='" + topic_name + "',kind_id=" + kind_id + ",time_limit='" + day.undoDate(time_limit) + "',state_id=" + state_id + ",topic_date='" + day.undoDate(topic_date) + "',user_id='" + user_id + "',topic_delete=" + 0 + ",plan_topic_date ='" + day.undoDate(plan_topic_date) + "',plan_limit_date ='" + day.undoDate(plan_limit_date) + "' where topic_id=" + topic_id +  ";");
}
} else {
if(topic_now.equals(topic_id)){
topic_now="0";
db.exeQuery("update " + ClassDefine.user_info + " set master_auth= 0 where user_id='" + user + "';");
db.getQuery("select * from " + ClassDefine.topic_report + " where id=" + topic_id + " and user_name='" + user + "' order by date desc;");
if(db.getNext()){
db.exeQuery("update " + ClassDefine.topic_report + " set complete_date='" + date + "' where id=" + topic_id + " and user_name='" + user + "' and date='" + db.getResult("date") + "';");
}
db.exeQuery("update " + ClassDefine.topic_info + " set topic_sub_id=" + topic_sub_id + ",topic_name='" + topic_name + "',time_limit='" + day.undoDate(time_limit) + "',state_id=" + state_id + ",topic_date='" + day.undoDate(topic_date) + "',user_id='" + user_id + "',topic_delete=" + 0 + ",plan_topic_date ='" + day.undoDate(plan_topic_date) + "',plan_limit_date ='" + day.undoDate(plan_limit_date) + "' where topic_id=" + topic_id +  ";");
} else {
db.exeQuery("update " + ClassDefine.topic_info + " set topic_sub_id=" + topic_sub_id + ",topic_name='" + topic_name + "',kind_id=" + kind_id + ",time_limit='" + day.undoDate(time_limit) + "',state_id=" + state_id + ",topic_date='" + day.undoDate(topic_date) + "',user_id='" + user_id + "',topic_delete=" + 0 + ",plan_topic_date ='" + day.undoDate(plan_topic_date) + "',plan_limit_date ='" + day.undoDate(plan_limit_date) + "' where topic_id=" + topic_id +  ";");
}
}
}
/*** データの削除処理 ***/
else if(topic_ope.equals("2")){
topic_id = request.getParameter("topic_id[" + i + "]");
db.exeQuery("update " + ClassDefine.topic_info + " set topic_delete =" + 1 + "where topic_id =" + topic_id + ";");
}
/*** 新規データの追加 ***/
else if(topic_ope.equals("3")){
if((kensu - 1) == i){
db.exeQuery("update " + ClassDefine.lock_table + " set lock_user = 'dummy' where lock_id = 0;");
}
topic_name = request.getParameter("topic_name[" + i + "]");
if(topic_name != null && !topic_name.equals("")){
/*** 新規追加 ***/
/*** 新規追加IDを取得 ***/
new_num.getQuery("select topic_id from " + ClassDefine.next_id);
new_num.getNext();
/*** 追加するデータを取得 ***/
plan_topic_date = request.getParameter("plan_topic_date[" + i + "]");
if(plan_topic_date == null || plan_topic_date.equals("")){
plan_topic_date = "1111/11/11";
}
plan_limit_date = request.getParameter("plan_limit_date[" + i + "]");
if(plan_limit_date == null || plan_limit_date.equals("")){
plan_limit_date = "1111/11/11";
}
//time_limit = request.getParameter("time_limit[" + i + "]");
kind_id = request.getParameter("kind_id[" + i + "]");
state_id = request.getParameter("state_id[" + i + "]");
//topic_date = request.getParameter("topic_date[" + i + "]");
user_id = request.getParameter("user_id[" + i + "]");
topic_sub_id = request.getParameter("topic_sub_id[" + i + "]");
if(topic_sub_id == null || topic_sub_id.equals("")){
topic_sub_id = new_num.getResult("topic_id");
}
/*** データベースへ追加  ***/
db.exeQuery("insert into " + ClassDefine.topic_info + " values(" + new_num.getResult("topic_id") + "," + topic_sub_id + ",'" + topic_name + "'," + kind_id + ",'1111-11-11'," + state_id + ",'1111-11-11','" + user_id + "'," + 0 + ",'" + day.undoDate(plan_topic_date) + "','" + day.undoDate(plan_limit_date) + "');");
/*** 新規BBS作成 ***/
writebbs.writeHtbbsf(Integer.parseInt(new_num.getResult("topic_id")),ClassDefine.bbs_dir,"課題","q");
new_num.exeQuery("update " + ClassDefine.next_id + " set topic_id = " + (Integer.parseInt(new_num.getResult("topic_id")) + 1) + ";");
}
}
i++;
topic_ope = request.getParameter("topic_ope[" + i + "]");
}
DB_Operation kindDB = new DB_Operation();
DB_Operation stateDB = new DB_Operation();
DB_Operation userDB = new DB_Operation();

/*** DBから取得したデータを表示 ***/
int shinchoku_add = 0;
String search_word_1 = null;
String search_word_2 = null;
String search_word_3 = null;
String search_word_4 = null;
String search_word_28 = null;
String topic_user = null;
String topic_kind_m = null;
String topic_state = null;
String topic_sure = null;

/*** 検索処理の有無 ***/
String search = null;
/*** 検索かどうかを確認 ***/
search = request.getParameter("search");
if(search != null && search.equals("1")){

//検索条件を取得
/*** 検索語 ***/
search_word_1 = request.getParameter("search_word_1");//検索語1
search_word_2 = request.getParameter("search_word_2");//検索語2
search_word_3 = request.getParameter("search_word_3");//検索語3
search_word_4 = request.getParameter("search_word_4");//検索語4
search_word_28 = request.getParameter("search_word_28");

topic_user = request.getParameter("topic_user");//ユーザ名
topic_kind_m = request.getParameter("topic_kind_m");//種別
topic_state = request.getParameter("topic_state");//状態
topic_sure = request.getParameter("topic_sure");//表示範囲
// セッション変数の格納
session.setAttribute("search_word_1",search_word_1);
session.setAttribute("search_word_2",search_word_2);
session.setAttribute("search_word_3",search_word_3);
session.setAttribute("search_word_4",search_word_4);
session.setAttribute("search_word_28",search_word_28);
session.setAttribute("topic_user",topic_user);
session.setAttribute("topic_kind_m",topic_kind_m);
session.setAttribute("topic_state",topic_state);
session.setAttribute("topic_sure",topic_sure);
}
else{
search_word_1 = (String)session.getAttribute("search_word_1");//検索語1
if(search_word_1 == null){
search_word_1 = "";
}
search_word_2 = (String)session.getAttribute("search_word_2");//検索語2
if(search_word_2 == null){
search_word_2 = "";
}
search_word_3 = (String)session.getAttribute("search_word_3");//検索語3
if(search_word_3 == null){
search_word_3 = "";
}
search_word_4 = (String)session.getAttribute("search_word_4");//検索語3
search_word_28 = (String)session.getAttribute("search_word_28");
if(search_word_28 == null){
search_word_28 = "";
}

topic_user = (String)session.getAttribute("topic_user");//ユーザ名
topic_kind_m = (String)session.getAttribute("topic_kind_m");//種別
topic_state = (String)session.getAttribute("topic_state");//状態
topic_sure = (String)session.getAttribute("topic_sure");//表示範囲
}
%>
<html>
<head>
<title>課題管理ページ 表示用</title>
<script type="text/javascript" src="fixed_midashi.js"></script>
</head>
<body onLoad="FixedMidashi.create();">
<center>
<font color="bulue" size="10"><%/*課題管理ページ*/%></font>
<%/*<br><br>*/%>
<form action="Master-Page-View.jsp" method="post">
<input type="hidden" name="search" value="1">
<FONT COLOR="Crimson">検索語1：</FONT>
<input type="text" name="search_word_1" value="<%= search_word_1%>" size="30" maxlength="30">

<FONT COLOR="Crimson">項番：</FONT>
<input type="text" name="search_word_2" value="<%= search_word_2%>" size="30" maxlength="30">

<FONT COLOR="Crimson">ID：</FONT>
<input type="text" name="search_word_3" value="<%= search_word_3%>" size="5" maxlength="30">
<FONT COLOR="Crimson">種別：</FONT>
<select name="search_word_4">
<%
if(search_word_4 == null || search_word_4.equals("")){
%>
<option value=""></option>
<%
} else if(search_word_4.equals("0")){
%>
<option value="0">要件定義</option>
<%
} else if(search_word_4.equals("1")){
%>
<option value="1">基本設計</option>
<%
} else if(search_word_4.equals("2")){
%>
<option value="2">概要設計</option>
<%
} else if(search_word_4.equals("3")){
%>
<option value="3">詳細設計</option>
<%
} else if(search_word_4.equals("4")){
%>
<option value="4">製造</option>
<%
} else if(search_word_4.equals("5")){
%>
<option value="5">単体試験</option>
<%
} else if(search_word_4.equals("6")){
%>
<option value="6">結合試験</option>
<%
} else if(search_word_4.equals("7")){
%>
<option value="7">安定化試験</option>
<%
} else if(search_word_4.equals("8")){
%>
<option value="8">維持管理</option>
<%
} else if(search_word_4.equals("9")){
%>
<option value="9">その他</option>
<%
} else if(search_word_4.equals("10")){
%>
<option value="10">その他</option>
<%
}
%>
<option value=""></option>
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
<option value="10">削除</option>
</select>
<br>
<FONT COLOR="Crimson">担当：</FONT>
<select name="topic_user">
<%
if(topic_user != null && !topic_user.equals("")){
db.getQuery("select * from " + ClassDefine.user_info + " where user_id='" + topic_user + "';");
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
</select>
<FONT COLOR="Crimson">工程：</FONT>
<select name="topic_kind_m">
<%
if(topic_kind_m != null && !topic_kind_m.equals("")){
db.getQuery("select * from " + ClassDefine.topic_kind + " where kind_id='" + topic_kind_m + "';");
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
<FONT COLOR="Crimson">状態：</FONT>
<select name="topic_state">
<%
if(topic_state != null && !topic_state.equals("")){
db.getQuery("select * from " + ClassDefine.topic_state + " where state_id='" + topic_state + "';");
if(db.getNext()){
%>
<option value="<%= db.getResult("state_id")%>">
<%=  db.getResult("topic_state")%>
</option>
<%
}
}
%>
<option value="-1"></option>
<%
db.getQuery("select * from " + ClassDefine.topic_state + ";");
while(db.getNext()){
%>
<option value="<%= db.getResult("state_id")%>">
<%=  db.getResult("topic_state")%>
</option>
<%
}
%>
</select>
<FONT COLOR="Crimson">表示範囲：</FONT>
<select name="topic_sure">
<%
if(topic_sure == null || topic_sure.equals("") || topic_sure.equals("0")){
%>
<option value="0"></option>
<%
} else if(topic_sure.equals("2")){
%>
<option value="2">全て(削除分も含む)</option>
<%
}
%>
<option value="0"></option>
<!-option value="1"-><!-親IDのみ-><!-/option->
<option value="2">全て(削除分も含む)</option>
</select>
<FONT COLOR="Crimson">備考表示：</FONT>
<select name="search_word_28">
<%
if(search_word_28 == null || search_word_28.equals("")){
%>
<option value=""></option>
<%
} else if(search_word_28.equals("1")){
%>
<option value="1">備考非表示</option>
<%
}
%>
<option value=""></option>
<option value="1">備考非表示</option>
</select>
<br>
<FONT COLOR="Crimson">現日付：<%= cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.DATE)%></FONT>
現在作業中の課題：<%= topic_now%><input type="submit" value="検索"><input type="reset" value="抽出条件リセット"></form>
<!- /*** 送信範囲(開始) ***/ ->
<a href="Csvout.jsp"><font size=2 color="black">CSVファイル作成</font></a>
<a href="PDF_File/<%= user%>.csv"><font size=2 color="black">CSVファイルダウンロード</font></a>
<a href="kubun.jsp"><font size=2 color="black">メニューへ戻る</font></a>
<%/* <a href="PDF_File/kadai.xlsx"><font size=2 color="black">課題管理表ダウンロード</font></a> */%>
<%/* <a href="PDF_File/kado.xlsx"><font size=2 color="black">稼動集計表ダウンロード</font></a> */%>
<a href="select-plan-Page.jsp" target="_blank"><font size=2 color="black">作業計画</font></a>
<a href="select-report-Page.jsp" target="_blank"><font size=2 color="black">作業実績</font></a>
<a href="select-plan-report-Page.jsp" target="_blank"><font size=2 color="black">作業線表</font></a>
<a href="Master-Page.jsp"><font size=2 color="black">編集用ページ</font></a>

<input type="hidden" name="search" value="0">
<table border="1"  style="border: 1px solid #666666; border-collapse: collapse;" _fixedhead="rows:1; cols:10">
<tr bgcolor="#ffff99">
<td align="center">ID</td>
<td align="center" colspan="9" nowrap>項目名</td>
<td align="center" nowrap>工程</td>
<td align="center" nowrap>種別</td><td align="center"  nowrap>状態</td>
<td align="center" nowrap>開始予定日</td><td align="center" nowrap>完了予定日</td>
<td align="center" nowrap>最新更新日</td><td align="center" nowrap>完了日</td>
<td align="center" nowrap>担当者</td>
<td align="center" nowrap>総数</td>
<td align="center" nowrap>実績</td>
<%
if(!search_word_28.equals("1")){
%>
<td align="center" nowrap>備考</td>
<%
}
%>
</tr>
<%

//SQL文を格納する変数
String sql = "select * from " + ClassDefine.topic_info + " order by kouban,kind_id,topic_sub_id,plan_limit_date desc,topic_id;";

/*** DBからデータを取得 ***/

db.getQuery(sql);
i=0;
if(topic_sure == null){
topic_sure = "0";
}
while (db.getNext()){
if((((search_word_1 == null) || search_word_1.equals("")) || (db.getResult("topic_name").indexOf(search_word_1) != -1)) &&
   (((search_word_2 == null) || search_word_2.equals("")) || (db.getResult("kouban").matches("^" + search_word_2 + ".*"))) &&
   (((search_word_3 == null) || search_word_3.equals("")) || db.getResult("topic_id").equals(search_word_3)) &&
   (((search_word_4 == null) || search_word_4.equals("")) || db.getResult("topic_sub_id").equals(search_word_4)) &&
   (((topic_user == null) || topic_user.equals("-1") || topic_user.equals("")) || db.getResult("user_id").equals(topic_user)) &&
   (((topic_kind_m == null) || topic_kind_m.equals("-1") || topic_kind_m.equals("")) || db.getResult("kind_id").equals(topic_kind_m)) &&
   (((topic_state == null) || topic_state.equals("-1") || topic_state.equals("")) || db.getResult("state_id").equals(topic_state)) &&
   (((topic_sure == null) || topic_sure.equals("") || topic_sure.equals("2")) || (topic_sure.equals("0") && db.getResult("topic_delete").equals("0")) || ((db.getResult("topic_id") == db.getResult("topic_sub_id")) && topic_sure.equals("1")))){
if(currentdate.after(df.parse(day.editDate(db.getResult("plan_limit_date")))) && !db.getResult("state_id").equals("2")){
bgcolor=1;
} else if(!db.getResult("state_id").equals("2")) {
bgcolor=0;
} else {
bgcolor=2;
}
%>
<%if(bgcolor==0){%><tr><%}else if(bgcolor==1){%><tr bgcolor="#FFFF00"> <%}else {%><tr bgcolor="#808080"> <%}%>
<!- /*** トピックIDを表示 ***/ ->
<td align="left" nowrap>
<%= db.getResult("topic_id")%></td>

<!- /*** 項番を表示 ***/ ->
<%
String[] split_koban = db.getResult("kouban").split("-", 9);
for(int count = 0; count < split_koban.length; count++){
%>
<td align="left" nowrap>
<%= split_koban[count]%></td>
<%
}
%>
<!- /*** トピック名 ***/ ->
<td colspan="<%= 9 - split_koban.length%>" nowrap><%= db.getResult("topic_name")%>
</td>



<!- /*** 優先度を表示 ***/ ->
<td nowrap>
<%
String topic_sub_id_current = db.getResult("topic_sub_id");
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
}  else if(topic_sub_id_current.equals("10")){
%>
削除
<%
}
%>
</td>
<%
/*** 種別を判定 ***/
kindDB.getQuery("select kind from " + ClassDefine.topic_kind + " where kind_id=" + db.getResult("kind_id") + ";");
kindDB.getNext();
String kind_id_current =db.getResult("kind_id");
%>
<!- /*** 種別を表示 ***/ ->
<td nowrap>
<%= kindDB.getResult("kind")%>
</td>
<%
/*** 状態を判定 ***/
stateDB.getQuery("select topic_state from " + ClassDefine.topic_state + " where state_id=" + db.getResult("state_id") + ";");
stateDB.getNext();
String state_id_current = db.getResult("state_id");
%>
<!- /*** 状態を表示 ***/ ->
<td nowrap>
<%= stateDB.getResult("topic_state")%>
</td>
<!- /*** 着手予定を表示 ***/ ->
<%
plan_topic_date = day.editDate(db.getResult("plan_topic_date"));
if(plan_topic_date.equals("1111/11/11")){
plan_topic_date = "<br>";
}
%>
<td nowrap><%= plan_topic_date%></td>
 <!- /*** 完了予定を表示 ***/ ->
<%
plan_limit_date = day.editDate(db.getResult("plan_limit_date"));
if(plan_limit_date.equals("1111/11/11")){
plan_limit_date = "<br>";
}
%>
<td nowrap><%= plan_limit_date%></td>
<!- /*** 開始日を表示 ***/ ->
<%
topic_date = day.editDate(db.getResult("topic_date"));
if(topic_date.equals("1111/11/11")){
topic_date = "<br>";
}
%>
<td nowrap><%= topic_date%></td>
<!- /*** 期限日を表示 ***/ ->
<%
time_limit = day.editDate(db.getResult("time_limit"));
if(time_limit.equals("1111/11/11")){
time_limit = "<br>";
}
%>
<td nowrap><%= time_limit%></td>
<%
/*** 担当者を判定 ***/
userDB.getQuery("select user_name from " + ClassDefine.user_info + " where user_id='" + db.getResult("user_id") + "';");
userDB.getNext();
String user_id_current = db.getResult("user_id");
%>
<!- /*** 担当者を表示 ***/ ->
<td nowrap>
<%= userDB.getResult("user_name")%>
</td>

<td nowrap><%= db.getResult("shinchoku")%></td>
<td nowrap><%= db.getResult("shinchoku2")%></td>
<%
dataList = readData(ClassDefine.bbs_dir + "htbbsf" + db.getResult("topic_id") + ".log", null);
size = dataList.size();
if(size > 0){
biko="";
for(i = 0;i < size;i++){
data = (Hashtable)dataList.get(i);
biko = biko.concat("【" + (String)data.get("date") + " " + (String)data.get("name") +"】<br>");
biko = biko.concat((String)data.get("comment") + "<br><br>");
//biko = convert.convertCsv(biko);
}
}
else {
biko = "<br>";
}
%>
<%
if(!search_word_28.equals("1")){
%>
<td nowrap>
<%= biko%>
</td>
<%
}
%>
</tr>
<%
i++;
}
}
%>
<!- /*** 送信範囲終了 ***/ ->
</table>
<center>
</body>
</html>
<%db.closeDB();
kindDB.closeDB();
stateDB.closeDB();
userDB.closeDB();
new_num.closeDB();%>
<%!
/*** 2008/06/17 データの取得 メソッド start***/

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

/*** 2008/06/17 データの取得 メソッド end***/
%>