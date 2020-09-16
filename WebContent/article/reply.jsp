<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sbs.board.Reply" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sbs.board.Article" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Article article = (Article)request.getAttribute("article");%>
<%List<Reply> reply = (List<Reply>)request.getAttribute("reply");%>

<div>
<h1> 게시물 댓글달기</h1>
번호 : <%= article.getId() %> <br>
제목 : <%= article.getTitle() %> <br>
내용 : <%= article.getBody() %> <br>
작성자 : <%= article.getNickname() %> <br>
작성일 : <%= article.getRegDate() %> <br>
조회수 : <%= article.getHit() %> <br>
<hr>
</div>

-댓글입력-
<form action="test?cmd=reply">
내용 입력 : <input type="text" name="body"><br>
작성자 입력 : <input type="text" name="nickname"><br>
<input type="hidden" name="parentId" value="<%= article.getId() %>">
<input type="hidden" name="cmd" value="reply">
<input type="submit">
</form>
</body>
</html>