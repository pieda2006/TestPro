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

/*** �p�X���[�h�F��(END) ***/

/*** ID ***/
String id = null;
/*** SubID ***/
String subid = null;
/*** �g�s�b�N�� ***/
String topic_name = null;
/*** ��� ***/
String kind = null;
/*** ��� ***/
String state = null;
/*** ����\��� ***/
String plan_topic_date = null;
/*** �����\��� ***/
String plan_limit_date = null;
/*** �J�n�� ***/
String topic_date = null;
/*** ������ ***/
String limit_date = null;
/*** �S���� ***/
String user_id = null;
/*** �폜�t���O ***/
String delete_flg = null;
/*** 2008/06/17 ���l start ***/
String biko = null;
/*** 2008/06/17 ���l end ***/
int topic_count = 0;
int i = 0;
/*** 2008/06/17 �f�����i�[�p�ϐ� start ***/
Vector dataList = null;
/*** 2008/06/17 �f�����i�[�p�ϐ� end ***/

/*** 2008/06/17 �f�����̃��X�̐� start ***/
int size = 0;
/*** 2008/06/17 �f�����̃��X�̐� end ***/

/*** 2008/06/17 �f�����̃n�b�V�� start ***/
Hashtable data = null;
/*** 2008/06/17 �f�����̃n�b�V�� end ***/

/*** ���[�U�E��ʁE��ԁE�S���Ҍ����pdb�C���X�^���X���� ***/
DB_Operation searchDB = new DB_Operation();

/*** 2008/06/17 CSV�p�ϊ��N���X���� start ***/
Escape_String convert = new Escape_String();
/*** 2008/06/17 CSV�p�ϊ��N���X���� end ***/

/*** �t�@�C���f���o���p�C���X�^���X���� ***/
WriteCSV writeFile = new WriteCSV(ClassDefine.file_dir + user + ".csv");

//SQL�����i�[����ϐ�
String sql = "select * from " + ClassDefine.topic_info + " order by kind_id,plan_limit_date desc;";
/*** �������� ***/
db.getQuery(sql);
i = 0;
/*** �t�@�C���o�� ***/
writeFile.writeString("\"ID\",\"�g�s�b�N��\",\"�H��\",\"���\",\"���\",\"�J�n�\���\",\"�����\���\",\"�ŏI�X�V��\",\"������\",\"�S����\",\"�폜�t���O\",\"���l\"");

String search_word_1 = null;
String search_word_2 = null;
String search_word_3 = null;
String search_word_4 = null;
String topic_user = null;
String topic_kind_m = null;
String topic_state = null;
String topic_sure = null;

/*** ������ ***/
search_word_1 = (String)session.getAttribute("search_word_1");//������1
search_word_2 = (String)session.getAttribute("search_word_2");//������2
search_word_3 = (String)session.getAttribute("search_word_3");//������3
search_word_4 = (String)session.getAttribute("search_word_4");//������3
topic_user = (String)session.getAttribute("topic_user");//���[�U��
topic_kind_m = (String)session.getAttribute("topic_kind_m");//���
topic_state = (String)session.getAttribute("topic_state");//���
topic_sure = (String)session.getAttribute("topic_sure");//�\���͈�

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
subid = "�v����`";
}else if(db.getResult("topic_sub_id").equals("1")){
subid = "��{�݌v";
}else if(db.getResult("topic_sub_id").equals("2")){
subid = "�T�v�݌v";
}else if(db.getResult("topic_sub_id").equals("3")){
subid = "�ڍא݌v";
}else if(db.getResult("topic_sub_id").equals("4")){
subid = "����";
}else if(db.getResult("topic_sub_id").equals("5")){
subid = "�P�̎���";
}else if(db.getResult("topic_sub_id").equals("6")){
subid = "��������";
}else if(db.getResult("topic_sub_id").equals("7")){
subid = "���艻����";
}else if(db.getResult("topic_sub_id").equals("8")){
subid = "�ێ��Ǘ�";
}else {
subid = "���̑�";
}

topic_name = db.getResult("topic_name");
searchDB.getQuery("select kind from " + ClassDefine.topic_kind + " where kind_id = " + db.getResult("kind_id") + ";");
if(searchDB.getNext()){
kind = searchDB.getResult("kind");
}
/*** ��� ***/
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

/*** 2008/06/17 �f���ŐV�󋵎擾 start ***/

dataList = readData(ClassDefine.bbs_dir + "htbbsf" + id + ".log", null);
size = dataList.size();
if(size > 0){
biko="";
for(i = 0;i < size;i++){
data = (Hashtable)dataList.get(i);
biko = biko.concat("�y" + (String)data.get("date") + " " + (String)data.get("name") +"�z\n");
biko = biko.concat((String)data.get("comment") + "\n");
biko = convert.convertCsv(biko);
}
}
else {
biko = "";
}
/*** 2008/06/17 �f���ŐV�󋵎擾 end ***/

writeFile.writeString("\"" + id + "\",\"" + topic_name + "\",\"" + subid + "\",\"" + kind + "\",\"" + state + "\",\"" + plan_topic_date + "\",\"" + plan_limit_date + "\",\"" + topic_date + "\",\"" + limit_date + "\",\"" + user_id + "\",\"" + delete_flg + "\",\"" + biko + "\"");
}
}
writeFile.writeClose();
db.closeDB();
searchDB.closeDB();
%>
<jsp:forward page="Master-Page-View.jsp" />

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