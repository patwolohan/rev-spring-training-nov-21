package ie.rc.SpringRestWebService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("ie.rc")
@SpringBootApplication
public class SpringRestWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestWebServiceApplication.class, args);
	}

}
