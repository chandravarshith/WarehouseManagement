package warehouse.management;

import java.util.ArrayList;

public class Buyer {
	private String buyerName;
	private String buyerNumber;
	private String buyerPassword;
	private ArrayList<Address> address;
	private ArrayList<Order> orders;
	
	
	public Buyer(String buyerName, String buyerNumber, String buyerPassword) {
		super();
		this.buyerName = buyerName;
		this.buyerNumber = buyerNumber;
		this.buyerPassword = buyerPassword;
		this.address = new ArrayList<>();
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
	
	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
	public String getBuyerName() {
		return buyerName;
	}
	
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	
	public String getBuyerNumber() {
		return buyerNumber;
	}
	
	public void setBuyerNumber(String buyerNumber) {
		this.buyerNumber = buyerNumber;
	}
	
	public String getBuyerPassword() {
		return buyerPassword;
	}
	
	public void setBuyerPassword(String buyerPassword) {
		this.buyerPassword = buyerPassword;
	}

	public ArrayList<Address> getAddress() {
		return address;
	}

	public void setAddress(ArrayList<Address> address) {
		this.address = address;
	} 
	
}
