<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가입을 환영합니다</title>
</head>
<body>
	<h2 align="center">우리는 환영한다 당신의 가입을!</h2>
	<form action="registerUser" method="post">
		<table border="1" align="center" style="border-style: outset;">
			<tr align="center">
				<td width="80px">이름</td>
				<td><input type="text" name="registerName" required></td>
			</tr>			
			<tr align="center">
				<td>암호</td>
				<td><input type="password" name="registerPassword" required></td>
			</tr>			
			<tr align="center">
				<td>email</td>
				<td><input type="email" name="registerEmail" required></td>
			</tr>			
			<tr align="center">
				<td>성별</td>
				<td>
					<select name="registerGender">
						<option value="1">남</option>
						<option value="2">여</option>
						<option value="0">그외</option>
					</select>
				</td>
			</tr>			
			<tr align="center">
				<td>나이</td>
				<td><input type="number" name="registerAge" min="0" max="150" step="1" required></td>
			</tr>
			<tr align="center">
				<td colspan="2"><button type="submit">가입</button> <button type="reset">초기화</button></td>
			</tr>			
			<tr align="center">
				<td colspan="2"><a href="index.jsp">초기화면</a> <a href="userList">회원 리스트</a></td> 
			</tr>
		</table>		
	</form>
</body>
</html>