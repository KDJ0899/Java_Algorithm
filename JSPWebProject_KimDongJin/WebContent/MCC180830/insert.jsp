<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="Exam.DTO" %>
<%@ page import="Exam.ExamDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dto" class="Exam.DTO"></jsp:useBean>
<jsp:setProperty property="*" name="dto"></jsp:setProperty>
<%
String edu="";
if(request.getParameter("U.G")!=null)
	edu+="U.G ";
if(request.getParameter("P.G")!=null)
	edu+="P.G ";
if(request.getParameter("Doctorate")!=null)
	edu+="Doctorate ";
dto.setEducational(edu);
ExamDao dao=ExamDao.getInstance();
int i=dao.Insert(dto);

%>
<p>success</p>

</body>
</html>