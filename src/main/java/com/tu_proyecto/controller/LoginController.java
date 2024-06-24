package com.tu_proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Debe coincidir con el nombre de tu archivo HTML (login.html)
    }
}
