/**
 *
 * @author luyas
 */
package za.co.protogen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.ConfigurableApplicationContext;
// import za.co.protogen.core.CarService;
// import za.co.protogen.core.impl.CarServiceImpl;
import za.co.protogen.utility.Constant;
import za.co.protogen.domain.Car;
import java.util.List;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        // System.out.println(Constant.cars.toString());
        // // System.out.println(Constant.cars.getCarById(1));
        // List<Car> cars = Constant.cars;
        // System.out.println(cars);

    }
}
