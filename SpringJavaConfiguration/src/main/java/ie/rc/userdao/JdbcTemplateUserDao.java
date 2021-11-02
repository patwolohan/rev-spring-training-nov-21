package ie.rc.userdao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.sqlite.SQLiteDataSource;

public class JdbcTemplateUserDao implements UserDao {

	private JdbcTemplate jdbc;
	
	public JdbcTemplateUserDao() {
		
		SQLiteDataSource dataSource = new SQLiteDataSource();
		dataSource.setUrl("jdbc:sqlite:C:/data/november/userdb.db");
		
		jdbc = new JdbcTemplate(dataSource);
	}
	@Override
	public List<User> getUsers() {
		
		List<User> users = jdbc.query("select * from users", new UserMapper());
		return users;
	}

	@Override
	public User getUser(int id) throws UserDaoException {
		User user = null;		
		try {
			user = jdbc.queryForObject("select * from users where id = ?",  
										new Object [] { id }, 
										new UserMapper());
		} catch(Exception ex) {
			throw new UserDaoException("user not found");
		}
		return user;
	}

	@Override
	public User addUser(User userToAdd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User userToUpdate) throws UserDaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(int id) throws UserDaoException {
		jdbc.update("delete from users where id = ?", id);
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		UserDao dao = new JdbcTemplateUserDao();

		User u4;

		try {
			dao.deleteUser(4);			
			
			
			u4 = dao.getUser(4);
			System.out.println(u4);
			
		} catch (UserDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		List<User> users = dao.getUsers();
		
		for (User u:users) {
			System.out.println(u);
		}
	}
}
