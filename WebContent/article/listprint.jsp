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
	<h1>게시물 목록</h1>
	번호를 누르시면 상세보기가 실행됩니다.
	<br>
	<hr>

	<form action="test?cmd=delete" method="POST">
		<%
			List<Article> articles = (List<Article>) request.getAttribute("articles");
		for (int i = 0; i < articles.size(); i++) {
		%>
		<div>
			<input type="checkbox" name="ckb" value="<%=articles.get(i).getId()%>" />
			<a href="http://localhost:8090/test?cmd=read&id=<%=articles.get(i).getId()%>">
				번호 : <%=articles.get(i).getId()%></a>
				제목 : <%=articles.get(i).getTitle()%>
				내용 : <%=articles.get(i).getBody()%>
				작성자 : <%=articles.get(i).getNickname()%>
				날짜 : <%=articles.get(i).getRegDate()%>
				조회수 : <%=articles.get(i).getHit()%>
		</div>
		<hr>
		<%
			}
		%>
		<input type="submit" value="삭제"/>
		<a href="http://localhost:8090/test?cmd=addArticle" >   [게시물추가]</a>
		<a href="http://localhost:8090/test?cmd=logincheck" >   [로그인]</a>
	</form>
	<div>
	</div>
</body>
<!-- 
<h1> 제목
<br> 줄바꿈
<div> 영역 - 여기선 자동줄바꿈됨
<form> uri제조기 (상자만들기?)
<a>링크  <>a쓰고 띄운다음 링크걸면 해당링크로 들어가게됨.
 -->
</html>
