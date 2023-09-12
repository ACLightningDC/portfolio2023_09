package vo.kakaopay;

import java.util.Date;

public class PaymentVO {

	private int pay_code;//
	private long odr_code;
	private String pay_method;
	private Date pay_date;
	private int pay_tot_price;
	private int pay_rest_price;
	private String pay_noback_user;
	private String pay_nobank;
	public int getPay_code() {
		return pay_code;
	}
	public void setPay_code(int pay_code) {
		this.pay_code = pay_code;
	}
	public long getOdr_code() {
		return odr_code;
	}
	public void setOdr_code(long odr_code) {
		this.odr_code = odr_code;
	}
	public String getPay_method() {
		return pay_method;
	}
	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}
	public Date getPay_date() {
		return pay_date;
	}
	public void setPay_date(Date pay_date) {
		this.pay_date = pay_date;
	}
	public int getPay_tot_price() {
		return pay_tot_price;
	}
	public void setPay_tot_price(int pay_tot_price) {
		this.pay_tot_price = pay_tot_price;
	}
	public int getPay_rest_price() {
		return pay_rest_price;
	}
	public void setPay_rest_price(int pay_rest_price) {
		this.pay_rest_price = pay_rest_price;
	}
	public String getPay_noback_user() {
		return pay_noback_user;
	}
	public void setPay_noback_user(String pay_noback_user) {
		this.pay_noback_user = pay_noback_user;
	}
	public String getPay_nobank() {
		return pay_nobank;
	}
	public void setPay_nobank(String pay_nobank) {
		this.pay_nobank = pay_nobank;
	}
	
	
	
}
