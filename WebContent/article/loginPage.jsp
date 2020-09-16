<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sbs.board.TestServlet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% String loginId = (String)application.getAttribute("loginId"); %>
<% String loginPw = (String)application.getAttribute("loginPw"); %>
<% if(loginId != null){%>
 반갑습니다!!
<%}else {%>
	없는 아이디 입니다.
<%}%>



</body>
</html>