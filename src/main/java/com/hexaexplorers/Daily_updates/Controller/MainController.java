package com.hexaexplorers.Daily_updates.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String helloPage()
    {
        return "hello User";
    }

    @GetMapping("/login")
    public String LoginPage()
    {
        return "Login Page";
    }
}
