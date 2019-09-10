<%@ page import="bean.Dao" %>
<%@ page import="bean.productDTO" %>
<%@ page import="bean.colorDTO" %>
<%@ page import="bean.sizeDTO" %>
<%@ page import="bean.cartDTO" %>
<%@ page import="java.util.ArrayList" %>
<%
	int no=Integer.parseInt(request.getParameter("no"));
	Dao dao=Dao.getInstance();
	productDTO dto=dao.productDetail(no);
	ArrayList<colorDTO> color=dao.colorList(no);
	ArrayList<sizeDTO>	size=dao.sizerList(no);	
	ArrayList<cartDTO> cart;
	
%>
<jsp:include page="header.jsp"></jsp:include>
<form id="order" method="post" name="order" >
<input type="hidden" id="dist" name="dist" value="">
<div id="fh5co-author">
		<div class="container">
			<div class="row top-line animate-box">
			<div class="col-md-4">
			<img alt="" src="images/<%=dto.getImage()%>" style="width: 500px; height: 700px;">
			</div>
				<div class="col-md-6  col-md-push-2  fh5co-heading text-center" style="line-height: 80px;" >
					<h2><%=dto.getName() %></h2>
						<table id="tb">
						<tr>
						<th scope="row" class="col-md-2" style="font-size: 25px; font-weight: bold; border-bottom: 1px solid #eaeaea; ">Price</th>
						<td class="col-md-3" style="font-size: 25px; font-weight: bold; color: black; border-bottom: 1px solid #eaeaea;">Rs.<%=dto.getPrice() %></td>
						</tr>
						<tr>
						<th scope="row" class="col-md-2" style="font-size: 25px; font-weight: bold; border-bottom: 1px solid #eaeaea; vertical-align: top;">Color</th>
						<td class="col-md-3" style=" border-bottom: 1px solid #eaeaea;">
						<%for(int i=0;i<color.size();i++){ 
						%>
						<a href="#"><span id="c<%=i %>" style=" font-size:25px;font-weight: bold; float:left;color: black; margin: 0 50px 10px 0; " onclick="color('<%=color.get(i).getColor()%>','<%=i%>')"><%=color.get(i).getColor()%> </span></a>  
						<%} %>
						<input type="hidden" id="col" value=""/>
						<input type="hidden" id="colorIndex" value=""/>
						
						</td>
						</tr>
						<tr>
						<th scope="row" class="col-md-2" style="font-size: 25px; font-weight: bold; border-bottom: 1px solid #eaeaea; vertical-align: top;">Size</th>
						<td class="col-md-3" style=" border-bottom: 1px solid #eaeaea; ">
						<%for(int i=0;i<size.size();i++){ 
						%>
						<a href="#"><span id="s<%=i %>" style=" font-size:25px;font-weight: bold; float:left;color: black; margin: 0 50px 10px 0;" onclick="size('<%=size.get(i).getSize()%>','<%=i%>')"><%=size.get(i).getSize()%></span></a>  
						<%} %>				
						</td>
						</tr>
						</table>
						<table>
						<colgroup>
							<col style="width:*%;">
							<col style="width:25%;">
							<col style="width:10%;">
							<col style="width:10%;">
							<col style="width:15%;">
						</colgroup>
						<tbody id="here">
						</tbody>
						<tr>
							<th colspan="3" scope="row" style="float: right;font-size: 25px; font-weight: bold;">Total. Rs <font color="blue" id="price" >0</font></th>
						</tr>
						</table>
						<a style="float: left;margin-left: 100px;" onclick="ord()">
							<span style=" font-size: 20px;padding: 0 20px;  border: 2px solid #000000; font-weight:  bold; color:white; background-color: black">Order</span>
						</a>
						<a style="float: left; margin-left: 100px;" onclick="cart()">
							<span style="font-size: 20px; padding: 0 20px; border: 2px solid #000000; font-weight: bold;color: black;">Cart</span>
							<input type="hidden" id="num" name="num" value="">
							<input type="hidden" id="no" name="no" value="<%=dto.getNo()%>">
						</a>
				</div>
			</div>
		<!-- 	<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<p class="animate-box"><img src="images/project-7.jpg" class="img-responsive" alt="Free HTML5 Template by FreeHTML5.co"></p>
					<p class="animate-box"><img src="images/project-6.jpg" class="img-responsive" alt="Free HTML5 Template by FreeHTML5.co"></p>

					<div class="testimony animate-box">
						<blockquote>
							<p>&ldquo;Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove&rdquo;</p>
							<p class="person"><cite>&mdash; Job Smith</cite> CEO and Founder</p>
						</blockquote>
					</div>
					<p class="animate-box"><img src="images/project-5.jpg" class="img-responsive" alt="Free HTML5 Template by FreeHTML5.co"></p>
					<p class="animate-box"><img src="images/project-3.jpg" class="img-responsive" alt="Free HTML5 Template by FreeHTML5.co"></p>
				

					<div class="row row-pt-md portfolio-navigation">
						<div class="col-xs-4 text-left">
							<a href="#" class="btn btn-primary btn-outline"><i class="icon-chevron-left"></i> Prev </a>
						</div>
						<div class="col-xs-4 text-center">
							<a href="#" class="btn btn-primary btn-outline"><i class="icon-grid2"></i> View All</a>
						</div>
						<div class="col-xs-4 text-right">
							<a href="#" class="btn btn-primary btn-outline">Next <i class="icon-chevron-right"></i></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="fh5co-started">
		<div class="container">
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
					<h2>Get Started</h2>
					<p>We create beautiful themes for your site behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
					<p><a href="#" class="btn btn-primary">Let's work together</a></p>
				</div>
			</div>
		</div>
	</div> -->
			</div>
		</div>
</form>
	<script>
	var dupl= new Array();
	for(var i=0;i<<%=color.size()%>;i++)
		dupl[i]=new Array();
	function color(c,i) {
		var color=document.getElementById("col");
		var index=document.getElementById("colorIndex");
		var button=document.getElementById("c"+i);
		for(var j=0;j<<%=color.size()%>;j++){
			if(j==i)
				button.setAttribute("class", "selected");
			else
				document.getElementById("c"+j).setAttribute("class", "");
		}
		for(var j=0;j<<%=size.size()%>;j++){
				document.getElementById("s"+j).setAttribute("class", "");
		}
		color.value=c;
		index.value=i;
	}
	function size(s,i) {
		var id=document.getElementById("here");
		var price=document.getElementById("price");
		var color=document.getElementById("col");
		if(color.value==""){
			alert("Please select Color!!");
			return;
		}
		var colorIndex=document.getElementById("colorIndex").value;
		for(var j=0;j<<%=size.size()%>;j++){
			if(j==i)
				document.getElementById("s"+j).setAttribute("class", "selected");
			else
				document.getElementById("s"+j).setAttribute("class", "");
		}
		if (dupl[colorIndex][i]=='1'){
			alert("Already Seleted");
			return;
		}
		else{
			dupl[colorIndex][i]='1';
		}
		var sum=parseInt(price.innerHTML)+parseInt(<%=dto.getPrice()%>);
		price.innerHTML=sum;
		var row=id.insertRow(id.rows.length).innerHTML=
			"<tr id='row"+id.rows.length+"'style='font-size: 25px;' ><td style='font-size: 20px; border-bottom: 1px solid #eaeaea;'><%=dto.getName()%></td>\
			<td style='border-bottom: 1px solid #eaeaea;'>\
			<span>\
			<input type='text' id='option_box"+id.rows.length+"'name='amount"+id.rows.length+"' onchange='change("+id.rows.length+")'\
			style='position: relative; left: 30px; width: 40px; height: 22px; padding: 0 5px; float: left;' \
			value='1'>\
			<a href='#none'>\
			<img src='//img.echosting.cafe24.com/design/skin/default/product/btn_count_up.gif' id='option_box"+id.rows.length+"_up' onclick='up("+id.rows.length+")'\
			style='position: relative; left: 36px; float: left;' alt='수량증가'></a>\
			<a href='#none'>\
			<img src='//img.echosting.cafe24.com/design/skin/default/product/btn_count_down.gif'id='option_box"+id.rows.length+"_down' onclick='down("+id.rows.length+")'\
			style='position: relative; top: 10px; left: 15px; float: left;'alt='수량감소'></a>\
			<a href='#none'>\
			<img src='//img.echosting.cafe24.com/design/skin/default/product/btn_price_delete.gif'\
			style='    position: relative; top: 5px; 'alt='삭제' id='option_box_del' onclick='del(this,"+id.rows.length+")'></a>\
			</span>\
			</td>\
			<td style='left: 10px; position: relative; border-bottom: 1px solid #eaeaea;'>"+color.value+"</td>\
			<input type='hidden' id='color"+id.rows.length+"' name='color"+id.rows.length+"' value='"+color.value+"'>\
			<td style='left: 30px; position: relative; border-bottom: 1px solid #eaeaea;'>"+s+"</td>\
			<input type='hidden' id='size"+id.rows.length+"' name='size"+id.rows.length+"' value='"+s+"'>\
			<td style='left: 40px; position: relative; border-bottom: 1px solid #eaeaea;'>Rs. <b id='price"+id.rows.length+"' ><%=dto.getPrice()%></b></td>\
			<input type='hidden' id='priceh"+id.rows.length+"' name='priceh"+id.rows.length+"' value='<%=dto.getPrice()%>'>"
	}
	function up(no) {
		var priceid="price"+no;
		var boxid="option_box"+no;
		var pricehid="priceh"+no;
		var box=document.getElementById(boxid);
		var price=document.getElementById(priceid);
		var priceh=document.getElementById(pricehid);
		var total=document.getElementById("price");
		var sum=parseInt(price.innerHTML)+parseInt(<%=dto.getPrice()%>);
		price.innerHTML=sum;
		var sum=parseInt(priceh.value)+parseInt(<%=dto.getPrice()%>);
		priceh.value=sum;
		var sum=parseInt(total.innerHTML)+parseInt(<%=dto.getPrice()%>);
		total.innerHTML=sum;
		box.value=parseInt(box.value)+1;
	}
	function down(no) {
		var priceid="price"+no;
		var boxid="option_box"+no;
		var pricehid="priceh"+no;
		var box=document.getElementById(boxid);
		if(box.value==1){
			alert("Minimum order quantity is 1!!");
			return;
		}
		var price=document.getElementById(priceid);
		var priceh=document.getElementById(pricehid);
		var total=document.getElementById("price");
		var sum=parseInt(price.innerHTML)-parseInt(<%=dto.getPrice()%>);
		price.innerHTML=sum;
		var sum=parseInt(priceh.value)-parseInt(<%=dto.getPrice()%>);
		priceh.value=sum;
		var sum=parseInt(total.innerHTML)-parseInt(<%=dto.getPrice()%>);
		total.innerHTML=sum;
		box.value=parseInt(box.value)-1;
	}
	function change(no) {
		var priceid="price"+no;
		var boxid="option_box"+no;
		var box=document.getElementById(boxid);
		var price=document.getElementById(priceid);
		var total=document.getElementById("price");
		total.innerHTML=parseInt(total.innerHTML)-parseInt(price.innerHTML);
		var sum=parseInt(<%=dto.getPrice()%>)*parseInt(box.value);
		price.innerHTML=sum;
		var sum=sum+parseInt(total.innerHTML);
		total.innerHTML=sum;
	}
	function del(obj,no) {
		    var tr = $(obj).parent().parent().parent().parent();
		    document.getElementById("col").value="";
		    var color=document.getElementById("color"+no).value;
			var size=document.getElementById("size"+no).value;
			var i=0;
		   	for(var j=0;j<<%=color.size()%>;j++){
				document.getElementById("c"+j).setAttribute("class", "");
				if(document.getElementById("c"+j).innerHTML==color)
					i=j;
		}
		for(var j=0;j<<%=size.size()%>;j++){
				document.getElementById("s"+j).setAttribute("class", "");
				if(document.getElementById("s"+j).innerHTML==size)
					dupl[i][j]=0;
		}
		var priceid="price"+no;
		var price=document.getElementById(priceid);
		var total=document.getElementById("price");
		total.innerHTML=parseInt(total.innerHTML)-parseInt(price.innerHTML);
		
		
		    //라인 삭제
		    tr.remove();
	}
	function ord() {
		if("<%=session.getAttribute("id")%>"=="null"){
			alert("Please Login!");
			document.order.action="login.jsp";
			document.order.submit();
		}
		else{
			var id=document.getElementById("here");
			if(id.rows.length<1){
				alert("Please select products!");
				return;
			}
			var num=document.getElementById("num");
			num.value=id.rows.length;
			document.order.action="onCart.jsp";
			document.getElementById("dist").value=2;
			document.order.submit();
<%-- 			var sum=0;
			var str="                       Order Success!!  \n";
			str+="name                             color       size     amount      pirce\n"
			for(var i=1;i<id.rows.length+1;i++){
				var colorid=document.getElementById("color"+i);
				var sizeid=document.getElementById("size"+i);
				var priceid=document.getElementById("priceh"+i);
				var amountid=document.getElementById("option_box"+i);
				str+="<%=dto.getName()%>     "+colorid.value+"       "+sizeid.value+"       "+amountid.value+"      "+priceid.value+"\n";
				sum+=parseInt(priceid.value);
			}
			str+="------------------------------------------------------------\n";
			str+="                                                   total: Rs."+sum;
			
			alert(str); --%>
		}
	}
	function cart() {
		var id=document.getElementById("here");
		var num=document.getElementById("num");
		document.getElementById("dist").value=1;
		num.value=id.rows.length;
		if("<%=session.getAttribute("id")%>"=="null"){
			alert("Please Login!");
			document.order.action="login.jsp";
		}
		else{
			document.order.action="onCart.jsp";
		}
		if(id.rows.length<1){
			alert("Please select products!");
			return;
		}
		document.order.submit();
	}
</script>
<jsp:include page="footer.jsp"></jsp:include>