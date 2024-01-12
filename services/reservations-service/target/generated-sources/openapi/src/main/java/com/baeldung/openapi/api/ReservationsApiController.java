package com.baeldung.openapi.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-12T20:14:59.524943600+02:00[Africa/Johannesburg]")
@Controller
@RequestMapping("${openapi.reservation.base-path:}")
public class ReservationsApiController implements ReservationsApi {

    private final ReservationsApiDelegate delegate;

    public ReservationsApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) ReservationsApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new ReservationsApiDelegate() {});
    }

    @Override
    public ReservationsApiDelegate getDelegate() {
        return delegate;
    }

}
