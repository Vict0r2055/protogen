package com.baeldung.openapi.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-12T02:42:47.824164200+02:00[Africa/Johannesburg]")
@Controller
@RequestMapping("${openapi.car.base-path:}")
public class CarsApiController implements CarsApi {

    private final CarsApiDelegate delegate;

    public CarsApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) CarsApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new CarsApiDelegate() {});
    }

    @Override
    public CarsApiDelegate getDelegate() {
        return delegate;
    }

}
