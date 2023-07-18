package warehouse.management;

public class Administrator {
	private static String adminName = "Admin";
	private static String adminNumber = "1234567890";
	private static String adminPassword = "Password";
	
	
	public static String getAdminName() {
		return adminName;
	}
	public static void setAdminName(String adminName) {
		Administrator.adminName = adminName;
	}
	public static String getAdminNumber() {
		return adminNumber;
	}
	public static void setAdminNumber(String adminNumber) {
		Administrator.adminNumber = adminNumber;
	}
	public static String getAdminPassword() {
		return adminPassword;
	}
	public static void setAdminPassword(String adminPassword) {
		Administrator.adminPassword = adminPassword;
	}
	
	
}
