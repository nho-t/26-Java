package day10;

public class SchoolApp {
	
	public static void print(Person p) {
//		if(p instanceof Person) {
//			System.out.println("사람 객체 입니다.");
//		}
		if(p instanceof Student) {
			System.out.println("학생 객체 입니다.");
		}
		if(p instanceof Researcher) {
			System.out.println("리서처 객체 입니다.");
		}
		
	}

	public static void main(String[] args) {

		
		Person p = new Person("이사람", "0110");
		Student p1 = new Student("김학생", "1111");
		Researcher p2 = new Researcher("박리서처", "2222");
		
		print(p);
		print(p1);
		print(p2);

	}

}
