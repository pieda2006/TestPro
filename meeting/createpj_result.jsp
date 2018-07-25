<%@
page import = "java.io.*"
import = "javax.servlet.*"
import = "javax.servlet.http.*"
import = "java.util.*"
import = "java.text.*"
import = "java.nio.channels.FileChannel"

pageEncoding="shift-jis"
contentType = "text/html; charset = shift-jis"
%>

<html>
<head>
<title>プロジェクト追加結果</title>
</head>
<body>
<%
DB_Operation db = new DB_Operation();
String pj_name = request.getParameter("pj_name");
String src_dir = "/usr/share/tomcat/webapps/meeting/master";
String dst_dir = "/usr/share/tomcat/webapps/meeting/" + pj_name;
File file = new File(dst_dir);
file.mkdirs();
copyFiles(src_dir, dst_dir);

ClassDefine ClassDefine = new ClassDefine();
ClassDefine.topic_info = ClassDefine.topic_info + "_" + pj_name;
ClassDefine.next_id = ClassDefine.next_id + "_" + pj_name;
ClassDefine.user_info = ClassDefine.user_info + "_" + pj_name;
ClassDefine.topic_kind = ClassDefine.topic_kind + "_" + pj_name;
ClassDefine.topic_state = ClassDefine.topic_state + "_" + pj_name;
ClassDefine.lock_table = ClassDefine.lock_table + "_" + pj_name;
ClassDefine.topic_plan = ClassDefine.topic_plan + "_" + pj_name;
ClassDefine.topic_report = ClassDefine.topic_report + "_" + pj_name;
ClassDefine.query = ClassDefine.query + "_" + pj_name;
ClassDefine.userpass = ClassDefine.userpass + "_" + pj_name;
ClassDefine.tag = ClassDefine.tag + "_" + pj_name;

db.exeQuery("create table " + ClassDefine.topic_info + "(topic_id int primary key,topic_sub_id int,topic_name text,kind_id int,time_limit date,state_id int,topic_date date,user_id text,topic_delete int,plan_topic_date date,plan_limit_date date,shinchoku int, kouban text, shinchoku2 int);");
db.exeQuery("create table " + ClassDefine.next_id + "(topic_id int primary key,message_id int,kind_id int);");
db.exeQuery("insert into " + ClassDefine.next_id + " values(0,0,0);");
db.exeQuery("create table " + ClassDefine.user_info + "(user_id text primary key,user_name text,user_pass text,master_auth int);");
db.exeQuery("insert into " + ClassDefine.user_info + " values('-','-','-',0);");
db.exeQuery("create table " + ClassDefine.topic_kind + "(kind_id int primary key,kind text);");
db.exeQuery("create table " + ClassDefine.topic_state + "(state_id int primary key,topic_state text);");
db.exeQuery("insert into " + ClassDefine.topic_state + " values(0,'未着手');");
db.exeQuery("insert into " + ClassDefine.topic_state + " values(1,'継続');");
db.exeQuery("insert into " + ClassDefine.topic_state + " values(2,'完了');");
db.exeQuery("insert into " + ClassDefine.topic_state + " values(3,'作業中');");
db.exeQuery("insert into " + ClassDefine.topic_state + " values(4,'新規');");
db.exeQuery("create table " + ClassDefine.lock_table + "(lock_id int primary key,lock_user text);");
db.exeQuery("insert into " + ClassDefine.lock_table + " values(0,'dummy');");
db.exeQuery("insert into " + ClassDefine.lock_table + " values(1,'dummy');");
db.exeQuery("insert into " + ClassDefine.lock_table + " values(2,'dummy');");
db.exeQuery("insert into " + ClassDefine.lock_table + " values(3,'dummy');");
db.exeQuery("create table " + ClassDefine.topic_report + "(date timestamp,complete_date timestamp,id int,user_name text,biko text,shinchoku int);");
db.exeQuery("create index index_" + pj_name +  "_1 on " + ClassDefine.topic_report + "(id);");
db.exeQuery("create table " + ClassDefine.topic_plan + "(date timestamp,complete_date timestamp,id int,user_name text,biko text,shinchoku int);");
db.exeQuery("create index index_" + pj_name + "_2 on " + ClassDefine.topic_plan + "(id);");
db.exeQuery("create table " + ClassDefine.query + "(date timestamp,username text,kubun int,no int,text text,check1 int,check2 int,check3 int,file text);");
db.exeQuery("create table " + ClassDefine.userpass + "(username text primary key,userpass text,name text,kubun int);");
db.exeQuery("insert into " + ClassDefine.userpass + " values('-','-','-',0);");
db.exeQuery("create table " + ClassDefine.tag + "(tag_id int primary key,tag text,parent_id int,full_dir text);");

db.closeDB();
%>

作成確認：<a href=<%= pj_name%>><font size=2 color="black"><%= pj_name%></font></a>

</body>
</html>

<%!
private int copyFiles(String srcDir, String dstDir) throws IOException {
  int result = 0;
  File file = new File(srcDir);
  for (File eachFile : file.listFiles()) { 
    if (eachFile.isFile()) { 
      copyTransfer(eachFile.getAbsolutePath(), dstDir + "/" + eachFile.getName()); 
      result += 1; 
    } else {
	  File newDir = new File(dstDir+"/"+eachFile.getName());
      if(newDir.mkdirs()){ 
        copyFiles(eachFile.toString(),dstDir+"/"+eachFile.getName()); 
        result += 1; 
      }else{ 
        System.out.println(eachFile+"作成に失敗しました。"); 
      }
    }
  }
  return result; 
}

private static void copyTransfer(String srcPath, String destPath) throws IOException {
  FileChannel srcChannel = new FileInputStream(srcPath).getChannel(); 
  FileChannel destChannel = new FileOutputStream(destPath).getChannel();
  try {
    srcChannel.transferTo(0, srcChannel.size(), destChannel);
  } finally {
    srcChannel.close(); 
    destChannel.close(); 
  }
}
%>
