package BookMarket;

import javax.swing.table.DefaultTableModel;

class ReadOnlyTableModel extends DefaultTableModel {
	ReadOnlyTableModel(Object[][] data, Object[] columnNames) {
		super(data, columnNames);
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
