package BookMarket;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

class GuestInfoPage extends JPanel {
	GuestInfoPage() {
		setLayout(new BorderLayout(12, 12));
		add(PageTitle.create("고객 정보 확인"), BorderLayout.NORTH);

		JPanel info = new JPanel(new GridLayout(3, 2, 8, 8));
		info.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		info.add(new JLabel("이름"));
		info.add(new JLabel(Welcome.mUser.getName()));
		info.add(new JLabel("연락처"));
		info.add(new JLabel(Welcome.mUser.getPhone()));
		info.add(new JLabel("주소"));
		String address = Welcome.mUser.getAddress();
		info.add(new JLabel(address == null || address.isBlank() ? "미입력" : address));
		add(info, BorderLayout.CENTER);
	}
}
