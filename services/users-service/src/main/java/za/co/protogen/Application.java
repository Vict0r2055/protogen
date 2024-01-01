/**
 *
 * @author luyas 
 */
package za.co.protogen;

// imports
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import za.co.protogen.core.UserService;
import za.co.protogen.core.impl.UserServiceImpl;
import za.co.protogen.domain.User;
import za.co.protogen.utility.Constant;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

       
    }
}
