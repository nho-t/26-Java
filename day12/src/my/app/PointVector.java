package my.app;
import java.util.Vector;

class Point {
	
	private int x,y;
	
	// 인자 생성자 
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// getter, setter 
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	
}

public class PointVector {

	public static void main(String[] args) {
		
		// vector 객체
		Vector<Point> pvectors = new Vector<Point>();
		
		// 자료 저장 (원소(요소)) 저장
		pvectors.add(new Point(3,5));
		pvectors.add(new Point(30,70));
		
		// 자료 검색 
		for(int i=0; i<pvectors.size(); i++) {
			System.out.println("X : " + pvectors.elementAt(i).getX() + " Y : " + pvectors.elementAt(i).getY());
	        
		}

		
		for(Point p:pvectors) {
			System.out.println(p.getX());
			System.out.println(p.getY());
		}

	}

}
