package day09;

public class Animal {
	
	// 캡슐화..
	
	private String name;
	private int age; 
	
	public Animal( ) {}
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
	public void setName(String name) { // 멤버값을 저장하는 setter 메소드 
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() { // 속성(필드) 값을 확인하는 용도의 getter 메소드 
		return name;
	}
	public int getAge() {
		return age;
	}
	public static void main(String[] args) {


	}

}
