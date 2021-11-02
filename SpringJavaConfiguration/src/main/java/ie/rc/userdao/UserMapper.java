package ie.rc.userdao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String email = rs.getString("email");
		boolean active = rs.getBoolean("active");

		User user = new User(id, name, email, active);
		
		return user;
	}



}
