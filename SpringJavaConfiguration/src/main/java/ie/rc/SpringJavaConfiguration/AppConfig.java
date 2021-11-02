package ie.rc.SpringJavaConfiguration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ie.rc.userdao.InMemoryUserDao;
import ie.rc.userdao.SqliteUserDao;
import ie.rc.userdao.UserDao;

@Configuration
public class AppConfig {
	
	@Bean
	public TestBean getTestBean() {
		
		return new TestBean();
	}
	
	@Bean
	public String getTestString() {
		
		return "This is a spring string";
	}
	
	@Bean
	public UserDao getDao() {
		
		return new SqliteUserDao();
	}
	

}
