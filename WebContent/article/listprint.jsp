<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sbs.board.TestServlet" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sbs.board.Article"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> ☆게시물 목록☆ </h1>
번호를 누르시면 상세보기가 실행됩니다.<br>
<a href="http://localhost:8090/test?cmd=addArticle">[게시물 추가]</a>
<hr>
<% 
List<Article> articles = (List<Article>)request.getAttribute("articles");
%>
<%Article article = (Article)request.getAttribute("article"); %>
<% for (int i = 0; i<articles.size(); i++){%>
<div>
<!-- 리스트의 번호를 클릭하면 cmd=read의 id번째 상세보기로 이동 -->
<a href="http://localhost:8090/test?cmd=read&id=<%= articles.get(i).getId() %>"> 
번호    : <% out.println(articles.get(i).getId());%></a><br>
제목    : <% out.println(articles.get(i).getTitle());%><br>
내용    : <% out.println(articles.get(i).getBody());%><br>
작성자 : <% out.println(articles.get(i).getNickname());%><br>
날짜    : <% out.println(articles.get(i).getRegDate());%><br>
조회수 : <% out.println(articles.get(i).getHit());%><br>
<hr>
<%
}
%>
</div>

</body>
</html>



<!-- 
<h1> 제목
<br> 줄바꿈
<div> 영역 - 여기선 자동줄바꿈됨
<form> uri제조기 (상자만들기?)
<a>링크  <>a쓰고 띄운다음 링크걸면 해당링크로 들어가게됨.
 -->