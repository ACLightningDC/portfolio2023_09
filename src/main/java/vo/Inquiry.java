package vo; //리스트 내역 추가 -> 작성

import java.util.Date;

public class Inquiry {
    private int id;
    private int users_id;
    private int sellerMall_id;
    private int product_id;
    private int order_list_id;
    
    private String contents; //내용
    private String name;  //제목
 
    private String inquiryDate; //문의 작성일
	


	private String result;
    private String answer;
    
    
	public Inquiry() { }

	
	public Inquiry(int id, int users_id, int sellerMall_id, int product_id, int order_list_id, String contents,
			String name, String inquiryDate, String result, String answer) {
		super();
		
		this.id = id;
		this.users_id = users_id;
		this.sellerMall_id = sellerMall_id;
		this.product_id = product_id;
		this.order_list_id = order_list_id;
		this.contents = contents;
		this.name = name;
		this.inquiryDate = inquiryDate;
		this.result = result;
		this.answer = answer;
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

	public int getOrder_list_id() {
		return order_list_id;
	}

	public void setOrder_list_id(int order_list_id) {
		this.order_list_id = order_list_id;
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


	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getInquiryDate() {
		return inquiryDate;
	}
	
	
	public void setInquiryDate(String inquiryDate) {
		this.inquiryDate = inquiryDate;
	}
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}


	@Override
	public String toString() {
		return "Inquiry [id=" + id + ", users_id=" + users_id + ", sellerMall_id=" + sellerMall_id + ", product_id="
				+ product_id + ", order_list_id=" + order_list_id + ", contents=" + contents + ", name=" + name
				+ ", inquiryDate=" + inquiryDate + ", result=" + result + ", answer=" + answer + "]";
	}


	
}
