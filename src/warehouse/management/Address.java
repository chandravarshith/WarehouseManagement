package warehouse.management;

public class Address {
	private String name;
	private String mobileNumber;
	private String doorNum;
	private String area;
	private String city;
	private String state;
	private String areaCode;
	
	public Address(String name, String mobileNumber, String doorNum, String area, String city, String state,
			String areaCode) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.doorNum = doorNum;
		this.area = area;
		this.city = city;
		this.state = state;
		this.areaCode = areaCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getDoorNum() {
		return doorNum;
	}

	public void setDoorNum(String doorNum) {
		this.doorNum = doorNum;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
}
