package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.DBClose;
import DB.DBConnection;
import DTO.BookDto;

public class BookDao {
	
	DBConnection DBCN = DBConnection.getInstance();
	DBClose DBCL = DBClose.getInstance();
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	public static BookDao bookdao = null;
	private Connection conn = null;
//	private int bookcnt = 0;
	
	private BookDao() {
		DBCN.init();
		conn = DBCN.conn();
	}
	
	public static BookDao getInstance() {
		if(bookdao == null) {
			bookdao = new BookDao();
		}
		return bookdao;
	}
	
	public boolean isin(String isbn) {
		ArrayList<BookDto> blist = bookdao.selectAll();
		for(BookDto tempu : blist) {
			if(isbn.equals(tempu.getIsbn())){
				return true;
			}
		}
		return false;
	}
	
	public void insert(BookDto bdto) {
		if(conn != null) {
			try {
				String sql = "insert into book values (?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bdto.getIsbn());
				pstmt.setString(2, bdto.getTitle());
				pstmt.setString(3, bdto.getWriter());
				pstmt.setString(4, bdto.getCategory());
				pstmt.setInt(5, bdto.getBookcnt());
				// 쿼리 실행
				int result = pstmt.executeUpdate();
				if(result == 0) {
					conn.rollback();
					System.out.println("결과에 의해 롤백 완료");
				}else {
					conn.commit();
					System.out.println("결과에 의해 커밋 완료");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					DBCL.close();
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
	
	public ArrayList<BookDto> select(String keyword){
		ArrayList<BookDto> slist = new ArrayList<BookDto>();
		if(conn != null) {
			try {
				String sql = "select * from book where title like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + keyword + "%");
				rs = pstmt.executeQuery();
				while(rs.next()) {	
					BookDto searchTemp = new BookDto();
					searchTemp.setIsbn(rs.getString("isbn"));
					searchTemp.setTitle(rs.getString("title"));
					searchTemp.setWriter(rs.getString("writer"));
					searchTemp.setCategory(rs.getString("category"));
					searchTemp.setBookcnt(rs.getInt("bookcnt"));
					slist.add(searchTemp);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					DBCL.close();
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		return slist;
	}
	
	public ArrayList<BookDto> selectAll(){
		ArrayList<BookDto> blist = new ArrayList<BookDto>();
		if(conn != null) {
			try {
				String sql = "select * from book";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {	
					BookDto bookTemp = new BookDto();
					bookTemp.setIsbn(rs.getString("isbn"));
					bookTemp.setTitle(rs.getString("title"));
					bookTemp.setWriter(rs.getString("writer"));
					bookTemp.setCategory(rs.getString("category"));
					bookTemp.setBookcnt(rs.getInt("bookcnt"));
					blist.add(bookTemp);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					DBCL.close();
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		return blist;
	}
	
	public void delete(String isbn) {
		if(conn != null) {
			try {
				String sql = "delete from book where isbn = ? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, isbn);
				// 쿼리 실행
				int result = pstmt.executeUpdate();
				if(result == 0) {
					conn.rollback();
					System.out.println("결과에 의해 롤백 완료");
				}else {
					conn.commit();
					System.out.println("결과에 의해 커밋 완료");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					DBCL.close();
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
//	public int findBookCnt(String isbn) {
//		if(conn != null) {
//			try {
//				String sql = "select bookcnt from book where isbn = ?";
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, isbn);
//				rs = pstmt.executeQuery();
//				while(rs.next()) {	
//					bookcnt = rs.getInt("bookcnt");
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} finally {
//				try {
//					DBCL.close();
//				}catch (Exception e) {
//					// TODO: handle exception
//				}
//			}
//		}
//		return bookcnt;
//	}
	
	public void bookAdd(String isbn, String title, String writer, String category) {
		if(conn != null) {
			try {
				String sql = null;
//				bookcnt = bookdao.findBookCnt(isbn);
				if(bookdao.isin(isbn)) {
					sql = "update book set bookcnt = bookcnt + ? where isbn = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, 1);
					pstmt.setString(2, isbn);
				}else {
					sql = "insert into book values(?,?,?,?,1)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, isbn);
					pstmt.setString(2, title);
					pstmt.setString(3, writer);
					pstmt.setString(4, category);
				}
				// 쿼리 실행
				int result = pstmt.executeUpdate();
				if(result == 0) {
					conn.rollback();
					System.out.println("결과에 의해 롤백 완료");
				}else {
					conn.commit();
					System.out.println("결과에 의해 커밋 완료");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					DBCL.close();
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
	
	public void bookSub(String isbn, int bookcnt) {
		if(conn != null) {
			try {
				String sql = null;
				if(bookcnt <= 1) {
					sql = "delete from book where isbn = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, isbn);
				}else {
					sql = "update book set bookcnt = ? where isbn = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, bookcnt-1);
					pstmt.setString(2, isbn);
				}
				// 쿼리 실행
				int result = pstmt.executeUpdate();
				if(result == 0) {
					conn.rollback();
					System.out.println("결과에 의해 롤백 완료");
				}else {
					conn.commit();
					System.out.println("결과에 의해 커밋 완료");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					DBCL.close();
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
}
