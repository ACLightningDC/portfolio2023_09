package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static db.JdbcUtill.*;

import vo.Address;
import vo.Order_list;
import vo.Product;
import vo.ShoppingCart;
import vo.Users;
import vo.sellermall;

public class DAO {
	private Connection con =null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	
	private DAO() {}
	
	private static DAO dao;
	
	public static DAO getInstance() {
		if(dao == null) {
			dao = new DAO();
		}
		
		return dao;
	}
	
	public void setConnection(Connection con) {
		this.con=con;
	}

	public int loginCheck(String id, String password) {
		
		int loginCheck = 0;
		
		String sql = " select id from users where userid = ? and password = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			//0 prepareStatment 의 setString -> ? 1 부터 함 
			pstmt.setString(1, id);
			System.out.println("id 값"+id);

			pstmt.setString(2, password);
			System.out.println("password 값"+password);

			rs = pstmt.executeQuery();
			System.out.println(loginCheck);

			if(rs.next()) {
				loginCheck = rs.getInt("id");
				System.out.println("sql 값 인출"+rs.getInt("id"));
			}
			System.out.println(loginCheck);
		}catch(Exception e) {
			System.out.println("loginCheck 에러: " +e);
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return loginCheck;
	}

	public Users getUsersInfo(int id) {
		Users userInfo = null;
		String sql = " select * from users where id = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				userInfo = new Users();
				userInfo.setId(id);
				userInfo.setUserid(rs.getString("userid"));
				userInfo.setName(rs.getString("name"));
				userInfo.setDate(rs.getString("date"));
				userInfo.setEmail(rs.getString("email"));
				userInfo.setPhone(rs.getString("phone"));
				userInfo.setBirthday(rs.getString("birthday"));
				userInfo.setGrade(rs.getString("grade"));
			}
		}catch(Exception e){
			System.out.println("[DAO] getUsersInfo 에러" + e );
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return userInfo;
	}

	public String findId(String name, String email) {
		String userid = null;
		String sql = " select userid from users where name =? and email = ?";
		try {
			
			System.out.println(name +" "+email);
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				userid = rs.getString("userid");
			}
			
			System.out.println(userid);
		}catch(Exception e){
			System.out.println("[DAO] findId 에러" + e );
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return userid;
	}

	public int PassowordFind(String randomPasswordEncode, String userid, String email) {
		int check = 0;
		String sql =" update users set password=? where userid=? and email=?";
		try {
								
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, randomPasswordEncode);
			pstmt.setString(2, userid);
			pstmt.setString(3, email);
			
			check= pstmt.executeUpdate();

				System.out.println(userid);
			}catch(Exception e){
				System.out.println("[DAO] PassowordFind 에러" + e );
			}finally {
				close(pstmt);
			}
		return check;
	}

	public int accountjoin(Users users) {
		int check = 0;
		String sql =" insert into users(userid, password, name, phone , birthday  , email ,gender ) value(?, ?, ?, ?, ?, ?, ?)";
		try {
								
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, users.getUserid());
			pstmt.setString(2, users.getPassword());
			pstmt.setString(3, users.getName());
			pstmt.setString(4, users.getPhone());
			pstmt.setString(5, users.getBirthday());
			pstmt.setString(6, users.getEmail());
			pstmt.setString(7, users.getGender());
			
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] accountjoin 에러" + e );
			}finally {
				close(pstmt);
			}
		return check;
	}

	public int addressAdd(int users_id , String postcode, String address1, String address2) {
		int check = 0;
		String sql =" insert into address(users_id , postcode, address1, address2) value(?, ?, ?,?)";
		try {
								
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, users_id);
			pstmt.setString(2, postcode);
			pstmt.setString(3, address1);
			pstmt.setString(4, address2);
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] addressAdd 에러" + e );
			}finally {
				close(pstmt);
			}
		return check;
	}

	public int usersIdGet(String userid, String password) {
		int user_id = 0;
		String sql = " select id from users where userid =? and password = ?";
		try {
			
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				user_id = rs.getInt("id");
			}
			
			System.out.println(userid);
		}catch(Exception e){
			System.out.println("[DAO] findId 에러" + e );
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return user_id;
	}

	/**
	 * 작업중 
	 */
//	public ArrayList<Address> findAddress(int id) {
//		ArrayList<Address> addressS = null;
//		String sql = " select * from address where users_id = ?";
//		try {
//			
//			pstmt = con.prepareStatement(sql);
//			
//			pstmt.setString(1, id);
//			
//			rs= pstmt.executeQuery();
//			
//			if(rs.next()) {
//				user_id = rs.getInt("id");
//			}
//			
//			System.out.println(userid);
//		}catch(Exception e){
//			System.out.println("[DAO] findId 에러" + e );
//		}finally {
//			close(rs);
//			close(pstmt);
//		}
//			
//		return user_id;	}

	/**
	 * 유저 삭제
	 */
	public int accountDelete(int id) {
		int check = 0;
		String sql =" delete from users where id = ?";
		try {
								
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] accoutDelete 에러" + e );
			}finally {
				close(pstmt);
			}
		return check;
	}
	/**
	 * 
	 * @param userid
	 * @param name
	 * @param phone
	 * @param birthday
	 * @return
	 * 
	 * 유저 수정
	 */
	public int userupdate(int id ,String userid, String name, String phone, String birthday) {
		int check = 0;
		String sql =" update users set userid = ?, name = ?, phone = ? , birthday = ? where id = ? ";
		try {
								
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			pstmt.setString(2, name);
			pstmt.setString(3, phone);
			pstmt.setString(4, birthday);
			pstmt.setInt(5, id);
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] accoutupdate 에러" + e );
			}finally {
				close(pstmt);
			}
		return check;
		}

	public int CompanyRegistrationNumber(int user_id, String companyRegistrationNumber) {
		int check = 0;
		String sql =" insert into seller(users_id , CompanyRegistrationNumber) value(?,?) ";
		try {
								
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, user_id);
			pstmt.setString(2, companyRegistrationNumber);
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] CompanyRegistrationNumber 에러" + e );
			}finally {
				close(pstmt);
			}
		return check;
		}

	public int sellerGrade(int user_id) {
		
		int check = 0;
		String sql =" update users set grade = 'S' where id = ? ";
		try {
								
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, user_id);
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] sellerGrade 에러" + e );
			}finally {
				close(pstmt);
			}
		return check;
	}

	public int getSeller_id(int users_id) {
		int seller_id = 0;
		String sql = " select id from seller where users_id = ?";
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, users_id);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				seller_id= rs.getInt("id");
			}
			
		}catch(Exception e){
			System.out.println("[DAO] getSeller_id 에러" + e );
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return seller_id;
	}

	public int createMall(int seller_id, String name) {
		
		int check = 0;
		String sql =" insert into sellermall(seller_id , name )value(? , ?)";
		try {
								
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, seller_id);
			pstmt.setString(2, name);
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] sellerGrade 에러" + e );
			}finally {
				close(pstmt);
			}
		return check;
	}

	public ArrayList<sellermall> findSellerMall(int seller_id) {
		 ArrayList<sellermall> sellerMalls = new ArrayList<sellermall>();
		String sql = " select * from sellermall where seller_id= ? ";
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, seller_id);
			
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				sellermall mall = new sellermall();
				mall.setId(rs.getInt("id"));
				mall.setSeller_id(rs.getInt("seller_id"));
				mall.setName(rs.getString("name"));
				mall.setCreate_date(rs.getString("create_date"));
				mall.setGrade(rs.getString("grade"));
				sellerMalls.add(mall);
			}
			
		}catch(Exception e){
			System.out.println("[DAO] findSellerMall 에러" + e );
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return sellerMalls;
	}
	
	/*
	 * 제품 추가
	 */
	public int ProductAdd(Product product) {
		
		int check = 0;
		String sql =" insert into product(sellerMall_id,name,kind,img,price)value(?,?,?,?,?)";
		try {
								
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, product.getSellerMall_id());
			pstmt.setString(2, product.getName());
			pstmt.setString(3, product.getKind());
			pstmt.setString(4, product.getImg());
			pstmt.setInt(5, product.getPrice());
			
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] ProductAdd 에러" + e );
			}finally {
				close(pstmt);
			}
		
		return check;
	}

	public ArrayList<Product> getProductList(int sellerMallid) {
		 ArrayList<Product> productList = new ArrayList<Product>();
		String sql = " select * from product where sellerMall_id= ? ";
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, sellerMallid);
			
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setSellerMall_id(rs.getInt("sellerMall_id"));
				product.setPrice(rs.getInt("price"));
				product.setKind(rs.getString("kind"));
				product.setName(rs.getString("name"));
				product.setDate(rs.getString("date"));
				product.setImg(rs.getString("img"));
				product.setBuycount(rs.getInt("buycount"));
				
				productList.add(product);
			}
			
		}catch(Exception e){
			System.out.println("[DAO] getProductList 에러" + e );
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return productList;
	}

	public ArrayList<Product> getAllProductList() {
		 ArrayList<Product> productList = new ArrayList<Product>();
			String sql = " select * from product ";
			try {
				
				pstmt = con.prepareStatement(sql);
				
				
				rs= pstmt.executeQuery();
				
				while(rs.next()) {
					Product product = new Product();
					product.setId(rs.getInt("id"));
					product.setSellerMall_id(rs.getInt("sellerMall_id"));
					product.setPrice(rs.getInt("price"));
					product.setKind(rs.getString("kind"));
					product.setName(rs.getString("name"));
					product.setDate(rs.getString("date"));
					product.setImg(rs.getString("img"));
					product.setBuycount(rs.getInt("buycount"));
					
					productList.add(product);
				}
				
			}catch(Exception e){
				System.out.println("[DAO] getAllProductList 에러" + e );
			}finally {
				close(rs);
				close(pstmt);
			}
				
			return productList;
	}

	public ArrayList<sellermall> getAllsellermallList() {
		 ArrayList<sellermall> sellerMalls = new ArrayList<sellermall>();
			String sql = " select * from sellermall";
			try {
				
				pstmt = con.prepareStatement(sql);
								
				rs= pstmt.executeQuery();
				
				while(rs.next()) {
					sellermall mall = new sellermall();
					mall.setId(rs.getInt("id"));
					mall.setSeller_id(rs.getInt("seller_id"));
					mall.setName(rs.getString("name"));
					mall.setCreate_date(rs.getString("create_date"));
					mall.setGrade(rs.getString("grade"));
					sellerMalls.add(mall);
				}
				
			}catch(Exception e){
				System.out.println("[DAO] getAllsellermallList 에러" + e );
			}finally {
				close(rs);
				close(pstmt);
			}
				
			return sellerMalls;
	}

	public int shoppingCartProductAdd(int users_id, int product_id, int order_count) {

		int check = 0;
		String sql =" insert into order_list(users_id , product_id , order_count )value(?,?,?)";
		try {
								
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, users_id);
			pstmt.setInt(2, product_id);
			pstmt.setInt(3, order_count);
			
			
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] shoppingCartProductAdd 에러" + e );
			}finally {
				close(pstmt);
			}
		
		return check;
	}

	public int GetCartOrder_count(int users_id, int product_id) {
		int order_count = 0;
		String sql = " select order_count from order_list where users_id= ? and product_id = ? ";
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, users_id);
			pstmt.setInt(2, product_id);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				order_count = rs.getInt("order_count");
			}
			
		}catch(Exception e){
			System.out.println("[DAO] GetCartOrder_count 에러" + e );
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return order_count;	
	}

	public ArrayList<ShoppingCart> shoppingCartView(int users_id) {
		 ArrayList<ShoppingCart> shoppingCartList = new ArrayList<ShoppingCart>();
			String sql = " select l.id ,product_id ,users_id, order_count , delivery , l.date , result"
					+ " ,sellerMall_id , price , name , kind ,img  "
					+ " from order_list l join product r on l.product_id = r.id where users_id = ? ";
			try {
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, users_id);	
				rs= pstmt.executeQuery();
				
				while(rs.next()) {
					ShoppingCart shoppingCart = new ShoppingCart();
					shoppingCart.setId(rs.getInt("id"));
					shoppingCart.setUsers_id(rs.getInt("users_id"));
					shoppingCart.setProduct_id(rs.getInt("product_id"));
					shoppingCart.setOrder_count(rs.getInt("order_count"));
					shoppingCart.setDelivery(rs.getString("delivery"));
					shoppingCart.setDate(rs.getString("date"));
					shoppingCart.setResult(rs.getString("result"));
					
					shoppingCart.setSellerMall_id(rs.getInt("sellerMall_id"));
					shoppingCart.setPrice(rs.getInt("price"));
					shoppingCart.setName(rs.getString("name"));
					shoppingCart.setKind(rs.getString("kind"));
					shoppingCart.setImg(rs.getString("img"));
					shoppingCartList.add(shoppingCart);
				}
				
			}catch(Exception e){
				System.out.println("[DAO] shoppingCartView 에러" + e );
			}finally {
				close(rs);
				close(pstmt);
			}
				
			return shoppingCartList;
			}

	public int shoppingCartProductUpdate(int users_id, int product_id, int order_count) {
		int check = 0;
		String sql =" update order_list set order_count= ? where users_id = ? and product_id = ? ";
		try {
								
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order_count);
			pstmt.setInt(2, users_id);
			pstmt.setInt(3, product_id);
			
			
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] shoppingCartProductUpdate 에러" + e );
			}finally {
				close(pstmt);
			}
		
		return check;
	}

	public Product getProduct(int product_id) {
		Product product = null;
		String sql = " select * from product where id = ? ";
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, product_id);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				product = new Product();
				product.setId(rs.getInt("id"));
				product.setSellerMall_id(rs.getInt("sellerMall_id"));
				product.setPrice(rs.getInt("price"));
				product.setKind(rs.getString("kind"));
				product.setName(rs.getString("name"));
				product.setDate(rs.getString("date"));
				product.setImg(rs.getString("img"));
				product.setBuycount(rs.getInt("buycount"));
				
			}
			
		}catch(Exception e){
			System.out.println("[DAO] getProduct 에러" + e );
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return product;	}

	public int CartRemove(int i) {
		int check = 0;
		String sql ="delete from order_list where id = ? ";
		try {
								
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, i);
			
			
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] CartRemove 에러" + e );
			}finally {
				close(pstmt);
			}
		
		return check;
	}
	
}
