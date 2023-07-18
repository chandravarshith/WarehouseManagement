package warehouse.management;

import java.util.ArrayList;

public class Seller {
	private String sellerName;
	private String sellerNumber;
	private String sellerPassword;
	private ArrayList<Order> orders;
	
	
	public Seller(String sellerName, String sellerNumber, String sellerPassword) {
		super();
		this.sellerName = sellerName;
		this.sellerNumber = sellerNumber;
		this.sellerPassword = sellerPassword;
	}
	

	public ArrayList<Order> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	public String getSellerName() {
		return sellerName;
	}
	
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	
	public String getSellerNumber() {
		return sellerNumber;
	}
	
	public void setSellerNumber(String sellerNumber) {
		this.sellerNumber = sellerNumber;
	}
	
	public String getSellerPassword() {
		return sellerPassword;
	}
	
	public void setSellerPassword(String sellerPassword) {
		this.sellerPassword = sellerPassword;
	}


	public int getOrderIndex(String orderId) {
		int i=0;
		while(i<this.orders.size()) {
			if(orderId.equals(this.orders.get(i).getOrderId())) {
				return i;
			}
			i++;
		}
		return 0;
	}

	public void deleteOrder(String orderId) {
		this.orders.remove(getOrderIndex(orderId));
	}
	
	
}
