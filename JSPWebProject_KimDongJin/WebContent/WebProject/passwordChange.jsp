<jsp:include page="header.jsp"></jsp:include>
<%@ page import="bean.Dao" %>
<%@ page import="bean.userDTO" %>

<%
String id=request.getParameter("id");
String ans=request.getParameter("ans");
Dao dao=Dao.getInstance();
int n=dao.valAnswer(id, ans);
	if(n==0){%>
		<div style="border: 2px solid; margin-top: 300px;padding: 50px 50px; width: 700px;margin-left: 650px; text-align: center;">
	<h1>The answer does not match.</h1>
	<a id=signin href="find.jsp" style="border:1px solid #FF4F57; color: red;\
		font-size: 15px; border-radius: 4px; padding: 10px 14px; font-weight: 700; letter-spacing: 0.5px; background-color: white;"
		onmouseover="signOn()" onmouseout="signOut()">Password Find Page</a>
	</div>
<%}else{%>
	<form id="signinForm" method="get" name="signinForm" >
	<input type="hidden" name="no" value="<%=n %>">
		<div class="container">
			<!-- 좌우측의 공간 확보 -->
			<div style="margin-top: 150px;">
				<!-- 본문 들어가는 부분 -->
				<h2 style="text-align: center;">Password Change</h2>
					<div class="form-group" id="divPassword">
					<label for="inputPassword" class="col-lg-4 control-label"
						style="text-align: right; margin-top: 20px">Password</label>
					<div class="col-lg-8 form-inline" style="margin-top: 20px">
						<input type="password" class="form-control" id="password" onchange="passwor()" value=""
							name="password" data-rule-required="true" placeholder="6~15 Words"
							maxlength="30" size="50">
					<p id="pT" style="color: red; font-size: 20px" ></p>
					</div>
				</div>
				<div class="form-group" id="divPasswordCheck">
					<label for="inputPasswordCheck" class="col-lg-4 control-label"
						style="text-align: right; margin-top: 20px">Re-Password</label>
					<div class="col-lg-8 form-inline" style="margin-top: 20px">
						<input type="password" class="form-control" id="passwordCheck" onchange="passwordChec()"
							data-rule-required="true" placeholder="Re-Password" maxlength="30"
							size="50">
						<p id="pcT" style="color: red; font-size: 20px" ></p>
					</div>
				</div>
				<div class="col-lg-offset-2 col-lg-5">
						<div class="collapse navbar-collapse" id="navbar">
							<ul class="nav navbar-nav navbar-right float-right">
								<li><a id="signin" onclick="Signin()")
									style="border:1px solid #FF4F57; color: red;\
									font-size: 15px; border-radius: 4px; padding: 10px 14px; font-weight: 700; letter-spacing: 0.5px; background-color: white;"
									onmouseover="signOn()" onmouseout="signOut()"> Next</a></li>
							</ul>
						</div>
					</div>
			</div>
		</div>
	</form>

<%} 
%>
<script type="text/javascript">
function Signin() {
	document.signinForm.action="Change.jsp";
	passwor()
	passwordChec()
	 if(document.getElementById("pT").innerHTML!=""||document.getElementById("password").value==""){
			alert("Please check Password.");
		}
		else if(document.getElementById("pcT").innerHTML!=""||document.getElementById("passwordCheck").value=="")
			alert("Passwords are different.");
		else
			document.signinForm.submit();
}
function passwor() {
	var password=document.getElementById("password").value;
	if(password=="")
		document.getElementById("pT").innerHTML="Please Enter Password";
	else if(password.length<6||password.length>15)
		document.getElementById("pT").innerHTML="The length of Password is not correct";
	else
		document.getElementById("pT").innerHTML="";
}
function passwordChec() {
	var passwordCheck=document.getElementById("passwordCheck").value;
	var password=document.getElementById("password").value;
	if(passwordCheck!=password)
		document.getElementById("pcT").innerHTML="Passwords are different.";
	else
		document.getElementById("pcT").innerHTML="";
}
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
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Main -->
	<script src="js/main.js"></script>

</body>
</html>