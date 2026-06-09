package BookMarket;

public class User extends Person {
	public User(String name, int phone) {
		super(name, phone);
	}

	public User(String name, String phone) {
		super(name, phone);
	}

	public User(String username, int phone, String address) {
		super(username, phone, address);
	}

	public User(String username, String phone, String address) {
		super(username, phone, address);
	}
}
