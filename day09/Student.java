package day09;

public class Student extends Human{
	
	// 학생만이 갖는 필드(속성) 정의
	private String sid;
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid; 
	}
	
	// 인자 생성자
	public Student(String name, int age, String sid ) {
		//this.name = name;
		//this.age = age; 
		super(name,age);
		this.sid = sid;
	}

	public static void main(String[] args) {
		// T

	}

}
