package ie.rc.userdao;

import java.util.ArrayList;

public interface UserDao {

	ArrayList<User> getUsers();
	User getUser(int id) throws UserDaoException;
	User addUser(User userToAdd);
	void updateUser(User userToUpdate) throws UserDaoException;
	void deleteUser(int id) throws UserDaoException;
	void close();
}
