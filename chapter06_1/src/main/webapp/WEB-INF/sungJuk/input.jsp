<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/chapter06_1/sungJuk/result.do" method="post">
	<table border="1">
		<tr>
			<th width="70">이름</th>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<th>국어</th>
			<td><input type="text" name="kor"></td>
		</tr>
		<tr>
			<th>영어</th>
			<td><input type="text" name="eng"></td>
		</tr>
		<tr>
			<th>수학</th>
			<td><input type="text" name="math"></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="계산">
				<input type="reset" value="다시 작성">
			</td>
		</tr>
	</table>


</form>

</body>
</html>