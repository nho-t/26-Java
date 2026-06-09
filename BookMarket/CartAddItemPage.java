package BookMarket;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

class CartAddItemPage extends JPanel {
	private final MainWindow owner;
	private final JTable bookTable;
	private final JTextArea detailArea = new JTextArea();

	CartAddItemPage(MainWindow owner) {
		this.owner = owner;
		setLayout(new BorderLayout(12, 12));
		add(PageTitle.create("장바구니에 항목 추가하기"), BorderLayout.NORTH);

		bookTable = new JTable(createBookModel());
		bookTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bookTable.getSelectionModel().addListSelectionListener(event -> updateDetail());
		add(new JScrollPane(bookTable), BorderLayout.CENTER);

		detailArea.setEditable(false);
		detailArea.setRows(4);
		add(new JScrollPane(detailArea), BorderLayout.SOUTH);

		JButton addButton = new JButton("장바구니에 담기");
		addButton.addActionListener(event -> addSelectedBook());
		JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		actions.add(addButton);
		add(actions, BorderLayout.EAST);

		if (bookTable.getRowCount() > 0) {
			bookTable.setRowSelectionInterval(0, 0);
		}
	}

	private DefaultTableModel createBookModel() {
		return new ReadOnlyTableModel(BookRepository.getBookTableData(),
				new Object[] { "도서ID", "도서명", "가격", "저자", "분야", "출간일" });
	}

	private void updateDetail() {
		Book book = getSelectedBook();
		if (book == null) {
			detailArea.setText("");
			return;
		}
		detailArea.setText("도서명: " + book.getName() + "\n저자: " + book.getAuthor()
				+ "\n설명: " + book.getDescription());
	}

	private Book getSelectedBook() {
		int row = bookTable.getSelectedRow();
		if (row < 0) {
			return null;
		}
		String bookId = String.valueOf(bookTable.getValueAt(row, 0));
		return BookRepository.findById(bookId);
	}

	private void addSelectedBook() {
		Book book = getSelectedBook();
		if (book == null) {
			JOptionPane.showMessageDialog(this, "추가할 도서를 선택하세요.");
			return;
		}
		Welcome.mCart.insertBook(book);
		JOptionPane.showMessageDialog(this, book.getBookID() + " 도서를 장바구니에 담았습니다.");
		owner.showPage(new CartItemListPage(owner));
	}
}
