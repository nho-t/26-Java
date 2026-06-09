package day04;

import java.util.Scanner;

public class ex08 {

	public static void main(String[] args) {
		
		int count = 0;
		int sum = 0; 
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 (-1 입력 시 종료): ");
		int n = scanner.nextInt();
		
		while(n != -1) { 
			sum += n;
			count++;
			n = scanner.nextInt();
		} 
		
		if(count == 0) {
			System.out.println("입력된 수가 없습니다."); 
		} else {
			System.out.println("정수의 개수는 " + count + "개이며");
			System.out.println("평균은 " + (double)sum/count + "입니다."); 
		}
		
		scanner.close();
	}
}