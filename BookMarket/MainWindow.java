package BookMarket;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainWindow extends JFrame {
	private final JPanel contentPanel = new JPanel(new BorderLayout());

	public MainWindow() {
		setTitle("Book Market");
		setSize(980, 640);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				confirmExit();
			}
		});

		setJMenuBar(createMenuBar());
		add(createButtonPanel(), BorderLayout.WEST);
		contentPanel.setBorder(BorderFactory.createEmptyBorder(18, 18, 18, 18));
		add(contentPanel, BorderLayout.CENTER);
		showPage(new GuestInfoPage());
	}

	public void showPage(JPanel page) {
		contentPanel.removeAll();
		contentPanel.add(page, BorderLayout.CENTER);
		contentPanel.revalidate();
		contentPanel.repaint();
	}

	private JPanel createButtonPanel() {
		JPanel panel = new JPanel(new GridLayout(9, 1, 6, 6));
		panel.setBorder(BorderFactory.createEmptyBorder(18, 18, 18, 0));
		addButton(panel, "1. 고객 정보", () -> showPage(new GuestInfoPage()));
		addButton(panel, "2. 장바구니 목록", () -> showPage(new CartItemListPage(this)));
		addButton(panel, "3. 장바구니 비우기", this::clearCart);
		addButton(panel, "4. 항목 추가", () -> showPage(new CartAddItemPage(this)));
		addButton(panel, "5. 수량 줄이기", () -> showPage(new CartItemListPage(this)));
		addButton(panel, "6. 항목 삭제", () -> showPage(new CartItemListPage(this)));
		addButton(panel, "7. 영수증", () -> showPage(new OrderPage(this)));
		addButton(panel, "8. 종료", this::confirmExit);
		addButton(panel, "9. 관리자", this::openAdminDialog);
		return panel;
	}

	private void addButton(JPanel panel, String text, Runnable action) {
		JButton button = new JButton(text);
		button.addActionListener(event -> action.run());
		panel.add(button);
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("메뉴");
		addMenuItem(menu, "고객 정보 확인", () -> showPage(new GuestInfoPage()));
		addMenuItem(menu, "도서 추가", () -> showPage(new CartAddItemPage(this)));
		addMenuItem(menu, "장바구니 보기", () -> showPage(new CartItemListPage(this)));
		addMenuItem(menu, "영수증 표시", () -> showPage(new OrderPage(this)));
		addMenuItem(menu, "관리자", this::openAdminDialog);
		addMenuItem(menu, "종료", this::confirmExit);
		menuBar.add(menu);
		return menuBar;
	}

	private void addMenuItem(JMenu menu, String text, Runnable action) {
		JMenuItem item = new JMenuItem(text);
		item.addActionListener(event -> action.run());
		menu.add(item);
	}

	private void clearCart() {
		if (Welcome.mCart.getCartCount() == 0) {
			JOptionPane.showMessageDialog(this, "장바구니가 이미 비어 있습니다.");
			return;
		}
		int result = JOptionPane.showConfirmDialog(this, "장바구니를 비우겠습니까?", "장바구니 비우기",
				JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			Welcome.mCart.clearCart();
			showPage(new CartItemListPage(this));
		}
	}

	private void openAdminDialog() {
		AdminLoginDialog dialog = new AdminLoginDialog(this);
		dialog.setVisible(true);
	}

	private void confirmExit() {
		int result = JOptionPane.showConfirmDialog(this, "온라인 서점을 종료하겠습니까?", "종료",
				JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			dispose();
		}
	}
}
