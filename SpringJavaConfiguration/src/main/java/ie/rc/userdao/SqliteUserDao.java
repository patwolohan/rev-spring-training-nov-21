package ie.rc.userdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SqliteUserDao implements UserDao {

	// member variables
	private Connection conn;
	private final String url = "jdbc:sqlite:C:/data/november/userdb.db";
	
	// member functions

	// constructor
	public SqliteUserDao() {
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// getUsers
	public List<User> getUsers() {
		ArrayList<User> users = new ArrayList<>();
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
	
	public User getUser(int id) {
		User u = null;
		
		String sql = "SELECT * from users where id = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next() ) {
				// record was found
				String name = rs.getString("name");
				String email = rs.getString("email");
				boolean active = rs.getBoolean("active");
				
				u = new User(id, name, email, active);				
			} else {
				//throw new UserDaoException("User " + id + " not found");
			}
			rs.close();
			stmt.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return u;
	}	
	
	public void deleteUser(int id) throws UserDaoException {
		
		String sql = "DELETE FROM users WHERE id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			int n = stmt.executeUpdate();
			
			if (n==0) {
				throw new UserDaoException("User " + id + " not found");
			}
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateUser(User userToUpdate) {
		// update this user in the database

		String sql = "UPDATE users SET name = ?, email = ?, active = ? WHERE id = ?";

		// System.out.println(sql);
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, userToUpdate.getName());
			stmt.setString(2, userToUpdate.getEmail());
			stmt.setBoolean(3, userToUpdate.isActive());
			stmt.setInt(4, userToUpdate.getId());
			stmt.executeUpdate();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
	public User addUser(User userToAdd) {
		
		String sql = "INSERT INTO users (name, email, active) VALUES (?, ?, ?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1,  userToAdd.getName());
			stmt.setString(2,  userToAdd.getEmail());
			stmt.setBoolean(3,  userToAdd.isActive());
			
			stmt.executeUpdate();
			stmt.close();
			
			// find out the id of the inserted record
			sql = "select last_insert_rowid();";
			
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next() ) {
				userToAdd.setId(rs.getInt(1));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userToAdd;
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
		
		SqliteUserDao dao = new SqliteUserDao();

		
		User userToAdd = new User("NEW USER", "new.user@gmail.com", true);
		
		
		User addedUser = dao.addUser(userToAdd);
		
		System.out.println(addedUser);
		
		
		
		//dao.deleteUser(3);
		
		/*
		User u4 = dao.getUser(4);
		
		
		u4.setName("CHANGED");
		u4.setEmail("changed@gmail.com");
		u4.setActive(false);
		
		dao.updateUser(u4);
		
		u4 = dao.getUser(4);
		
		System.out.println(u4);
		*/
		
		
		
		
		
		
		//User n = new User("NEW USER", "new.user@gmail.com", true);
		
		//n = dao.addUser(n);
		
		//System.out.println(n);
		
		//dao.deleteUser(2);
		/*
		List<User> users = dao.getUsers();

		for (User u: users) {
			
			System.out.println(u);
		}
		
		
		User u = dao.getUser(2);
		
		System.out.println(u);
		
		*/
		dao.close();

	}

}
