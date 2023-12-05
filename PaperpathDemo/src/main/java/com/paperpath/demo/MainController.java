package com.paperpath.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Chris
 */
@Controller
public class MainController {

    @GetMapping(value = {"", "/", "/home"})
    public String getHome() {
        return "index";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
}
