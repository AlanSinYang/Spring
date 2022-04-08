import com.kuang.pojo.UserT;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {

//        Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        UserT user = (UserT) context.getBean("user2");
        user.show();
    }
}
