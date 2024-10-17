package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	public String findID(String name, String tel) {
		if((conn = DBCN.conn()) != null) {
			try {
				String sql = "select id from account where name = ? and tel = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, tel);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					String userId = null;
					userId = rs.getString("id");
					return userId;
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
		return null;
	}
	public String findPW(String id, String pwhint) {
		if((conn = DBCN.conn()) != null) {
			try {
				String sql = "select pw from account where id = ? and pwhint = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, pwhint);
				rs = pstmt.executeQuery();
				while(rs.next()) {	
					String userPw = null;
					userPw = rs.getString("pw");
					return userPw;
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
		return null;
	}
	public void resetPW(String resetPw, String id) {
		if((conn = DBCN.conn()) != null) {
			try {
				String sql = "update account set pw = ? where id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, resetPw);
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
	public ArrayList<UserDto> selectAll(){
		ArrayList<UserDto> ulist = new ArrayList<UserDto>();
		if((conn = DBCN.conn()) != null) {
			try {
				String sql = "select * from account";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {	
					UserDto userTemp = new UserDto();
					userTemp.setId(rs.getString("id"));
					userTemp.setName(rs.getString("name"));
					userTemp.setPw(rs.getString("pw"));
					userTemp.setPwHint(rs.getString("pwhint"));
					userTemp.setTel(rs.getString("tel"));
					userTemp.setAuth(rs.getString("auth"));
					ulist.add(userTemp);
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
		return ulist;
	}
		
}
