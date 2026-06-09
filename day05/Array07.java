package day05;

public class Array07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str[] = {"사과","바나나","딸기","복숭아","포도"};
		
		
		try {
		for(int i = 0; i<6; i++) {
			System.out.println(str[i]);
			}
		
		} catch(ArrayIndexOutOfBoundsException a) {
			a.printStackTrace();
		}
	}

}
