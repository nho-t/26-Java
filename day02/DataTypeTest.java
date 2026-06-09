package day02;

public class DataTypeTest {

	public static void main(String[] args) {
		// 1. 기본형 
		boolean IsTrue; 
		int age;
		double height, weight; 
		
		
		// 2. 변수 초기화
		IsTrue = false; 
		age = 20; 
		height = 189.9; 
		weight = 90.12; 
		
		
		
		
		
		// 3. 레퍼런스형 - 3개 (배열, 클래스, 인터페이스)
		String name = "박준호";
		//name = "박준호";
		String s = new String("홍길동");
		String addr = "경기도 화성시 만세구 향남읍 행정중앙 2로 83";
		
		
		// 레퍼런스 변수 만들기(클래스 명으로) 
		DataTypeTest dtt = new DataTypeTest();
		
		// 4. 변수 값 출력하기 
		
		System.out.println(IsTrue);
		System.out.println("나이 : " + age);
		System.out.println("키 : " + height);
		System.out.println("몸무게 : " + weight);
		System.out.println("이름 : " + name);
		System.out.println("주소 : " + addr);
		
		System.out.println(s);
		System.out.println(dtt);
		
		

	}

}
