import com.kuang.pojo.Student;
import com.kuang.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());
    }
    /*
    Student{name='小阳', address=Address{address='null'},
    books=[唐人街探案1, 唐人街探案2, 唐人街探案3, 唐人街探案4], hobbys=[烹饪, 听歌, 自由自在, 旅游],
    card={身份证=431124200212160319, 银行卡=111112222233334444}, games=[战地5, 彩六, Dying Light2],
    wife='null', info={password=123456, url=男, driver=20220407, username=root}}
     */

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User user = context.getBean("user", User.class);
        User user2 = context.getBean("user2", User.class);
        System.out.println(user.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user==user2);
    }
//    其余的request,session,application这些只能仔Web开发中使用到.
}
