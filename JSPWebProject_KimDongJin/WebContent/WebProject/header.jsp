<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Mister Street</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Website Template by FreeHTML5.co" />
	<meta name="keywords" content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
	<meta name="author" content="FreeHTML5.co" />

	<!-- <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet"> -->
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<!-- Theme style  -->
	<link rel="stylesheet" href="css/style.css">

	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
</head>
<body>
		
	<div class="fh5co-loader"></div>
	
	<div id="page">
	<nav class="fh5co-nav" role="navigation">
		<div class="container">
			<div class="fh5co-top-logo">
				<div id="fh5co-logo"><a href="Index.jsp">Mister Street</a></div>
			</div>
			<div class="fh5co-top-menu menu-1 text-center">
				<ul>
					<li><a href="list.jsp?no=1">T-shirts</a></li>
					<li><a href="list.jsp?no=2">Shirts</a></li>
					<li><a href="list.jsp?no=3">Pants</a></li>
					<li><a href="list.jsp?no=4">Outer</a></li>
					<%if(session.getAttribute("no")!=null){ %>
					<li class="has-dropdown">
						<a href="#">My Page</a>
						<ul class="dropdown" style="display: none;">
							<li><a href="orderList.jsp">Order List</a></li>
							<li><a href="cart.jsp">Cart</a></li>
							<li><a href="info.jsp">My Information</a></li>
						</ul>
					</li>
					<%} %>
				</ul>
			</div>
			<div class="fh5co-top-social menu-1 text-right">
			
			<%if(session.getAttribute("id")==null){ %>
			<b style="position:relative;top:4px; margin-right: 20px;">Please Login</b>
				<a id="login"href="login.jsp" style="border:1px solid #FF4F57; color: red; margin-top:20px; position:relative;top:5px;\
				font-size: 15px; border-radius: 4px; padding: 10px 14px; font-weight: 700; letter-spacing: 0.5px; background-color: #edebe8;"
				onmouseover="mouseOn()" onmouseout="mouseOut()">Log In</a>
				<%}else{ %>
				<b style="position:relative;top:4px; margin-right: 20px;">Weclome <%=session.getAttribute("id") %></b>
				<a id="login"href="logout.jsp" style="border:1px solid #FF4F57; color: red; margin-top:20px; position:relative;top:5px;\
				font-size: 15px; border-radius: 4px; padding: 10px 14px; font-weight: 700; letter-spacing: 0.5px; background-color: #edebe8;"
				onmouseover="mouseOn()" onmouseout="mouseOut()">Log Out</a>
				<%} %>
			</div>
		</div>
	</nav>
<script type="text/javascript">
function mouseOn() {
	var id=document.getElementById("login");
	id.style.color="white";
	id.style.backgroundColor="red";
}
function mouseOut() {
	var id=document.getElementById("login");
	id.style.color="red";
	id.style.backgroundColor="#edebe8";
}
</script>
</body>
</html>