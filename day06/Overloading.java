package day06;

public class Overloading {
	
	public static void coffee(int c ) { // 블랙커피
		System.out.println("블랙 커피 만듭니다.");
	}
	public static void coffee(int c, int cr) { // 크림커피
		System.out.println("크림 커피 만듭니다.");
	}
	public static void coffee(int c, int cr, int s) { // 믹스커피
		System.out.println("믹스 커피 만듭니다.");
	}

	public static void main(String[] args) {
		coffee(3,3,3);
		coffee(3);		
		coffee(3,3);
	}

}
