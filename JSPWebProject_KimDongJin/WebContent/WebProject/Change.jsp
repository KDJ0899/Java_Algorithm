<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="bean.Dao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% 
	int no=Integer.parseInt(request.getParameter("no"));
	String password=request.getParameter("password");
	Dao dao=Dao.getInstance();
	int n=dao.changePassword(no,password);
	response.sendRedirect("login.jsp");
%>
</body>
</html>