package my.app;
import java.util.Scanner;
import java.util.ArrayList;


public class ArrayListEx {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> alist = new ArrayList<String>();
		// 이름을 4번 입력해서 컬렉션에 저장하기 
		for(int i = 0; i<4; i++) {
			System.out.println("이름을 입력하세요 : ");
			alist.add(scan.nextLine());
		}
		// 저장된 모든 이름을 모두 출력하기 
		for(String name : alist) {
			System.out.println(name);
		}
		

	}

}
