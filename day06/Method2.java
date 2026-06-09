package day06;
import java.util.Scanner;

public class Method2 {
	// 2개의 정수를 입력 받아서 최대값을 반환하는 max()메소드를 정의하고 호출한 후 결과를 출력하시오.
	
	public static int max(int a, int b) {
		int  Maxnum = a;
		if (b>Maxnum) {
			Maxnum = b;
		}
		
		return Maxnum;
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); 
		
		System.out.println("정수 1 입력 : ");
		int a = scan.nextInt();
		System.out.println("정수 2 입력 : ");
		int b = scan.nextInt();

		

	}

}
