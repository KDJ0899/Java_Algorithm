<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ page import="bean.Dao" %>
<%@ page import="bean.cartDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%	
	Dao dao=Dao.getInstance();
	int size=Integer.parseInt(request.getParameter("size"));
	for(int i=0;i<size;i++){
		cartDTO dto=new cartDTO();
		dto.setNo(Integer.parseInt(request.getParameter("cart_no"+i)));
		dto.setAmount(Integer.parseInt(request.getParameter("amount"+i)));
		dao.cartUpdate(dto);
	}
	response.sendRedirect("cart.jsp");
%>
</body>
</html>