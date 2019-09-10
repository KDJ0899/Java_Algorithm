<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="insert.jsp" method="get" name="submitForm">
<table border="1">
	<tr>
	<td>Id</td><td><input type="text" name="id" id="id"></td>
	</tr>
	<tr>
	<td>Name</td><td><input type="text" name="name" id="name"></td>
	</tr>
	<tr>
	<td>Sex</td>
	<td><input type="radio" name="se" checked="checked" onclick="ClickSex('Male')">Male<input type="radio" name="se" onclick="ClickSex('Female')">Female
	<input type="hidden" name="sex" value="Male" id="sex"></td>
	</tr>
	<tr>
	<td>Address</td><td><textarea name="address" id="address"></textarea></td>
	</tr>
	<tr>
	<td>Marital Status</td>
	<td><input type="radio" name="status" checked="checked" onclick="ClickStatus('Single')">Single<input type="radio" name="status" onclick="ClickStatus('Married')">Married
	<input type="radio" name="status"  onclick="ClickStatus('Divorced')">Divorced <input type="hidden" name="marital_status" value="Single" id="Marital_status"></td></td>
	</tr>
	<tr>
	<td>Educational Qualification</td><td><input type="checkbox" name="U.G" value="U.G">U.G<input type="checkbox" name="P.G">P.G<input type="checkbox" name="Doctorate">Doctorate</td>
	</tr>
	<tr>
	<td><input type="button" onclick="Sub()" value="Submit"><input type="button" onclick="del()" value="Delete"></td><td><input type="reset" value="Clear"></td>
</table>
</form>
<script type="text/javascript">
function Sub() {
	if(document.getElementById("id").value=="")
		alert("Enter the ID");
	else if(document.getElementById("name").value=="")
		alert("Enter the Name");
	else if(document.getElementById("address").value=="")
		alert("Enter the Address");
	else
 		document.submitForm.submit();
}

function del() {
	if(document.getElementById("id").value=="")
		alert("Enter the ID");
	else{
		document.submitForm.action="Delete.jsp";
		document.submitForm.submit();
	}
}
function ClickSex(s){
	document.getElementById("sex").value=s;
}
function ClickStatus(s) {
	document.getElementById("Marital_status").value=s;
	
}
</script>
</body>
</html>