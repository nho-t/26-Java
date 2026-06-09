package day03;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("시간을 정수로 입력하시오 : ");
		
		int time = scan.nextInt();
		
		int hour = (time / 60) / 60; // 60으로 나눈 나머지는 초 
		int minute = (time / 60) % 60; // time을 60으로 나누고 , 남은 나머지를 다시 60으로 나눈 나머지 값 
		int second = time % 60; // time을 60으로 나눈 몫 
		
		System.out.println(time + "초는 " + hour + "시간 " + minute + "분 " + second + "초 입니다.");
		
		

		
	}

	

}
