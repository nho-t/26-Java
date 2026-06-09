package day07;

public class Person {
	// 필드(변수)
	String name;
	int age;
	char abc; // 혈액형 // 자바 추상화? 
	// 기본 생성자 정의 : 클래스 이름과 동일한 메소드, 객체 생성시 호출
	// 역할 : 필드(변수 초기화)
	public Person() { // void나 static을 넣지 않아도 됨. 컴파일러가 알아서 호출하기 때문	
		name = "홍길동";
		age = 20;
		abc = 'A';
		System.out.println("객체가 생성됨"); // 소소코드를 생성자로 바꾸시오 하며 바꿀 수 있어야함 (시험 출제)
	}
	
	public person() {
		public static String name; 	
	}

	
	// 메소드
	public void 밥먹기() {
		System.out.println("밥먹다.");
	}

	
	public void 운동하기(String s) {
		System.out.println(s + "종목을 운동합니다.");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
