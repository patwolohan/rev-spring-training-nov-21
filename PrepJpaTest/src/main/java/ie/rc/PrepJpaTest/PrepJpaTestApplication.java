package ie.rc.PrepJpaTest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrepJpaTestApplication implements CommandLineRunner {

	
	@Autowired
	UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PrepJpaTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
		//User newUser = new User("New", "new.user@gmail.com", true);
		
		//userRepository.save(newUser);

		

		
		
		User u13 = userRepository.findById(13).get();
		
		System.out.println(u13);
		
		
		u13.setName("CHANGED");
		u13.setEmail("changed@gmail.com");
		u13.setActive(!u13.isActive());

		
		userRepository.save(u13);

		List<User> users = userRepository.findAll();

		for (User user:users) {
			
			System.out.println(user);
		}

		
		
		
		
	}

}
