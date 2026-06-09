package day11;

public class SmartPhone extends Calc implements PhoneInterface {
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "스마트폰입니다.";
	}
	
	
	
	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone();
		sp.sendCall();
		sp.receiveCall();
		System.out.println("3 + 5 = " + sp.claculate(3, 5));
		System.out.println(sp.toString());

	}

	@Override
	public void sendCall() {
		System.out.println("스마트폰 벨소리");
		
	}

	@Override
	public void receiveCall() {
		System.out.println("스마트폰 전화가 왔습니다.");
		
	}

}
