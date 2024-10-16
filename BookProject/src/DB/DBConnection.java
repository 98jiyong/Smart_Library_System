package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private String driverName = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String userName = "system";
	private String password = "11111111";
	private Connection conn = null;
	public static DBConnection DBCN = null;
	
	private DBConnection() {
		
	}
	
	public static DBConnection getInstance() {
		if(DBCN == null) {
			DBCN = new DBConnection();
		}
		return DBCN;
	}
	
	public void init() {
		try {
			Class.forName(driverName);
			System.out.println("Driver Loading Success");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection conn() {
		try {
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("Oracle Connection Success");
		} catch (SQLException e) {
			System.out.println("Oracle Connection Failed");
		}
		return conn;
	}
	
}
