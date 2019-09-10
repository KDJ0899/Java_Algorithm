<jsp:include page="header.jsp"></jsp:include>
<form id="loginForm" method="get" name="loginForm" >
<div style="width: 500px; margin: 30px auto;margin-top: 200px; border: 2px solid; padding: 70px 50px; border-radius: 10px;">
        <h2 class="text-center"><b>Login</b></h2>   
        <div class="form-group">
        	<div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                <input type="text" id="id" class="form-control" name="id" placeholder="Username" required="required">				
            </div>
        </div>
		<div class="form-group">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                <input type="password" id="password" class="form-control" name="password" placeholder="Password" required="required">				
            </div>
        </div>        
        <div class="form-group">
            <a class="btn btn-primary login-btn btn-block" onclick="login()">Login</a>
        </div>
        <div class="form-group">
            <a href="signUp.jsp" class="btn btn-primary login-btn btn-block">Sign up</a>
        </div>
        
        <div class="form-group">
            <a href="find.jsp" class="btn btn-primary login-btn btn-block">Forgot Password?</a>
        </div>
    </div>
  </form>
    <script type="text/javascript">
	function login() {
		document.loginForm.action="loginPage.jsp";
		if(document.getElementById("id").value==""){
			alert("Please check ID.");
			}
		else if(document.getElementById("password").value=="")
			alert("Please check Password.");
		else
			document.loginForm.submit();
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