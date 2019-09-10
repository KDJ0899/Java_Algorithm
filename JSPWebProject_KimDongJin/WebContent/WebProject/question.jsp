<jsp:include page="header.jsp"></jsp:include>
<%@ page import="bean.Dao" %>
<%@ page import="bean.userDTO" %>

<%
	String id=request.getParameter("id");
	String name=request.getParameter("name");
	Dao dao=Dao.getInstance();
	userDTO dto=dao.getQuestion(id, name);
	if(dto.getQuestion()==null){%>
		<div style="border: 2px solid; margin-top: 300px;padding: 50px 50px; width: 700px;margin-left: 650px; text-align: center;">
		<h1>The information does not match.</h1>
		<a id=signin href="find.jsp" style="border:1px solid #FF4F57; color: red;\
			font-size: 15px; border-radius: 4px; padding: 10px 14px; font-weight: 700; letter-spacing: 0.5px; background-color: white;"
			onmouseover="signOn()" onmouseout="signOut()">Password Find Page</a>
		</div>
	<%}else{%>
	<form id="signinForm" method="get" name="signinForm" >
		<div class="container">
			<!-- 좌우측의 공간 확보 -->
			<div style="margin-top: 150px;">
				<!-- 본문 들어가는 부분 -->
				<h2 style="text-align: center;">Find Password</h2>
				<div class="form-group" id="divId">
					<label for="inputId" class="col-lg-4 control-label"
						style="text-align: right; ">Question</label>
					<div class="col-lg-8 form-inline">
						<label for="inputId"
						style="text-align: left;font-size: 20px;"><%=dto.getQuestion() %></label>
						<input type="hidden" name="id" value="<%=id%>"> 
					</div>
				</div>
				<div class="form-group" id="divAddress">
					<label for="inputAddress" class="col-lg-4 control-label"
						style="text-align: right; margin-top: 20px">Answer</label>
					<div class="col-lg-8 form-inline" style="margin-top: 20px">
						<input type="tel" class="form-control onlyNumber" id="ans2" name="ans" onchange="ans2Check()"
							data-rule-required="true" placeholder="Answer" value="" required="required"
							maxlength="11" size="50">
						<p id="ans2T" style="color: red; font-size: 20px" ></p>
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
	document.signinForm.action="passwordChange.jsp";
	document.signinForm.submit();
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