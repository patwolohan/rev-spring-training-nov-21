package ie.rc.SpringJavaConfiguration;

import java.sql.*;

public class DbHelloWorld {

	public static void main(String[] args) {
		
		String url = "jdbc:sqlite:C:/data/november/userdb.db";
		try {
			Connection conn = DriverManager.getConnection(url);
			
			String sql = "select * from users";
			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next() ) {
				
				System.out.println(rs.getString("name"));
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
