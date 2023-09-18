package vo;

public class Order_list {

private int id;
private int users_id;
private int product_id;
private int order_count;
private int delivery_id;
private String date;
private String result;

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
public int getProduct_id() {
	return product_id;
}
public void setProduct_id(int product_id) {
	this.product_id = product_id;
}
public int getOrder_count() {
	return order_count;
}
public void setOrder_count(int order_count) {
	this.order_count = order_count;
}
public int getDelivery_id() {
	return delivery_id;
}
public void setDelivery_id(int delivery_id) {
	this.delivery_id = delivery_id;
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
@Override
public String toString() {
	return "Order_list [id=" + id + ", users_id=" + users_id + ", product_id=" + product_id + ", order_count="
			+ order_count + ", delivery=" + delivery_id + ", date=" + date + ", result=" + result + "]";
}
}
