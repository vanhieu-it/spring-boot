package org.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller
// @ResponseBody
@RestController
public class HelloController {

    @RequestMapping("/")
    String hello() {
        return "Hello World, Spring Boot!";
    }

}
