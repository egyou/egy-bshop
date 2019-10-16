<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	for(int i = 0; i < 3; i++) {
%>
<h1>입력하신 아이디는 : <%= request.getParameter("name") %></h1>
<%-- <h1>입력하신 아이디는 : <%= request.getAttribute("name") %></h1>--%> 
<h1>입력하신 아이디는 : ${ requestScope.name }</h1>
<h1>입력하신 암호는 : ${param.password }</h1>
<h1>입력하신 로그인상태는 : ${sessionScope.name }</h1>
<%
	}
%>
<a href="forward.jsp"> forward 로 이동</a>
<%--
<jsp:forward page="forward.jsp"/>
 --%>
</body>
</html>