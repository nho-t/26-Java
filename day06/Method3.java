package day06;
import java.util.Scanner;

public class Method3 {
	// 2개의 정수와 1개의 문자열을 입력받아서 사칙연산을 수행하는 계산기 메소드 add(), sub, mul, div 를 정의하시오
	
	public static int add(int a, int b, String s) {
		return a+b;
	}
	public static int sub(int a, int b, String s) {
		return a-b;
	}
	public static int mul(int a, int b, String s) {
		return a*b;
	}
	public static int div(int a, int b, String s) {
		return a/b;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("첫번째 정수를 입력하시오 : ");
		int a = scan.nextInt();
		System.out.println("두번째 정수를 입력하시오 : ");
		int b = scan.nextInt();
		System.out.println("연산 부호를 입력하시오 : ");
		String s = scan.next();
		
		switch(s) {
		case "+":
			System.out.println(a + "+" + b + "=" + add(a,b,s));
			break;
		case "-":
			System.out.println(a + "-" + b + "=" + sub(a,b,s));
			break;
		case "*":
			System.out.println(a + "*" + b + "=" + mul(a,b,s));
			break;
		case "/":
			System.out.println(a + "/" + b + "=" + div(a,b,s));
			break;
		default:
			break;
		}
		

		

	}

}
