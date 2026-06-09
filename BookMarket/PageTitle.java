package BookMarket;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

class PageTitle {
	private PageTitle() {
	}

	static JLabel create(String text) {
		JLabel label = new JLabel(text);
		label.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		return label;
	}
}
