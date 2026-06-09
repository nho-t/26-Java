package day04;
import java.util.Scanner;

public class ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in); 

		System.out.println("나이를 입력 하시오 : ");
		int grade = scanner.nextInt();
		
		if(grade < 18) {
			System.out.println("청소년 관람 불가");
		}
		
		scanner.close();
		
		
		
	}

}
