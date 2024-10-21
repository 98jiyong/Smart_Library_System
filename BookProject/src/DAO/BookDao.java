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
}
