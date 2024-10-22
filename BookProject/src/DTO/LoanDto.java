package DTO;

public class LoanDto {
	
	private String isbn = null;
	private String title = null;
	private String writer = null;
	private String category = null;
	private String id = null;
	private int bookcnt = 0;
	
	public int getBookcnt() {
		return bookcnt;
	}
	public void setBookcnt(int bookcnt) {
		this.bookcnt = bookcnt;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
