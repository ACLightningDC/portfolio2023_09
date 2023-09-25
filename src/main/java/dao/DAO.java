package dao;

import static db.JdbcUtill.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Address;
import vo.Delivery;
import vo.Order_list;
import vo.Product;
import vo.ShoppingCart;
import vo.Users;
import vo.sellermall;
import vo.user_security.User_security;

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
				userInfo.setAddress_id(rs.getInt("address_id"));
				userInfo.setSnsLogin_id(rs.getString("snsLogin_id"));
				userInfo.setUserSecurity_id(rs.getString("userSecurity_id"));
				
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
		String sql =" insert into users(userid , password, name, phone , birthday  , email ,gender ) value(?, ?, ?, ?, ?, ?, ? )";
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
/********************************************************************/
	/********************************************************************/
	public ArrayList<Product> productPageGetList(int first , int limit) {
		 ArrayList<Product> productList = new ArrayList<Product>();
			String sql = " select  * from product LIMIT ? , ?";
			try {
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, first);
				pstmt.setInt(2, limit);
				//pstmt.setInt(1, page);
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
				System.out.println("[DAO] productPageGetList 에러" + e );
			}finally {
				close(rs);
				close(pstmt);
			}
				
			return productList;
	}
	
	public int getAllProductListCnt() {
		 int cnt = 0;
			String sql = " select count(*) cnt from product ";
			try {
				
				pstmt = con.prepareStatement(sql);
				
				//pstmt.setInt(1, page);
				rs= pstmt.executeQuery();
				
				if(rs.next()) {
					cnt = rs.getInt(1);
				}
				
			}catch(Exception e){
				System.out.println("[DAO] getAllProductListCnt 에러" + e );
			}finally {
				close(rs);
				close(pstmt);
			}
				
			return cnt;
	}

	/********************************************************************/

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

	public ArrayList<Order_list> GetCartOrder_Check(int users_id, int product_id) {
		ArrayList<Order_list> order_list = new ArrayList<Order_list>(); 
		String sql = " select id , order_count, result from order_list where users_id= ? and product_id = ? ";
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, users_id);
			pstmt.setInt(2, product_id);
			
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				Order_list order = new Order_list();
				
				order.setId(rs.getInt("id"));
				order.setOrder_count(rs.getInt("order_count")); 
				order.setResult(rs.getString("result"));
				
				order_list.add(order);
			}
			
		}catch(Exception e){
			System.out.println("[DAO] GetCartOrder_count 에러" + e );
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return order_list;	
	}

	public ArrayList<ShoppingCart> shoppingCartView(int users_id) {
		 ArrayList<ShoppingCart> shoppingCartList = new ArrayList<ShoppingCart>();
			String sql = " select l.id ,product_id ,users_id, order_count , delivery_id , l.date , result"
					+ " ,sellerMall_id , price , name , kind ,img  "
					+ " from order_list l join product r on l.product_id = r.id where users_id = ? and result = 'N'";
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
					shoppingCart.setDelivery_id(rs.getInt("delivery_id"));
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
	public ArrayList<ShoppingCart> shoppingResultView(int users_id) {
		ArrayList<ShoppingCart> shoppingCartList = new ArrayList<ShoppingCart>();
		String sql = " select l.id ,product_id ,users_id, order_count , delivery_id , l.date , result"
				+ " ,sellerMall_id , price , name , kind ,img  "
				+ " from order_list l join product r on l.product_id = r.id where users_id = ?  and result = 'P' or result = 'D' or result = 'C'";
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
				shoppingCart.setDelivery_id(rs.getInt("delivery_id"));
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
	public ArrayList<ShoppingCart> orderManageSalesView(int sellerMallid) {
		ArrayList<ShoppingCart> shoppingCartList = new ArrayList<ShoppingCart>();
		String sql = " select l.id ,product_id ,users_id, order_count , delivery_id , l.date , result"
				+ " ,sellerMall_id , price , name , kind ,img  "
				+ " from order_list l join product r on l.product_id = r.id where sellerMall_id = ? and( result = 'D' or result='P' )order by result ,date asc ";
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sellerMallid);	
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				ShoppingCart shoppingCart = new ShoppingCart();
				shoppingCart.setId(rs.getInt("id"));
				shoppingCart.setUsers_id(rs.getInt("users_id"));
				shoppingCart.setProduct_id(rs.getInt("product_id"));
				shoppingCart.setOrder_count(rs.getInt("order_count"));
				shoppingCart.setDelivery_id(rs.getInt("delivery_id"));
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
			System.out.println("[DAO] orderManageSalesView 에러" + e );
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return shoppingCartList;
	}

	public int shoppingCartProductUpdate(int id, int order_count) {
		int check = 0;
		String sql =" update order_list set order_count= ? where id = ? ";
		try {
								
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order_count);
			pstmt.setInt(2, id);
			
			
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

	public String accountEmailCheck(String email) {
		String emailCheck = null;
		String sql = " select email from users where email = ? ";
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, email);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				emailCheck = rs.getString("email");
			}
			
		}catch(Exception e){
			System.out.println("[DAO] getProduct 에러" + e );
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return emailCheck;
	}

	public String AccountUseridCheck(String userid) {
		String useridCheck = null;
		String sql = " select userid from users where userid = ? ";
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				useridCheck = rs.getString("userid");
			}
			
		}catch(Exception e){
			System.out.println("[DAO] AccountUseridCheck 에러" + e );
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return useridCheck;
	}

	public ArrayList<Address> UserAddressGet(int user_id) {
		ArrayList<Address> addressList = new ArrayList<Address>();
		String sql = " select * from address where users_id= ?; ";
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user_id);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				Address address = new Address();
				address.setId(rs.getInt("id"));
				address.setUser_id(rs.getInt("users_id"));
				address.setAddress1(rs.getString("address1"));
				address.setAddress2(rs.getString("address2"));
				address.setPostcode(rs.getString("postcode"));
				
				addressList.add(address);
			}
			
		}catch(Exception e){
			System.out.println("[DAO] UserAddressGet 에러" + e );
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return addressList;
	}

	public int CartCountUpdate(int id, int orderCount) {
		int check = 0;
		String sql ="update order_list set order_count = ? where id =?";
		try {
								
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, orderCount);
			pstmt.setInt(2, id);
			
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] CartCountUpdate 에러" + e );
			}finally {
				close(pstmt);
			}
		
		return check;
	}

	public int makeinquiry(int users_id, int seller_Mall_id, int product_id, String inquiry_name, String inquiry_contents) {
		int check = 0;
		String sql ="insert into inquiry(users_id , sellerrMall_id ,product_id , contents , name)value(?,?,?,?,?)";
		try {
								
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, users_id);
			pstmt.setInt(2, seller_Mall_id);
			pstmt.setInt(3, product_id);
			pstmt.setString(4, inquiry_name);
			pstmt.setString(5, inquiry_contents);
			
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] makeinquiry 에러" + e );
			}finally {
				close(pstmt);
			}
		
		return check;
	}

//	public ArrayList<InquiryUser> getinquiryUser(int users_id) {
//		ArrayList<InquiryUser> InquiryUserList = new ArrayList<InquiryUser>();
//		String sql = " select * from address where users_id= ?; ";
//		try {
//			
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, users_id);
//			rs= pstmt.executeQuery();
//			
//			while(rs.next()) {
//				InquiryUser inquiryUser = new InquiryUser();
//				inquiryUsers.setId(rs.getInt("id"));
//				address.setUser_id(rs.getInt("users_id"));
//				address.setAddress1(rs.getString("address1"));
//				address.setAddress2(rs.getString("address2"));
//				address.setPostcode(rs.getString("postcode"));
//				
//				InquiryUserList.add(inquiryUsers);
//			}
//			
//		}catch(Exception e){
//			System.out.println("[DAO] getinquiryUser 에러" + e );
//		}finally {
//			close(rs);
//			close(pstmt);
//		}
//			
//		return InquiryUserList;
//	}

	public ShoppingCart cartBuy(int order_id) {
		ShoppingCart shoppingCart = new ShoppingCart();
			String sql = " select l.id ,product_id ,users_id, order_count , delivery_id , l.date , result"
					+ " ,sellerMall_id , price , name , kind ,img  "
					+ " from order_list l join product r on l.product_id = r.id where l.id = ? ";
			try {
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, order_id);	
				rs= pstmt.executeQuery();
				
				if(rs.next()) {
					shoppingCart.setId(rs.getInt("id"));
					shoppingCart.setUsers_id(rs.getInt("users_id"));
					shoppingCart.setProduct_id(rs.getInt("product_id"));
					shoppingCart.setOrder_count(rs.getInt("order_count"));
					shoppingCart.setDelivery_id(rs.getInt("delivery_id"));
					shoppingCart.setDate(rs.getString("date"));
					shoppingCart.setResult(rs.getString("result"));
					
					shoppingCart.setSellerMall_id(rs.getInt("sellerMall_id"));
					shoppingCart.setPrice(rs.getInt("price"));
					shoppingCart.setName(rs.getString("name"));
					shoppingCart.setKind(rs.getString("kind"));
					shoppingCart.setImg(rs.getString("img"));
				}
				
			}catch(Exception e){
				System.out.println("[DAO] cartBuy 에러" + e );
			}finally {
				close(rs);
				close(pstmt);
			}
				
			return shoppingCart;
		
		
	}

//	public int addressUpdate(int user_id, String postcode, String address1, String address2) {
//		int check = 0;
//		String sql =" insert into address(id , postcode, address1, address2) value(?, ?, ?,?)";
//		try {
//								
//			pstmt = con.prepareStatement(sql);
//			
//			pstmt.setInt(1, id);
//			pstmt.setString(2, postcode);
//			pstmt.setString(3, address1);
//			pstmt.setString(4, address2);
//			check= pstmt.executeUpdate();
//
//			}catch(Exception e){
//				System.out.println("[DAO] addressAdd 에러" + e );
//			}finally {
//				close(pstmt);
//			}
//		return check;
//	}

	public int addressDelete(int id) {
		int check = 0;
		String sql =" delete from address where id = ?";
		try {
								
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] addressDelete 에러" + e );
			}finally {
				close(pstmt);
			}
		return check;
	}

	public int ShopDelete(int id) {
		int check = 0;
		String sql =" delete from sellermall where id = ?";
		try {
								
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] ShopDelete 에러" + e );
			}finally {
				close(pstmt);
			}
		return check;
	}

	public int shoppingresultUpdate(String result, int id, int delivery_id) {
		int check = 0;
		String sql =" update order_list set result = ? , delivery_id = ?  where id = ? ";
		try {
								
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, result);
			pstmt.setInt(2, delivery_id);
			pstmt.setInt(3, id);
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] shoppingresultUpdate 에러" + e );
			}finally {
				close(pstmt);
			}
		return check;
	}

	public int addressBasicSelect(int users_id, int id) {
		int check = 0;
		String sql =" update users set address_id = ? where id = ? ";
		try {
								
			pstmt = con.prepareStatement(sql);
			System.out.println("입력 id"+id);

			pstmt.setInt(1, id);
			pstmt.setInt(2, users_id);
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] addressBasicSelect 에러" + e );
			}finally {
				close(pstmt);
			}
		return check;
	}

	public ArrayList<ShoppingCart> OrderManageShow(int sellerMallid) {
		ArrayList<ShoppingCart> shoppingCartList = new ArrayList<ShoppingCart>();
		String sql = " select l.id ,product_id ,users_id, order_count , delivery_id , l.date , result"
				+ " ,sellerMall_id , price , name , kind ,img  "
				+ " from order_list l join product r on l.product_id = r.id where sellerMall_id = ?  and result = 'P' or result = 'D' order by result desc";
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sellerMallid);	
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				ShoppingCart shoppingCart = new ShoppingCart();
				shoppingCart.setId(rs.getInt("id"));
				shoppingCart.setUsers_id(rs.getInt("users_id"));
				shoppingCart.setProduct_id(rs.getInt("product_id"));
				shoppingCart.setOrder_count(rs.getInt("order_count"));
				shoppingCart.setDelivery_id(rs.getInt("delivery_id"));
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
			System.out.println("[DAO] OrderManageShow 에러" + e );
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return shoppingCartList;
	}
//수정 필요 
/**
 * 
 * 
 * 
 * 
 * @param address_id
 * @param delivery
 * @return
 */
	public int OrderManageDeliveryregistration(int address_id, Delivery delivery) {
		int check = 0;
		String sql =" insert into delivery (address_id,delivery_company,delivery_num)value(?,?,?)";
		try {
			
			System.out.println(address_id);
			
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, address_id);
			pstmt.setString(2, delivery.getDelivery_company());
			pstmt.setString(3, delivery.getDelivery_num());
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] OrderManageDeliveryregistration 에러" + e );
			}finally {
				close(pstmt);
			}
		return check;
	}

	public int OrderManageDeliveryresultChange(int delivery_Id , int id) {
		int check = 0;
		String sql =" update order_list set delivery_id =?, result = ? where id = ? ";
		try {
								
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, delivery_Id);
			pstmt.setString(2, "D");
			pstmt.setInt(3, id);
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] OrderManageDeliveryresultChange 에러" + e );
			}finally {
				close(pstmt);
			}
		return check;
	}

	public int shopUpdate(int sellerMallid, String name) {
		int check = 0;
		String sql =" update sellermall set name = ? where id = ? ";
		try {
								
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setInt(2, sellerMallid);
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] shopUpdate 에러" + e );
			}finally {
				close(pstmt);
			}
		return check;
	}
	public Address getAddress(int address_id) {
		Address address = null;
		String sql = " select * from address where id= ? ";
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, address_id);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				address= new Address();
				address.setId(rs.getInt("id"));
				address.setUser_id(rs.getInt("users_id"));
				address.setAddress1(rs.getString("address1"));
				address.setAddress2(rs.getString("address2"));
				address.setPostcode(rs.getString("postcode"));
				
			}
			
		}catch(Exception e){
			System.out.println("[DAO] UserAddressGet 에러" + e );
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return address;
	}

	public int GetAddress_id(int order_id) {
		int address_id = 0;
		String sql = " select r.address_id from order_list l join users r on l.users_id = r.id where l.id = ? ";
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order_id);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				address_id = rs.getInt(1);
			}
			
		}catch(Exception e){
			System.out.println("[DAO] GetAddress_id 에러" + e );
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return address_id;
	}

	public int getdeliveryId(int address_id, Delivery delivery) {
		int delivery_Id = 0;
		String sql = " select id from delivery where address_id = ? and delivery_company = ? and delivery_num = ? ";
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, address_id);
			pstmt.setString(2, delivery.getDelivery_company());
			pstmt.setString(3, delivery.getDelivery_num());
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				delivery_Id = rs.getInt(1);
			}
			
		}catch(Exception e){
			System.out.println("[DAO] getdeliveryId 에러" + e );
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return delivery_Id;
		
	}

	public int user_securitySetting(int users_id, String ipAddress, String model) {
		int check = 0;
		String sql =" insert into user_security (users_id,ipAddress,model)value(?,?,?)";
		try {
			
			
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, users_id);
			pstmt.setString(2, ipAddress);
			pstmt.setString(3, model);
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] user_securitySetting 에러" + e );
			}finally {
				close(pstmt);
			}
		return check;
	}

	public int user_securityCancel(int users_id) {
		int check = 0;
		String sql =" delete from user_security where users_id = ?";
		try {
			
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, users_id);
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] user_securityCancel 에러" + e );
			}finally {
				close(pstmt);
			}
		return check;
	}

	public ArrayList<User_security> getUser_security(int id) {
		ArrayList<User_security> user_securityList = new ArrayList<>();
		String sql = " select * from user_security where users_id = ? ";
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				User_security user_security = new User_security();
				user_security.setId(rs.getInt("id"));
				user_security.setUsers_id(rs.getInt("users_id")); 
				user_security.setModel(rs.getString("model")); 
				user_security.setIpaddress(rs.getString("ipaddress")); 
				user_security.setSecurity_check(rs.getInt("security_check")); 
				user_securityList.add(user_security);
			}
			
		}catch(Exception e){
			System.out.println("[DAO] getdeliveryId 에러" + e );
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return user_securityList;
		
	}

	public int createDelivery(int address_id) {
		int check = 0;
		String sql =" insert into delivery (address_id)VALUES (?)";
		try {
			
			
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, address_id);
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] delivery 에러" + e );
			}finally {
				close(pstmt);
			}
		return check;
	}

	public int getDelivery_id(int address_id) {
		int delivery_Id = 0;
		String sql = " select id from delivery where address_id = ? and delivery_company is null and delivery_num is null";
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, address_id);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				delivery_Id = rs.getInt(1);
			}
			
		}catch(Exception e){
			System.out.println("[DAO] getDelivery_id 에러" + e );
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return delivery_Id;
		
	}

	public Delivery orderCheckForm(int delivery_id) {
		Delivery del = null;
		String sql = " select * from delivery where id = ?";
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, delivery_id);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				del = new Delivery();
				del.setId(rs.getInt("id"));
				del.setAddress_id(rs.getInt("address_id"));
				del.setDelivery_company(rs.getString("delivery_company"));
				del.setDelivery_num(rs.getString("delivery_num"));
			}
			
		}catch(Exception e){
			System.out.println("[DAO] getDelivery_id 에러" + e );
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return del;
	}

	public int secu_checkUpdate(int secu_check, int secuid) {
		
		int check = 0;
		String sql =" update user_security set security_check = ? where id = ? ";
		try {
								
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, secu_check);
			pstmt.setInt(2, secuid);
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] secu_checkUpdate 에러" + e );
			}finally {
				close(pstmt);
			}
		
		return check;
	}

	public int createSecu(int loginCheck, int secu_check, String ipAddress, String model) {
		int check = 0;
		String sql =" insert into user_security (users_id , ipaddress, model ,security_check) values(?,?,?,?) ";
		try {
								
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, loginCheck);
			pstmt.setString(2, ipAddress);
			pstmt.setString(3, model);
			pstmt.setInt(4, secu_check);
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] createSecu 에러" + e );
			}finally {
				close(pstmt);
			}
		
		return check;
	}

	public ArrayList<sellermall> getAllsellermallList(int page, int limit) {
		ArrayList<sellermall> sellermallList = new ArrayList<sellermall>();
		String sql = " select  * from sellermall LIMIT ? , ?";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, page);
			pstmt.setInt(2, limit);
			//pstmt.setInt(1, page);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				sellermall mall = new sellermall();
				mall.setId(rs.getInt("id"));
				mall.setSeller_id(rs.getInt("seller_id"));
				mall.setName(rs.getString("name"));
				mall.setCreate_date(rs.getString("create_date"));
				mall.setGrade(rs.getString("grade"));
				sellermallList.add(mall);
			}
			
		}catch(Exception e){
			System.out.println("[DAO] productPageGetList 에러" + e );
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return sellermallList;
	}

	public int shopPageGet() {
		 int cnt = 0;
			String sql = " select count(*) cnt from sellermall ";
			try {
				
				pstmt = con.prepareStatement(sql);
				
				//pstmt.setInt(1, page);
				rs= pstmt.executeQuery();
				
				if(rs.next()) {
					cnt = rs.getInt(1);
				}
				
			}catch(Exception e){
				System.out.println("[DAO] getAllProductListCnt 에러" + e );
			}finally {
				close(rs);
				close(pstmt);
			}
				
			return cnt;
	}

	public int myImformationUpdate(Users inputuser) {
		int check = 0;
		
		String sql =" update users set userid = ? ,password=? , name=? ,email=? ,phone = ?where id = ? ";
		try {
								
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, inputuser.getUserid());
			pstmt.setString(2, inputuser.getPassword());
			pstmt.setString(3, inputuser.getName());
			pstmt.setString(4, inputuser.getEmail());
			pstmt.setString(5, inputuser.getPhone());
			pstmt.setInt(6, inputuser.getId());
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] myImformationUpdate 에러" + e );
			}finally {
				close(pstmt);
			}
		
		return check;
	}

	public int snsSubmit(int users_id, String snsId, String snsEmail) {
		int check = 0;
		String sql =" insert into snsLogin (users_id , snsId, snsEmail ) values(?,?,?) ";
		try {
								
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, users_id);
			pstmt.setString(2, snsId);
			pstmt.setString(3, snsEmail);
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] snsSubmit 에러" + e );
			}finally {
				close(pstmt);
			}
		
		return check;
	}

	public int usersupdatesnsSubmit(int users_id) {
		int check = 0;
		
		String sql =" update users set snsLogin_id = 01 where id = ? ";
		try {
								
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, users_id);
			check= pstmt.executeUpdate();

			}catch(Exception e){
				System.out.println("[DAO] myImformationUpdate 에러" + e );
			}finally {
				close(pstmt);
			}
		
		return check;
	}

	public int ForSnsLoginGetUsers_id(String snsId, String snsEmail) {
		 int users_id = 0;
			String sql = " select users_id from snsLogin where snsId = ? and snsEmail = ? ";
			try {
				
				
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, snsId);
				pstmt.setString(2, snsEmail);
				//pstmt.setInt(1, page);
				rs= pstmt.executeQuery();
				
				if(rs.next()) {
					users_id = rs.getInt("users_id");
				}
				
			}catch(Exception e){
				System.out.println("[DAO] ForSnsLoginGetUsers_id 에러" + e );
			}finally {
				close(rs);
				close(pstmt);
			}
				
			return users_id;
	}

	public ArrayList<Product> mallproductGet(int mallID) {
		ArrayList<Product> productList = new ArrayList<Product>();
		String sql = " select * from product where sellerMall_id = ? ";
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, mallID);
			
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
				product.setStock(rs.getInt("stock"));
				
				productList.add(product);
			}
			
		}catch(Exception e){
			System.out.println("[DAO] getProduct 에러" + e );
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return productList;
	}
	


	
	
}
