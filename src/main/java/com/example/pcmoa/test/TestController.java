package com.example.pcmoa.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${app.version:3.2.3}")
    String version;

    @GetMapping("/")
    public String version() {
        return "CI/CD TEST COMPLETED!!!";
    }
}
