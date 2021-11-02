package ie.rc.userdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDao {

	// member variables
	private Connection conn;
	private final String url = "jdbc:sqlite:C:/data/november/userdb.db";
	
	// member functions

	// constructor
	public UserDao() {
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// getUsers
	public List<User> getUsers() {
		List<User> users = new ArrayList<>();
		String sql = "select * from users";
		
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				boolean active = rs.getBoolean("active");
				User u = new User(id, name, email, active);
				
				users.add(u);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	// close
	public void close() {
		try {
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		UserDao dao = new UserDao();

		List<User> users = dao.getUsers();

		for (User u: users) {
			
			System.out.println(u);
		}
		
		dao.close();

	}

}
