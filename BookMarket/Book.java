package BookMarket;

public class Book extends Item{
	private String author;
	private String description;
	private String category;
	private String releaseDate;
	
	public Book(String bookId, String name, int unitPrice) {
		super(bookId, name, unitPrice);
	}
	
	public Book(String bookId, String name, int unitPrice, String author, String description, String category, String releaseDate) {
		super(bookId, name, unitPrice);
		this.author = author;
		this.description = description;
		this.category = category;
		this.releaseDate = releaseDate;
	}
	
	@Override
	public String getBookID() {
		return this.bookId; 
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getUnitPrice() {
		return this.unitPrice;
	}

	@Override
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Object[] toTableRow() {
		return new Object[] {
			getBookID(),
			getName(),
			getUnitPrice(),
			getAuthor(),
			getCategory(),
			getReleaseDate()
		};
	}

	@Override
	public String toString() {
		return getBookID() + " | " + getName() + " | " + getUnitPrice()
				+ "원 | " + getAuthor() + " | " + getCategory() + " | " + getReleaseDate();
	}
}

