<jsp:include page="header.jsp"></jsp:include>
<%@ page import="bean.Dao" %>
<%@ page import="bean.productDTO" %>
<%@ page import="bean.cartDTO" %>
<%@ page import="java.util.ArrayList" %>

<div class="well well-small">
<%
Dao dao=Dao.getInstance();
ArrayList<cartDTO> dto=dao.cartlist(Integer.parseInt(session.getAttribute("no").toString()), 2);
int sum=0;
%>
		<h1>Check Out <small class="pull-right"> <%=dto.size() %> Items are in the cart </small></h1>
	<hr class="soften">	

	<table class="table table-bordered table-condensed">
              <thead>
                <tr>
                  <th>Product</th>
                  <th>Description</th>
                  <th>Date</th>
                  <th>Unit price</th>
                  <th>Qty </th>
                  <th>Total</th>
				</tr>
              </thead>
              <tbody>
              <%for(int i=0;i<dto.size();i++){
              sum+=Integer.parseInt(dto.get(i).getPrice())*(dto.get(i).getAmount());%>
                <tr>
                  <td style="width: 200px;"><img width="200" height="200" src="images/<%=dto.get(i).getImage() %>" alt=""></td>
                  <td style="font-weight: bold; text-align: center; font-size: 20px;" ><%=dto.get(i).getName() %><br><%=dto.get(i).getColor() %><br><%=dto.get(i).getSize() %></td>
                  <td style="font-weight: bold; font-size: 20px;"><%=dto.get(0).getO_Date() %></td>
                  <td style="font-weight: bold; font-size: 20px;">Rs.<%=dto.get(i).getPrice() %></td>
                  <td>
					<p style='position: relative; width: 60px; height: 22px; padding: 0 5px; float: left; font-size: 20px; border-radius: 4px;'>
						<%=dto.get(i).getAmount() %> 
					</p>
				</td>
                  <td style="font-weight: bold; font-size: 20px;" >Rs. <b id="price<%=i%>"><%=Integer.parseInt(dto.get(i).getPrice())*dto.get(i).getAmount()%></b></td>
                </tr>
                <%} %>
                <tr>
                  <td colspan="5" class="alignR" style="font-size: 20px;">Total products:	</td>
                  <td style="font-size: 20px;"> Rs.<b id="price"><%=sum %></b></td>
                </tr>
				</tbody>
            </table><br>
			<div style="text-align: center;">
			</div>
	</div>
<script>
</script>
<jsp:include page="footer.jsp"></jsp:include>