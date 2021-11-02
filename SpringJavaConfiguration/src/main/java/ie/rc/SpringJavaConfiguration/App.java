package ie.rc.SpringJavaConfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Annotation Driven Spring Configuration" );
        
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        
        TestBean tb = ctx.getBean(TestBean.class);
        
        System.out.println(tb);
        
        String s = ctx.getBean(String.class);
        
        System.out.println(s);
    }
}
