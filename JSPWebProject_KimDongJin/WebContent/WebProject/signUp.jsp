<jsp:include page="header.jsp"></jsp:include>
<form id="signinForm" method="get" name="signinForm" >
		<div class="container">
			<!-- 좌우측의 공간 확보 -->
			<div >
				<!-- 본문 들어가는 부분 -->
				<div class="form-group" id="divId">
					<label for="inputId" class="col-lg-4 control-label"
						style="text-align: right">ID</label>
					<div class="col-lg-8 form-inline">
						<input type="text" class="form-control onlyAlphabetAndNumber"
							id="id" data-rule-required="true" name="id" onchange="idVal()" value=""
							placeholder="5~30 Alphabet, UnderScore(_), Number." maxlength="30"
							size="50">
					<!-- 	<input type="button" value="Dupl" onclick="IdChk()"> -->
						<p id="idT" style="color: red; font-size: 20px" >
						<%-- <c:if test="${dupl==0 }">
						<font color="green">사용가능한 아이디</font>
						</c:if>
						<c:if test="${dupl==1 }">
						중복된 아이디 입니다.
						</c:if> --%>
						</p>
					</div>
				</div>
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
				<div class="form-group" id="divBirthday">
					<label for="inputName" class="col-lg-4 control-label"
						style="text-align: right; margin-top: 20px">Birthday</label>
					<div class="col-lg-8 form-inline" style="margin-top: 20px">
						<select name="Year" class="form-control" onfocus="${Year}">
							<%
								for (int i = 0; i < 30; i++) {
							%><option><%=1980 + i%></option>
							<%
								}
							%>
						</select> <select name="Month" class="form-control">
							<option>January</option>
							<option>Feburary</option>
							<option>March</option>
							<option>April</option>
							<option>May</option>
							<option>June</option>
							<option>July</option>
							<option>August</option>
							<option>Setember</option>
							<option>October</option>
							<option>November</option>
							<option>December</option>
						</select> <select name="Day" class="form-control" >
							<%
								for (int i = 1; i < 32; i++) {
							%><option><%=i%></option>
							<%
								}
							%>
						</select>
					</div>
				</div>

				<div class="form-group" id="divAddress">
					<label for="inputAddress" class="col-lg-4 control-label"
						style="text-align: right; margin-top: 20px">Address</label>
					<div class="col-lg-8 form-inline" style="margin-top: 20px">
						<input type="tel" class="form-control onlyNumber" id="address" name="address" onchange="addressCheck()"
							data-rule-required="true" placeholder="Address" value=""
							maxlength="11" size="50">
						<p id="addressT" style="color: red; font-size: 20px" ></p>
					</div>
				</div>
				
				<div class="form-group" id="divPhoneNumber">
					<label for="inputPhoneNumber" class="col-lg-4 control-label"
						style="text-align: right; margin-top: 20px">Phone Number</label>
					<div class="col-lg-8 form-inline" style="margin-top: 20px">
						<input type="tel" class="form-control onlyNumber" id="phoneNumber" name=phone onchange="phoneCheck()"
							data-rule-required="true" placeholder="Only Number" value=""
							maxlength="11" size="50">
						<p id="phoneT" style="color: red; font-size: 20px" ></p>
					</div>
				</div>
				<div class="form-group" id="divAddress">
					<label for="inputAddress" class="col-lg-4 control-label"
						style="text-align: right; margin-top: 20px">Question</label>
					<div class="col-lg-8 form-inline" style="margin-top: 20px">
						<input type="tel" class="form-control onlyNumber" id="ans1" name="ques" onchange="ans1Check()"
							data-rule-required="true" placeholder="Qustion" value=""
							maxlength="11" size="50" required="required">
						<p id="ans1T" style="color: red; font-size: 20px" ></p>
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
				<div class="form-group navbar-default main-navigation">
					<div class="col-lg-offset-2 col-lg-5">
						<div class="collapse navbar-collapse" id="navbar">
							<ul class="nav navbar-nav navbar-right float-right">
								<li><a id="signin" onclick="Signin()")
									style="border:1px solid #FF4F57; color: red;\
									font-size: 15px; border-radius: 4px; padding: 10px 14px; font-weight: 700; letter-spacing: 0.5px; background-color: white;"
									onmouseover="signOn()" onmouseout="signOut()"> Sign Up</a></li>
							</ul>
						</div>
					</div>
					<div class="col-lg-offset-5"></div>
				</div>
			</div>
		</div>
	</form>
	<script type="text/javascript">
	function Signin() {
		document.signinForm.action="signUPpage.jsp";
		passwor();
		passwordChec();
		nameCheck();
		phoneCheck();
		addressCheck();
		ans1Check();
		ans2Check();
		if(document.getElementById("idT").innerHTML!=""/* &&dupl==1 */){
			alert("Please check ID.");
			}
		/* else if(dupl!=0||document.getElementById("idT").innerHTML=="")
			alert("Please check ID duplication.");*/
		else if(document.getElementById("pT").innerHTML!=""||document.getElementById("password").value==""){
			alert("Please check Password.");
		}
		else if(document.getElementById("pcT").innerHTML!=""||document.getElementById("passwordCheck").value=="")
			alert("Passwords are different.");
		else if(document.getElementById("nameT").innerHTML!=""||document.getElementById("name").value=="")
			alert("Please check Name.");
		else if(document.getElementById("phoneT").innerHTML!=""||document.getElementById("phoneNumber").value=="")
			alert("Please check Phone Number.");
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
	function addressCheck() {
		var address=document.getElementById("address").value;
		var arr=address.split("");
		if(address=="")
			document.getElementById("addressT").innerHTML="Please Enter Address"
		else
			document.getElementById("addressT").innerHTML="";
	}
	function phoneCheck() {
		var Phone=document.getElementById("phoneNumber").value;
		var arr=Phone.split("");
		if(Phone=="")
			document.getElementById("phoneT").innerHTML="Please Enter Phone Number"
		else
			for(i=0;i<arr.length;i++){
				if(arr[i]<'0'||arr[i]>'9'){
					document.getElementById("phoneT").innerHTML="Only Number."
					break;
				}
				else
					document.getElementById("phoneT").innerHTML="";
			}
	}
	function IdChk(){
		var id=document.getElementById("id").value;
		var arr=id.split("");
		if(id=="")
			alert("Please Check ID.");
		else if(id.length<5||id.length>30)
			alert("Please Check ID.");
		else
			for(i=0;i<arr.length;i++){
				if((arr[i]<'a'||arr[i]>'z')&&arr[i]!='_'&&(arr[i]<'A'||arr[i]>'Z')&&(arr[i]<'0'||arr[i]>'9')){
					alert("Please Check ID.");
					break;
				}
				else{
					document.signinForm.action="/User/IdCheck";
					document.signinForm.submit();
				}
			}
	}
	function ans1Check() {
		var address=document.getElementById("ans1").value;
		var arr=address.split("");
		if(address=="")
			document.getElementById("ans1T").innerHTML="Please Enter Question"
		else
			document.getElementById("ans1T").innerHTML="";
	}
	function ans2Check() {
		var address=document.getElementById("ans2").value;
		var arr=address.split("");
		if(address=="")
			document.getElementById("ans2T").innerHTML="Please Enter Answer"
		else
			document.getElementById("ans2T").innerHTML="";
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