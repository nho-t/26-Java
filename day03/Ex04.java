package day03;
import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("숫자를 입력하시오 : ");
		int num = scan.nextInt();
		// 만약 짝수라면 짝수입니다, 아니라면 홀수입니다. 
		
		if(num % 2 == 0) {
			// 참일 때 실행문
			System.out.println("짝수입니다.");
			
		}else {
			System.out.println("홀수입니다.");
		}
		
		
		
		
		

	}

}
