package ie.rc.SpringJavaConfiguration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

}
