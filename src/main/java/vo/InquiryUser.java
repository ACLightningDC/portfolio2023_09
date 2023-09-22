package vo;

public class InquiryUser {
/**
 * 제품 이름 
 * 제품 사진 
 * 쇼핑몰 이름 
 * 
 * 질문 이름
 * 질문 내용
 * 질문 시간 
 * 질문 결과
 * 
 * 주문 일자
 */
		
	private String contents;
	private String name;
	private String date;
	private String result;
	
	private String product_name;
	private String product_img;
	
	private String sellermall_name;
	
	private String order_list_date;

	
	
	public InquiryUser() { }
	

	public InquiryUser(String contents, String name, String date, String result, String product_name,
			String product_img, String sellermall_name, String order_list_date) {
		super();
		this.contents = contents;
		this.name = name;
		this.date = date;
		this.result = result;
		this.product_name = product_name;
		this.product_img = product_img;
		this.sellermall_name = sellermall_name;
		this.order_list_date = order_list_date;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_img() {
		return product_img;
	}

	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}

	public String getSellermall_name() {
		return sellermall_name;
	}

	public void setSellermall_name(String sellermall_name) {
		this.sellermall_name = sellermall_name;
	}

	public String getOrder_list_date() {
		return order_list_date;
	}

	public void setOrder_list_date(String order_list_date) {
		this.order_list_date = order_list_date;
	}


	@Override
	public String toString() {
		return "InquiryUser [contents=" + contents + ", name=" + name + ", date=" + date + ", result=" + result
				+ ", product_name=" + product_name + ", product_img=" + product_img + ", sellermall_name="
				+ sellermall_name + ", order_list_date=" + order_list_date + "]";
	}
	
	
	
}
