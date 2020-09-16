<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="test?cmd=login">

i d : <input type="text" name="loginId" > <br>
pw : <input type="text" name="loginPw" > <br>
<hr>
<input type="hidden" name="cmd" value="login">
<input type="submit">
<a href="http://localhost:8090/test?cmd=list">[목록]</a>
</form>

</body>
</html>