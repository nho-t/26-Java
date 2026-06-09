package BookMarket;

public abstract class Item {

	protected String bookId;
	protected String name;
	protected int unitPrice;

	public Item(String bookId, String name, int unitPrice) {
		this.bookId = bookId;
		this.name = name;
		this.unitPrice = unitPrice;
	}

	public abstract String getBookID();
	public abstract String getName();
	public abstract int getUnitPrice();
	public abstract void setBookId(String bookId);
	public abstract void setName(String name);
	public abstract void setUnitPrice(int unitPrice);
}
