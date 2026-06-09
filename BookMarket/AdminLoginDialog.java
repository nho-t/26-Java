package BookMarket;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class AdminLoginDialog extends JDialog {
	private final MainWindow owner;
	private final JTextField idField = new JTextField(14);
	private final JPasswordField passwordField = new JPasswordField(14);

	AdminLoginDialog(MainWindow owner) {
		super(owner, "관리자 로그인", true);
		this.owner = owner;
		setSize(320, 180);
		setLocationRelativeTo(owner);
		setLayout(new BorderLayout(8, 8));
		JPanel form = new JPanel(new GridLayout(2, 2, 8, 8));
		form.setBorder(BorderFactory.createEmptyBorder(18, 18, 8, 18));
		form.add(new JLabel("아이디"));
		form.add(idField);
		form.add(new JLabel("비밀번호"));
		form.add(passwordField);
		add(form, BorderLayout.CENTER);

		JButton loginButton = new JButton("로그인");
		JButton cancelButton = new JButton("취소");
		loginButton.addActionListener(event -> login());
		cancelButton.addActionListener(event -> dispose());
		JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		actions.add(loginButton);
		actions.add(cancelButton);
		add(actions, BorderLayout.SOUTH);
		getRootPane().setDefaultButton(loginButton);
	}

	private void login() {
		Admin admin = new Admin(Welcome.mUser.getName(), Welcome.mUser.getPhone());
		String password = new String(passwordField.getPassword());
		if (admin.getId().equals(idField.getText().trim()) && admin.getPassword().equals(password)) {
			dispose();
			owner.showPage(new AdminPage(owner));
		} else {
			JOptionPane.showMessageDialog(this, "관리자 정보가 일치하지 않습니다.", "로그인 실패",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
