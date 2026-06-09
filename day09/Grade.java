package day09;
import java.util.Scanner;


public class Grade {
	// 이름, 과목점수 3개 필드(속성, 멤버변수) 선언
	String name;
	int score1, score2, score3;
	
	// 인자 생성자 
	public Grade(String name, int score1, int score2, int score3) {
		this.name = name;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
	}
	
	
	//이름(name)을 반환하는 getName 메소드 정의
	public String getName() {
			return name;
	}
	public int getAverage() {
		int sum = score1 + score2 + score3;
		int avg = sum / 3; 
		return avg;
	}
	
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("이름, 자바, 웹프로그래밍, 운영체제 순으로 점수 입력>>");
		String name = scanner.next();
		int java = scanner.nextInt();
		int web = scanner.nextInt();
		int os = scanner.nextInt();
		//Grade st1 = new Grade(); -> 에러 발생함 
		
		Grade st = new Grade(name, java, web, os); // 한 명의 점수 객체 생성
		System.out.println(st.getName() + "의 평균은 " + st.getAverage());
		scanner.close();
	}

}


