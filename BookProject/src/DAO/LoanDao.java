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
	
	
	public void insert(LoanDto ldto) {
		if(conn != null) {
			try {
				String sql = "insert into loanlist values (?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ldto.getIsbn());
				pstmt.setString(2, ldto.getTitle());
				pstmt.setString(3, ldto.getWriter());
				pstmt.setString(4, ldto.getCategory());
				pstmt.setString(5, ldto.getId());
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
					loanTemp.setId(rs.getString("id"));
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
}
