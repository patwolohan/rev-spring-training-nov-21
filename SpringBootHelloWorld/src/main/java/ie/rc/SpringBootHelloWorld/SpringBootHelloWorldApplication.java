package ie.rc.SpringBootHelloWorld;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import ie.rc.userdao.User;
import ie.rc.userdao.UserDao;

@ComponentScan("ie.rc.userdao")
@SpringBootApplication
public class SpringBootHelloWorldApplication implements CommandLineRunner {

	@Autowired
	UserDao dao;
	
	@Value("${app.name}")
	public String name;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
				
		System.out.println("Name=" + name);
		List<User> users = dao.getUsers();
		
		for (User u: users) {
			System.out.println(u);
		}
	}
}
