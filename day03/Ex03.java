package day03;
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요 : ");
		
		int num = scan.nextInt();
		int n = num % 2; // 짝수 홀수 판단 식
		
		String result = (n == 0) ? "짝수" : "홀수"; // result가 0이라면 앞의 짝수 출력, 0이 아니라면 홀수 출력 = 3항 연산자
		
		System.out.println(result);
		


	}

}
