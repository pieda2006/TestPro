<%@
page import = "java.io.*"
import = "javax.servlet.*"
import = "javax.servlet.http.*"
import = "java.util.*"
pageEncoding="shift-jis"
contentType = "text/html; charset = shift-jis"
%>
<%

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

/*** �󂫃i���o�[�𒲂ׂ� ***/
DB_Num number = new DB_Num();
/*** �e�[�u���̕ύX ***/
number.set_Table(ClassDefine.query);

/*** �t�H�[�����瑗�M����Ă����f�[�^���󂯎��ySTART�z ***/

/*** �����Ă����f�[�^���󂯎�� ***/
ServletInputStream in = request.getInputStream();
/*** �󂯎��o�C�g�f�[�^���i�[����ϐ� ***/
byte buffer[]  = new byte[4096];
/*** �󂯎�����o�C�g�f�[�^��ۑ�����ϐ� ***/
int size = 0;
/*** �󂫃i���o�[�̎擾 ***/
number.numGet();
/*** �󂫃i���o�[ ***/
int e_no = 0;
for(i=0;i<max_Number;i++){
if(number.numBool(i)){
e_no = i;
break;
}
}
/*** �t�@�C���̗L�� ***/
int isFile = 0;
/*** ���� ***/
String operation = "";
/*** �ԍ� ***/
String no = "";
/*** ���� ***/
String query = "";
/*** �s�� ***/
int new_row = 0;
/*** �t�@�C���� ***/
String file = "";
/*** ���M�f�[�^ID��boundary�Ɋi�[�Aheader�ɂ̓o�C�g�f�[�^�𕶎���ɕϊ��������̂��i�[ ***/
String header,boundary="";
/*** ���̕�������󂯎������File�����M����Ă����Ɣ��f���� ***/
String image1 = "x-zip-compressed";
String image3 = "application/zip";
/*String image2 = "application/pdf";
String image4 = "text/plain";
String image5 = "application/vnd.ms-excel";*/
/*** �t�@�C���̃^�C�v ***/
String file_Type = "";
/*** �s�� ***/
String row = "";
/*** �^�O ***/
String tag = "";
/*** �V�[�N���b�g ***/
String sercret = "";
String check3 = "";
int backupNum = 0;

/*** �X�V�t���O ***/
boolean upflag = true;
/*** �ǂ̕������f�[�^�x�[�X�ɕۑ�����̂��𔻒肷�邽�߂̃J�E���^ ***/
int count = 0,count1 = 0;
/*** ��������󂯎�����f�[�^�̏������s���܂� ***/
/*** Boundary��ۑ� ***/
if((size=in.readLine(buffer,0,buffer.length)) != -1){
boundary = new String(buffer,0, size-2);
count1++;
}
while((size=in.readLine(buffer,0,buffer.length)) != -1){
header = new String(buffer,0, size);

//out.println("�ycount=" + count + "�z�ycount1=" + count1 + "�z<br>");
//out.println(header + "<br>");

/*** Boundary�������Ă�����J�E���^��1�v���X���� ***/
if(header.indexOf(boundary) != -1){
count++;
count1 = 0;
}
/*** �ԍ� ***/
if(count == 0 && count1 == 3){
no = header;
if(no.indexOf("-") != -1){
operation = "insert";
no = Integer.toString(e_no);
}
else {
operation = "update";
db.getQuery("select username from " + ClassDefine.query + " where no=" + no + ";");
db.getNext();
if(db.getResult("username").equals("dummy")){
db.exeQuery("update " + ClassDefine.query + " set username='" + user + "' where no=" + no + ";");
upflag = false;
break;
}
else if(!db.getResult("username").equals(user)){
upflag = false;
break;
}
}
}
/*** ���� ***/
else if(count == 1 && count1 == 3){
query = header;
while((size=in.readLine(buffer,0,buffer.length)) != -1){
header = new String(buffer,0, size);
if(header.indexOf(boundary) != -1) {
query = query.substring(0,query.length()-2);
count++;
count1 = 0;
break;
}
if(3 <= count1){
query = query.concat((new String(buffer,0,size,"Shift-Jis")));
new_row++;
}
count1++;
}
}
/*** �^�O ***/
else if(count == 2 && count1 == 3){
tag = header;
//tag = tag.substring(0,tag.length()-2);
}
/*** �V�[�N���b�g ***/
else if(count == 3 && count1 == 3){
sercret = header;
//tag = tag.substring(0,tag.length()-2);
}
/*** �t�@�C�� ***/
else if((header.indexOf(image1) != -1)/* || (header.indexOf(image2) != -1)*/ || (header.indexOf(image3) != -1)/* || (header.indexOf(image4) != -1) || (header.indexOf(image5) != -1)*/){
isFile = 1;
if(!check3.equals("")){
backupNum = Integer.parseInt(check3.trim());
if(backupNum > 100){
backupNum = 100;
}
}
if(backupNum > 0){
for(int backcount=backupNum-1; backcount>0; backcount--){
File delete_file = new File(ClassDefine.file_dir + no.trim() + ".zip.bak" + backcount);
if (delete_file.exists()){
delete_file.renameTo(new File(ClassDefine.file_dir + no.trim() + ".zip.bak" + (backcount+1)));
}
}
File delete_file = new File(ClassDefine.file_dir + no.trim() + ".zip");
if (delete_file.exists()){
delete_file.renameTo(new File(ClassDefine.file_dir + no.trim() + ".zip.bak1"));
}
}
if(header.indexOf(image1) != -1){
file_Type = ".zip";
}
else if(header.indexOf(image3) != -1){
file_Type = ".zip";
}
/*else if(header.indexOf(image4) != -1){
file_Type = ".txt";
}
else if(header.indexOf(image5) != -1){
file_Type = ".xls";
}
else {
file_Type = ".pdf";
}*/
/*** �o�C�g�f�[�^���i�[����o�b�t�@ ***/
ByteArrayOutputStream receivedBuffer = new ByteArrayOutputStream();
file = Integer.parseInt(no.trim()) + file_Type;
FileOutputStream fout = new FileOutputStream(ClassDefine.file_dir + file);
byte buf[] = null;
while((size=in.readLine(buffer,0,buffer.length)) != -1){
if(3 <= count1){
receivedBuffer.write(buffer,0,size);
buf = receivedBuffer.toByteArray();
fout.write(buf, 0, buf.length);
receivedBuffer.reset();
buf = null;
}
header = new String(buffer,0, size);
if(header.indexOf(boundary) != -1){
/*** �t�@�C���̍쐬 ***/
buf = receivedBuffer.toByteArray();
fout.write(buf, 0, buf.length/*-2*/);
fout.close();
count++;
count1 = 0;
}
count1++;
}
}
else if(count == 5 && count1 == 3){
if(header.indexOf("1") != -1){
operation = "delete";
}
}
else if(count == 4 && count1 == 3){
row = header;
}
else if(count == 6 && count1 == 3){
check3 = header;
}
count1++;
}
if(upflag){
/*** ���݂̓������擾 ***/
/*** ���t���V�X�e���ϐ�����擾����I�u�W�F�N�g�錾 ***/
GregorianCalendar cal = new GregorianCalendar();
String day = (cal.getTime()).toString();
if(row.substring(0,row.length()-2).equals("0")){
//new_row = 0;
new_row++;
if(!operation.equals("insert")){
user="dummy";
}
}
else {
new_row++;
}

if(operation.equals("insert")){
db.exeQuery("insert into " + ClassDefine.query + " values('" + day + "','" + user + "'," + new_row + "," + no + ",'" + query + "'," + tag + "," + sercret + ",1,'" + file + "');");

File delete_file = new File(ClassDefine.file_dir + "htbbsf" + no + ".log");
if (delete_file.exists()){
    delete_file.delete();
}
Htbbsf writebbs = new Htbbsf();
writebbs.writeHtbbsf(Integer.parseInt(no),ClassDefine.file_dir,"����",ClassDefine.file_htbbs_dir);
}
else if(operation.equals("update")){
if(isFile == 0){
db.exeQuery("update " + ClassDefine.query + " set username = '" + user + "',date = '" + day + "', text = '" + query + "', kubun = " + new_row + ", check1 =  " + tag + ", check2 =  " + sercret + ", check3 = " + check3 + "where no = " + no + ";");
}
else if(isFile == 1){
db.exeQuery("update " + ClassDefine.query + " set username = '" + user + "',date = '" + day + "', text = '" + query + "', file = '" + file + "', kubun = " + new_row + ", check1 =  " + tag + ", check2 =  " + sercret + ", check3 = " + check3 + "  where no = " + no + ";");
}
}
else if(operation.equals("delete")){
db.exeQuery("delete from " + ClassDefine.query + " where no =" + no + ";");
for(int backcount = 1;backcount<100;backcount++){
File delete_file = new File(ClassDefine.file_dir + no.trim() + ".zip.bak" + backcount);
if (delete_file.exists()){
delete_file.delete();
} else {
break;
}
}
}
}
db.closeDB();
%>
<jsp:forward page="Kubun_A_Browse.jsp" />