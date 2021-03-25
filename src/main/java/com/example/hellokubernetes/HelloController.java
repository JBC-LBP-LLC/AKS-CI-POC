package com.example.hellokubernetes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {

    private static final String template = "Welcome you from %s!";
    private final AtomicLong counter = new AtomicLong();

    @Value("${application.env}")
    private String env;

    @GetMapping("/")
    public Greeting greeting() {
        return new Greeting(counter.incrementAndGet(), String.format(template, env));
    }

    static public class Greeting {
        public long id;
        public String content;

        public Greeting(long id, String content) {
            this.id = id;
            this.content = content;
        }
    }
}
