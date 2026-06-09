package day03;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int age; // 변수 선언 
		String name = new String(); // 참조형 변수 선언
		// 변수 초기화
		age = 20; 
		name = "박준호"; 
		System.out.println("나이 : " + age);
		System.out.println("이름 : " + name);
		
		// Scanner 객체 생성 
		Scanner scan = new Scanner(System.in);
		
		// Scanner 소스
		System.out.println("나이를 입력 하시오 : ");
		age = scan.nextInt();

		System.out.println("이름을 입력 하시오 : ");
		name = scan.next();
		
		double height;
		System.out.println("키를 입력하시오 : ");
		height = scan.nextDouble();
		
		String city;
		System.out.println("도시를 입력하시오 : ");
		city = scan.next();
		
		boolean single; 
		System.out.println("독신 여부를 입력하시오 : ");
		single = scan.nextBoolean();
		
		// 출력
		System.out.println("나이 : " + age);
		System.out.println("이름 : " + name);
		System.out.println("키 : " + height);
		System.out.println("도시 : " + city);
		System.out.println("독신여부 : " + single);
		
		
		

	}

}
