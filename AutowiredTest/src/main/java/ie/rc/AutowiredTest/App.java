package ie.rc.AutowiredTest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ie.rc.userdao.User;
import ie.rc.userdao.UserDao;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Autowired Test" );
     
        /* this doesn't work
         * autowired only works on spring managed beans
         */
        //UserService usb = new UserService();
        //usb.doSomething();
        
        
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        
        UserService us = ctx.getBean(UserService.class);
        
        us.doSomething();
        
        
        /*
        UserDao dao = ctx.getBean(UserDao.class);
        
        List<User> users = dao.getUsers();
        
        for (User u:users) {
        	System.out.println(u);
        }
        */
    }
}
