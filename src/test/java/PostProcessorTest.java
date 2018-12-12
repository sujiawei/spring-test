
import com.sujiawei.java.core.BeanFactoryPostProcessorTest;
import com.sujiawei.java.core.BeanFactoryPostProcessorTest1;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PostProcessorTest {
    ApplicationContext applicationcontext=null;
    @Before
    public void before() {
        System.out.println("》》》Spring ApplicationContext容器开始初始化了......");
        applicationcontext= new ClassPathXmlApplicationContext(new String[]{"service/spring-test1.xml"});
        System.out.println("》》》Spring ApplicationContext容器初始化完毕了......");
    }
    @Test
    public void  test() {
        //BeanLifecycle beanLifecycle =applicationcontext.getBean("beanLifecycle",BeanLifecycle.class);
        BeanFactoryPostProcessorTest beanFactoryPostProcessorTest=applicationcontext.getBean(BeanFactoryPostProcessorTest.class);
        System.out.println(beanFactoryPostProcessorTest.toString());
        BeanFactoryPostProcessorTest1 beanFactoryPostProcessorTest1=applicationcontext.getBean(BeanFactoryPostProcessorTest1.class);
        System.out.println(beanFactoryPostProcessorTest1.toString());
    }
}