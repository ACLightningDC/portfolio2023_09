package vo; //리스트 내역 추가 -> 작성

import java.util.Date;

public class Inquiry {
    private int id;
    private int users_id;
    private int sellerMall_id;
    private int product_id;
    private String contents; //내용
    private String name;  //제목
    private int order_list_id;
    private Date inquiryDate; //문의 작성일
	
	public Inquiry() { }

	public Inquiry(int id, int users_id, int sellerMall_id, int product_id, String contents, String name,
			int order_list_id, Date inquiryDate) {
		super();
		this.id = id;
		this.users_id = users_id;
		this.sellerMall_id = sellerMall_id;
		this.product_id = product_id;
		this.contents = contents;
		this.name = name;
		this.order_list_id = order_list_id;
		this.inquiryDate = inquiryDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

	public int getSellerMall_id() {
		return sellerMall_id;
	}

	public void setSellerMall_id(int sellerMall_id) {
		this.sellerMall_id = sellerMall_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrder_list_id() {
		return order_list_id;
	}

	public void setOrder_list_id(int order_list_id) {
		this.order_list_id = order_list_id;
	}

	public Date getInquiryDate() {
		return inquiryDate;
	}

	public void setInquiryDate(Date inquiryDate) {
		this.inquiryDate = inquiryDate;
	}

	
	
	
}
