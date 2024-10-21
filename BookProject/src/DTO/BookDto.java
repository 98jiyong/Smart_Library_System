package DTO;

public class BookDto {
	
	private String isbn = null;
	private String title = null;
	private String writer = null;
	private String category = null;
	private int bookcnt = 0;
	
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
	public int getBookcnt() {
		return bookcnt;
	}
	public void setBookcnt(int bookcnt) {
		this.bookcnt = bookcnt;
	}
	
	@Override
	public String toString() {
		return "BookDto [isbn=" + isbn + ", title=" + title + ", writer=" + writer + ", category=" + category
				+ ", bookcnt=" + bookcnt + "]";
	}
	
}
