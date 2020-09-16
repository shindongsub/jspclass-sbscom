<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sbs.board.Article"%> 
<%@ page import="com.sbs.board.TestServlet"%>
<%@ page import="com.sbs.board.Reply"%>  
<%@ page import="java.util.List"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Article article = (Article)request.getAttribute("article");
List<Reply> reply = (List<Reply>)request.getAttribute("reply"); 
%>

<h1>게시물 상세보기</h1><br>
<div>
번호 : <%= article.getId() %><br>
제목 : <%= article.getTitle() %><br>
내용 : <%= article.getBody() %><br>
작성자 : <%= article.getNickname() %><br>
날짜 : <%= article.getRegDate() %><br>
조회수 : <%= article.getHit() %><br>
</div>

<a href="http://localhost:8090/test?cmd=list">[목록]</a>
<a href="http://localhost:8090/test?cmd=addReply&parentId=<%= article.getId() %>">[댓글]</a>
<a href="http://localhost:8090/test?cmd=updateArticle&id=<%= article.getId() %>">[수정]</a>
<a href="http://localhost:8090/test?cmd=delete&id=<%= article.getId() %>">[삭제]</a>
<hr>
-댓글내용-<br>
<hr>
<div>
<% for (int i=0; i<reply.size() ;i++){%>
	<div>
	내용 : <%= reply.get(i).getBody() %> <br>
	작성자 : <%= reply.get(i).getWriter() %> <br>
	작성일 : <%= reply.get(i).getRegDate() %> <br>
	</div>
</div>


<a href="http://localhost:8090/test?cmd=readReply&id=<%= reply.get(i).getId() %>">[댓글수정]</a>
<a href="http://localhost:8090/test?cmd=deleteReply&id=<%= reply.get(i).getId() %>">[댓글삭제]</a><br>

<hr>
<div>
<%}%>
</div>
</body>
</html>