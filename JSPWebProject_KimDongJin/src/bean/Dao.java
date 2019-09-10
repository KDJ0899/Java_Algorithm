package bean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dao {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private Statement stmt=null;
	private ResultSet rs=null;
	private static Dao dao=new Dao();
	
	public static Dao getInstance() {
		return dao;
	}
	private Connection connect() throws Exception{
		Connection con = null; // DB 연결을 위한 클래스
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
	public ArrayList<productDTO> Index(){
		ArrayList<productDTO> list=new ArrayList<>();
		try {
			conn=connect();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from product");
			while(rs.next()) {
				productDTO dto=new productDTO();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setPrice(rs.getInt("price"));
				dto.setCategory_no(rs.getInt("category_No"));
				dto.setImage(rs.getString("image"));
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
	
	public ArrayList<productDTO> productList(int no){
		ArrayList<productDTO> list=new ArrayList<>();
		try {
			conn=connect();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from product where category_no="+no);
			while(rs.next()) {
				productDTO dto=new productDTO();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setPrice(rs.getInt("price"));
				dto.setCategory_no(rs.getInt("category_No"));
				dto.setImage(rs.getString("image"));
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
	
	public productDTO productDetail(int no){
		productDTO dto=new productDTO();
		try {
			conn=connect();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from product where no="+no);
			while(rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setPrice(rs.getInt("price"));
				dto.setCategory_no(rs.getInt("category_No"));
				dto.setImage(rs.getString("image"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {rs.close();}catch (Exception e) {}
			try {pstmt.close();}catch (Exception e) {}
			try {conn.close();}catch (Exception e) {}
		}
		return dto;
	}
	
	public ArrayList<colorDTO> colorList(int no){
		ArrayList<colorDTO> list=new ArrayList<>();
		try {
			conn=connect();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from color where product_no="+no+" order by color");
			while(rs.next()) {
				colorDTO dto=new colorDTO();
				dto.setNo(rs.getInt("no"));
				dto.setColor(rs.getString("color"));
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
	public ArrayList<sizeDTO> sizerList(int no){
		ArrayList<sizeDTO> list=new ArrayList<>();
		try {
			conn=connect();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from size where product_no="+no);
			while(rs.next()) {
				sizeDTO dto=new sizeDTO();
				dto.setNo(rs.getInt("no"));
				dto.setSize(rs.getString("size"));
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
	
	public categoryDTO category(int no){
		categoryDTO dto=new categoryDTO();
		try {
			conn=connect();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from category where no="+no);
			while(rs.next()) {
				System.out.println("ggg");
				dto.setNo(rs.getInt("no"));
				dto.setCategory(rs.getString("category"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {rs.close();}catch (Exception e) {}
			try {pstmt.close();}catch (Exception e) {}
			try {conn.close();}catch (Exception e) {}
		}
		return dto;
	}
	public int singUp(String id,String password,String name,String birthday,String phone,String address,String ques,String ans){
		categoryDTO dto=new categoryDTO();
		int res = 0;
		try {
			conn=connect();
			stmt=conn.createStatement();
			res=stmt.executeUpdate("insert into user(id,password,name,birthday,phoneNumber,address,question,answer) values ('"+id+"','"+password+"','"+name+"','"+birthday+"','"+phone+"','"+address+"','"+ques+"','"+ans+"')");
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
	
	public userDTO login(userDTO u){
		u.setNo(0);
		try {
			conn=connect();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from user where id='"+u.getId()+"' and password='"+u.getPassword()+"'");
			while(rs.next())
				u.setNo(rs.getInt("no"));
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {rs.close();}catch (Exception e) {}
			try {pstmt.close();}catch (Exception e) {}
			try {conn.close();}catch (Exception e) {}
		}
		return u;
	}
	
	public int cart(cartDTO dto){
		int res=0;
		try {
			conn=connect();
			stmt=conn.createStatement();
			res=stmt.executeUpdate("insert into cart(amount,dist,color,size,product_no,user_no,o_Date) "
					+ "values ("+dto.getAmount()+","+dto.getDist()+",'"+dto.getColor()+"','"+dto.getSize()+"',"+dto.getProduct_no()+","+dto.getUser_no()+",sysdate())");
			if(res==1) 
				System.out.println("Sucsess");
			else{
				System.out.println("fail");
				return 0;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {rs.close();}catch (Exception e) {}
			try {pstmt.close();}catch (Exception e) {}
			try {conn.close();}catch (Exception e) {}
		}
		return res;
	}
	public ArrayList<cartDTO> cartlist(int user_no, int dist){
		ArrayList<cartDTO> list=new ArrayList<>();
		try {
			conn=connect();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select c.no, amount,color,size,o_Date,p.name,p.price,p.image,u.id,u.address from cart c,product p,user u where p.no=c.product_no and u.no=c.user_no and u.no="+user_no+" and dist="+dist);
			while(rs.next()) {
				cartDTO dto=new cartDTO();
				dto.setNo(rs.getInt("c.no"));
				dto.setSize(rs.getString("size"));
				dto.setAmount(rs.getInt("amount"));
				dto.setColor(rs.getString("color"));
				dto.setName(rs.getString("p.name"));
				dto.setPrice(rs.getString("p.price"));
				dto.setImage(rs.getString("p.image"));
				dto.setId(rs.getString("u.id"));
				dto.setAddress(rs.getString("u.address"));
				dto.setO_Date(rs.getDate("o_Date"));
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
	
	public int cartUpdate(cartDTO dto){
		int res=0;
		try {
			conn=connect();
			stmt=conn.createStatement();
			res=stmt.executeUpdate("update cart set amount="+dto.getAmount()+",dist=2,o_Date=sysdate() where no="+dto.getNo()+";");
			if(res==1) 
				System.out.println("Sucsess");
			else{
				System.out.println("fail");
				return 0;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {rs.close();}catch (Exception e) {}
			try {pstmt.close();}catch (Exception e) {}
			try {conn.close();}catch (Exception e) {}
		}
		return res;
	}
	
	public userDTO getUser(int no){
		userDTO dto=new userDTO();
		try {
			conn=connect();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from user where no="+no);
			while(rs.next()) {
				dto.setName(rs.getString("name"));
				dto.setBirthday(rs.getString("birthday"));
				dto.setAddress(rs.getString("address"));
				dto.setPhoneNumber(rs.getString("phoneNumber"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {rs.close();}catch (Exception e) {}
			try {pstmt.close();}catch (Exception e) {}
			try {conn.close();}catch (Exception e) {}
		}
		return dto;
	}
	
	public userDTO getQuestion(String id,String name){
		userDTO dto=new userDTO();
		try {
			conn=connect();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from user u where u.id='"+id+"' and name='"+name+"'");
			while(rs.next()) {
				dto.setQuestion(rs.getString("question"));
				dto.setAnswer(rs.getString("answer"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {rs.close();}catch (Exception e) {}
			try {pstmt.close();}catch (Exception e) {}
			try {conn.close();}catch (Exception e) {}
		}
		return dto;
	}
	
	public int valAnswer(String id,String ans){
		int no=0;
		try {
			conn=connect();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from user u where u.id='"+id+"' and answer='"+ans+"'");
			while(rs.next()) {
				no=rs.getInt("no");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {rs.close();}catch (Exception e) {}
			try {pstmt.close();}catch (Exception e) {}
			try {conn.close();}catch (Exception e) {}
		}
		return no;
	}
	
	public int changePassword(int no,String password){
		int res=0;
		try {
			conn=connect();
			stmt=conn.createStatement();
			res=stmt.executeUpdate("update user set password='"+password+"' where no="+no);
			if(res==1) 
				System.out.println("Sucsess");
			else{
				System.out.println("fail");
				return 0;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {rs.close();}catch (Exception e) {}
			try {pstmt.close();}catch (Exception e) {}
			try {conn.close();}catch (Exception e) {}
		}
		return res;
	}
	
	
	public int delete(int no){
		int res=0;
		try {
			conn=connect();
			stmt=conn.createStatement();
			res=stmt.executeUpdate("delete from cart where no="+no);
			if(res==1) 
				System.out.println("Sucsess");
			else{
				System.out.println("fail");
				return 0;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {rs.close();}catch (Exception e) {}
			try {pstmt.close();}catch (Exception e) {}
			try {conn.close();}catch (Exception e) {}
		}
		return res;
	}
	
}
