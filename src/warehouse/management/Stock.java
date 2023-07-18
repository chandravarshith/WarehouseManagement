package warehouse.management;

public class Stock {
	private String stockId;
	private String itemName;
	private int quantity;
	private double price;
	private String sellerName;
	private String sellerNumber;
	
	public Stock(String stockId, String itemName, int quantity, double price, String sellerName, String sellerNumber) {
		super();
		this.stockId = stockId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
		this.sellerName = sellerName;
		this.sellerNumber = sellerNumber;
	}
	
	
	public String getStockId() {
		return stockId;
	}
	
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
	
}
