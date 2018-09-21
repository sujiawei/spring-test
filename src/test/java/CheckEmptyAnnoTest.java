import com.sujiawei.java.bean.User;
import com.sujiawei.java.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aop/spring-aop-test.xml")
public class CheckEmptyAnnoTest {

        @Resource
        private UserService userService;

        @Test
        public void testCheckEmptyAnno() {
            User user = new User();
            user.setId(1111);
            user.setName("jsw");
            userService.setUser(user);
        }
}
