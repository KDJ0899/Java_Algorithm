<jsp:include page="header.jsp"></jsp:include>
<%@ page import="bean.Dao" %>
<%@ page import="bean.productDTO" %>
<%@ page import="bean.cartDTO" %>
<%@ page import="java.util.ArrayList" %>
<div class="well well-small">
<%
Dao dao=Dao.getInstance();
ArrayList<cartDTO> dto=dao.cartlist(Integer.parseInt(session.getAttribute("no").toString()), 1);
int sum=0;
%>
		<h1>Check Out <small class="pull-right"> <%=dto.size() %> Items are in the cart </small></h1>
	<hr class="soften">	
	<form id="order" method="get" name="order">
	<input type="hidden" name="size" value="<%=dto.size()%>">
	<input type="hidden" name="cart_no" id="cart_no" value="">
	<table class="table table-bordered table-condensed">
              <thead>
                <tr>
                  <th>Product</th>
                  <th>Description</th>
                  <th>Avail.</th>
                  <th>Unit price</th>
                  <th>Qty </th>
                  <th>Total</th>
				</tr>
              </thead>
              <tbody id="here">
              <%for(int i=0;i<dto.size();i++){
              sum+=Integer.parseInt(dto.get(i).getPrice());%>
                <tr>
                  <td style="width: 200px;"><img width="200" height="200" src="images/<%=dto.get(i).getImage() %>" alt=""></td>
                  <td style="font-weight: bold; text-align: center; font-size: 20px;" ><%=dto.get(i).getName() %><br><%=dto.get(i).getColor() %><br><%=dto.get(i).getSize() %></td>
                  <td><span class="shopBtn"><span class="icon-ok"></span></span> </td>
                  <td style="font-weight: bold; font-size: 20px;">Rs.<%=dto.get(i).getPrice() %></td>
                  <td>
                  <input type="hidden" id="cart_no<%=i %>"name="cart_no<%=i %>" value="<%=dto.get(i).getNo()%>">
					<span>
						<input type='text' id='amount<%=i%>'name='amount<%=i%>' onchange='change(<%=i %>,<%=dto.get(i).getPrice() %>)'
						style='position: relative; left: 30px; width: 60px; height: 22px; padding: 0 5px; float: left; font-size: 20px; border-radius: 4px;' 
						value='<%=dto.get(i).getAmount()%>'>
						<a href='#none'>
						<img src='//img.echosting.cafe24.com/design/skin/default/product/btn_count_up.gif' id='option_box"+id.rows.length+"_up' onclick='up(<%=i %>,<%=dto.get(i).getPrice() %>)'
						style='position: relative; left: 36px; float: left;' alt='수량증가'></a>
						<a href='#none'>
						<img src='//img.echosting.cafe24.com/design/skin/default/product/btn_count_down.gif'id='option_box"+id.rows.length+"_down' onclick='down(<%=i %>,<%=dto.get(i).getPrice() %>)'
						style='position: relative; top: 10px; left: 15px; float: left;'alt='수량감소'></a>
						<a href='#none'>
						<img src='//img.echosting.cafe24.com/design/skin/default/product/btn_price_delete.gif'
						style='    position: relative; top: 5px; left: 20px;border-radius: 4px;'alt='삭제' id='option_box_del' onclick='del(this,<%=i%>)'></a>
						</span>
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
			<a onclick="ord()">
			<span style=" font-size: 20px;padding: 10px 30px;  border: 2px solid #000000; font-weight:  bold; color:white; background-color: black">Order</span>
			</a>
			</div>
			</form>
	</div>
	
<script>
function up(no,p) {
	var priceid="price"+no;
	var boxid="amount"+no;
	var box=document.getElementById(boxid);
	var price=document.getElementById(priceid);
	var total=document.getElementById("price");
	var sum=parseInt(price.innerHTML)+parseInt(p);
	price.innerHTML=sum;
	var sum=parseInt(total.innerHTML)+parseInt(p);
	total.innerHTML=sum;
	box.value=parseInt(box.value)+1;
}
function down(no,p) {
	var priceid="price"+no;
	var boxid="amount"+no;
	var box=document.getElementById(boxid);
	if(box.value==1){
		alert("Minimum order quantity is 1!!");
		return;
	}
	var price=document.getElementById(priceid);
	var total=document.getElementById("price");
	var sum=parseInt(price.innerHTML)-parseInt(p);
	price.innerHTML=sum;
	var sum=parseInt(total.innerHTML)-parseInt(p);
	total.innerHTML=sum;
	box.value=parseInt(box.value)-1;
}
function change(no,p) {
	var priceid="price"+no;
	var boxid="amount"+no;
	var box=document.getElementById(boxid);
	var price=document.getElementById(priceid);
	var total=document.getElementById("price");
	total.innerHTML=parseInt(total.innerHTML)-parseInt(price.innerHTML);
	var sum=parseInt(p)*parseInt(box.value);
	price.innerHTML=sum;
	var sum=sum+parseInt(total.innerHTML);
	total.innerHTML=sum;
}
function ord() {
		var id=document.getElementById("here");
		if(<%=dto.size()%><1){
			alert("Please add products in Cart!");
			return;
		}
		document.order.action="orderUpdate.jsp";
		document.order.submit();
}
function del(obj,no) {
   /*  var tr = $(obj).parent().parent().parent().parent();
	var i=0;
	var priceid="price"+no;
	var price=document.getElementById(priceid);
	var total=document.getElementById("price");
	total.innerHTML=parseInt(total.innerHTML)-parseInt(price.innerHTML);


    //라인 삭제
    tr.remove(); */
    var cart=document.getElementById("cart_no"+no).value;
    document.getElementById("cart_no").value=cart;
	document.order.action="delete.jsp";
	document.order.submit();
}
</script>
<jsp:include page="footer.jsp"></jsp:include>