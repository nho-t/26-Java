package day03;
import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);

		// id, pwd 초기화
		String id = "Park", pwd = "1234";
		
		System.out.println("아이디를 입력하시오 : ");		
		String myId = scan.next();
		
		System.out.println("비밀번호를 입력하시오 : ");		
		String myPwd = scan.next();
		
		if((myId.equals(id)) && (myPwd.endsWith(pwd))) {
			
			System.out.println("로그인 성공");
			
		}else {
			System.out.println("로그인 실패");
		}
		
		

	}

}
