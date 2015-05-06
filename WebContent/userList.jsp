<%@page import="com.samsung.husers.vo.UserVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%ArrayList<UserVO> userList = (ArrayList<UserVO>)request.getAttribute("userList"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 리스트</title>
</head>
<body align="center">
	<h1>회원 목록</h1>
		<table border="1" cellpadding="0" cellspacing="0" width="700" align="center">
			<tr>
				<th bgcolor="orange" width="100">회원번호</th>
				<th bgcolor="orange" width="100">이름</th>
				<th bgcolor="orange" width="150">비밀번호</th>
				<th bgcolor="orange" width="200">이메일</th>
				<th bgcolor="orange" width="100">성별</th>
				<th bgcolor="orange" width="100">나이</th>
			</tr>
			<%
			if(userList.size()==0){%>
				<tr>
					<th colspan="6">가입된 회원이 없습니다</th>
				</tr>
			<%}else{
				for(UserVO user:userList){
				System.out.println("나이: "+user.getAge());
				System.out.println("성별: "+user.getGender());
				%>
				<tr>
					<th width="100"><%=user.getSeq() %></th>
					<th width="100"><%=user.getName() %></th>
					<th width="150"><%=user.getPassword() %></th>
					<th width="200"><%=user.getEmail() %></th>
					<th width="150"><%if(user.getGender()==1){
						%>남자<%
					}else if(user.getGender()==2){
						%>여자<%
					}else{
						%>중...성?<%
					}%></th>
					<th width="100"><%=user.getAge() %></th>
				</tr>
				<%}
			}%>
		</table>
		<br> <a href="index.jsp">첫 페이지로</a>
		<br> <a href="welcome.jsp">회원가입</a>
</body>
</html>