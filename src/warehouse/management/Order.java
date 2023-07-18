package warehouse.management;

public class Order {
	private String orderId;
	private String productId;
	private String productName;
	private int orderedQuantity;
	private String sellerName;
	private String buyerName;
	private String buyerNumber;
	private double orderCost;
	private String orderStatus;
	
	public Order(String orderId, String productId, String productName, int orderedQuantity, String sellerName,
			String buyerName,String buyerNumber,double orderCost) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.productName = productName;
		this.orderedQuantity = orderedQuantity;
		this.sellerName = sellerName;
		this.buyerName = buyerName;
		this.buyerNumber = buyerNumber;
		this.orderCost = orderCost;
		this.orderStatus = "Yet to be delivered";
	}
	

	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getOrderedQuantity() {
		return orderedQuantity;
	}
	public void setOrderedQuantity(int orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public double getOrderCost() {
		return orderCost;
	}
	public void setOrderCost(double orderCost) {
		this.orderCost = orderCost;
	}
	public String getBuyerNumber() {
		return buyerNumber;
	}
	public void setBuyerNumber(String buyerNumber) {
		this.buyerNumber = buyerNumber;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
}
