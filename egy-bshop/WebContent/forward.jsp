<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${param.name }</h1> <%-- request.getParameter("name") --%>
<h1>${requestScope.name }</h1> <%-- request.getAttribute("name") --%> 
<h1>${sessionScope.name }</h1> <%-- session.getAttribute("name") --%>
</body>
</html>