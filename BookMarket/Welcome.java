package BookMarket;

import java.awt.GraphicsEnvironment;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.SwingUtilities;

public class Welcome {
	public static Cart mCart = new Cart();
	public static User mUser;

	public static void main(String[] args) {
		if (args.length > 0 && "console".equalsIgnoreCase(args[0])) {
			runConsole();
			return;
		}
		if (GraphicsEnvironment.isHeadless()) {
			System.out.println("그래픽 환경이 아니어서 콘솔 모드로 실행합니다.");
			runConsole();
			return;
		}
		SwingUtilities.invokeLater(() -> new GuestWindow().setVisible(true));
	}

	public static void runConsole() {
		Scanner input = new Scanner(System.in);
		System.out.print("당신의 이름을 입력하세요: ");
		String userName = input.nextLine().trim();
		System.out.print("연락처를 입력하세요: ");
		String userMobile = input.nextLine().trim();
		mUser = new User(userName, userMobile);

		boolean quit = false;
		while (!quit) {
			System.out.println("***********************************************");
			System.out.println("\tWelcome to Shopping Mall");
			System.out.println("\tWelcome to Book Market!");
			menuIntroduction();
			try {
				System.out.print("메뉴를 선택해 주세요: ");
				int menu = input.nextInt();
				input.nextLine();
				if (menu < 1 || menu > 9) {
					throw new MenuChoiceException("1부터 9까지의 숫자를 입력하세요.");
				}
				switch (menu) {
				case 1:
					menuGuestInfo();
					break;
				case 2:
					menuCartItemList();
					break;
				case 3:
					menuCartClear(input);
					break;
				case 4:
					menuCartAddItem(input);
					break;
				case 5:
					menuCartRemoveItemCount(input);
					break;
				case 6:
					menuCartRemoveItem(input);
					break;
				case 7:
					menuCartBill(input);
					break;
				case 8:
					menuExit();
					quit = true;
					break;
				case 9:
					menuAdminLogin(input);
					break;
				default:
					break;
				}
			} catch (InputMismatchException e) {
				input.nextLine();
				System.out.println("숫자로 메뉴를 입력하세요.");
			} catch (MenuChoiceException | IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void menuIntroduction() {
		System.out.println("1. 고객 정보 확인하기\t\t4. 장바구니에 항목 추가하기");
		System.out.println("2. 장바구니 상품 목록 보기\t5. 장바구니의 항목 수량 줄이기");
		System.out.println("3. 장바구니 비우기\t\t6. 장바구니의 항목 삭제하기");
		System.out.println("7. 영수증 표시하기\t\t8. 종료");
		System.out.println("9. 관리자 로그인");
		System.out.println("***********************************************");
	}

	public static void menuGuestInfo() {
		System.out.println("현재 고객 정보");
		System.out.println("이름: " + mUser.getName());
		System.out.println("연락처: " + mUser.getPhone());
		if (mUser.getAddress() != null && !mUser.getAddress().isBlank()) {
			System.out.println("주소: " + mUser.getAddress());
		}
	}

	public static void menuGuestInfo(String userName, int userMobile) {
		menuGuestInfo();
	}

	public static void menuCartItemList() {
		if (mCart.getCartCount() == 0) {
			System.out.println("장바구니가 비어 있습니다.");
			return;
		}
		mCart.printCart();
	}

	public static void menuCartClear(Scanner input) {
		if (mCart.getCartCount() == 0) {
			System.out.println("장바구니가 이미 비어 있습니다.");
			return;
		}
		System.out.print("장바구니의 모든 항목을 삭제하겠습니까? Y|N ");
		if ("Y".equalsIgnoreCase(input.nextLine().trim())) {
			mCart.clearCart();
			System.out.println("장바구니를 비웠습니다.");
		}
	}

	public static void menuCartClear() {
		mCart.clearCart();
		System.out.println("장바구니를 비웠습니다.");
	}

	public static void menuCartAddItem(Scanner input) {
		Book[] books = BookRepository.toArray();
		mCart.printBookList(books);
		while (true) {
			System.out.print("장바구니에 추가할 도서의 ID를 입력하세요: ");
			String bookId = input.nextLine().trim();
			Book book = BookRepository.findById(bookId);
			if (book == null) {
				System.out.println("해당 도서 ID가 없습니다. 다시 입력해 주세요.");
				continue;
			}
			System.out.print("장바구니에 추가하겠습니까? Y|N ");
			if ("Y".equalsIgnoreCase(input.nextLine().trim())) {
				mCart.insertBook(book);
				System.out.println(book.getBookID() + " 도서가 장바구니에 추가되었습니다.");
			}
			return;
		}
	}

	public static void menuCartAddItem() {
		System.out.println("도서 추가는 콘솔 입력 또는 GUI 화면에서 진행하세요.");
	}

	public static void menuCartAddItem(Book[] booklist) {
		mCart.printBookList(booklist);
	}

	public static void menuCartRemoveItemCount(Scanner input) {
		if (mCart.getCartCount() == 0) {
			System.out.println("수량을 줄일 항목이 없습니다.");
			return;
		}
		mCart.printCart();
		System.out.print("수량을 줄일 도서 ID를 입력하세요: ");
		String bookId = input.nextLine().trim();
		if (mCart.decreaseBookQuantity(bookId)) {
			System.out.println("선택한 도서의 수량을 줄였습니다.");
		} else {
			System.out.println("장바구니에 해당 도서가 없습니다.");
		}
	}

	public static void menuCartRemoveItemCount() {
		System.out.println("수량 줄이기는 콘솔 입력 또는 GUI 화면에서 진행하세요.");
	}

	public static void menuCartRemoveItem(Scanner input) {
		if (mCart.getCartCount() == 0) {
			System.out.println("삭제할 항목이 없습니다.");
			return;
		}
		mCart.printCart();
		System.out.print("삭제할 도서 ID를 입력하세요: ");
		String bookId = input.nextLine().trim();
		if (mCart.removeCartItemByBookId(bookId)) {
			System.out.println("선택한 도서를 장바구니에서 삭제했습니다.");
		} else {
			System.out.println("장바구니에 해당 도서가 없습니다.");
		}
	}

	public static void menuCartRemoveItem() {
		System.out.println("항목 삭제는 콘솔 입력 또는 GUI 화면에서 진행하세요.");
	}

	public static void menuCartBill(Scanner input) {
		if (mCart.getCartCount() == 0) {
			System.out.println("장바구니가 비어 있어 영수증을 표시할 수 없습니다.");
			return;
		}
		System.out.print("배송받을 분은 고객 정보와 같습니까? Y|N ");
		String sameUser = input.nextLine().trim();
		String name = mUser.getName();
		String phone = mUser.getPhone();
		String address = mUser.getAddress();
		if (!"Y".equalsIgnoreCase(sameUser) || address == null || address.isBlank()) {
			System.out.print("배송받을 고객명: ");
			name = input.nextLine().trim();
			System.out.print("배송받을 연락처: ");
			phone = input.nextLine().trim();
			System.out.print("배송받을 주소: ");
			address = input.nextLine().trim();
			mUser.setAddress(address);
		}
		String deliveryDate = LocalDate.now().plusDays(1).toString();
		printReceipt(name, phone, address, deliveryDate);
	}

	public static void menuCartBill() {
		printReceipt(mUser.getName(), mUser.getPhone(), mUser.getAddress(), LocalDate.now().plusDays(1).toString());
	}

	public static void printReceipt(String name, String phone, String address, String deliveryDate) {
		System.out.println("*************** 배송 받을 고객 정보 ***************");
		System.out.println("고객명: " + name + "\t연락처: " + phone);
		System.out.println("배송지: " + address + "\t배송일: " + deliveryDate);
		System.out.println("************************************************");
		mCart.printCart();
	}

	public static void menuExit() {
		System.out.println("온라인 서점을 종료합니다.");
	}

	public static void menuAdminLogin(Scanner input) {
		System.out.println("관리자 정보를 입력하세요.");
		System.out.print("아이디: ");
		String adminId = input.nextLine().trim();
		System.out.print("비밀번호: ");
		String adminPw = input.nextLine().trim();
		Admin admin = new Admin(mUser.getName(), mUser.getPhone());
		if (!adminId.equals(admin.getId()) || !adminPw.equals(admin.getPassword())) {
			System.out.println("관리자 정보가 일치하지 않습니다.");
			return;
		}
		System.out.println("관리자 로그인 성공");
		System.out.print("새 도서를 추가하겠습니까? Y|N ");
		if ("Y".equalsIgnoreCase(input.nextLine().trim())) {
			addBookFromConsole(input);
		}
	}

	public static void menuAdminLogin() {
		System.out.println("관리자 로그인은 콘솔 입력 또는 GUI 화면에서 진행하세요.");
	}

	private static void addBookFromConsole(Scanner input) {
		System.out.print("도서 ID: ");
		String id = input.nextLine().trim();
		System.out.print("도서명: ");
		String title = input.nextLine().trim();
		System.out.print("가격: ");
		int price = Integer.parseInt(input.nextLine().trim());
		System.out.print("저자: ");
		String author = input.nextLine().trim();
		System.out.print("설명: ");
		String description = input.nextLine().trim();
		System.out.print("분야: ");
		String category = input.nextLine().trim();
		System.out.print("출간일: ");
		String releaseDate = input.nextLine().trim();
		BookRepository.addBook(new Book(id, title, price, author, description, category, releaseDate));
		System.out.println("새 도서를 등록했습니다.");
	}
}
