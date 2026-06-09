package day04;
import java.util.Scanner;

public class ex10 {

	public static void main(String[] args) {
		// 5개 정수 입력받아서 양수의 합을 구하시오 
		
		Scanner scanner = new Scanner(System.in);
		
		int sum = 0;
		System.out.println("정수를 입력하시오 : ");
		for(int i = 1; i <= 5; i++) {
			int num = scanner.nextInt();
			// 만약 정수가 음수라면, 무시. 양수라면 합 추가 
			if(num < 0)
					continue;
			else {
				sum = sum + num;
				
			}
		}
		System.out.println("양수의 합은 : " + sum);
		
		scanner.close();
		
		

	}

}
