<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sbs.board.Reply"%>  
<%@ page import="com.sbs.board.Article"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Reply reply = (Reply)request.getAttribute("reply");%>
<% Article article = (Article) request.getAttribute("article"); %>

<div>
<h1> 댓글 수정 </h1>
<form action="test?cmd=updateReply">
내용입력 : <input type="text" name="body" value="<%= reply.getBody() %>"><br>
작성자 : <%= reply.getWriter() %><br>
날짜 : <%= reply.getRegDate() %><br>
<hr>
<input type="hidden" name="cmd" value="updateReply">
<input type="hidden" name="id" value="<%= reply.getId() %>">
<input type="hidden" name="writer" value="<%= reply.getWriter() %>">
<input type="submit">
</form>
</div>

</body>
</html>