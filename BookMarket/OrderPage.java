package BookMarket;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class OrderPage extends JPanel {
	private final MainWindow owner;
	private final JTextField nameField = new JTextField(16);
	private final JTextField phoneField = new JTextField(16);
	private final JTextField addressField = new JTextField(26);
	private final JTextField dateField = new JTextField(12);
	private final JRadioButton sameUserYes = new JRadioButton("예", true);
	private final JRadioButton sameUserNo = new JRadioButton("아니요");

	OrderPage(MainWindow owner) {
		this.owner = owner;
		setLayout(new BorderLayout(12, 12));
		add(PageTitle.create("영수증 표시하기"), BorderLayout.NORTH);

		if (Welcome.mCart.getCartCount() == 0) {
			add(new JLabel("장바구니가 비어 있어 영수증을 표시할 수 없습니다."), BorderLayout.CENTER);
			return;
		}

		JPanel form = new JPanel(new GridBagLayout());
		form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(6, 6, 6, 6);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		form.add(new JLabel("배송받을 분이 고객 정보와 같습니까?"), gbc);
		JPanel radios = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
		ButtonGroup group = new ButtonGroup();
		group.add(sameUserYes);
		group.add(sameUserNo);
		radios.add(sameUserYes);
		radios.add(sameUserNo);
		gbc.gridx = 1;
		form.add(radios, gbc);
		addRow(form, gbc, 1, "이름", nameField);
		addRow(form, gbc, 2, "연락처", phoneField);
		addRow(form, gbc, 3, "배송지", addressField);
		addRow(form, gbc, 4, "배송일", dateField);
		add(form, BorderLayout.CENTER);

		JButton receiptButton = new JButton("영수증 표시");
		receiptButton.addActionListener(event -> showReceipt());
		JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		actions.add(receiptButton);
		add(actions, BorderLayout.SOUTH);

		dateField.setText(LocalDate.now().plusDays(1).toString());
		fillUserInfo();
		sameUserYes.addActionListener(event -> fillUserInfo());
		sameUserNo.addActionListener(event -> clearRecipientFields());
	}

	private void addRow(JPanel form, GridBagConstraints gbc, int row, String label, JTextField field) {
		gbc.gridx = 0;
		gbc.gridy = row;
		gbc.weightx = 0;
		form.add(new JLabel(label), gbc);
		gbc.gridx = 1;
		gbc.weightx = 1;
		form.add(field, gbc);
	}

	private void fillUserInfo() {
		nameField.setText(Welcome.mUser.getName());
		phoneField.setText(Welcome.mUser.getPhone());
		addressField.setText(Welcome.mUser.getAddress() == null ? "" : Welcome.mUser.getAddress());
	}

	private void clearRecipientFields() {
		nameField.setText("");
		phoneField.setText("");
		addressField.setText("");
	}

	private void showReceipt() {
		if (nameField.getText().trim().isEmpty() || phoneField.getText().trim().isEmpty()
				|| addressField.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "배송 정보를 모두 입력하세요.");
			return;
		}
		Welcome.mUser.setAddress(addressField.getText().trim());
		owner.showPage(new ReceiptPage(nameField.getText().trim(), phoneField.getText().trim(),
				addressField.getText().trim(), dateField.getText().trim()));
	}
}
