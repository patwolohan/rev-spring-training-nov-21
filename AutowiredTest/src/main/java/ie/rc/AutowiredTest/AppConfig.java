package ie.rc.AutowiredTest;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.sqlite.SQLiteDataSource;

@Configuration
@ComponentScan("ie.rc")
public class AppConfig {

	@Bean 
	public DataSource getDataSource() {

		SQLiteDataSource dataSource = new SQLiteDataSource();
		dataSource.setUrl("jdbc:sqlite:C:/data/november/userdb.db");

		return dataSource;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		
		JdbcTemplate jdbc = new JdbcTemplate(getDataSource());
		
		return jdbc;
		
	}
}
