<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
	int x=Integer.parseInt(request.getParameter("num"));
	int no=Integer.parseInt(request.getParameter("no"));
	int amount;
	int dist=Integer.parseInt(request.getParameter("dist"));;
	String color;
	String size;
	int user_no=Integer.parseInt(session.getAttribute("no").toString());
	List<cartDTO> li=new ArrayList<cartDTO>();
	cartDTO dto=new cartDTO();
	Dao dao=Dao.getInstance();
	for(int i=1;i<=x;i++){
		amount=Integer.parseInt(request.getParameter("amount"+i));
		color=request.getParameter("color"+i);
		size=request.getParameter("size"+i);
		dto.setAmount(amount);
		dto.setDist(dist);
		dto.setColor(color);
		dto.setSize(size);
		dto.setProduct_no(no);
		dto.setUser_no(user_no);
		int n=dao.cart(dto);
		System.out.print(n);
	}
	
	response.sendRedirect("Detail.jsp?no="+no);
%>
</body>
</html>