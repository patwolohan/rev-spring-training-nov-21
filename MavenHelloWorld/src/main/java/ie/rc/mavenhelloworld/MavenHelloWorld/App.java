package ie.rc.mavenhelloworld.MavenHelloWorld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Spring Bean Test" );
        // TestBean tb = new TestBean();
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("springBeans.xml");
        
        TestBean tb = ctx.getBean(TestBean.class);	// request object from Spring Context
        
        System.out.println(tb);
        
        String s = ctx.getBean(String.class);
        
        System.out.println(s);
        
    }
}
