package BookMarket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart implements CartInterface {
	private final List<CartItem> cartItems = new ArrayList<>();

	public Cart() {
	}

	@Override
	public void printBookList(Book[] booklist) {
		for (Book book : booklist) {
			if (book != null) {
				System.out.println(book);
				System.out.println("  설명: " + book.getDescription());
			}
		}
	}

	@Override
	public void insertBook(Book book) {
		CartItem existing = findCartItem(book.getBookID());
		if (existing == null) {
			cartItems.add(new CartItem(book));
		} else {
			existing.increaseQuantity();
		}
	}

	@Override
	public void deleteBook() {
		clearCart();
	}

	public void clearCart() {
		cartItems.clear();
	}

	public void printCart() {
		System.out.println("장바구니 상품 목록:");
		System.out.println("------------------------------------------------------------");
		System.out.println("도서ID\t\t도서명\t\t수량\t합계");
		for (CartItem item : cartItems) {
			System.out.println(item.getBookID() + "\t" + item.getItemBook().getName()
					+ "\t" + item.getQuantity() + "\t" + item.getTotalPrice() + "원");
		}
		System.out.println("------------------------------------------------------------");
		System.out.println("총 금액: " + getTotalAmount() + "원");
	}

	@Override
	public boolean isCartInBook(String bookId) {
		CartItem item = findCartItem(bookId);
		if (item != null) {
			item.increaseQuantity();
			return true;
		}
		return false;
	}

	@Override
	public void removeCart(int numId) {
		if (numId >= 0 && numId < cartItems.size()) {
			cartItems.remove(numId);
		}
	}

	public boolean removeCartItemByBookId(String bookId) {
		CartItem item = findCartItem(bookId);
		if (item == null) {
			return false;
		}
		cartItems.remove(item);
		return true;
	}

	public boolean decreaseBookQuantity(String bookId) {
		CartItem item = findCartItem(bookId);
		if (item == null) {
			return false;
		}
		item.decreaseQuantity();
		if (item.getQuantity() == 0) {
			cartItems.remove(item);
		}
		return true;
	}

	public CartItem findCartItem(String bookId) {
		for (CartItem item : cartItems) {
			if (item.getBookID().equals(bookId)) {
				return item;
			}
		}
		return null;
	}

	public List<CartItem> getCartItems() {
		return Collections.unmodifiableList(cartItems);
	}

	public int getCartCount() {
		return cartItems.size();
	}

	public int getTotalAmount() {
		int total = 0;
		for (CartItem item : cartItems) {
			total += item.getTotalPrice();
		}
		return total;
	}

	public Object[][] getCartTableData() {
		Object[][] rows = new Object[cartItems.size()][5];
		for (int i = 0; i < cartItems.size(); i++) {
			rows[i] = cartItems.get(i).toTableRow();
		}
		return rows;
	}
}
