package Exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.productDTO;



public class ExamDao {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private Statement stmt=null;
	private ResultSet rs=null;
	private static ExamDao dao=new ExamDao();
	public static ExamDao getInstance() {
		return dao;
	}
	
	private Connection connect() throws Exception{
		Connection con = null; 
		  try {
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspproject", "root", "");
			  System.out.println("My-SQL 연결 성공!!");
		  }catch(SQLException e) {
			  System.out.println("My-SQL 연결 실패!!");
			  e.printStackTrace();
		  }
		return con;
	}
	public int Insert(DTO dto){
		int res = 0;
		try {
			conn=connect();
			stmt=conn.createStatement();
			res=stmt.executeUpdate("insert into test values ('"+dto.getId()+"','"+dto.getName()+"','"+dto.getSex()+"','"+dto.getAddress()+"','"+dto.getMarital_status()+"','"+dto.getEducational()+"')");
			if(res==1) 
				System.out.println("Sucsess");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {rs.close();}catch (Exception e) {}
			try {pstmt.close();}catch (Exception e) {}
			try {conn.close();}catch (Exception e) {}
		}
		return res;
	}
	public int Delete(String id) {
		int res = 0;
		try {
			conn=connect();
			stmt=conn.createStatement();
			res=stmt.executeUpdate("delete from test where id="+id);
			if(res==1) 
				System.out.println("Sucsess");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {rs.close();}catch (Exception e) {}
			try {pstmt.close();}catch (Exception e) {}
			try {conn.close();}catch (Exception e) {}
		}
		return res;
	}
	public ArrayList<DTO> select() {
		ArrayList<DTO> list=new ArrayList<>();
		try {
			conn=connect();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from test");
			while(rs.next()) {
				DTO dto=new DTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setSex(rs.getString("sex"));
				dto.setAddress(rs.getString("address"));
				dto.setEducational(rs.getString("educational"));
				dto.setMarital_status(rs.getString("marital_status"));
				list.add(dto);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {rs.close();}catch (Exception e) {}
			try {pstmt.close();}catch (Exception e) {}
			try {conn.close();}catch (Exception e) {}
		}
		return list;
		
	}
}
