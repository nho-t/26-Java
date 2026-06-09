package BookMarket;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class AdminPage extends JPanel {
	private final MainWindow owner;
	private final JTable bookTable = new JTable();
	private final JTextField idField = new JTextField(14);
	private final JTextField nameField = new JTextField(14);
	private final JTextField priceField = new JTextField(14);
	private final JTextField authorField = new JTextField(14);
	private final JTextField categoryField = new JTextField(14);
	private final JTextField dateField = new JTextField(14);
	private final JTextField descriptionField = new JTextField(28);

	AdminPage(MainWindow owner) {
		this.owner = owner;
		setLayout(new BorderLayout(12, 12));
		add(PageTitle.create("관리자 도서 등록"), BorderLayout.NORTH);
		bookTable.setModel(createBookModel());
		add(new JScrollPane(bookTable), BorderLayout.CENTER);
		add(createForm(), BorderLayout.SOUTH);
	}

	private JPanel createForm() {
		JPanel wrapper = new JPanel(new BorderLayout(8, 8));
		JPanel form = new JPanel(new GridLayout(4, 4, 8, 8));
		form.add(new JLabel("도서ID"));
		form.add(idField);
		form.add(new JLabel("도서명"));
		form.add(nameField);
		form.add(new JLabel("가격"));
		form.add(priceField);
		form.add(new JLabel("저자"));
		form.add(authorField);
		form.add(new JLabel("분야"));
		form.add(categoryField);
		form.add(new JLabel("출간일"));
		form.add(dateField);
		form.add(new JLabel("설명"));
		form.add(descriptionField);
		wrapper.add(form, BorderLayout.CENTER);
		JButton addButton = new JButton("추가");
		JButton cancelButton = new JButton("취소");
		addButton.addActionListener(event -> addBook());
		cancelButton.addActionListener(event -> owner.showPage(new GuestInfoPage()));
		JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		actions.add(addButton);
		actions.add(cancelButton);
		wrapper.add(actions, BorderLayout.SOUTH);
		return wrapper;
	}

	private DefaultTableModel createBookModel() {
		return new ReadOnlyTableModel(BookRepository.getBookTableData(),
				new Object[] { "도서ID", "도서명", "가격", "저자", "분야", "출간일" });
	}

	private void addBook() {
		try {
			String id = idField.getText().trim();
			String title = nameField.getText().trim();
			String author = authorField.getText().trim();
			String category = categoryField.getText().trim();
			String date = dateField.getText().trim();
			String description = descriptionField.getText().trim();
			int price = Integer.parseInt(priceField.getText().trim());
			if (id.isEmpty() || title.isEmpty() || author.isEmpty()) {
				throw new IllegalArgumentException("도서ID, 도서명, 저자는 필수입니다.");
			}
			BookRepository.addBook(new Book(id, title, price, author, description, category, date));
			bookTable.setModel(createBookModel());
			clearForm();
			JOptionPane.showMessageDialog(this, "도서를 등록했습니다.");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "가격은 숫자로 입력하세요.", "입력 오류",
					JOptionPane.WARNING_MESSAGE);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "입력 오류", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void clearForm() {
		idField.setText("");
		nameField.setText("");
		priceField.setText("");
		authorField.setText("");
		categoryField.setText("");
		dateField.setText("");
		descriptionField.setText("");
	}
}
