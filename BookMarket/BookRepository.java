package BookMarket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BookRepository {
	private static final List<Book> BOOKS = new ArrayList<>();

	static {
		resetDefaults();
	}

	private BookRepository() {
	}

	public static void resetDefaults() {
		BOOKS.clear();
		BOOKS.add(new Book("ISBN1234", "쉽게 배우는 JSP 웹 프로그래밍", 27000, "송미영",
				"단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍", "IT전문서", "2018/10/08"));
		BOOKS.add(new Book("ISBN1235", "안드로이드 프로그래밍", 33000, "우재남",
				"실습 단계별 명쾌한 멘토링!", "IT전문서", "2022/01/22"));
		BOOKS.add(new Book("ISBN1236", "스크래치", 22000, "고광일",
				"컴퓨팅 사고력을 키우는 블록 코딩", "컴퓨터입문", "2019/06/10"));
	}

	public static List<Book> getBooks() {
		return Collections.unmodifiableList(BOOKS);
	}

	public static Book[] toArray() {
		return BOOKS.toArray(new Book[0]);
	}

	public static Book findById(String bookId) {
		for (Book book : BOOKS) {
			if (book.getBookID().equalsIgnoreCase(bookId)) {
				return book;
			}
		}
		return null;
	}

	public static boolean exists(String bookId) {
		return findById(bookId) != null;
	}

	public static void addBook(Book book) {
		if (exists(book.getBookID())) {
			throw new IllegalArgumentException("이미 등록된 도서 ID입니다.");
		}
		BOOKS.add(book);
	}

	public static Object[][] getBookTableData() {
		Object[][] rows = new Object[BOOKS.size()][6];
		for (int i = 0; i < BOOKS.size(); i++) {
			rows[i] = BOOKS.get(i).toTableRow();
		}
		return rows;
	}
}
