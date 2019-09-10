<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="bean.Dao" %>
<%@ page import="bean.userDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body style="text-align: center">
<%
	Dao dao=Dao.getInstance();
	String id=request.getParameter("id");
	String password=request.getParameter("password");
	String name=request.getParameter("name");
	String year=request.getParameter("Year");
	String Month=request.getParameter("Month");
	String Day=request.getParameter("Day");
	String phone=request.getParameter("phone");
	String address=request.getParameter("address");
	String question=request.getParameter("ques");
	String answer=request.getParameter("ans");
	String birthDay="";
	
	if(Integer.parseInt(Day)<10)
		Day='0'+Day;
	if(Month.equals("January"))
		birthDay+=year+"01"+Day;
	else if(Month.equals("Feburary"))
		birthDay+=year+"02"+Day;
	else if(Month.equals("March"))
		birthDay+=year+"03"+Day;
	else if(Month.equals("April"))
		birthDay+=year+"04"+Day;
	else if(Month.equals("May"))
		birthDay+=year+"05"+Day;
	else if(Month.equals("June"))
		birthDay+=year+"06"+Day;
	else if(Month.equals("July"))
		birthDay+=year+"07"+Day;
	else if(Month.equals("August"))
		birthDay+=year+"08"+Day;
	else if(Month.equals("Setember"))
		birthDay+=year+"09"+Day;
	else if(Month.equals("October"))
		birthDay+=year+"10"+Day;
	else if(Month.equals("November"))
		birthDay+=year+"11"+Day;
	else 
		birthDay+=year+"12"+Day;
	
	int n=dao.singUp(id, password, name, birthDay, phone,address,question,answer);
	if(n==1){
%>
<div style="border: 2px solid; margin-top: 300px;padding: 50px 50px; width: 500px;margin-left: 650px;">
<h1>Sign Up Success</h1>
<a id=signin href="login.jsp" style="border:1px solid #FF4F57; color: red;\
	font-size: 15px; border-radius: 4px; padding: 10px 14px; font-weight: 700; letter-spacing: 0.5px; background-color: white;"
	onmouseover="signOn()" onmouseout="signOut()">Login Page</a>
</div>
<%} else{ %>
<div style="border: 2px solid; margin-top: 300px;padding: 50px 50px; width: 500px;margin-left: 650px;">
<h1>Sign Up Failed.</h1>
<a id=signin href="signUp.jsp" style="border:1px solid #FF4F57; color: red;\
	font-size: 15px; border-radius: 4px; padding: 10px 14px; font-weight: 700; letter-spacing: 0.5px; background-color: white;"
	onmouseover="signOn()" onmouseout="signOut()">SignUp Page</a>
</div>
<%} %>
<script type="text/javascript">
function signOn() {
	var id=document.getElementById("signin");
	id.style.color="white";
	id.style.backgroundColor="red";
}
function signOut() {
	var id=document.getElementById("signin");
	id.style.color="red";
	id.style.backgroundColor="white";
}
</script>
</body>
</html>