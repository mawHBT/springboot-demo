package com.example.springbootdemo.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * In Spring’s approach to building RESTful web services, HTTP requests are handled by a controller.
 * These components are identified by the @RestController annotation.
 * marks the class as a controller where every method returns a domain object instead of a view, shorthand for including both @Controller and @ResponseBody
 */
@RestController
// handles GET requests for /greeting by returning a new instance of the Greeting class
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //ensures that HTTP GET requests to /greeting are mapped to the greeting() method
    @GetMapping("/greeting")
    //@RequestParam binds the value of the query string parameter name into the name parameter of the greeting() method
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        // Because Jackson 2 is on the classpath, Spring’s MappingJackson2HttpMessageConverter is automatically chosen to convert the Greeting instance to JSON.
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    /*
     * There are companion annotations for other HTTP verbs (e.g. @PostMapping for POST).
     * There is also a @RequestMapping annotation that they all derive from, and can serve as a synonym
     * (e.g. @RequestMapping(method=GET)).
     */
}