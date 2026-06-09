package day04;
import java.util.Scanner;

public class ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in); 
		
		System.out.println("필기시험 점수를 입력하시오 : ");
		int score1 = scanner.nextInt();
		
		System.out.println("토익 점수를 입력하시오 : ");
		int score2 = scanner.nextInt();
		
		if(score1 >= 80 && score2 >= 850) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
		
		scanner.close();

	}

}
