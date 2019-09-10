<jsp:include page="header.jsp"></jsp:include>
<%@ page import="bean.Dao" %>
<%@ page import="bean.userDTO" %>
<%
	Dao dao=Dao.getInstance();
	userDTO dto=dao.getUser(Integer.parseInt(session.getAttribute("no").toString()));
%>
	<div class="container">
			<div class="row top-line animate-box" style="text-align: center; ">
				<h2 style="margin-top: 40px;"><%=session.getAttribute("id") %>'s Information</h2>
				
				<div class="form-group" id="divBirthday">
					<label for="inputName" class="col-lg-4 control-label"
						style="text-align: right; margin-top: 20px">Name: </label>
					<label for="inputName" class="col-lg-8 control-label"
						style="text-align: left; margin-top: 20px"><%=dto.getName() %></label>
				</div>
				
				<div class="form-group" id="divBirthday">
					<label for="inputName" class="col-lg-4 control-label"
						style="text-align: right; margin-top: 20px">Birthday:</label>
					<label for="inputName" class="col-lg-8 control-label"
						style="text-align: left; margin-top: 20px"><%=dto.getBirthday() %></label>
				</div>

				<div class="form-group" id="divAddress">
					<label for="inputAddress" class="col-lg-4 control-label"
						style="text-align: right; margin-top: 20px">Address:</label>
					<label for="inputName" class="col-lg-8 control-label"
						style="text-align: left; margin-top: 20px"><%=dto.getAddress() %></label>
				</div>
				
				<div class="form-group" id="divPhoneNumber">
					<label for="inputPhoneNumber" class="col-lg-4 control-label"
						style="text-align: right; margin-top: 20px">Phone Number:</label>
					<label for="inputName" class="col-lg-8 control-label"
						style="text-align: left; margin-top: 20px"><%=dto.getPhoneNumber() %></label>
				</div>
			</div>
	</div>
<jsp:include page="footer.jsp"></jsp:include>