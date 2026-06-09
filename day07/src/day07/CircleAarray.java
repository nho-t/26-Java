package day07;

public class CircleAarray {

	public static void main(String[] args) {
		// 객체 배열 생성
		Circle c[];
		c = new Circle[5];
		
		for (int i = 0; i<c.length; i++) {
			c[i] = new Circle(i, null);
		}
		
		for (int i = 0; i<c.length; i++) {
			System.out.print((int)c[i].getArea() + " ");
		}
		

	}

}
