package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnect {
	private String servername;
	private String port;
	private String db_name;
	private String db_user;
	private String db_pass;
	
	public MyConnect() {
		servername = "127.0.0.1";
		port = "8889";
		db_name = "giohang";
		db_user = "root";
		db_pass = "root";
	}
	
	public Connection getcn() {
		Connection cn = null;
		String db_url = "jdbc:mysql://" + servername + ":" + port + "/" + db_name;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(db_url, db_user, db_pass);
		} catch (ClassNotFoundException ex) { 
			System.out.println(ex.getMessage());
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return cn;
	}
}
