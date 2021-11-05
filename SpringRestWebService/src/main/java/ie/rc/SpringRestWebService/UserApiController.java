package ie.rc.SpringRestWebService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ie.rc.userdao.User;
import ie.rc.userdao.UserDao;
import ie.rc.userdao.UserDaoException;

@RestController
@RequestMapping("/api")
public class UserApiController {

	@Autowired
	UserDao dao;
	
	@GetMapping("/users")
	public List<User> getUsers() {
		
		return dao.getUsers();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") int id) {
		User user = null;
		try {
			user = dao.getUser(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (UserDaoException e) {
			System.out.println("not found");
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		
		try {
			dao.deleteUser(id);
		} catch (UserDaoException e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User userToAdd) {
		
		System.out.println(userToAdd);
		
		User addedUser = dao.addUser(userToAdd);
		return addedUser;
	}
	
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable("id") int id, @RequestBody User userToUpdate) {
		try {
			dao.updateUser(userToUpdate);
			
		} catch (UserDaoException e) {
			e.printStackTrace();
		}
		return userToUpdate;
	}
	
	@GetMapping("/test")
	public User test() {
		
		User u = new User(1, "Alice", "alice@gmail.com", false);
		
		return u;
	}
}
