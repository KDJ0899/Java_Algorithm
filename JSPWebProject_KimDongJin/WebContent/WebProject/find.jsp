<jsp:include page="header.jsp"></jsp:include>
<form id="signinForm" method="get" name="signinForm" >
		<div class="container">
			<!-- 좌우측의 공간 확보 -->
			<div style="margin-top: 150px;">
				<!-- 본문 들어가는 부분 -->
				<h2 style="text-align: center;">Find Password</h2>
				<div class="form-group" id="divId">
					<label for="inputId" class="col-lg-4 control-label"
						style="text-align: right">ID</label>
					<div class="col-lg-8 form-inline">
						<input type="text" class="form-control onlyAlphabetAndNumber"
							id="id" data-rule-required="true" name="id" onchange="idVal()" value=""
							placeholder="5~30 Alphabet, UnderScore(_), Number." maxlength="30"
							size="50">
						<p id="idT" style="color: red; font-size: 20px" >
						</p>
					</div>
				</div>
				<div class="form-group" id="divName">
					<label for="inputName" class="col-lg-4 control-label"
						style="text-align: right; margin-top: 20px">Name</label>
					<div class="col-lg-8 form-inline" style="margin-top: 20px">
						<input type="text" class="form-control onlyHangul" id="name" name="name" onchange="nameCheck()"
							data-rule-required="true" placeholder="Only Alphabet" value=""
							maxlength="15" size="50">
						<p id="nameT" style="color: red; font-size: 20px" ></p>
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
	<<script type="text/javascript">
	function Signin() {
		document.signinForm.action="question.jsp";
		nameCheck();
		if(document.getElementById("idT").innerHTML!=""/* &&dupl==1 */){
			alert("Please check ID.");
			}
		else if(document.getElementById("nameT").innerHTML!=""||document.getElementById("name").value=="")
			alert("Please check Name.");
		else
			document.signinForm.submit();
	}
	function idVal() {
		var id=document.getElementById("id").value;
		var arr=id.split("");
		if(id=="")
			document.getElementById("idT").innerHTML="Please Enter ID";
		else if(id.length<5||id.length>30)
			document.getElementById("idT").innerHTML="The length of ID is not correct";
		else
			for(i=0;i<arr.length;i++){
				if((arr[i]<'a'||arr[i]>'z')&&arr[i]!='_'&&(arr[i]<'A'||arr[i]>'Z')&&(arr[i]<'0'||arr[i]>'9')){
					document.getElementById("idT").innerHTML="The ID does not meet the requirements.";
					break;
				}
				else
					document.getElementById("idT").innerHTML="";
			}
	}
	function nameCheck(){
		var name=document.getElementById("name").value;
		var arr=name.split("");
		if(name=="")
			document.getElementById("nameT").innerHTML="Please Enter Name"
			else
				for(i=0;i<arr.length;i++){
					if((arr[i]<'a'||arr[i]>'z')&&(arr[i]<'A'||arr[i]>'Z')){
						document.getElementById("nameT").innerHTML="Only Alphabet."
						break;
					}
					else
						document.getElementById("nameT").innerHTML="";
				}
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