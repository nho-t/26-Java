package BookMarket;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GuestWindow extends JFrame {
	private final JTextField nameField = new JTextField(18);
	private final JTextField phoneField = new JTextField(18);
	private final JTextField addressField = new JTextField(18);

	public GuestWindow() {
		setTitle("Book Market - 고객 정보 입력");
		setSize(440, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(12, 12));

		JLabel title = new JLabel("Welcome to Book Market", SwingConstants.CENTER);
		title.setBorder(BorderFactory.createEmptyBorder(22, 16, 8, 16));
		add(title, BorderLayout.NORTH);

		JPanel form = new JPanel(new GridBagLayout());
		form.setBorder(BorderFactory.createEmptyBorder(8, 32, 8, 32));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(6, 6, 6, 6);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		addRow(form, gbc, 0, "이름", nameField);
		addRow(form, gbc, 1, "연락처", phoneField);
		addRow(form, gbc, 2, "주소", addressField);
		add(form, BorderLayout.CENTER);

		JButton startButton = new JButton("입력 완료");
		startButton.addActionListener(event -> openMainWindow());
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(startButton);
		add(buttonPanel, BorderLayout.SOUTH);
		getRootPane().setDefaultButton(startButton);
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

	private void openMainWindow() {
		String name = nameField.getText().trim();
		String phone = phoneField.getText().trim();
		String address = addressField.getText().trim();
		if (name.isEmpty() || phone.isEmpty()) {
			JOptionPane.showMessageDialog(this, "이름과 연락처를 입력하세요.", "입력 확인",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		Welcome.mUser = new User(name, phone, address);
		MainWindow mainWindow = new MainWindow();
		mainWindow.setVisible(true);
		dispose();
	}
}
