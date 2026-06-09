package day11;

public class SamsungPhone implements PhoneInterface{
	

	public static void main(String[] args) {
		
		SamsungPhone sp = new SamsungPhone();
		sp.sendCall();
		sp.receiveCall();
		
		PhoneInterface pi = new SamsungPhone();
		
	}

	@Override
	public void sendCall() {
		System.out.println("띠리리링");
		
	}

	@Override
	public void receiveCall() {
		System.out.println("전화가 왔습니다.");
		
	}

}
