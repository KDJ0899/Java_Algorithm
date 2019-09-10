<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="Exam.ExamDao" %>
    <%@ page import="Exam.DTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
String id=request.getParameter("id");
ExamDao dao=ExamDao.getInstance();
dao.Delete(id);
ArrayList<DTO> list=dao.select();
%>
<table border="1"> 
<tr>
<td>id</td><td>name</td><td>sex</td><td>addres</td><td>Marital status</td><td>Educational Qqualification</td>
</tr>
<%
for(int i=0;i<list.size();i++){
%><tr><td><%=list.get(i).getId() %></td><td><%=list.get(i).getName() %></td><td><%=list.get(i).getSex() %></td><td><%=list.get(i).getAddress() %></td>
<td><%=list.get(i).getEducational() %></td><td><%=list.get(i).getMarital_status() %></td></tr>

<%} %>
</table>
</body>
</html>