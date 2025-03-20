package api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApi {

    @GetMapping(value = "/")
    public String hello() {
        return "Hello, Docker Container!";
    }
}
