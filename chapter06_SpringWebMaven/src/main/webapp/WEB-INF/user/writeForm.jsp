<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><a href="/chapter06_SpringWebMaven/"><img src="/chapter06_SpringWebMaven/image/1.gif" width="50" height="50"></a>회원 가입</h1>
<form action="/user/write" method="post">
	<table border="1">
		<tr>
			<th width="70">이름</th>
			<td><input type="text" name="name" id="name"></td>
			<div id="nameDiv"></div>
		</tr>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id" id="id"></td>
			<div id="idDiv"></div>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pwd" id="pwd"></td>
			<div id="pwdDiv"></div>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="등록">
				<input type="reset" value="취소">
			</td>
		</tr>
			
	
	</table>

</form>

<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="../js/write.js"></script> -->

</body>
</html>