package vo;

public class Pay {
	private String orderId; 
	private String mId; 
	private String paymentKey; 
	private int order_num; 
	private String id; 
	private String email;
	private String orderName; 
	private String pay_method; 
	private String easyPay; 
	private String pay_bank; 
	private String pay_status; 
	private String pay_date; 
	private String cancelReason; 
	private String cancel_date; 
	private int cancelAmount; 
	
	public Pay() {}
	
	//orderId, 취소 제외
	
	public Pay(String mId, String paymentKey, int order_num, String id, String email, String orderName,
			String pay_method, String easyPay, String pay_bank, String pay_status, String pay_date) {
		super();
		this.mId = mId;
		this.paymentKey = paymentKey;
		this.order_num = order_num;
		this.id = id;
		this.email = email;
		this.orderName = orderName;
		this.pay_method = pay_method;
		this.easyPay = easyPay;
		this.pay_bank = pay_bank;
		this.pay_status = pay_status;
		this.pay_date = pay_date;
	}

	public Pay(String orderId, String mId, String paymentKey, int order_num, String id, String email,
			String orderName, String pay_method, String easyPay, String pay_bank, String pay_status, String pay_date,
			String cancelReason, String cancel_date, int cancelAmount) {
		super();
		this.orderId = orderId;
		this.mId = mId;
		this.paymentKey = paymentKey;
		this.order_num = order_num;
		this.id = id;
		this.email = email;
		this.orderName = orderName;
		this.pay_method = pay_method;
		this.easyPay = easyPay;
		this.pay_bank = pay_bank;
		this.pay_status = pay_status;
		this.pay_date = pay_date;
		this.cancelReason = cancelReason;
		this.cancel_date = cancel_date;
		this.cancelAmount = cancelAmount;
	}

	@Override
	public String toString() {
		return "Pay_DTO [orderId=" + orderId + ", mId=" + mId + ", paymentKey=" + paymentKey + ", order_num="
				+ order_num + ", id=" + id + ", email=" + email + ", orderName=" + orderName + ", pay_method="
				+ pay_method + ", easyPay=" + easyPay + ", pay_bank=" + pay_bank + ", pay_status=" + pay_status
				+ ", pay_date=" + pay_date + ", cancelReason=" + cancelReason + ", cancel_date=" + cancel_date
				+ ", cancelAmount=" + cancelAmount + "]";
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getPaymentKey() {
		return paymentKey;
	}

	public void setPaymentKey(String paymentKey) {
		this.paymentKey = paymentKey;
	}

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getPay_method() {
		return pay_method;
	}

	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}

	public String getEasyPay() {
		return easyPay;
	}

	public void setEasyPay(String easyPay) {
		this.easyPay = easyPay;
	}

	public String getPay_bank() {
		return pay_bank;
	}

	public void setPay_bank(String pay_bank) {
		this.pay_bank = pay_bank;
	}

	public String getPay_status() {
		return pay_status;
	}

	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
	}

	public String getPay_date() {
		return pay_date;
	}

	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getCancel_date() {
		return cancel_date;
	}

	public void setCancel_date(String cancel_date) {
		this.cancel_date = cancel_date;
	}

	public int getCancelAmount() {
		return cancelAmount;
	}

	public void setCancelAmount(int cancelAmount) {
		this.cancelAmount = cancelAmount;
	}
	
	
}
