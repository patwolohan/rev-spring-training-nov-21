package ie.rc.JpaTest;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaTestApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(JpaTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Spring JPA Test");
		
		//User newUser = new User(0, "Zoltar", "zoltar@gmail.com", false);
		//userRepository.save(newUser);
		//System.out.println(newUser);
		
		User u22 = userRepository.findById(22).get();
		
		System.out.println(u22);
		
		u22.setName("CHANGED");
		u22.setEmail("changed@gmail.com");
		u22.setActive(!u22.isActive());
		
		userRepository.save(u22);
		
		System.out.println("=======================");
		
		User u23 = userRepository.findById(23).get();
		
		userRepository.delete(u23);
		
		System.out.println("=======================");
		
		
		List<User> users = userRepository.findAll();
		
		for (User u:users) {
			
			System.out.println(u);
		}
	}



}
