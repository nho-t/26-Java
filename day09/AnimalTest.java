package day09;

public class AnimalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal cat = new Animal();
		Human hong = new Human();
		
		//cat.변수로 접근이 불가능하다 
		//cat.name = "뽀삐";
		cat.setName("뽀삐");
		//cat.age = 10;
		cat.setAge(10);
		//System.out.println(cat.age); -> 불가능
		System.out.println(cat.getAge());
		System.out.println(cat.getName());
		
		//hong.name = "홍길동";
		hong.setName("홍길동");
		hong.setAge(25);
		hong.setAddr("대전 동구 용운동");
		
		System.out.println(hong.getName());
		System.out.println(hong.getAge());
		System.out.println(hong.getAddr());
		

	}

}
