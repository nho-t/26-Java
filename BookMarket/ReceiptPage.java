package BookMarket;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class ReceiptPage extends JPanel {
	ReceiptPage(String name, String phone, String address, String deliveryDate) {
		setLayout(new BorderLayout(12, 12));
		add(PageTitle.create("주문 영수증"), BorderLayout.NORTH);
		JTextArea receipt = new JTextArea();
		receipt.setEditable(false);
		receipt.setText(buildReceipt(name, phone, address, deliveryDate));
		add(new JScrollPane(receipt), BorderLayout.CENTER);
	}

	private String buildReceipt(String name, String phone, String address, String deliveryDate) {
		StringBuilder builder = new StringBuilder();
		builder.append("배송 받을 고객 정보\n");
		builder.append("고객명: ").append(name).append("\n");
		builder.append("연락처: ").append(phone).append("\n");
		builder.append("배송지: ").append(address).append("\n");
		builder.append("배송일: ").append(deliveryDate).append("\n\n");
		builder.append("도서ID\t도서명\t수량\t합계\n");
		for (CartItem item : Welcome.mCart.getCartItems()) {
			builder.append(item.getBookID()).append("\t")
					.append(item.getItemBook().getName()).append("\t")
					.append(item.getQuantity()).append("\t")
					.append(item.getTotalPrice()).append("원\n");
		}
		builder.append("\n총 금액: ").append(Welcome.mCart.getTotalAmount()).append("원\n");
		return builder.toString();
	}
}
