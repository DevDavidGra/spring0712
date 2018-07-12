package part01test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnDAO {
	private String driver,url,user,pass;
	private Connection conn;

	
	public ConnDAO() {
	}

	public ConnDAO(String driver, String url, String user, String pass) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pass = pass;
	}
	
	public void init() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, pass);
	}
	
	public List<Map<String, String>> select() throws SQLException {
		
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		String sql = "select * from employees";
		try(	PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery()){
						
			
			while(rs.next()) {
				Map<String, String> map = new HashMap<>();
				map.put("name", rs.getString("first_name"));
				list.add(map);
			}
		}
		
		return list;
	}
	
	public void exit() throws SQLException {
		if(conn!=null) {
			conn.close();
		}
		
	}
	
}
