package avante.domain;

public class Book {
	private String title;
	private float price;
	private int quantity;
	
	public Book() {
		
	}
	
	public Book(String title,float price,int quantity) {
		this.title=title;
		this.price=price;
		this.quantity=quantity;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
