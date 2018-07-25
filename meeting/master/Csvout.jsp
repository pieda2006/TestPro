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
%>
<jsp:forward page="attention.jsp" />
<%
}
}
else {
%>
<jsp:forward page="attention.jsp" />
<%
}

/*** パスワード認証(END) ***/

/*** ID ***/
String id = null;
/*** SubID ***/
String subid = null;
/*** トピック名 ***/
String topic_name = null;
/*** 種別 ***/
String kind = null;
/*** 状態 ***/
String state = null;
/*** 着手予定日 ***/
String plan_topic_date = null;
/*** 完了予定日 ***/
String plan_limit_date = null;
/*** 開始日 ***/
String topic_date = null;
/*** 完了日 ***/
String limit_date = null;
/*** 担当者 ***/
String user_id = null;
/*** 削除フラグ ***/
String delete_flg = null;
/*** 2008/06/17 備考 start ***/
String biko = null;
/*** 2008/06/17 備考 end ***/
int topic_count = 0;
int i = 0;
/*** 2008/06/17 掲示板情報格納用変数 start ***/
Vector dataList = null;
/*** 2008/06/17 掲示板情報格納用変数 end ***/

/*** 2008/06/17 掲示板情報のレスの数 start ***/
int size = 0;
/*** 2008/06/17 掲示板情報のレスの数 end ***/

/*** 2008/06/17 掲示板情報のハッシュ start ***/
Hashtable data = null;
/*** 2008/06/17 掲示板情報のハッシュ end ***/

/*** ユーザ・種別・状態・担当者検索用dbインスタンス生成 ***/
DB_Operation searchDB = new DB_Operation();

/*** 2008/06/17 CSV用変換クラス生成 start ***/
Escape_String convert = new Escape_String();
/*** 2008/06/17 CSV用変換クラス生成 end ***/

/*** ファイル吐き出し用インスタンス生成 ***/
WriteCSV writeFile = new WriteCSV(ClassDefine.file_dir + user + ".csv");

//SQL文を格納する変数
String sql = "select * from " + ClassDefine.topic_info + " order by kind_id,plan_limit_date desc;";
/*** 検索処理 ***/
db.getQuery(sql);
i = 0;
/*** ファイル出力 ***/
writeFile.writeString("\"ID\",\"トピック名\",\"工程\",\"種別\",\"状態\",\"開始予定日\",\"完了予定日\",\"最終更新日\",\"完了日\",\"担当者\",\"削除フラグ\",\"備考\"");

String search_word_1 = null;
String search_word_2 = null;
String search_word_3 = null;
String search_word_4 = null;
String topic_user = null;
String topic_kind_m = null;
String topic_state = null;
String topic_sure = null;

/*** 検索語 ***/
search_word_1 = (String)session.getAttribute("search_word_1");//検索語1
search_word_2 = (String)session.getAttribute("search_word_2");//検索語2
search_word_3 = (String)session.getAttribute("search_word_3");//検索語3
search_word_4 = (String)session.getAttribute("search_word_4");//検索語3
topic_user = (String)session.getAttribute("topic_user");//ユーザ名
topic_kind_m = (String)session.getAttribute("topic_kind_m");//種別
topic_state = (String)session.getAttribute("topic_state");//状態
topic_sure = (String)session.getAttribute("topic_sure");//表示範囲

while (db.getNext()){
if((((search_word_1 == null) || search_word_1.equals("")) || (db.getResult("topic_name").indexOf(search_word_1) != -1)) &&
   (((search_word_2 == null) || search_word_2.equals("")) || (db.getResult("topic_name").indexOf(search_word_2) != -1)) &&
   (((search_word_3 == null) || search_word_3.equals("")) || db.getResult("topic_id").equals(search_word_3)) &&
   (((search_word_4 == null) || search_word_4.equals("")) || db.getResult("topic_sub_id").equals(search_word_4)) &&
   (((topic_user == null) || topic_user.equals("-1") || topic_user.equals("")) || db.getResult("user_id").equals(topic_user)) &&
   (((topic_kind_m == null) || topic_kind_m.equals("-1") || topic_kind_m.equals("")) || db.getResult("kind_id").equals(topic_kind_m)) &&
   (((topic_state == null) || topic_state.equals("-1") || topic_state.equals("")) || db.getResult("state_id").equals(topic_state)) &&
   (((topic_sure == null) || topic_sure.equals("") || topic_sure.equals("2")) || (topic_sure.equals("0") && db.getResult("topic_delete").equals("0")) || ((db.getResult("topic_id") == db.getResult("topic_sub_id")) && topic_sure.equals("1")))){

id = db.getResult("topic_id");
if(db.getResult("topic_sub_id").equals("0")){
subid = "要件定義";
}else if(db.getResult("topic_sub_id").equals("1")){
subid = "基本設計";
}else if(db.getResult("topic_sub_id").equals("2")){
subid = "概要設計";
}else if(db.getResult("topic_sub_id").equals("3")){
subid = "詳細設計";
}else if(db.getResult("topic_sub_id").equals("4")){
subid = "製造";
}else if(db.getResult("topic_sub_id").equals("5")){
subid = "単体試験";
}else if(db.getResult("topic_sub_id").equals("6")){
subid = "結合試験";
}else if(db.getResult("topic_sub_id").equals("7")){
subid = "安定化試験";
}else if(db.getResult("topic_sub_id").equals("8")){
subid = "維持管理";
}else {
subid = "その他";
}

topic_name = db.getResult("topic_name");
searchDB.getQuery("select kind from " + ClassDefine.topic_kind + " where kind_id = " + db.getResult("kind_id") + ";");
if(searchDB.getNext()){
kind = searchDB.getResult("kind");
}
/*** 状態 ***/
searchDB.getQuery("select topic_state from topic_state where state_id = " + db.getResult("state_id") + ";");
if(searchDB.getNext()){
state = searchDB.getResult("topic_state");
}
if(!db.getResult("plan_topic_date").equals("1111-11-11")){
plan_topic_date = db.getResult("plan_topic_date");
}
else {
plan_topic_date = "";
}
if(!db.getResult("plan_limit_date").equals("1111-11-11")){
plan_limit_date = db.getResult("plan_limit_date");
}
else {
plan_limit_date = "";
}
if(!db.getResult("topic_date").equals("1111-11-11")){
topic_date = db.getResult("topic_date");
}
else {
topic_date = "";
}
if(!db.getResult("time_limit").equals("1111-11-11")){
limit_date = db.getResult("time_limit");
}
else {
limit_date = "";
}
searchDB.getQuery("select user_name from " + ClassDefine.user_info + " where user_id = '" + db.getResult("user_id") + "';");
if(searchDB.getNext()){
user_id = searchDB.getResult("user_name");
}
delete_flg = db.getResult("topic_delete");

/*** 2008/06/17 掲示板最新状況取得 start ***/

dataList = readData(ClassDefine.bbs_dir + "htbbsf" + id + ".log", null);
size = dataList.size();
if(size > 0){
biko="";
for(i = 0;i < size;i++){
data = (Hashtable)dataList.get(i);
biko = biko.concat("【" + (String)data.get("date") + " " + (String)data.get("name") +"】\n");
biko = biko.concat((String)data.get("comment") + "\n");
biko = convert.convertCsv(biko);
}
}
else {
biko = "";
}
/*** 2008/06/17 掲示板最新状況取得 end ***/

writeFile.writeString("\"" + id + "\",\"" + topic_name + "\",\"" + subid + "\",\"" + kind + "\",\"" + state + "\",\"" + plan_topic_date + "\",\"" + plan_limit_date + "\",\"" + topic_date + "\",\"" + limit_date + "\",\"" + user_id + "\",\"" + delete_flg + "\",\"" + biko + "\"");
}
}
writeFile.writeClose();
db.closeDB();
searchDB.closeDB();
%>
<jsp:forward page="Master-Page-View.jsp" />

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