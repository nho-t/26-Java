package day07;

// Circle 
class Circle { // 생성형
	public int radius;
	public String name;
	
	public Circle() { // 생성자 
		radius = 10;
		name = "불고기피자";
	}  
	public Circle(int r, String n) { // 인자(매겨변수_2개) 생성자
 		radius = r; // 시험 출제 , 다양한 형태로 생성자를 오버로딩 = 왜? 다양한 형태로 태어나게 하기 위해서, 반복되지 않게 하기 위해 
 		name = n;
	}
	public double getArea() { // 메소드
		return 3.14*radius*radius;
	}
	
}

public class Pizza {

	public static void main(String[] args) {
		// 1. 래퍼런스 변수 pizza 선언
		Circle pizza;
		Circle pizza2;
		// 2. Circle 객체 생성
		pizza = new Circle();
		pizza2 = new Circle(10, "치즈피자");
		
		// 3. 피자의 반지름 설정
//		pizza.radius = 10;
		// 4. 피자의 이름 설정
//		pizza.name = "자바 피자";
		// 5. 피자의 면적 메소드 호출하여 알아내기
		double area = pizza.getArea();
		System.out.println(pizza.name + "의 면적은 " + area);
		System.out.println(pizza2.name);
		
		//래퍼런스 변수 donut 선언
		Circle donut;
		// Circle 객체 생성
		donut = new Circle();
		// 도넛 반지름 5로 설정
		donut.radius = 5;
		// 도넛 이름을 "자바도넛"으로 설정
		donut.name = "자바 도넛";
		//도넛 면적 계산하여 출력하기
		double area1 = donut.getArea();
		System.out.println(donut.name + "의 면적은 " + area1);
;

	}

}

