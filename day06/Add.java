package day06;
import java.util.Scanner;

public class Add {

	public static void main(String[] args) {
		// 2개의 정수를 입력받아 더한 결과를 출력하시오. 
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("첫번째 정수를 입력하시오 : ");
		int A = scanner.nextInt();
		
		System.out.println("두번째 정수를 입력하시오 : ");
		int B = scanner.nextInt();
		
		System.out.println("두 정수를 더한 결과는 " + (A+B) + " 입니다.\n");
		
		System.out.println("첫번째 실수를 입력하시오 : ");
	    double C = scanner.nextDouble();
		
		System.out.println("두번째 실수를 입력하시오 : ");
		double D = scanner.nextDouble();
		
		System.out.println("두 실수를 곱한 결과는 " + (C*D) + " 입니다.\n");
		
		scanner.close();

	}

}
