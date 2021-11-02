package ie.rc.SpringJavaConfiguration;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ie.rc.userdao.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Annotation Driven Spring Configuration" );
        
        /*
        UserDao dao = new InMemoryUserDao();
        
        ArrayList<User> users = dao.getUsers();
        
        for (User u:users) {
        	
        	System.out.println(u);
        }
        
        dao.close();
        */
        
        
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        
        UserDao dao = ctx.getBean(UserDao.class);
        
        ArrayList<User> users = dao.getUsers();
        
        for (User u:users) {
        	
        	System.out.println(u);
        }
        
        dao.close();
        
        
    }
}
