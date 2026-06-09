package day07;

public class PersonTest {
	
	public static void main(String[] args) {
		// person 객체 생성하기 = hong 객체 생성 / instance
		Person hong = new Person(); // 생성자 함수, Person.java에 있는 Person Class에 접근하기위해 hong이 라는 변수를 만듬
//		hong.name = "홍길동"; // 굳이 필요 X, Person.java 에서 이미 있기 때문
//		hong.age = 20;
//		hong.abc = 'A';
		hong.밥먹기();
		hong.운동하기("헬스");
		
//		hong.addr = "대전 동구 용운동";
//		System.out.println(Person.getName()); // static 메소스 호출은 클래스이름. 으로 사용

		
		Person kim = new Person();
		kim.name = "김사람";
		kim.age = 20;
		kim.abc = 'B';
		kim.밥먹기();
		kim.운동하기("러닝");
		
	}

}
