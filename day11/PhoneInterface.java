package day11;

public interface PhoneInterface {
	
	// 상수 
	final int TIMEOUT = 10000;
	void sendCall();
	void receiveCall();
	default void printlogo() {
		System.out.println("** Phone **");
	}

	
	
	
	// 추상 메소드 

}
