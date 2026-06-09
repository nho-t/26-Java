package BookMarket;

public class Person {
	private String name;
	private String phone;
	private String address;

	public Person(String name, int phone) {
		this(name, String.valueOf(phone));
	}

	public Person(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public Person(String name, int phone, String address) {
		this(name, String.valueOf(phone), address);
	}

	public Person(String name, String phone, String address) {
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = String.valueOf(phone);
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
