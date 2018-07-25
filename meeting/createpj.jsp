<%@
page import = "java.io.*"
import = "javax.servlet.*"
import = "javax.servlet.http.*"
import = "java.util.*"
import = "java.text.*"

pageEncoding="shift-jis"
contentType = "text/html; charset = shift-jis"
%>

<html>
<head>
<title>プロジェクト追加</title>

<form id=formid action="createpj_result.jsp" method="post">
プロジェクト名：
<input type="text" name="pj_name" value="" size="3" maxlength="30">
<input type="submit" value="作成">
</form>