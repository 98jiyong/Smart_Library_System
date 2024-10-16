package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DBClose;
import DB.DBConnection;
import DTO.UserDto;

public class UserDao {
	
	DBConnection DBCN = DBConnection.getInstance();
	DBClose DBCL = DBClose.getInstance();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	public static UserDao userdao = null;
	
	private UserDao() {
		DBCN.init();
	}
	
	public static UserDao getInstance() {
		if(userdao == null) {
			userdao = new UserDao();
		}
		return userdao;
	}
	
	public void insert(UserDto udto) {
		if((conn = DBCN.conn()) != null) {
			try {
				String sql = "insert into account values (?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, udto.getId());
				pstmt.setString(2, udto.getName());
				pstmt.setString(3, udto.getPw());
				pstmt.setString(4, udto.getPwHint());
				pstmt.setString(5, udto.getTel());
				pstmt.setString(6, udto.getAuth());
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
