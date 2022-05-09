import com.kuang.config.MapConfig;
import com.kuang.pojo.User;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.awt.AppContext;

public class MyTest {
    public static void main(String[] args) {
//        如果完全使用了配置类去做,我们就只能通过AnnotationConfig 上下文来获取容器,通过配置类的class对象加载
        ApplicationContext context = new AnnotationConfigApplicationContext(MapConfig.class);
        //此容器中有两个User对象,一个id危getUser,另一个id为user
        User getUser = (User) context.getBean("getuser");
        System.out.println(getUser.getName());
    }
}
