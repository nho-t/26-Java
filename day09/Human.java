package day09;

public class Human extends Animal { // extends - 상속 키워드
	
	public Human( ) {}
	
	public Human(String name, int age) {
		super(name, age);
	}
	
	// private
	private String addr;
	
	//getter 
	public String getAddr() {
		return addr;
	}
	
	//setter
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public void eat() {}
	public void sleep() {}
	public void love() {}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
