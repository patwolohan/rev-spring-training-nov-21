package ie.rc.UserManagerSystem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
	
	@Autowired
	UserRepository userRepository;

	@RequestMapping("/")
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<User> get(@PathVariable("id") int id) {
		
		User user = null;
		Optional<User> entity = userRepository.findById(id);
		
		if (entity.isPresent()) {
			return new ResponseEntity(entity.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity(user, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/")
	public User add(@RequestBody User userToAdd) {
		
		userRepository.save(userToAdd);
		return userToAdd;
	}
	
	@PutMapping("/{id}")
	public User update(@PathVariable("id") int id, @RequestBody User userToUpdate) {

		userRepository.save(userToUpdate);
		return userToUpdate;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") int id) {
		userRepository.deleteById(id);
	}

}
