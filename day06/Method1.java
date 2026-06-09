package day06;
import java.util.Scanner;

public class Method1 {
	
	// 1. 매개변수도 없고, 반환형도 없는 add() 메소드
	public static void add() {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int num2 = scan.nextInt();
		System.out.println(num + num2);
	}
	
	// 2. 매개변수(파라미터)는 있고, 반환형(void = 반환이 없기에 무조건 sysout이 필요)은 없는 add() 메소드
	
	public static void add(int a, int b) {
		System.out.println(a+b);
		
	}
	
	// 3. 매개변수는 없고, 반환형은 있는 add() 메소드 - 매개변수가 있는 add() 함수는  함수의 이름 중복이 자바에서는 가능 = 자바 중복 정의 = 오버로딩
	public static int add1() {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int num2 = scan.nextInt();
		return num+num2;
	}
	
	// 4. 매개변수와 반환형이 모두 있는 add2() 메소드
	public static int add2(int a, int b) {
		return a+b;
	}
	
	public static void main(String[] args) {
		//add();
		//add(50,60); //add 이름이 같아도 순차적으로 실행되며 괄호 안 arg가 입력된다
		//System.out.println(add1());
		// 호출
		int result = add2(50,60);
		System.out.println(result);
		result += 10;
		System.out.println(result);

	}

}
