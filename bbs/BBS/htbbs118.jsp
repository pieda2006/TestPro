<%
/**
 * Hello JSP BBS F ver 1.0
 * Copyright(C) Hirokazu Tanaka 2002-2003 All rights reserved.
 * E-MAIL : hiro@hellohiro.com
 * WWW : http://www.hellohiro.com/
 *
 * [�K�{���C�u����]
 * �uHello �t�@�C���A�b�v���[�h���C�u�����v���K�v�ɂȂ�܂��BWEB-INF/lib�t�H���_��
 * �ufileupload.jar�v�t�@�C����u���Ă��������B
 *
 */
%>
<%@ page contentType="text/html; charset=shift-jis" %>
<%@ page import="java.awt.*,java.util.*,java.io.*,java.net.*,java.text.*,com.hellohiro.servlet.upload.*,javax.servlet.http.*" %>
<%
/***************
*** ��{�ݒ�n **
****************/

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
%>
<%!
private static final String BG_COLOR       = "#DEF1FA"; // �w�i�F
private static final String TEXT_COLOR     = "#467AE6"; // �e�L�X�g�̐F
private static final String SUBJECT_COLOR  = "#467AE6"; // �L���̑薼�̐F
private static final String TEXT_POINT     = "10pt"; // �{���̕����̃T�C�Y
private static final String TEXT_HIGHT     = "12pt"; // �{���̕����̍���

private static final String LINK_COLOR     = "#3333DD"; // �����N
private static final String VLINK_COLOR    = "#DD3333"; // �K��ς݃����N
private static final String HLINK_COLOR    = "#FF0000"; // �}�E�X�z�[�o�[�����N
private static final String ALINK_COLOR    = "#FF0000"; // �A�N�e�B�u�����N

private static final boolean USE_IMG       = false; // �^�C�g���ɉ摜���g���Ftrue�@�g��Ȃ��Ffalse
private static final String IMG_PATH       = "./title.gif"; // �^�C�g���ɉ摜���g���ꍇ�̉摜�̃p�X
private static final String TITLE          = "118"; // �^�C�g��
private static final String TITLE_COLOR    = "#467AE6"; // �^�C�g���̕����̐F
private static final String TITLE_POINT    = "20pt"; // �^�C�g���̕����̃T�C�Y

private static final String HOME_URL       = "../Master-Page.jsp"; // �߂���URL
private static final String LOG_FILE       = "htbbsf118.log"; // ���O�t�@�C����
private static final String COUNT_FILE     = "count118.dat"; // �L���ԍ��ۑ��t�@�C��
private static final boolean PAST_LOG      = true; // �ߋ����O�@�\�Ftrue�@���� :false �Ȃ�
private static final String PAST_DIR       = "past118"; // �ߋ����O��ۑ�����t�H���_��
private static final String PAST_COUNT     = "pastcount118.dat"; // �ߋ����O�J�E���g�t�@�C����
private static final int MAX_PAST_LINE     = 200; // �ߋ����O��1�t�@�C��������̍ő�s��
private static final int MAX               = 50; // �ő�e�L���ێ���
private static final int PAGE_MAX          = 10; // �P�y�[�W����̍ő�\���e�L����
private static final String ADMIN_PASSWD   = "apple"; // �Ǘ��҃p�X���[�h
private static final boolean URL_AUTO_LINK = true; // URL�̎��������N������Ftrue ���Ȃ��Ffalse
private static final boolean NORMAL_RES    = true; // �ʏ�̕ԐM�@�\���g���Ftrue �g��Ȃ�:false
private static final boolean TOP_SORT      = true; // �ʏ�̕ԐM�����Ɛe�L������ԏ�ֈړ�����Ftrue ���Ȃ��Ffalse

private static final boolean TOMCAT3       = false; // Tomcat 3�@�ŕ�����������ꍇtrue�ɐݒ�

private static final boolean SEND_MAIL     = false; // �Ǘ��҂Ƀ��[���𑗐M����ꍇtrue�ɐݒ�
// �Ǘ��҃��[���A�h���X(���[���𑗐M����ꍇ)
private static final String ADMIN_MAIL     = "xxx@xxx.xxx";
// sendmail�p�X(���[���𑗐M����ꍇ)
private static final String SENDMAIL_PATH  = "/usr/sbin/sendmail";

private static final int SUB_MAX_LEN       = 15; // �薼�̒���(����ȏゾ�Əȗ�����܂�)

// �t�@�C���A�b�v���[�h�֘A�̐ݒ�
private static final String FILE_DIR       = "118"; // �A�b�v���[�h�����t�@�C����ۑ�����t�H���_
private static final int MAX_POST_SIZE     = 200000000; // ���M����f�[�^�̍ő�T�C�Y(�o�C�g)


// �J���[���X�g�ƃJ���[�����X�g�͑Ή�����悤�ɐݒ肵�Ă�������
// �J���[���X�g
private static final String[] COLOR_LIST = { "000000" ,
                                             "800000" ,
                                             "DF0000" ,
                                             "008040" ,
                                             "0000FF" ,
                                             "C100C1" ,
                                             "FF80C0" ,
                                             "FF8040" ,
                                             "000080" };
// �J���[�����X�g
private static final String[] COLOR_NAME_LIST = { "��" ,
                                                  "��" ,
                                                  "��" ,
                                                  "�݂ǂ�" ,
                                                  "��" ,
                                                  "��" ,
                                                  "�s���N" ,
                                                  "�I�����W" ,
                                                  "�����F" };


// �A�b�v���[�h��������g���q
private static final String[] EXTENSION_LIST = { "gif",
                                                 "jpg",
                                                 "jpeg",
                                                 "png",
                                                 "bmp",
                                                 "pdf",
                                                 "mid",
                                                 "mp3",
                                                 "wav",
                                                 "mpg",
                                                 "avi",
                                                 "ram",
                                                 "rm",
                                                 "zip",
                                                 "lzh",
                                                 "txt",
                                                 "java",
                                                 "doc",
                                                 "xls"};

// JSP�t�@�C��������f�B���N�g���̃p�X���擾�ł����ɁA
// �t�@�C���̏������݂��ł��Ȃ��ꍇ�Ɏw�肵�Ă��������B
private static final String JSP_BASE_DIR   = ""; // JSP�t�@�C��������f�B���N�g�̃p�X(��j"/home/tomcat/webapps/bbs/"
/***************
*** ��{�ݒ�I **
****************/

/** ���������͕ύX���Ȃ��ł������� **/
// �o�[�W����
private static final String VERSION = "1.0";
// ���[�h�萔
private static final String MODE_NORMAL   = "normal"; // �ʏ�
private static final String MODE_REGIST   = "regist"; // �o�^
private static final String MODE_USER_DEL = "userdel"; // �L���폜
private static final String MODE_HOW_TO   = "howto"; // �g����
private static final String MODE_PAST     = "past"; // �ߋ����O
private static final String MODE_LOG      = "log"; // �ߋ����O�\��
private static final String MODE_SEARCH   = "search"; // �ߋ����O����
private static final String MODE_ADMIN    = "admin"; // �Ǘ��p
private static final String MODE_RES_MSG  = "resmsg"; // �ԐM
// �N�b�L�[�𔭍s���郊�X�g
private static final String[] COOKIE_NAMES = { "name" ,
                                               "email" ,
                                               "url" ,
                                               "passwd" ,
                                               "color" };

// ���t�̃t�H�[�}�b�g�`��
private static final String DATE_PATTERN = "yyyy/MM/dd(EEE) HH:mm:ss";
// ���O���b�N
private Object lock  = new Object();
// �ߋ����O���b�N
private Object plock = new Object();
%>
<%
// �p�X�֘A
String requestUri = request.getRequestURI();
String contextPath = request.getContextPath();
if (requestUri.indexOf(contextPath)==0) {
  requestUri = requestUri.substring(contextPath.length() + 1);
}

String JSP_PATH = ClassDefine.bbs_htbbs_dir + FILE_DIR +".jsp";
String JSP_FILE = JSP_PATH.substring(JSP_PATH.lastIndexOf(File.separator) + 1, JSP_PATH.length());
String BASE_PATH = JSP_PATH.substring(0 , JSP_PATH.lastIndexOf(File.separator) + 1);
if (!JSP_BASE_DIR.equals("")) {
  if (!JSP_BASE_DIR.substring(JSP_BASE_DIR.length()-1).equals(File.separator)) {
    BASE_PATH = JSP_BASE_DIR + File.separator;
  } else {
    BASE_PATH = JSP_BASE_DIR;
  }
}
String LOG_PATH = BASE_PATH + LOG_FILE;
String COUNT_PATH = BASE_PATH + COUNT_FILE;
String PAST_COUNT_PATH = BASE_PATH + PAST_COUNT;
String PAST_DIR_PATH = BASE_PATH + PAST_DIR;
String FILE_DIR_PATH = BASE_PATH + FILE_DIR;

File uploadFile = null;
int start,end;
Hashtable params = new Hashtable();

// MIME�^�C�v���擾
String contentType = request.getContentType();
if (contentType!=null) {
  contentType = contentType.toLowerCase();
}

if (contentType!=null && contentType.startsWith("multipart/form-data")) { // �}���`�p�[�g�̏ꍇ
  // �}���`�p�[�g�p���N�G�X�g�擾
  FileUploadRequest uploadRequest;
  try {
    uploadRequest = new FileUploadRequest(request ,FILE_DIR_PATH,MAX_POST_SIZE);
  } catch (ExceededLimitException e) {
    showErrorHTML(out,"�A�b�v���[�h�ł���ő�e�ʂ𒴂��Ă��܂�",JSP_FILE);
    return;
  } catch (FileSizeZeroException e) {
    showErrorHTML(out,"�A�b�v���[�h����t�@�C���̃T�C�Y��0�ł�",JSP_FILE);
    return;
  } catch (Exception e) {
    showErrorHTML(out,"�A�b�v���[�h���ɃG���[���������܂���",JSP_FILE);
    e.printStackTrace();
    return;
  }
  // �t�@�C���֘A
  uploadFile = uploadRequest.getFile("uploadfile");
  if (uploadFile!=null) {
    String extension = uploadRequest.getFileExtension("uploadfile");
    if (extension==null) {
      uploadFile.delete();
      showErrorHTML(out,"�A�b�v���[�h����t�@�C���̊g���q������܂���",JSP_FILE);
      return;
    }
    extension = extension.toLowerCase();
    if (!fileExtensionCheck(extension)) {
      uploadFile.delete();
      showErrorHTML(out,"�g���q���u" + extension + "�v�̃t�@�C���̓A�b�v���[�h�ł��܂���",JSP_FILE);
      return;
    }

    params.put("originalfilename" , uploadRequest.getOriginalFileName("uploadfile"));
    params.put("filesystemname" , uploadRequest.getFilesystemName("uploadfile"));
    params.put("filesystempath" , uploadFile.getPath());
    params.put("fileextension" , uploadRequest.getFileExtension("uploadfile"));
    params.put("filecontenttype" , uploadRequest.getFileContentType("uploadfile"));
  }

  // �y�[�W�؂�ւ��֘A
  String strStart = uploadRequest.getParameter("start");
  if (strStart==null) {
    strStart = "1";
  }
  try {
    start = Integer.parseInt(strStart);
    if (start<1 || start > MAX) {
      showErrorHTML(out,"�p�����[�^���s���ł�",JSP_FILE);
      return;
    }
    end = start + PAGE_MAX -1;
  } catch (Exception e) {
      showErrorHTML(out,e.toString(),JSP_FILE);
      return;
  }
  // �p�����[�^�[���擾
  Enumeration paramNames = uploadRequest.getParameterNames();
  while (paramNames.hasMoreElements()) {
    String paramName = (String)paramNames.nextElement();
    if (paramName.equals("del")) {
      String[] del = uploadRequest.getParameterValues("del");
      params.put("del" , del);
    } else {
      params.put(paramName,uploadRequest.getParameter(paramName));
    }
  }

} else { // �}���`�p�[�g�łȂ��ꍇ
  // �y�[�W�؂�ւ��֘A
  String strStart = request.getParameter("start");
  if (strStart==null) {
    strStart = "1";
  }
  try {
    start = Integer.parseInt(strStart);
    if (start<1 || start > MAX) {
      showErrorHTML(out,"�p�����[�^���s���ł�",JSP_FILE);
      return;
    }
    end = start + PAGE_MAX -1;
  } catch (Exception e) {
      showErrorHTML(out,e.toString(),JSP_FILE);
      return;
  }
  // �p�����[�^�[���擾
  Enumeration paramNames = request.getParameterNames();
  while (paramNames.hasMoreElements()) {
    String paramName = (String)paramNames.nextElement();
    if (paramName.equals("del")) {
      String[] del = request.getParameterValues("del");
      params.put("del" , del);
    } else {
      params.put(paramName,toSJIS(request.getParameter(paramName)));
    }
  }
}

// ���݂̓��t��ݒ�
SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN,Locale.US);
params.put("date" , sdf.format(new Date()));
// �z�X�g����ݒ�
String host = request.getRemoteHost();
if (host==null) {
  host = "�s��";
}
params.put("host" , host);
// �u���E�U�����擾
String userAgent = request.getHeader("User-Agent");
params.put("user-agent" , userAgent);

// ���[�h���擾
String mode = (String)params.get("mode");
if (mode==null) {
  mode = MODE_NORMAL;
}
boolean showdata = false;
boolean showhowto = false;
boolean showlogin = false;
boolean showadmin = false;
boolean showpast = false;
boolean showlog = false;
boolean showsearch = false;
String msg = null;
Hashtable mailData = new Hashtable();
if (mode.equals(MODE_NORMAL)) { /** �ʏ�\�� **/
  showdata = true;
} else if (mode.equals(MODE_HOW_TO)) { /** �g���� **/
  showhowto = true;
} else if (mode.equals(MODE_ADMIN)) { /** �Ǘ��p **/
  if (params.get("passwd")==null) {
    showlogin = true;
  } else {
    // HTTP���\�b�h�̃`�F�b�N
    if (!request.getMethod().equalsIgnoreCase("POST")) {
      showErrorHTML(out,"�s���ȃA�N�Z�X�ł�",JSP_FILE);
      return;
    }
    if (((String)params.get("passwd")).equals(ADMIN_PASSWD)) {
      if (params.get("del")!=null) {
        // �f�[�^�̍폜
        msg = registData(mode , params , mailData , COUNT_PATH , LOG_PATH , PAST_COUNT_PATH ,PAST_DIR_PATH);
        if (msg!=null) {
          showErrorHTML(out,msg,JSP_FILE);
          return;
        }
      }
      showadmin = true;
    } else {
      msg = "�p�X���[�h���Ԉ���Ă��܂�";
      showlogin = true;
    }
  }

} else if (mode.equals(MODE_REGIST)) { /** �o�^ **/
  // HTTP���\�b�h�̃`�F�b�N
  if (!request.getMethod().equalsIgnoreCase("POST")) {
    showErrorHTML(out,"�s���ȃA�N�Z�X�ł�",JSP_FILE);
    if (uploadFile!=null) {
      uploadFile.delete();
    }
    return;
  }
  // �p�����[�^�[�̃`�F�b�N
  msg = paramCheck(mode , params , mailData);
  if (msg!=null) {
    showErrorHTML(out,msg,JSP_FILE);
    if (uploadFile!=null) {
      uploadFile.delete();
    }
    return;
  }
  // �f�[�^�̓o�^
  msg = registData(mode , params , mailData , COUNT_PATH , LOG_PATH , PAST_COUNT_PATH ,PAST_DIR_PATH);
  if (msg!=null) {
    showErrorHTML(out,msg,JSP_FILE);
    if (uploadFile!=null) {
      uploadFile.delete();
    }
    return;
  }
  // �N�b�L�[�𔭍s
  if (params.get("cookie")!=null) {
    addCookie(COOKIE_NAMES , params , response , Integer.MAX_VALUE);
  } else {
    addCookie(COOKIE_NAMES , params , response , 0);
  }
  showdata = true;

} else if (mode.equals(MODE_USER_DEL)) { /** �L���폜 **/
  // HTTP���\�b�h�̃`�F�b�N
  if (!request.getMethod().equalsIgnoreCase("POST")) {
    showErrorHTML(out,"�s���ȃA�N�Z�X�ł�",JSP_FILE);
    return;
  }
  // �p�����[�^�[�̃`�F�b�N
  msg = paramCheck(mode , params , mailData);
  if (msg!=null) {
    showErrorHTML(out,msg,JSP_FILE);
    return;
  }
  // �f�[�^�̍폜
  msg = registData(mode , params , mailData , COUNT_PATH , LOG_PATH , PAST_COUNT_PATH ,PAST_DIR_PATH);
  if (msg!=null) {
    showErrorHTML(out,msg,JSP_FILE);
    return;
  }
  showdata = true;
} else if (mode.equals(MODE_RES_MSG)) { // �ԐM
  if (params.get("no") == null) {
    showErrorHTML(out,"�s���ȃA�N�Z�X�ł�",JSP_FILE);
    return;
  }
  showdata = true;
} else if (mode.equals(MODE_PAST)) { // �ߋ����O
  showpast = true;
} else if (mode.equals(MODE_SEARCH)) { // �ߋ����O����
  showsearch = true;
} else if (mode.equals(MODE_LOG)) { // �ߋ����O�\��
  showlog = true;
}

/** �f�[�^�\�� **/
if (showdata) {
  // �N�b�L�[�̎擾
  Hashtable cookieTable = getCookie(COOKIE_NAMES , params , request);
  cookieTable.put("subject" , "");
  // �J���[�I��
  Hashtable colorHTML = new Hashtable();
  colorCheck(colorHTML , (String)cookieTable.get("color"));

  String btncap = "Send";
  // �f�[�^�̎擾
  Vector dataList;
  if (mode.equals(MODE_RES_MSG)) { // �ԐM
    dataList = readData(LOG_PATH , (String)params.get("no"));
    if (dataList==null) {
      showErrorHTML(out,"���̋L���͊��ɍ폜����Ă��܂�",JSP_FILE);
      return;
    }
    cookieTable.put("subject" , "Re:" + (String)((Hashtable)dataList.get(0)).get("subject"));
    btncap = "Send";
  } else { // �ʏ�
    dataList = readData(LOG_PATH , null);
  }
  int size = dataList.size();

  // �^�C�g��
  String title = "<font color=\"" + TITLE_COLOR + "\"><b style=\"font-size:" + TITLE_POINT + "\">" + TITLE + "</b></font>";
  if (USE_IMG) {
    title = "<img src=\"" + IMG_PATH + "\" border=\"0\">";
  }
%>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=shift-jis">
<title><%=TITLE%></title>
<style type="text/css">
<!--
body,tr,td,th { font-size:<%=TEXT_POINT%>;line-height: <%=TEXT_HIGHT%>; }
small { font-size:9pt; color:<%=TEXT_COLOR%> }
a:link {
  text-decoration: underline; font-weight: normal; color: <%=LINK_COLOR%>
}
a:visited {
  text-decoration: underline; font-weight: normal; color: <%=VLINK_COLOR%>
}
a:hover {
  text-decoration: underline; font-weight: normal; color: <%=HLINK_COLOR%>
}
a:active {
  text-decoration: underline; font-weight: normal; color: <%=ALINK_COLOR%>
}
-->
</style>
</head>
<body bgcolor="<%=BG_COLOR%>" text="<%=TEXT_COLOR%>" link="<%=LINK_COLOR%>" vlink="<%=VLINK_COLOR%>" alink="<%=ALINK_COLOR%>">
<div align="center"><font size=5 color="blue"><%=title%>
  <hr noshade size="1">
</div>
<%
  if (mode.equals(MODE_RES_MSG)) {
%>
  <br>
[<a href="<%=JSP_FILE%>">�f���ɖ߂�</a> ]
<table width="100%" cellspacing="0" cellpadding="3" border="0" bgcolor="#666666">
    <tr>
      <td align="center"><font color="#FFFFFF"><b>�ԐM</b></font></td>
    </tr>
  </table>
<table width="100%" border="0" cellspacing="0" cellpadding="5">
  <tr>
    <td>
<%
    for (int i=0;i<size;i++) {
      Hashtable data = (Hashtable)dataList.get(i);
      String no = (String)data.get("no");
      String pno = (String)data.get("pno");
      if (!no.equals(pno)) {
        out.println("<blockquote>");
      }
      // �薼�̒���
      String subject = omitString((String)data.get("subject"),SUB_MAX_LEN);
%>
      <hr size="1" noshade>
      [<%=(String)data.get("no")%>] <font color="<%=SUBJECT_COLOR%>"><b><%=subject%></b></font> ���e�ҁF<%=(String)data.get("name")%>
      <small>���e���F<%=(String)data.get("date")%></small><br>
      <blockquote>
        <font color="#<%=(String)data.get("color")%>">
        <%=(String)data.get("comment")%>
        </font>
        <% if (data.get("filesystemname")!=null)  { %>
		<br><br><b>�Y�t�t�@�C���F</b><a href="<%=FILE_DIR + "/" + (String)data.get("filesystemname")%>" target='_blank'><%=(String)data.get("originalfilename")%></a>
        <% } %>
        <%=(String)data.get("url")%>
      </blockquote>
<%
      if (!no.equals(pno)) {
        out.println("</blockquote>");
      }
    } // end for
%>
<hr size="1" noshade>
    </td>
  </tr>
</table>
<%
  } // end if
%>
<form action="<%=JSP_FILE%>" method="POST" enctype="multipart/form-data">
  <blockquote>
    <center><table cellpadding=2 cellspacing=0 width="401">
      <tr>
        <td nowrap><b>Name</b></td>
        <td nowrap> <input type=text name=name size="25" maxlength="100" tabindex=1 value="<%=cookieTable.get("name")%>">
        </td>
      </tr>
      <tr>
        <td nowrap><b></b></td>
        <td nowrap> <input type=hidden name=email value="<%=cookieTable.get("email")%>">
        </td>
      </tr>
      <tr>
        <td nowrap><b></b></td>
        <td nowrap> <input type=hidden name=subject value="<%=cookieTable.get("subject")%>">
          <input type=submit value="<%=btncap%>" tabindex=8 name="submit"> <input type=reset value="Reset" tabindex=9 name="reset">
          <input type=hidden name=mode value="<%=MODE_REGIST%>">
          <%
  if (mode.equals(MODE_RES_MSG)) {
%>
          <input type=hidden name=pno value="<%=(String)params.get("no")%>">
          <%
  }
%>
        </td>
      </tr>
      <tr>
        <td colspan=2 nowrap> <b>Comment</b><br>
        <textarea name=comment cols="70" rows="10" wrap=hard tabindex=4></textarea>
        </td>
      </tr>
      <% if (!mode.equals(MODE_RES_MSG)) { %>
      <tr>
        <td nowrap><strong>File Update</strong></td>
        <td nowrap><input name="uploadfile" type="file" id="uploadfile" size="25"></td>
      </tr>
      <% } %>
      <tr>
      </tr>
    </table></center>
  </blockquote>
</form>
<table width="100%" border="0" cellspacing="0" cellpadding="5">
  <tr>
    <td>
<%
  int count = 0;
  if (!mode.equals(MODE_RES_MSG)) {
    for (int i=0;i<size;i++) {
      Hashtable data = (Hashtable)dataList.get(i);
      String no = (String)data.get("no");
      String pno = (String)data.get("pno");
      if (no.equals(pno)) {
        count++;
      }
      if (count>=start && count<=end) {
        String res = "[ <a href=\"" + JSP_FILE + "?mode=" + MODE_RES_MSG + "&no=" + no + "\"></a> ]";
        if (!NORMAL_RES) {
          res = "";
        }
        if (!no.equals(pno)) {
          res = "";
          out.println("<blockquote>");
        }
        // �薼�̒���
        String subject = omitString((String)data.get("subject"),SUB_MAX_LEN);
%>
      <hr size="1" noshade>
      [<%=(String)data.get("no")%>] <font color="<%=SUBJECT_COLOR%>"><b></b></font> Name: <%=(String)data.get("name")%>
      <small>Date: <%=(String)data.get("date")%></small> <%=res%><br>
      <blockquote>
        <font color="#<%=(String)data.get("color")%>">
        <%=(String)data.get("comment")%>
        </font>
        <% if (data.get("filesystemname")!=null)  { %>
		<br><br><b>File: </b><a href="<%=FILE_DIR + "/" + (String)data.get("filesystemname")%>" target='_blank'><%=(String)data.get("originalfilename")%></a>
        <% } %>
        <%=(String)data.get("url")%>
	  </blockquote>
<%
        if (!no.equals(pno)) {
          out.println("</blockquote>");
        }
      } // end if
    } // end for
  } // end if
%>
<hr size="1" noshade>
    </td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="5" cellspacing="0">
  <tr>
    <td>
<%
  if (!mode.equals(MODE_RES_MSG)) {
    int i = PAGE_MAX;
    boolean page_move = false;
    if (start - PAGE_MAX >= 1) {
      out.println("<input type=button value=\"�O�y�[�W\" onClick=\"location.href='" + JSP_FILE + "?start=" + (start - PAGE_MAX) + "'\"> ");
    }
    if (start + PAGE_MAX <= count) {
      out.println("<input type=button value=\"���y�[�W\" onClick=\"location.href='" + JSP_FILE + "?start=" + (start + PAGE_MAX) + "'\"> ");
    }
    if (count > i) {
      out.print("<br><br>[���ڈړ�] ");
      page_move = true;
    }
    while (count > i - PAGE_MAX) {
      if (i - PAGE_MAX + 1==start) {
        if (page_move) {
          out.print("[<b>" + (i/PAGE_MAX) + "</b>] ");
        }
      } else {
        out.print("[<a href=\"" + JSP_FILE + "?start=" + (i - PAGE_MAX +1) +"\">" + (i/PAGE_MAX) + "</a>] ");
      }
      i+=PAGE_MAX;
    }
  }
%>
    </td>
  </tr>
</table>
<table width="304" align=right cellspacing="0" cellpadding="2" border="0">
  <tr>
    <td nowrap align=center>
      <form action="<%=JSP_FILE%>" method="POST"  enctype="multipart/form-data">
        <input type=hidden name=mode value="<%=MODE_USER_DEL%>">
        <small>No</small>
        <input type=text name=no size=3 maxlength="6" style="ime-mode: disabled">
        <input type=submit value="Delete">
      </form>
    </td>
  </tr>
</table>
<div align="center"><br clear=all><!-- ���쌠�\���i�폜���ϕs�j-->
</body>
</html>
<%
} // end if
/** �g�����\�� **/
if (showhowto) {
%>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=shift-jis">
<style type="text/css">
<!--
body,tr,td,th { font-size:<%=TEXT_POINT%>;line-height: <%=TEXT_HIGHT%>; }
small { font-size:9pt; color:<%=TEXT_COLOR%> }
a:link {
  text-decoration: underline; font-weight: normal; color: <%=LINK_COLOR%>
}
a:visited {
  text-decoration: underline; font-weight: normal; color: <%=VLINK_COLOR%>
}
a:hover {
  text-decoration: underline; font-weight: normal; color: <%=HLINK_COLOR%>
}
a:active {
  text-decoration: underline; font-weight: normal; color: <%=ALINK_COLOR%>
}
-->
</style>
<title><%=TITLE%> �g����</title>
</head>
<body bgcolor="<%=BG_COLOR%>" text="<%=TEXT_COLOR%>" link="<%=LINK_COLOR%>" vlink="<%=VLINK_COLOR%>" alink="<%=ALINK_COLOR%>">
[<a href="<%=JSP_FILE%>">�f���ɖ߂�</a>]
<table width="100%" cellspacing="0" cellpadding="3" border="0" bgcolor="#666666">
  <tr>
    <td align="center"><font color="#FFFFFF"><b>�f���̎g����</b></font></td>
  </tr>
</table>
<ol>
  <p>
  <li>���e�L����<b>HTML�^�O�͎g�p�ł��܂���B</b>
    <p>
  <li><b>�u���Ȃ܂��v</b>��<b>�u�R�����g�v</b>�͕K�����͂��Ȃ���΂Ȃ�܂���B�u�d���[���v�A�uURL�v�A�u�薼�v�A�u�폜�L�[�v�͔C�ӂł��B
    <p>
  <li>���e����<b>�u�폜�L�[�v</b>����͂��Ă����ƁA���́u�폜�L�[�v���g���Č�Ŏ����̋L�����폜���邱�Ƃ��ł��܂��B
    <p>
  <li>���e����<b>�u�폜�L�[�v</b>����͂��Ă��Ȃ��ꍇ�͂��̋L�����폜�ł��܂���B�����ӂ��������B
    <p>
  <li><b>�u�N�b�L�[����ۑ��v</b>�Ƀ`�F�b�N�����Ă����ƁA���񂩂�A���Ȃ܂��A�d���[���A�t�q�k�A�����F�A�폜�L�[�͎������͂���܂��B
    <p>
  <li>�e�L���̍ő�ێ�������<b>�ő� <%=MAX%>��</b>�ł��B����𒴂���ƌÂ��L������
    <% if (PAST_LOG) { %>
    �ߋ����O�ɏ������܂�܂��B
    <% } else { %>
    �폜����܂��B
    <% } %>
    <p>
  <li> �����̋L�����폜����ꍇ�̓y�[�W�E���̃t�H�[�����s�����Ƃ��ł��܂��B
    <p>
  <li>�Ǘ��҂����̌f���ɑ��������Ȃ����e�Ɣ��f�����ꍇ�͗\���Ȃ��폜���邱�Ƃ�����܂��B
</ol>
<table width="100%" cellspacing="0" cellpadding="3" border="0" bgcolor="#666666">
  <tr>
    <td align="center">�@</td>
  </tr>
</table>
<div align="center"><br><!-- ���쌠�\���i�폜���ϕs�j-->
</body>
</html>
<%
} // end if
/** �Ǘ��҃��O�C���y�[�W�\�� **/
if (showlogin) {
%>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=shift-jis">
<title><%=TITLE%> �F��</title>
<style type="text/css">
<!--
body,tr,td,th { font-size:<%=TEXT_POINT%>;line-height: <%=TEXT_HIGHT%>; }
small { font-size:9pt; color:<%=TEXT_COLOR%> }
a:link {
  text-decoration: underline; font-weight: normal; color: <%=LINK_COLOR%>
}
a:visited {
  text-decoration: underline; font-weight: normal; color: <%=VLINK_COLOR%>
}
a:hover {
  text-decoration: underline; font-weight: normal; color: <%=HLINK_COLOR%>
}
a:active {
  text-decoration: underline; font-weight: normal; color: <%=ALINK_COLOR%>
}
-->
</style>
</head>
<body bgcolor="<%=BG_COLOR%>" text="<%=TEXT_COLOR%>" link="<%=LINK_COLOR%>" vlink="<%=VLINK_COLOR%>" alink="<%=ALINK_COLOR%>">
[<a href="<%=JSP_FILE%>">�f���ɖ߂�</a>]
<table width="100%" cellspacing="0" cellpadding="3" border="0" bgcolor="#666666" align="center">
  <tr>
    <td align="center"><font color="#FFFFFF"><b>�F��</b></font></td>
  </tr>
</table>
<form action="<%=JSP_FILE%>" method="POST">
  <div align="center">
    <input type=hidden name=mode value="<%=MODE_ADMIN%>">
  </div>
  <div align="center"><b>�p�X���[�h����͂��Ă�������</b><br>
    <p><input type="password" name="passwd" size="10" >
    <br>
<font color="#CC0000">
<%
  if (msg!=null) out.print(msg);
%>
</font>
  </div>
  <div align="center"> </div>
  <P align="center">
    <input type=submit value="���O�C��">
</form>
<table width="100%" cellspacing="0" cellpadding="3" border="0" bgcolor="#666666" align="center">
  <tr>
    <td align="center">�@</td>
  </tr>
</table>
<div align="center"><br><!-- ���쌠�\���i�폜���ϕs�j-->
</body>
</html>
<%
} // end if
/** �Ǘ��҉�ʕ\�� **/
if (showadmin) {
  // �f�[�^�̎擾
  Vector dataList = readData(LOG_PATH , null);
  int size = dataList.size();
%>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=shift-jis">
<title><%=TITLE%> �Ǘ��y�[�W</title>
<style type="text/css">
<!--
body,tr,td,th { font-size:<%=TEXT_POINT%>;line-height: <%=TEXT_HIGHT%>; }
small { font-size:9pt; color:<%=TEXT_COLOR%> }
a:link {
  text-decoration: underline; font-weight: normal; color: <%=LINK_COLOR%>
}
a:visited {
  text-decoration: underline; font-weight: normal; color: <%=VLINK_COLOR%>
}
a:hover {
  text-decoration: underline; font-weight: normal; color: <%=HLINK_COLOR%>
}
a:active {
  text-decoration: underline; font-weight: normal; color: <%=ALINK_COLOR%>
}
-->
</style>
</head>
<body bgcolor="<%=BG_COLOR%>" text="<%=TEXT_COLOR%>" link="<%=LINK_COLOR%>" vlink="<%=VLINK_COLOR%>" alink="<%=ALINK_COLOR%>">
[<a href="<%=JSP_FILE%>">�f���ɖ߂�</a>]
<table width="100%" cellspacing="0" cellpadding="3" border="0" bgcolor="#666666" align="center">
  <tr>
    <td align="center"><font color="#FFFFFF"><b>�Ǘ��y�[�W</b></font></td>
  </tr>
</table>
<form action="<%=JSP_FILE%>" method="POST">
  <div align="center">
    <input type=hidden name=mode value="<%=MODE_ADMIN%>">
    <input type=hidden name=passwd value="<%=(String)params.get("passwd")%>">
  </div>
  <div align="center">�폜�������L���Ƀ`�F�b�N�����폜�{�^���������ĉ������B <br>
    <br>
  </div>
  <div align="center">
    <table border=1 cellspacing=0 cellpadding="2">
      <tr>
        <th nowrap><font color="#666666">�폜</font></th>
        <th nowrap><font color="#666666">No</font></th>
        <th nowrap><font color="#666666">�z�X�g��</font></th>
        <th nowrap><font color="#666666">�薼</font></th>
        <th nowrap><font color="#666666">���e��</font></th>
        <th nowrap><font color="#666666">���e��</font></th>
        <th nowrap><font color="#666666">�R�����g</font></th>
        <th nowrap><font color="#666666">�Y�t�t�@�C��</font></th>
      </tr>
      <%
  for (int i=0;i<size;i++) {
    Hashtable data = (Hashtable)dataList.get(i);
    String no = (String)data.get("no");
    String subject = (String)data.get("subject");
    subject = omitString(removeTag(subject) , 8);
    String name = (String)data.get("name");
    name = omitString(removeTag(name) , 8);
    String comment = (String)data.get("comment");
    comment = omitString(removeTag(comment), 12);
    String fileName = (String)data.get("filesystemname");
    String fileExist = "[��]";
	if (fileName!=null) {
	  fileExist = "[<a href=\"" + FILE_DIR + "/" + (String)data.get("filesystemname") + "\" target='_blank'>�L</a>]";
	}
%>
      <tr valign="middle">
        <td nowrap align="center"> <input type=checkbox name=del value="<%=no%>">
        </td>
        <td nowrap align="center"><b><%=no%></b></td>
        <td nowrap><%=(String)data.get("host")%></td>
        <td><%=subject%></td>
        <td><%=name%></td>
        <td nowrap><small><%=(String)data.get("date")%></small></td>
        <td><small><%=comment%></small></td>
        <td align="center"><%=fileExist%></td>
      </tr>
      <%
  } // end for
%>
    </table>
  </div>
  <P align="center">
    <input type=submit value="�폜����">
    �@
<input type=reset value="���Z�b�g">
</form>
<table width="100%" cellspacing="0" cellpadding="3" border="0" bgcolor="#666666" align="center">
  <tr>
    <td align="center">�@</td>
  </tr>
</table>
<div align="center"><br><!-- ���쌠�\���i�폜���ϕs�j-->
</body>
</html>
<%
} // end if
/** �ߋ����O��ʕ\�� **/
if (showpast) {
%>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=shift-jis">
<title><%=TITLE%> �ߋ����O</title>
<style type="text/css">
<!--
body,tr,td,th { font-size:<%=TEXT_POINT%>;line-height: <%=TEXT_HIGHT%>; }
small { font-size:9pt; color:<%=TEXT_COLOR%> }
a:link {
  text-decoration: underline; font-weight: normal; color: <%=LINK_COLOR%>
}
a:visited {
  text-decoration: underline; font-weight: normal; color: <%=VLINK_COLOR%>
}
a:hover {
  text-decoration: underline; font-weight: normal; color: <%=HLINK_COLOR%>
}
a:active {
  text-decoration: underline; font-weight: normal; color: <%=ALINK_COLOR%>
}
-->
</style>
<script language="JavaScript" type="text/JavaScript">
<!--
function goToPastLog(form) {
  if (form.select_file.selectedIndex >= 0) {
    form.mode.value = "<%=MODE_LOG%>";
    form.submit();
  }
}
function goToResult(form) {
  form.mode.value = "<%=MODE_SEARCH%>";
  form.submit();
}
//-->
</script>
</head>
<%
File dir = new File(PAST_DIR_PATH);
String[] fileList = dir.list();
String title = "�ߋ����O";
if (fileList == null || fileList.length == 0) {
  title = "�ߋ����O�͂���܂���";
}
%>
<body bgcolor="<%=BG_COLOR%>" text="<%=TEXT_COLOR%>" link="<%=LINK_COLOR%>" vlink="<%=VLINK_COLOR%>" alink="<%=ALINK_COLOR%>">
[<a href="<%=JSP_FILE%>">�f���ɖ߂�</a>]
<table width="100%" cellspacing="0" cellpadding="3" border="0" bgcolor="#666666" align="center">
  <tr>
    <td align="center"><font color="#FFFFFF"><b><%=title%></b></font></td>
  </tr>
</table>
<form action="<%=JSP_FILE%>" method="POST">
  <div align="center">�ߋ����O�F
    <select name="select_file" id="select_file">
<%
if (fileList!=null) {
  for (int i=fileList.length-1;i>=0;i--) {
%>
      <option value="<%=fileList[i]%>"><%=fileList[i]%></option>
<%
  }
}
%>
    </select>
    �@
    <input type=button onClick="goToPastLog(this.form)" value="�ړ�">
    �@�ߋ����O�����F
    <input name="keyword" type="text" id="keyword" size="15" maxlength="20">
    �@
    <input type=button onClick="goToResult(this.form)" value="����">
    <input name="mode" type="hidden" id="mode" value="">
  </div>
</form>
<table width="100%" cellspacing="0" cellpadding="3" border="0" bgcolor="#666666" align="center">
  <tr>
    <td align="center">�@</td>
  </tr>
</table>
<div align="center"><br>
  <!-- ���쌠�\���i�폜���ϕs�j-->
</body>
</html>
<%
} // end if
/** �ߋ����O�������ʕ\�� **/
if (showsearch) {
%>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=shift-jis">
<title><%=TITLE%> �ߋ����O��������</title>
<style type="text/css">
<!--
body,tr,td,th { font-size:<%=TEXT_POINT%>;line-height: <%=TEXT_HIGHT%>; }
small { font-size:9pt; color:<%=TEXT_COLOR%> }
a:link {
  text-decoration: underline; font-weight: normal; color: <%=LINK_COLOR%>
}
a:visited {
  text-decoration: underline; font-weight: normal; color: <%=VLINK_COLOR%>
}
a:hover {
  text-decoration: underline; font-weight: normal; color: <%=HLINK_COLOR%>
}
a:active {
  text-decoration: underline; font-weight: normal; color: <%=ALINK_COLOR%>
}
-->
</style>
</head>
<body bgcolor="<%=BG_COLOR%>" text="<%=TEXT_COLOR%>" link="<%=LINK_COLOR%>" vlink="<%=VLINK_COLOR%>" alink="<%=ALINK_COLOR%>">
[<a href="<%=JSP_FILE%>">�f���ɖ߂�</a>]
<table width="100%" cellspacing="0" cellpadding="3" border="0" bgcolor="#666666" align="center">
  <tr>
    <td align="center"><font color="#FFFFFF"><b>�ߋ����O��������</b></font></td>
  </tr>
</table><br>
<div align="center">[<a href="javascript:history.back()">������ʂɖ߂�</a>] </div>
<div align="center"><br>
<%
String keyword = (String)params.get("keyword");
if (keyword!=null && !keyword.trim().equals("")) {
  keyword = keyword.trim();
  Vector lines = new Vector();
  File dir = new File(PAST_DIR_PATH);
  String[] fileList = dir.list();
  if (fileList!=null) {
    for (int i=fileList.length-1;i>=0;i--) {
      String filePath = PAST_DIR_PATH + File.separator + fileList[i];
      BufferedReader br = new BufferedReader(
                          new InputStreamReader(
                          new FileInputStream(filePath),"shift-jis"));
      String line = null;
      while ((line=br.readLine())!=null) {
        if (line.indexOf(keyword)>=0) {
          lines.add(line);
        }
      }
      br.close();
    }
  }
  if (lines.size()==0) {
    if (fileList==null || fileList.length==0) {
      out.println("�ߋ����O�����݂��܂���");
    } else {
      out.println("������܂���ł���");
    }
  } else {
    out.println(lines.size() + "���q�b�g���܂���");
    out.println("<div align=\"left\">");
    for (int i=0;i<lines.size();i++) {
      out.println(lines.get(i));
    }
    out.println("</div>");
  }
} else {
  out.println("�L�[���[�h���w�肵�Ă�������");
}
%>
  <br>
  <br>
  [<a href="javascript:history.back()">������ʂɖ߂�</a>]</div><br>
<table width="100%" cellspacing="0" cellpadding="3" border="0" bgcolor="#666666" align="center">
  <tr>
    <td align="center">
�@</td>
  </tr>
</table>
<div align="center"><br>
  <!-- ���쌠�\���i�폜���ϕs�j-->
</body>
</html>
<%
} // end if
/** �ߋ����O�\�� **/
if (showlog) {
%>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=shift-jis">
<title><%=TITLE%> �ߋ����O�\�� [ <%=(String)params.get("select_file")%> ]</title>
<style type="text/css">
<!--
body,tr,td,th { font-size:<%=TEXT_POINT%>;line-height: <%=TEXT_HIGHT%>; }
small { font-size:9pt; color:<%=TEXT_COLOR%> }
a:link {
  text-decoration: underline; font-weight: normal; color: <%=LINK_COLOR%>
}
a:visited {
  text-decoration: underline; font-weight: normal; color: <%=VLINK_COLOR%>
}
a:hover {
  text-decoration: underline; font-weight: normal; color: <%=HLINK_COLOR%>
}
a:active {
  text-decoration: underline; font-weight: normal; color: <%=ALINK_COLOR%>
}
-->
</style>
</head>
<body bgcolor="<%=BG_COLOR%>" text="<%=TEXT_COLOR%>" link="<%=LINK_COLOR%>" vlink="<%=VLINK_COLOR%>" alink="<%=ALINK_COLOR%>">
[<a href="<%=JSP_FILE%>">�f���ɖ߂�</a>]
<table width="100%" cellspacing="0" cellpadding="3" border="0" bgcolor="#666666" align="center">
  <tr>
    <td align="center"><font color="#FFFFFF"><b>�ߋ����O�\�� [ <%=(String)params.get("select_file")%> ]</b></font></td>
  </tr>
</table><br><div align="center">[<a href="javascript:history.back()">������ʂɖ߂�</a>] </div>
<div align="left"><br>
<%
String fileName = (String)params.get("select_file");
if (fileName==null || fileName.equals("") || fileName.indexOf(File.separator) > 0) {
  out.println("���O�t�@�C�������݂��܂���");
} else {
  String filePath = PAST_DIR_PATH + File.separator + fileName;
  File logFile = new File(filePath);
  if (logFile.exists()) {
      BufferedReader br = new BufferedReader(
                          new InputStreamReader(
                          new FileInputStream(filePath),"shift-jis"));
      String line;
      while ((line=br.readLine())!=null) {
        out.println(line);
      }
      br.close();
  } else {
      out.println("���O�t�@�C�������݂��܂���");
  }
}
%>
  <br>
  <br>
  </div>
<div align="center">[<a href="javascript:history.back()">������ʂɖ߂�</a>] </div><br><br>
<table width="100%" cellspacing="0" cellpadding="3" border="0" bgcolor="#666666" align="center">

  <tr>
    <td align="center">�@</td>
  </tr>
</table>
<div align="center"><br>
  <!-- ���쌠�\���i�폜���ϕs�j-->
</body>
</html>
<%
} // end if
%>
<%!
/**
 * �t�@�C���̊g���q�̃`�F�b�N
 */
private boolean fileExtensionCheck(String extension) {
  for (int i=0;i<EXTENSION_LIST.length;i++) {
    if (EXTENSION_LIST[i].equals(extension)) {
      return true;
    }
  }
  return false;
}
/**
 * �N�b�L�[�𔭍s
 */
private void addCookie(String[] cookieNames,
                       Hashtable params,
                       HttpServletResponse response,
                       int expiry) {
  String name = removeTag((String)params.get("name"));
  name = replace(name , "&nbsp;" , " ");
  params.put("name" , name);
  String url = (String)params.get("url");
  if (url!=null) {
    url = removeTag(url);
    if (url.equals("")) {
      url = "http://";
    }
    params.put("url" , url);
  }
  try {
    for (int i=0;i<cookieNames.length;i++) {
      String val = (String)params.get(cookieNames[i]);
      if (val!=null) {
        Cookie cookie = new Cookie(cookieNames[i] , URLEncoder.encode(val,"shift-jis"));
        cookie.setMaxAge(expiry);
        response.addCookie(cookie);
      }
    }
  } catch (Exception e) {
    e.printStackTrace();
  }
}
/**
 * �N�b�L�[���擾
 */
private Hashtable getCookie(String[] cookieNames, Hashtable params , HttpServletRequest request) {
  Hashtable cookieTable = new Hashtable();
  boolean needcookie = true;
  for (int i=0;i<cookieNames.length;i++) {
    String param = (String)params.get(cookieNames[i]);
    if (param==null) {
      param = "";
    } else {
      if (cookieNames[i].equals("name")) {
        needcookie = false;
      }
    }
    cookieTable.put(cookieNames[i] , param);
  }
  String url = (String)cookieTable.get("url");
  if (url==null || url.equals("")) {
    url = "http://";
  }
  cookieTable.put("url" , url);
  if (needcookie) {
    try {
      Cookie[] cookies = request.getCookies();
      if (cookies!=null) {
        for (int i=0;i<cookies.length;i++) {
          cookieTable.put(cookies[i].getName() , URLDecoder.decode(cookies[i].getValue(),"shift-jis"));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  return cookieTable;
}
/**
 * �p�����[�^�[�`�F�b�N
 */
private String paramCheck(String mode , Hashtable params , Hashtable mailData) {
  if (mode.equals(MODE_REGIST)) { // �o�^
    String name = (String)params.get("name");
    String email = (String)params.get("email");
    String subject = (String)params.get("subject");
    String comment = (String)params.get("comment");
    String url = (String)params.get("url");

    if (name==null || name.equals("")) {
      return "���O�����͂���Ă��܂���";
    }
    if (comment== null || comment.equals("")) {
      return "�R�����g�����͂���Ă��܂���";
    }
    if (email!=null && !email.equals("")) {
      if (!emailCheck(email)) {
        return "�d���[��������������܂���";
      }
    }
    if (subject== null || subject.equals("")) {
      subject = "����";
    }
    if (SEND_MAIL) {
      mailData.put("o_name" , name);
      mailData.put("o_email" , email);
      mailData.put("o_subject" , subject);
      mailData.put("o_comment" , comment);
      mailData.put("o_url" , url);
    }

    name = htmlEncode(name);
    email = htmlEncode(email);
    subject = htmlEncode(subject);
    comment = htmlEncode(comment);
    comment = crlf2br(comment);
    comment = replace(comment,"\t","&nbsp;&nbsp;&nbsp;&nbsp;");
    if (URL_AUTO_LINK) {
      comment = urlAutoLink(comment);
    }
    
    url = htmlEncode(url);
    if (url!=null && !url.equals("http://") && url.startsWith("http://")) {
      url = "<p><a href=\"" + url + "\" target='_blank'>" + url + "</a>";
    } else {
      url = "";
      if (SEND_MAIL) {
        mailData.put("o_url" , url);
      }
    }
    name = "<b>" + name + "</b>";
    if (email!=null && !email.equals("")) {
      name = "<a href=\"mailto:" + email + "\">" + name + "</a>";
    }

    params.put("name" , name);
    params.put("email" , email);
    params.put("subject" , subject);
    params.put("comment" , comment);
    params.put("url" , url);
  } else if (mode.equals(MODE_USER_DEL)) { // �L���폜
    String no = (String)params.get("no");
    String delpasswd = (String)params.get("delpasswd");
    if (/*(no==null || no.equals("")) ||
        (delpasswd==null || delpasswd.equals(""))*/false) {
      return "�L��No�܂��͍폜�L�[�����͂���Ă��܂���";
    }
  }
  return null;
}
/**
 * ���[���A�h���X���`�F�b�N
 */
private boolean emailCheck(String email) {
  if(email.indexOf('@')==-1 || email.indexOf('.')==-1) {
    return false;
  }
  return true;
}
/**
 * �p�����[�^�[�̒l��K�؂ɕϊ�
 */
private String toSJIS(String input) {
  try {
    String charsetName = "iso-8859-1";
    if (TOMCAT3) {
      charsetName = "";
    }
    input = (new String(input.getBytes(charsetName),"JISAutoDetect")).trim();
  } catch (UnsupportedEncodingException e) {
  }
  return input;
}
/**
 * HTML�G���R�[�h
 */
private String htmlEncode(String input) {
  if (input==null) {
    return input;
  }
  StringBuffer buf = new StringBuffer();
  char[] c = input.toCharArray();
  for (int i=0; i < c.length; i++) {
    switch (c[i]) {
      case '<':
        buf.append("&lt;");
        break;
      case '>':
        buf.append("&gt;");
        break;
      case '"':
        buf.append("&quot;");
        break;
      case ' ':
        buf.append("&nbsp;");
        break;
      default:
        buf.append(c[i]);
    }
  }
  return buf.toString();
}
/**
 * �������u��
 */
private String replace(String input, String pattern, String replace) {
  int index = input.indexOf(pattern);
  if (index==-1) {
    return input;
  }
  StringBuffer sb = new StringBuffer();
  sb.append(input.substring(0,index) + replace);
  int plen = pattern.length();
  if (index + plen < input.length()) {
    String s = input.substring(index + plen);
    sb.append(replace(s , pattern , replace));
  }
  return sb.toString();
}
/**
 * �����񂪒����ꍇ�ȗ����܂�
 */
private String omitString(String input, int len) {
  if (input.length()<=len) {
    return input;
  }
  return input.substring(0,len) + "�D�D";
}
/**
 * �J���[�I������
 */
private void colorCheck(Hashtable colorHTML , String color) {
  if (color==null || color.equals("")) {
    color = COLOR_LIST[0];
  }
  StringBuffer sbChecked = new StringBuffer();
  StringBuffer sbSelected = new StringBuffer();
  for (int i=0;i<COLOR_LIST.length;i++) {
    if (COLOR_LIST[i].equals(color)) {
      sbChecked.append("<input type=radio value=" + COLOR_LIST[i] + " name=color checked><font color=\"#" + COLOR_LIST[i] + "\">��</font>" + "\n");
      sbSelected.append("<option value=\"" + COLOR_LIST[i] + "\" selected>" + COLOR_NAME_LIST[i] + "\n");
    } else {
      sbChecked.append("<input type=radio value=" + COLOR_LIST[i] + " name=color><font color=\"#" + COLOR_LIST[i] + "\">��</font>" + "\n");
      sbSelected.append("<option value=\"" + COLOR_LIST[i] + "\">" + COLOR_NAME_LIST[i] + "\n");
    }
  }
  colorHTML.put("colorcheck", sbChecked.toString());
  colorHTML.put("coloroptions" , sbSelected.toString());
}
/**
 * URL���������N����
 */
private String urlAutoLink(String input) {
  String urlString = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_%/.?+&=";
  int start = input.indexOf("http://");
  int len = "http://".length();
  if (true/*start==-1*/) {
    return input;
  }
  int index;
  for (index=start + len;index<input.length();index++) {
   if (urlString.indexOf(input.charAt(index))==-1) {
    break;
   }
  }
  String url = input.substring(start , index);
  String link = "<a href=\"" + url + "\" target=\"_blank\">" + url + "</a>";
  StringBuffer sb = new StringBuffer();
  sb.append(input.substring(0, start)).append(link);
  if (index < input.length()) {
    sb.append(urlAutoLink(input.substring(index)));
  }
  return sb.toString();
}
// �z��̒����������܂�
private boolean searchArray(String[] array, String search) {
  for (int i=0;i<array.length;i++) {
    if (array[i].equals(search)) {
      return true;
    }
  }
  return false;
}
// ���s�R�[�h(CrLf,Cr,Lf)��"<br>"�ɕϊ�
private String crlf2br(String value) {
  if (value.indexOf("\r")==-1 && value.indexOf("\n")==-1) {
    return value;
  }
  final String BR = "<br>";
  StringBuffer sb = new StringBuffer();
  char c;
  int flagCr=-2;
  int len = value.length();
  for (int i=0;i<len;i++) {
    c = value.charAt(i);
    if (c=='\r') {
      flagCr=i;
      sb.append(BR);
    } else if (c=='\n') {
      if (i-flagCr==1) {
        sb.delete(sb.length()-BR.length(), sb.length());
      }
      sb.append(BR);
    } else {
      sb.append(c);
    }
  }
  return sb.toString();
}
/**
 * �^�O����菜���܂�
 */
private String removeTag(String input) {
  if (input==null) {
    return "";
  }
  int index = input.indexOf("<");
  if (index==-1) {
    return input;
  }
  while (index!=-1) {
    int endTagIndex = input.indexOf(">" , index);
    if (endTagIndex==-1) {
      break;
    }
    input = input.substring(0,index) + input.substring(endTagIndex + 1);
    index = input.indexOf("<");
  }
  return input;
}

/**
 * ���[�����M
 */
private boolean sendMail(Hashtable params , Hashtable mailData) {
  String cmd = SENDMAIL_PATH + " -t";
  String fileName = (String)params.get("originalfilename");
  String fileExist = "�L";
  if (fileName==null) {
    fileExist = "��";
  }
  String param = "From: " + ADMIN_MAIL + "\n" +
                 "To: " + ADMIN_MAIL + "\n" +
                 "Subject: [" + TITLE + " : " + (String)params.get("no") + "] " +
                 (String)params.get("subject") + "\n" +
                 "Content-type: text/plain; charset=ISO-2022-JP\n" +
                 "X-Mailer: Hello JSP BBS F\n\n" +
                 "--------------------------------------------------------\n" +
                 "���e�����F" + (String)params.get("date") + "\n" +
                 "�z�X�g���F" + (String)params.get("host") + "\n" +
                 "�u���E�U�F" + (String)params.get("user-agent") + "\n" +
                 "\n" +
                 "���e�Җ��F" + (String)mailData.get("o_name") + "\n" +
                 "�d���[���F" + (String)mailData.get("o_email") + "\n" +
                 "�t�q�k�F" + (String)mailData.get("o_url") + "\n" +
                 "�Y�t�t�@�C���F" + fileExist + "\n" +
                 "�^�C�g���F" + (String)mailData.get("o_subject") + "\n" +
                 "���e�L���F\n\n" +
                 (String)mailData.get("o_comment") + "\n" +
                 "--------------------------------------------------------\n";

  try {
    Process process = Runtime.getRuntime().exec(cmd);
    OutputStream out = process.getOutputStream();
    out.write(param.getBytes("ISO-2022-JP"));
    out.flush();
    out.close();
    return true;
  } catch (Exception e) {
    e.printStackTrace();
    return false;
  }
}

/**
 * �ߋ����O�̏�������
 */
private void writePastLog(Hashtable params ,
                          String countPath ,
                          String pastDirPath,
                          int delCount) {
  synchronized (plock) {
    // �ߋ����O�̃J�E���g���擾
    int pastCount = 0;
    try {
      BufferedReader cin = new BufferedReader(new FileReader(countPath));
      String strCnt = cin.readLine();
      cin.close();
      pastCount = Integer.parseInt(strCnt);
    } catch (Exception e) {
    }

    // �ߋ����O�t�@�C���̃p�X���擾
    String pastFilePath = pastDirPath + File.separator + pastCount + ".html";
    // �ߋ����O�ǂݍ���
    Vector logs = new Vector();
    try {
      File f = new File(pastDirPath);
      if (!f.isDirectory()) {
        f.mkdir();
      }
      BufferedReader pin = new BufferedReader(
                           new InputStreamReader(
                           new FileInputStream(pastFilePath),"shift-jis"));
      String line;
      while ((line=pin.readLine())!=null) {
        if (!line.equals("")) {
          logs.add(line);
        }
      }
      if (logs.size()>2) {
        logs.remove(0);
        logs.remove(logs.size()-1);
      }
      pin.close();
    } catch (Exception e) {
    }

    // �s���擾
    int lineCount = logs.size();
    // �ő�s���̃`�F�b�N
    if (lineCount >= MAX_PAST_LINE && delCount==0) {
      pastCount++;
      pastFilePath = pastDirPath + File.separator + pastCount + ".html";
      logs.clear();
    }

    // �ߋ����O�̏�������
    try {
      String no = (String)params.get("no");
      String pno = (String)params.get("pno");

      String line = "["+ no + "] <font color=" + SUBJECT_COLOR + "><b>" + (String)params.get("subject") +
                    "</b></font> ���e�ҁF" + (String)params.get("name") +
                    " <small>���e��:" + (String)params.get("date") +
                    "</small><p><blockquote>" + (String)params.get("comment");
      if (params.get("filesystemname")!=null)  {
        line += "<br><br><b>�Y�t�t�@�C���F</b><a href=\"" +FILE_DIR + "/" + (String)params.get("filesystemname") + "\" target='_blank'>" + (String)params.get("originalfilename") + "</a>";
      }
      line += "<p>" + (String)params.get("url") + "</blockquote><hr>";
      if (!no.equals(pno)) {
        line = "<blockquote>" + line + "</blockquote>";
      }
      BufferedWriter pout = new BufferedWriter(
                          new OutputStreamWriter(
                          new FileOutputStream(pastFilePath),"shift-jis"));
      pout.write("<html><body>\r\n");
      pout.write(line + "\r\n");
      lineCount = logs.size();
      for (int i=0;i<lineCount;i++) {
        pout.write((String)logs.get(i) + "\r\n");
      }
      pout.write("</body></html>");
      pout.close();

      BufferedWriter cout = new BufferedWriter(new FileWriter(countPath));
      cout.write(String.valueOf(pastCount));
      cout.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
/**
 * �f�[�^�̎擾
 */
private Vector readData(String logPath , String no) {
  Vector dataList = new Vector();
  try {
    ObjectInputStream in = new ObjectInputStream(new FileInputStream(logPath));
    dataList = (Vector)in.readObject();
    in.close();
  } catch (Exception e) {
  }
  if (no!=null) { // �ԐM
    int size = dataList.size();
    Vector resList = new Vector();
    for (int i=0;i<size;i++) {
      Hashtable data = (Hashtable)dataList.get(i);
      if (((String)data.get("pno")).equals(no)) {
        resList.add(data);
      }
    }
    if (resList.size()==0) {
      return null;
    }
    return resList;
  }
  return dataList;
}
/**
 * �f�[�^�̓o�^�E�폜
 */
private String registData(String
                          mode,
                          Hashtable params,
                          Hashtable mailData,
                          String countPath ,
                          String logPath,
                          String logCountPath,
                          String logDirPath) {
  synchronized (lock) {
    Vector dataList = new Vector();
    int newNo = 1;
    String name = "";
    String comment = "";
    // �f�[�^�ǂݍ���
    try {
      // �L���擾
      ObjectInputStream din = new ObjectInputStream(new FileInputStream(logPath));
      dataList = (Vector)din.readObject();
      din.close();
      // �L���ԍ��擾
      BufferedReader cin = new BufferedReader(new FileReader(countPath));
      String strCnt = cin.readLine();
      cin.close();
      newNo = Integer.parseInt(strCnt) + 1;
    } catch (Exception e) {
    }

    if (mode.equals(MODE_REGIST)) { /** �o�^ **/
      int i;
      // ��d���e���ǂ����̃`�F�b�N
      for (i=0;i<dataList.size();i++) {
        // �ŐV�̋L���̖��O�ƃR�����g���擾
        name = (String)((Hashtable)dataList.get(i)).get("name");
        comment = (String)((Hashtable)dataList.get(i)).get("comment");
        String thisFileName = (String)((Hashtable)dataList.get(i)).get("originalfilename");
        if (thisFileName == null) {
          thisFileName = "";
        }
        String fileName = (String)params.get("originalfilename");
        if (fileName == null) {
          fileName = "";
        }

        if (((String)params.get("name")).equals(name) &&
            ((String)params.get("comment")).equals(comment) &&
            fileName.equals(thisFileName)) {
            return "��d���e�͋֎~�ł�";
        }
      }

      // �L���ԍ���ݒ�
      String no = String.valueOf(newNo);
      params.put("no", no);
      int size = dataList.size();
      if (params.get("pno")==null) { // �ʏ�o�^�̏ꍇ
        if (size >= MAX) {
          // �e�L�������擾
          Hashtable data = (Hashtable)dataList.get(0);
          String pno = (String)data.get("pno");
          int parentCount = 1;
          for (i=0;i<size;i++) {
            data = (Hashtable)dataList.get(i);
            String tmpPno = (String)data.get("pno");
            if (!tmpPno.equals(pno)) {
              parentCount++;
            }
            pno = tmpPno;
          }
          // �ő�ێ��e�L�����̃`�F�b�N
          if (parentCount >= MAX) {
            int delParentNum = parentCount - MAX + 1;
            data = (Hashtable)dataList.get(size-1);
            pno = (String)data.get("pno");
            int delCount=0;
            for (i=size-1;i>0;i--) {
              data = (Hashtable)dataList.get(i);
              String tmpPno = (String)data.get("pno");
              if (tmpPno.equals(pno)) {
                if (PAST_LOG) {
                  writePastLog((Hashtable)dataList.get(i),logCountPath,logDirPath,delCount++);
                }
                dataList.remove(i);
              } else {
                if (--delParentNum<=0) {
                  break;
                } else {
                  if (PAST_LOG) {
                    writePastLog((Hashtable)dataList.get(i),logCountPath,logDirPath,delCount++);
                  }
                  dataList.remove(i);
                  pno = tmpPno;
                }
              }
            }
          }
        }

        params.put("pno",no);
        // ���X�g�ɒǉ�
        dataList.add(0,params);
      } else { // �ԐM����̏ꍇ
        String pno = (String)params.get("pno");
        boolean exist = false;
        Vector sortData = new Vector();
        for (i=0;i<size;i++) {
          Hashtable data = (Hashtable)dataList.get(i);
          String tmpPno = (String)data.get("pno");
          // �e�L�������݂���ꍇ
          if (tmpPno.equals(pno)) {
            exist = true;
            // �g�b�v�\�[�g����
            if (TOP_SORT) {
              dataList.remove(i--);
              size--;
              sortData.add(data);
            }
          } else {
            if (exist) {
              break;
            }
          }
        }
        if (!exist) {
          return "�L�������ɍ폜����Ă��܂�";
        }
        if (TOP_SORT) { // �g�b�v�\�[�g����
          sortData.add(params);
          dataList.addAll(0, sortData);
        } else { // �g�b�v�\�[�g�Ȃ�
          dataList.add(i,params);
        }
      }
    } else if (mode.equals(MODE_USER_DEL)) { /** ���[�U�[�L���폜 **/
      String delNo = (String)params.get("no");
      String delPasswd = (String)params.get("delpasswd");
      int size = dataList.size();
      boolean delete = false;
      for (int i=size-1;i>=0;i--) {
        Hashtable data = (Hashtable)dataList.get(i);
        String tmpNo = (String)data.get("no");
        String tmpPasswd = (String)data.get("passwd");
        if (tmpNo.equals(delNo)) {
          if (/*tmpPasswd!=null && tmpPasswd.equals(delPasswd) && !tmpPasswd.equals("")*/true) {
            delete = true;
            dataList.remove(i);
            // �t�@�C�����폜���܂�
            String filePath = (String)data.get("filesystempath");
            if (filePath!=null) {
              File file = new File(filePath);
              if (file.exists()) {
                file.delete();
              }
            }
          } else {
            return "�폜�L�[���������܂�";
          }
          break;
        }
      }
      // �ԐM���폜���܂�
      if (delete) {
        size = dataList.size();
        for (int i=size-1;i>=0;i--) {
          Hashtable data = (Hashtable)dataList.get(i);
          String tmpPno = (String)data.get("pno");
          if (tmpPno.equals(delNo)) {
            dataList.remove(i);
            // �t�@�C�����폜���܂�
            String filePath = (String)data.get("filesystempath");
            if (filePath!=null) {
              File file = new File(filePath);
              if (file.exists()) {
                file.delete();
              }
            }
          }
        }
      }
    } else if (mode.equals(MODE_ADMIN)) { /** �Ǘ��ҋL���폜 **/
      String passwd = (String)params.get("passwd");
      if (passwd!=null && passwd.equals(ADMIN_PASSWD)) {
        String[] del = (String[])params.get("del");
        int size = dataList.size();
        Vector plist = new Vector();
        for (int i=size-1;i>=0;i--) {
          Hashtable data = (Hashtable)dataList.get(i);
          String tmpNo = (String)(data.get("no"));
          if (searchArray(del, tmpNo)) {
            String tmpPno = (String)(data.get("pno"));
            if (tmpNo.equals(tmpPno)) {
              plist.add(tmpPno);
            }
            dataList.remove(i);
            // �t�@�C�����폜���܂�
            String filePath = (String)(data.get("filesystempath"));
            if (filePath!=null) {
              File file = new File(filePath);
              if (file.exists()) {
                file.delete();
              }
            }
          }
        }
        // �ԐM�L�����폜
        if (plist.size()>0) {
          del = new String[plist.size()];
          plist.toArray(del);
          size = dataList.size();
          for (int i=size-1;i>=0;i--) {
            Hashtable data = (Hashtable)dataList.get(i);
            String tmpPno = (String)(data.get("pno"));
            if (searchArray(del, tmpPno)) {
              dataList.remove(i);
              // �t�@�C�����폜���܂�
              String filePath = (String)(data.get("filesystempath"));
              if (filePath!=null) {
                File file = new File(filePath);
                if (file.exists()) {
                  file.delete();
                }
              }
            }
          }
        }
      }
    }

    // �f�[�^��������
    try {
      File logFile = new File(logPath);
      if (logFile.exists() && !logFile.canWrite()) {
        return "���O�t�@�C���ɏ������݌���������܂���";
      }
      File countFile = new File(countPath);
      if (countFile.exists() && !countFile.canWrite()) {
        return "�J�E���g�t�@�C���ɏ������݌���������܂���";
      }
      // �L����������
      ObjectOutputStream dout = new ObjectOutputStream(new FileOutputStream(logFile));
      dout.writeObject(dataList);
      dout.close();
      // �L���ԍ�����������
      if (mode.equals(MODE_REGIST)) {
        BufferedWriter cout = new BufferedWriter(new FileWriter(countFile));
        cout.write(String.valueOf(newNo));
        cout.close();
        // ���[�����M
        if (SEND_MAIL) {
          if (!sendMail(params , mailData)) {
            return "���[�����M���ɃG���[���������܂���";
          }
        }
      }
    } catch (Exception e) {
      return "�������ݎ��ɃG���[���������܂���";
    }
    return null;
  }
}

/**
 * �G���[�o��
 */
private void showErrorHTML(JspWriter out, String msg , String back) throws IOException {
  out.println("<html>");
  out.println("<head>");
  out.println("<meta http-equiv=\"Content-type\" CONTENT=\"text/html; charset=shift-jis\">");
  out.println("<title>�G���[</title>");
  out.println("<style type=\"text/css\">");
  out.println("<!--");
  out.println("body { font-size:10pt }");
  out.println("-->");
  out.println("</style>");
  out.println("</head>");
  out.println("<body bgcolor=\"#FFFFFF\">");
  out.println("<hr width=\"350\" noshade size=\"1\">");
  out.println("<center>");
  out.println("<h4>�G���[</h4>");
  out.println("<p><font color='#CC0000'>" + msg + "</font>");
  out.println("<p>[<a href=\"" + back + "\">�߂�</a>]");
  out.println("</center>");
  out.println("<hr width=\"350\" noshade size=\"1\">");
  out.println("</body>");
  out.println("</html>");
}
%>
