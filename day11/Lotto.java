package day11;
import java.util.Random;

public class Lotto {
	// 난수 (1 ~ 45까지의 임의의 정수 6개 생성) 
	
	public static void main(String[] args) {
		Random random = new Random();
		int n = 0;
		for(int i = 1; i<=6; i++) {
			n =  random.nextInt(45)+1; // 1 ~ 46, 1 이상 46 미만 
			System.out.println(n);
		}
		
	

	}

}
