package day07; // 시험문제 출제

import java.util.Scanner; 

public class Book { 
	String title;
	String author;
	
	void show() { 
		System.out.println(title + " " + author); 
	}
	
	public Book() { // 기본 생성자
		this("", "");
		System.out.println("생성자 호출됨");
	}
	
	public Book(String title) {
		this(title, "작자미상");
	}
	
	public Book(String title, String author) { 
		this.title = title; 
		this.author = author;
	}
	


    
	public static void main(String[] args) {
		Book[] book = new Book[2];
		
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < book.length; i++) {
			System.out.print("제목 >> ");
			String title = scanner.nextLine();
			System.out.print("저자 >> ");
			String author = scanner.nextLine();
			book[i] = new Book(title, author); 
		}
		
		for (int i = 0; i < book.length; i++) {
			System.out.println("(" + book[i].title + ", " + book[i].author + ")");
		}
		
		scanner.close();
	}
}