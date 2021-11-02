package ie.rc.AutowiredTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ie.rc.userdao.User;
import ie.rc.userdao.UserDao;


@Component
public class UserService {

	@Autowired
	UserDao dao;
	
	public UserService() {
		
	}
	
	public void doSomething() {
		
		List<User> users = dao.getUsers();
		
		for (User u: users) {
			System.out.println(u);
		}
	}
}
