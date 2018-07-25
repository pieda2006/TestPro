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

DB_Operation directryDB = new DB_Operation();
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
Vector dataList = null;
/*** 2008/06/17 �f�����̃��X�̐� start ***/
int size = 0;
/*** 2008/06/17 �f�����̃��X�̐� end ***/

/*** 2008/06/17 �f�����̃n�b�V�� start ***/
Hashtable data = null;
/*** 2008/06/17 �f�����̃n�b�V�� end ***/
/*** 2008/06/17 CSV�p�ϊ��N���X���� start ***/
Escape_String convert = new Escape_String();
/*** 2008/06/17 CSV�p�ϊ��N���X���� end ***/

WriteCSV writeFile = new WriteCSV(ClassDefine.file_dir + user + "_file_list.csv");
String biko ="";
%>
<html>
<head>
<title>�t�@�C���ꗗ</title>
</head>
<body>
<center>
<a href="PDF_File/<%= user%>_file_list.csv"><font size=2 color="black">�t�@�C���ꗗ�_�E�����[�h</font></a>
<table border="2" cellspacing=0 bordercolor="#666666">
<tr><td align="center">ID</td>
<td align="center">�X�V��</td>
<td nowrap>�f�B���N�g��</td>
<td nowrap>�t�@�C����</td>
<td nowrap>�T�v</td>
</tr>
<%
writeFile.writeString("\"ID\",\"�X�V��\",\"�f�B���N�g��\",\"�t�@�C����\",\"�T�v\"");
db.getQuery("select * from " + ClassDefine.tag + " order by full_dir;");
while(db.getNext()){
directryDB.getQuery("select * from " + ClassDefine.query + " where check1=" + db.getResult("tag_id") + "order by text;");
while(directryDB.getNext()){
if(directryDB.getResult("check2").equals("0") || (directryDB.getResult("check2").equals("1") && directryDB.getResult("username").equals(user))){
%>
<tr>
<td align="center" nowrap><%= directryDB.getResult("no")%></td>
<td align="center" nowrap><%= directryDB.getResult("date")%></td>
<td nowrap><%= db.getResult("full_dir")%></td>
<td nowrap><%= directryDB.getResult("text")%></td>
<%
/*** 2008/06/17 �f���ŐV�󋵎擾 start ***/

dataList = readData(ClassDefine.file_dir + "htbbsf" + directryDB.getResult("no") + ".log", null);
size = dataList.size();
if(size > 0){
biko="";
/*for(i = 0;i < size;i++){*/
data = (Hashtable)dataList.get(0);
biko = biko.concat("�y" + (String)data.get("date") + " " + (String)data.get("name") +"�z\n");
biko = biko.concat((String)data.get("comment") + "\n");
/*}*/
}
else {
biko = "<br>";
}
/*** 2008/06/17 �f���ŐV�󋵎擾 end ***/
%>
<td><%= biko%></td></tr>
<%
biko = convert.convertCsv(biko);
writeFile.writeString("\"" + directryDB.getResult("no") + "\",\"" +directryDB.getResult("date") + "\",\"" + db.getResult("full_dir") + "\",\"" + directryDB.getResult("text") + "\",\"" + biko + "\"");
}
}
}
%>
</table>
<center>
</body>
</html>
<%
writeFile.writeClose();
db.closeDB();
directryDB.closeDB();
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