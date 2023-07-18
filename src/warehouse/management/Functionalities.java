package warehouse.management;

import java.util.ArrayList;

public class Functionalities {
	private ArrayList<Seller> sellers;
	private ArrayList<Buyer> buyers;
	private ArrayList<Stock> stock;
	private int sellerIndex;
	private int buyerIndex;
	private int stockIndex;
	private int orderIdCount;
	
	public Functionalities() {
		this.sellers = new ArrayList<>();
		this.buyers = new ArrayList<>();
		this.stock = new ArrayList<>();
		this.sellerIndex = 0;
		this.buyerIndex = 0;
		this.stockIndex = 0;
		this.orderIdCount = 1;
	}
	
	
	//Admin functionalities
	public boolean adminLogin(String number, String password) {
		if(Administrator.getAdminNumber().equals(number)) {
			if(Administrator.getAdminPassword().equals(password)) {
				System.out.println("\nLogin Successful!\n");
				return true;
			}
			else System.out.println("\nInvalid Password!\n");
		}
		else System.out.println("\nInvalid Username!\n");
		return false;
	}

	public void displaySellerDetails(String sellerNumber) {
		if(setSellerIndex(sellerNumber) != null) {
			System.out.println("____________________________________Seller Details_________________________________________\n");
			System.out.println("\t\t\tSeller Name\t\t:\t"+this.sellers.get(sellerIndex).getSellerName());
			System.out.println("\t\t\tMobile Number\t\t:\t"+this.sellers.get(sellerIndex).getSellerNumber());
			System.out.println("\t\t\tPassword\t\t:\t"+this.sellers.get(sellerIndex).getSellerPassword());
			System.out.println("___________________________________________________________________________________________\n");
		}
		else {
			System.out.println("\nSeller not found!\n");
		}
	}

	public void removeSellerDetails(String sellerNumber) {
		if(setSellerIndex(sellerNumber) != null) {
			displaySellerDetails(sellerNumber);
			this.sellers.remove(sellerIndex);
			System.out.println("\nSeller deleted successfully!\n");
		}
		else {
			System.out.println("\nSeller not found!\n");
		}
	}

	public Stock getStockDetails(String stockId) {
		int i = 0;
		while(i < this.stock.size()) {
			Stock item = this.stock.get(i);
			if(item.getStockId().equals(stockId)) {
				this.stockIndex = i;
				return item;
			}
			i++;
		}
		return null;
	}
	
	public void viewAvailabilityOfStock(String stockId) {
		Stock item = getStockDetails(stockId);
		if(item == null) {
			System.out.println("\nSorry, no stock is available with Stock ID: "+stockId);
			System.out.println();
			return;
		}
		
		System.out.println("\nStock Name\t\t:\t"+item.getItemName());
		System.out.println("Available Quantity\t:\t"+item.getQuantity());
		System.out.println();
	}
	
	public void displayStock() {
		int i = 0;
		System.out.println("__________________________________________________Stock List________________________________________________________\n");
		System.out.printf("\t%10s %23s %22s %20s %20s\n","Stock ID","Stock Name","Seller Name","Price","Quantity");
		System.out.println("____________________________________________________________________________________________________________________\n");
		while(i < this.stock.size()) {
			Stock item = this.stock.get(i);
			System.out.format("\t%10s %23s %19s %21s %20s", item.getStockId(), item.getItemName(), item.getSellerName(),
					item.getPrice(),item.getQuantity());  
			System.out.println();  
			i++;
		}
		System.out.println("____________________________________________________________________________________________________________________\n");
	}
	
	
	
	
	//Seller functionalities
	public Seller setSellerIndex(String number) {
		int i = 0;
		while(i < this.sellers.size()) {
			Seller s = this.sellers.get(i);
			if(s.getSellerNumber().equals(number)) {
				this.sellerIndex = i;
				return s;
			}
			i++;
		}
		return null;
	}

	public void registerSeller(Seller seller) {
		this.sellers.add(seller);
		if(setSellerIndex(seller.getSellerNumber()) == null) {
			System.out.println("\nSeller not found, Please Register!\n");
			return;
		}
		this.sellers.get(sellerIndex).setOrders(new ArrayList<>());
	}

	public int sellerLogin(String number, String password) {
		Seller s = setSellerIndex(number);
		if(s != null) {
			if(this.sellers.get(this.sellerIndex).getSellerNumber().equals(number)) {
				if(this.sellers.get(this.sellerIndex).getSellerPassword().equals(password)) {
					System.out.println("\nLogin Successful!\n");
					return 0;
				}
				else System.out.println("\nInvalid Password!\n");
			}
			else System.out.println("\nInvalid Mobile Number!\n");
		}
		else if(s == null) {
			System.out.println("\nSeller not found, Please Register!\n");
			return 1;
		}
		return 2;
	}


	public void addStockDetails(String stockId, String name, int quantity, Double price) {
		String sellerName = this.sellers.get(sellerIndex).getSellerName();
		String sellerNumber = this.sellers.get(sellerIndex).getSellerNumber();
		this.stock.add(new Stock(stockId, name, quantity, price, sellerName,sellerNumber));
	}


	public void displaySellerOrders() {
		Seller s = this.sellers.get(sellerIndex);
		ArrayList<Order> orders = s.getOrders();
		System.out.println("Total number of order = "+orders.size());
		int i = 0;
		System.out.println("________________________________________Seller Orders___________________________________________\n");
		System.out.printf("\t%10s %23s %22s %22s\n","Order ID","Buyer Name","Product Name","Ordered Quantity");
		System.out.println("________________________________________________________________________________________________\n");
		while(i < orders.size()) {
			Order o = orders.get(i);
			System.out.format("\t%10s %23s %22s %22s\n", o.getOrderId(),o.getBuyerName(), o.getProductName(),o.getOrderedQuantity()); 
			i++;
		}
		System.out.println("________________________________________________________________________________________________\n");
		
	}


	public void updateSellerOrders(String orderId) {
		int orderIndex = this.sellers.get(sellerIndex).getOrderIndex(orderId);
		ArrayList<Order> sellerOrders = this.sellers.get(sellerIndex).getOrders();
		String buyerNumber = sellerOrders.get(orderIndex).getBuyerNumber();
		setBuyerIndex(buyerNumber);
		ArrayList<Order> buyerOrders = this.buyers.get(buyerIndex).getOrders();
		orderIndex = this.buyers.get(buyerIndex).getOrderIndex(orderId);
		Order o = buyerOrders.get(orderIndex);
		o.setOrderStatus("Delivered");
		buyerOrders.set(orderIndex, o);
		this.buyers.get(buyerIndex).setOrders(buyerOrders);
		
		this.sellers.get(sellerIndex).deleteOrder(orderId);
	}

	
	
	
	//Buyer functionalities
	public Buyer setBuyerIndex(String number) {
		int i = 0;
		while(i < this.buyers.size()) {
			Buyer b = this.buyers.get(i);
			if(b.getBuyerNumber().equals(number)) {
				this.buyerIndex = i;
				return b;
			}
			i++;
		}
		return null;
	}

	public void registerBuyer(Buyer buyer) {
		this.buyers.add(buyer);
		if(setBuyerIndex(buyer.getBuyerNumber()) == null) {
			System.out.println("\nBuyer not found, Please Register!\n");
			return;
		}
		this.buyers.get(buyerIndex).setOrders(new ArrayList<>());
	}

	public int buyerLogin(String number, String password) {
		Buyer b = setBuyerIndex(number);
		if(b != null) {
			if(this.buyers.get(this.buyerIndex).getBuyerNumber().equals(number)) {
				if(this.buyers.get(this.buyerIndex).getBuyerPassword().equals(password)) {
					System.out.println("\nLogin Successful!\n");
					return 0;
				}
				else System.out.println("\nInvalid Password!\n");
			}
			else System.out.println("\nInvalid Mobile Number!\n");
		}
		else if(b == null) {
			System.out.println("\nBuyer not found, Please Register!\n");
			return 1;
		}
		return 2;
	}

	public void addAddressToBuyer(String name, String number, String doorNum, String area, String city, String state,
			String areaCode) {
		this.buyers.get(buyerIndex).getAddress().add(new Address(name,number,doorNum,area,city,state,areaCode));
		System.out.println("\nAddress added Successfully!\n");
	}
	
	public boolean displayAddresses() {
		Buyer b = this.buyers.get(buyerIndex);
		ArrayList<Address> addressList = b.getAddress();
		System.out.println("________________________Addresses__________________________\n");
		int i=0;
		while(i < addressList.size()) {
			Address a = addressList.get(i);
			System.out.println(" "+(i+1)+". Name\t\t:\t"+a.getName());
			System.out.println("    Mobile Number\t:\t"+a.getMobileNumber());
			System.out.println("    Door Number\t\t:\t"+a.getDoorNum());
			System.out.println("    Area\t\t:\t"+a.getArea());
			System.out.println("    City\t\t:\t"+a.getCity());
			System.out.println("    State\t\t:\t"+a.getState());
			System.out.println("    Area Code\t\t:\t"+a.getAreaCode());
			System.out.println();
			i++;
		}
		System.out.println("___________________________________________________________\n");
		if(i == 0) {
			System.out.println("\nNo Address added!\n");
			return false;
		}
		return true;
	}


	public int getNumberOfAddress() {
		return this.buyers.get(buyerIndex).getAddress().size();
	}

	public void editAddress(int serialNum, int editOp, String newValue) {
		Buyer b = this.buyers.get(buyerIndex);
		ArrayList<Address> addressList = b.getAddress();
		Address a = addressList.get(serialNum-1);
		switch(editOp) {
			case 1:
				a.setName(newValue); break;
			case 2:
				a.setMobileNumber(newValue); break;
			case 3:
				a.setDoorNum(newValue); break;
			case 4:
				a.setArea(newValue); break;
			case 5:
				a.setCity(newValue); break;
			case 6:
				a.setState(newValue); break;
			case 7:
				a.setAreaCode(newValue); break;
		}
		addressList.set(serialNum-1, a);
		b.setAddress(addressList);
		System.out.println("\nAddress changed Successfully!\n");
	}

	public void deleteAddress(int serialNum1) {
		Buyer b = this.buyers.get(buyerIndex);
		ArrayList<Address> addressList = b.getAddress();		
		addressList.remove(serialNum1-1);
		b.setAddress(addressList);
		System.out.println("\nAddress deleted Successfully!\n");
	}

	public void viewProducts() {
		int i = 0;
		System.out.println("_____________________________Products_____________________________________\n");
		System.out.printf("\t%10s %20s %20s\n","Product ID","Product Name","Price");
		System.out.println("__________________________________________________________________________\n");
		while(i < this.stock.size()) {
			Stock item = this.stock.get(i);
			System.out.format("\t%10s %20s %20s", item.getStockId(), item.getItemName(),item.getPrice());  
			System.out.println();  
			i++;
		}
		System.out.println("__________________________________________________________________________\n");
	}

	public void placeOrder(String stockId, int orderQuantity) {
		Stock s = getStockDetails(stockId);
		if(s.getQuantity() < orderQuantity) {
			System.out.println("\nSorry! The maximum order quantity for this Product is "+s.getQuantity()+"\n");
			return;
		}
		Seller seller = setSellerIndex(s.getSellerNumber());
		if(seller == null) {
			System.out.println("\nSeller not found, Order cannot be placed!\n");
			return;
		}
		
		Buyer b = this.buyers.get(buyerIndex);
		ArrayList<Order> buyerOrderList = b.getOrders();
		Double orderCost = s.getPrice()*orderQuantity;
		Order o = new Order(Integer.toString(this.orderIdCount),stockId,s.getItemName(),orderQuantity,s.getSellerName(),b.getBuyerName(),b.getBuyerName(),orderCost);
		this.orderIdCount++;
		buyerOrderList.add(o);
		b.setOrders(buyerOrderList);
		
		seller = this.sellers.get(sellerIndex);
		ArrayList<Order> sellerOrderList = seller.getOrders();
		sellerOrderList.add(o);
		seller.setOrders(sellerOrderList);	
		
		this.stock.get(stockIndex).setQuantity(s.getQuantity()-orderQuantity);
		if(this.stock.get(stockIndex).getQuantity() == 0) {
			this.stock.remove(stockIndex);
		}
		
		System.out.println("\nOrder placed successfully!\n");
	}


	public void displayBuyerOrders() {
		Buyer b = this.buyers.get(buyerIndex);
		ArrayList<Order> orders = b.getOrders();
		System.out.println("Total number of order = "+orders.size());
		int i = 0;
		System.out.println("______________________________________________________Buyer Orders_________________________________________________________\n");
		System.out.printf("\t%10s %23s %22s %22s %25s\n","Order ID","Product Name","OrderedQuantity","Order Cost","Order Status");
		System.out.println("___________________________________________________________________________________________________________________________\n");
		while(i < orders.size()) {
			Order o = orders.get(i);
			System.out.format("\t%10s %23s %22s %22s %25s\n", o.getOrderId(),o.getProductName(),o.getOrderedQuantity(),o.getOrderCost(),o.getOrderStatus());
			i++;
		}
		System.out.println("___________________________________________________________________________________________________________________________\n");
	}
	
}
