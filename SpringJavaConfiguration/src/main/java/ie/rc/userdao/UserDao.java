package ie.rc.userdao;

import java.util.ArrayList;

public interface UserDao {

	ArrayList<User> getUsers();
	User getUser(int id);
	User addUser(User userToAdd);
	void updateUser(User userToUpdate);
	void deleteUser(int id);
	void close();
}
