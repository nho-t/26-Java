package BookMarket;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

class CartItemListPage extends JPanel {
	private final JTable cartTable;
	private final JLabel totalLabel = new JLabel();

	CartItemListPage(MainWindow owner) {
		setLayout(new BorderLayout(12, 12));
		add(PageTitle.create("장바구니 상품 목록 보기"), BorderLayout.NORTH);

		cartTable = new JTable(createCartModel());
		cartTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(cartTable), BorderLayout.CENTER);

		JPanel bottom = new JPanel(new BorderLayout());
		JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton refreshButton = new JButton("새로 고침");
		JButton decreaseButton = new JButton("수량 줄이기");
		JButton removeButton = new JButton("선택 삭제");
		JButton clearButton = new JButton("전체 비우기");
		refreshButton.addActionListener(event -> refresh());
		decreaseButton.addActionListener(event -> decreaseSelected());
		removeButton.addActionListener(event -> removeSelected());
		clearButton.addActionListener(event -> clearCart());
		actions.add(refreshButton);
		actions.add(decreaseButton);
		actions.add(removeButton);
		actions.add(clearButton);
		bottom.add(totalLabel, BorderLayout.WEST);
		bottom.add(actions, BorderLayout.EAST);
		add(bottom, BorderLayout.SOUTH);
		refreshTotal();
	}

	private DefaultTableModel createCartModel() {
		return new ReadOnlyTableModel(Welcome.mCart.getCartTableData(),
				new Object[] { "도서ID", "도서명", "가격", "수량", "합계" });
	}

	private void refresh() {
		cartTable.setModel(createCartModel());
		refreshTotal();
	}

	private void refreshTotal() {
		totalLabel.setText("총 금액: " + Welcome.mCart.getTotalAmount() + "원");
	}

	private String selectedBookId() {
		int row = cartTable.getSelectedRow();
		if (row < 0) {
			return null;
		}
		return String.valueOf(cartTable.getValueAt(row, 0));
	}

	private void decreaseSelected() {
		String bookId = selectedBookId();
		if (bookId == null) {
			JOptionPane.showMessageDialog(this, "수량을 줄일 항목을 선택하세요.");
			return;
		}
		Welcome.mCart.decreaseBookQuantity(bookId);
		refresh();
	}

	private void removeSelected() {
		String bookId = selectedBookId();
		if (bookId == null) {
			JOptionPane.showMessageDialog(this, "삭제할 항목을 선택하세요.");
			return;
		}
		Welcome.mCart.removeCartItemByBookId(bookId);
		refresh();
	}

	private void clearCart() {
		if (Welcome.mCart.getCartCount() == 0) {
			JOptionPane.showMessageDialog(this, "장바구니가 비어 있습니다.");
			return;
		}
		int result = JOptionPane.showConfirmDialog(this, "장바구니를 모두 비우겠습니까?", "장바구니 비우기",
				JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			Welcome.mCart.clearCart();
			refresh();
		}
	}
}
