package ie.rc.userdao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class InMemoryUserDao implements UserDao {

	protected List<User> users = new ArrayList<User>();
	
	public InMemoryUserDao() {
		
		users.add(new User(1, "Alice", "alice@gmail.com", true));
		users.add(new User(2, "Bob", "bob@gmail.com", true));
		users.add(new User(3, "Carol", "carol@gmail.com", false));
		users.add(new User(4, "Dan", "dan@gmail.com", true));
		users.add(new User(5, "Eve", "eve@gmail.com", true));
	}

	public List<User> getUsers() {
		return users;
	}
	
	public User getUser(int id) throws UserDaoException {
		
		for (int i=0; i<users.size(); i++) {
			
			User user = users.get(i);
			if (user.getId() == id) {
				return user; 
			}
		}
		throw new UserDaoException("User " + id + " not found");
	}

	public User addUser(User userToAdd) {
		users.add(userToAdd);
		return userToAdd;
	}
	
	public void updateUser(User userToUpdate) throws UserDaoException {
		
		for (int i=0; i<users.size(); i++) {
			
			User user = users.get(i);
			if (user.getId() == userToUpdate.getId()) {
				user.setName(userToUpdate.getName());
				user.setEmail(userToUpdate.getEmail());
				user.setActive(userToUpdate.isActive());
				return;
			}
		}
		throw new UserDaoException("User " + userToUpdate.getId() + " not found");		
	}
	
	public void deleteUser(int id) throws UserDaoException {
		for (int i=0; i<users.size(); i++) {
			
			User user = users.get(i);
			if (user.getId() == id) {
				users.remove(user);
				return;
			}
		}
		throw new UserDaoException("User " + id + " not found");
	}
	
	public void close() {
		users.clear();
	}
}
