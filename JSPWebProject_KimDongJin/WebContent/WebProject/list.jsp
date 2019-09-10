<%@ page import="bean.Dao" %>
<%@ page import="bean.productDTO" %>
<%@ page import="bean.categoryDTO" %>
<%@ page import="bean.colorDTO" %>
<%@ page import="java.util.ArrayList" %>
<jsp:include page="header.jsp"></jsp:include>
<%
	Dao dao=Dao.getInstance();
	int no=Integer.parseInt(request.getParameter("no"));
	ArrayList<productDTO> list=dao.productList(no);	
	categoryDTO category=dao.category(no);
%>
	<div id="fh5co-work">
		<div class="container">
			<div class="row top-line animate-box">
				<div class="col-md-12 text-center animate-box">
					<h1><b style="color: red"><%=category.getCategory() %></b></h1>
				</div>
			</div>
			<div class="row">
				<%
				for(productDTO dto:list){
					ArrayList<colorDTO> color=dao.colorList(dto.getNo());
				%>
				<div class="col-md-4 text-center animate-box">
					<a class="work" href="Detail.jsp?no=<%=dto.getNo()%>">
						<div class="work-grid" style="background-image:url(images/<%=dto.getImage()%>)">
							<div class="inner">
								<div class="desc">
								<h3><%=dto.getName() %></h3>
								<span class="cat"><p style="color: NAVY;">Rs.<%=dto.getPrice() %></p></span>
								<div style="display: inline-block;">
									<%for(colorDTO x:color){ %>
									<span style="float:left; width: 18px;height: 18px; background-color: <%=x.getColor() %>; margin: 0 3px 3px 0; border: 1px solid #e3e3e3;"></span>
									<%} %>
								</div>
								</div>
							</div>
						</div>
					</a>
				</div>
				<%} %>
			</div>
		</div>
	</div>
<jsp:include page="footer.jsp"></jsp:include>