package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.DBClose;
import DB.DBConnection;
import DTO.LoanDto;

public class LoanDao {
	DBConnection DBCN = DBConnection.getInstance();
	DBClose DBCL = DBClose.getInstance();
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	public static LoanDao loandao = null;
	private Connection conn = null;
	
	private LoanDao() {
		DBCN.init();
		conn = DBCN.conn();
	}
	
	public static LoanDao getInstance() {
		if(loandao == null) {
			loandao = new LoanDao();
		}
		return loandao;
	}
	
	public boolean isin(String isbn, String id) {
		ArrayList<LoanDto> llist = loandao.selectAll(id);
		for(LoanDto tempu : llist) {
			if(isbn.equals(tempu.getIsbn())){
				return true;
			}
		}
		return false;
	}
	
	public void insert(LoanDto ldto) {
		if(conn != null) {
			try {
				String sql = null;
				if(loandao.isin(ldto.getIsbn(), ldto.getId())) {
					sql = "update loanlist set bookcnt = bookcnt + ? where isbn = ? and id = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, 1);
					pstmt.setString(2, ldto.getIsbn());
					pstmt.setString(3, ldto.getId());
				}else {
					sql = "insert into loanlist values (?,?,?,?,?,?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, ldto.getIsbn());
					pstmt.setString(2, ldto.getTitle());
					pstmt.setString(3, ldto.getWriter());
					pstmt.setString(4, ldto.getCategory());
					pstmt.setString(5, ldto.getId());
					pstmt.setInt(6, 1);
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
	
	public ArrayList<LoanDto> select(String id, String keyword){
		ArrayList<LoanDto> slist = new ArrayList<LoanDto>();
		if(conn != null) {
			try {
				String sql = "select * from loanlist where id =? and title like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, "%" + keyword + "%");
				rs = pstmt.executeQuery();
				while(rs.next()) {	
					LoanDto searchTemp = new LoanDto();
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
	
	public ArrayList<LoanDto> selectAll(String id){
		ArrayList<LoanDto> llist = new ArrayList<LoanDto>();
		if(conn != null) {
			try {
				String sql = "select * from loanlist where id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				while(rs.next()) {	
					LoanDto loanTemp = new LoanDto();
					loanTemp.setIsbn(rs.getString("isbn"));
					loanTemp.setTitle(rs.getString("title"));
					loanTemp.setWriter(rs.getString("writer"));
					loanTemp.setCategory(rs.getString("category"));
//					loanTemp.setId(rs.getString("id"));
					loanTemp.setBookcnt(rs.getInt("bookcnt"));
					llist.add(loanTemp);
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
		return llist;
	}
	
	public void delete(String isbn, String id) {
		if(conn != null) {
			try {
				String sql = "delete from loanlist where isbn = ? and id = ? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, isbn);
				pstmt.setString(2, id);
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
	
	public void bookSub(String isbn, String id, int bookcnt) {
		if(conn != null) {
			try {
				String sql = null;
				if(bookcnt <= 1) {
					sql = "delete from loanlist where isbn = ? and id = ? ";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, isbn);
					pstmt.setString(2, id);
				}else {
					sql = "update loanlist set bookcnt = bookcnt - ? where isbn = ? and id = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, 1);
					pstmt.setString(2, isbn);
					pstmt.setString(3, id);
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
