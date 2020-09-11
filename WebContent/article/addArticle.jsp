<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<h1> 게시물 추가 </h1>
<form action="test?cmd=add">
제목 입력 : <input type="text" name="title"><br>
내용 입력 : <input type="text" name="body"><br>
작성자 입력 : <input type="text" name="nickname"><br>
<input type="hidden" name="cmd" value="add">
<input type="submit">
</form>
</div>
</body>
</html>