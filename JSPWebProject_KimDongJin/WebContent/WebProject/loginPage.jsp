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
<jsp:useBean id="u" class="bean.userDTO"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>
<% 
	Dao dao=Dao.getInstance();
	u=dao.login(u);
	if(u.getNo()!=0){
		session.setAttribute("id", u.getId());
		session.setAttribute("no", u.getNo());
		response.sendRedirect("Index.jsp");
	}
	else{
		%><script language="JavaScript">
		alert("Login Failed");
		</script><%
		response.sendRedirect("login.jsp");}
%>

</body>
</html>