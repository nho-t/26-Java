package day04;
import java.util.Scanner;

public class ex11 {

	public static void main(String[] args) {
		// 무한반복하여 정수를 입력한 후 음수가 입력되면, 무한 반복을 종료하고 누적의 합을 출력하기
		
		Scanner scanner = new Scanner(System.in);
		
		int sum = 0;
		System.out.println("정수를 입력하시오 : ");
		
		while(true) {
			int num = scanner.nextInt();
			if(num < 0)
				break;
		else {
			sum = sum + num;	
			}
		}
		System.out.println("양수의 합은 : " + sum);
		
		
		scanner.close();
	}

}
