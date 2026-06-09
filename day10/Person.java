package day10;

public class Person {
	
	String name;
	String id; 
	
	public Person(String name, String id) {
		this.name = name;
		this.id = id;
		
	}
	
	public void printInfo() {
		System.out.println("이름 : " + name + "ID : " + id);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
