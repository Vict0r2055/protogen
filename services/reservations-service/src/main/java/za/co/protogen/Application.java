/**
 *
 * @author luyas
 */

package za.co.protogen;

// imports
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import za.co.protogen.core.ReservationService;
// import za.co.protogen.core.impl.ReservationServiceImpl;
// import za.co.protogen.domain.Reservation;
// import java.time.LocalDate;
// import java.util.List;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        // Get the ReservationService bean from the application context
        // ReservationService reservationService =
        // context.getBean(ReservationService.class);

    }
}
