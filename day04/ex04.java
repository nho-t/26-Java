package day04;
import java.util.Scanner;

public class ex04 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		
		System.out.println("가위바위보 게임");
		String user1 = scanner.next();
		System.out.println("철수 가위바위보 입력 값 : " + user1);
		String user2 = scanner.next();
		System.out.println("영희 가위바위보 입력 값 : " + user2);

		if(user1.equals("보")) { // 철수 보
			if(user2.equals("보")) {
				System.out.println("비겼습니다.");
			}else if(user2.equals("바위")) {
				System.out.println("철수가 이겼습니다.");
			}else {
				System.out.println("철수가 졌습니다.");
			}
		}else if(user1.equals("바위")) { // 철수 바위
			if(user2.equals("바위")) {
				System.out.println("비겼습니다."); 
			}else if(user2.equals("가위")) {
				System.out.println("철수가 이겼습니다.");
			}else {
				System.out.println("철수가 졌습니다.");
			} 
		}else if(user1.equals("가위")) { // 철수 가위
			if(user2.equals("가위")) {
				System.out.println("비겼습니다."); 
			}else if(user2.equals("보")) {
				System.out.println("철수가 이겼습니다."); 
			}else {
				System.out.println("철수가 졌습니다."); 
			} 
		} 
		
		scanner.close();
	}
}