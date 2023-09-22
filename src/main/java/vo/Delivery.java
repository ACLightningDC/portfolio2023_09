package vo;

public class Delivery {
	private int id;
	private int address_id;
	private String delivery_company;
	private String delivery_num;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public String getDelivery_company() {
		return delivery_company;
	}
	public void setDelivery_company(String delivery_company) {
		this.delivery_company = delivery_company;
	}
	public String getDelivery_num() {
		return delivery_num;
	}
	public void setDelivery_num(String delivery_num) {
		this.delivery_num = delivery_num;
	}
	
	
	
}
