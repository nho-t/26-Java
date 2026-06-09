package day10;

class Book {
	private String title;
	
	public Book(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
}


public class EBook extends Book {
	
	int inch;
	public EBook(String title, int inch) {
		super(title);
		this.inch = inch;
	}
	
	public void printInfo() {
		System.out.println(super.getTitle() + "은 " + this.inch + "인치 전자책 입니다." );
	}
	
	public void text2speech(int page) {
		System.out.println(page + "페이지의 텍스트를 음성으로 출력합니다.");
	}
	
	
	

	public static void main(String[] args) {
		EBook ebook = new EBook("자바에센셜-전자책", 14);
		ebook.printInfo();
		ebook.text2speech(3);
	}

}
