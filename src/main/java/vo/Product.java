package vo;

public class Product {
private int id;
private int sellerMall_id;
private int price;
private String name;
private String kind;
private String date;
private String img;
private int buycount;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getSellerMall_id() {
	return sellerMall_id;
}
public void setSellerMall_id(int sellerrMall_id) {
	this.sellerMall_id = sellerrMall_id;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getKind() {
	return kind;
}
public void setKind(String kind) {
	this.kind = kind;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public int getBuycount() {
	return buycount;
}
public void setBuycount(int buycount) {
	this.buycount = buycount;
}

}
