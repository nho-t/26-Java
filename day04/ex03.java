package day04;
import java.util.Scanner;

public class ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in); 
		
		int balance = 10000;
		
		System.out.println("나이를 입력하시오 : ");
		
		int age = scanner.nextInt();
		
		if(age >= 7 && age <= 12) {
			System.out.println("어린이입니다.");
			balance = balance - 450; 
		} else if (age >= 13 && age <= 18) {
			System.out.println("청소년입니다.");
			balance = balance - 720;
		} else if (age >= 19) {
			System.out.println("어른입니다.");
			balance = balance - 1200;
		}
		
		System.out.println("남은 잔액은 " + balance + "입니다.");
		
		scanner.close();

	}

}
