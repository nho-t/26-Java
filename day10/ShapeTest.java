package day10;
import java.util.ArrayList;

public class ShapeTest {

	public static void main(String[] args) {
		
		Shape s = new Line();
		Shape s1 = new Circle();
		
		ArrayList<Shape> array = new ArrayList<Shape>();
		array.add(s);
		array.add(s1);
		array.add(new Line());
		array.add(new Tri());
		
		for(Shape sp:array) {
			if(sp instanceof Line) {
				System.out.println("선객체");
				sp.draw();
			}
			if(sp instanceof Circle) {
				System.out.println("원객체");
				sp.draw();
			}
			if(sp instanceof Tri) {
				sp.draw();
			}
		}

	}

}
