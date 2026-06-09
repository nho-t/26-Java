package day10;

public abstract class Shape {
	
	String name;
	
	//추상화
	abstract public void draw();
	
	public void printInfo() {
		System.out.println(name);
	}

}
