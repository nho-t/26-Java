package day10;

public class Line extends Shape{
	
	//메소드 오버라이딩 - 컨트롤 + 스페이스, draw 선택
	@Override
	public void draw() {
		System.out.println("선을 그리다.");
	}

}
