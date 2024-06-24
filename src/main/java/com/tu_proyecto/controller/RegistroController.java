package com.tu_proyecto.controller;

import com.tu_proyecto.model.Estudiante;
import com.tu_proyecto.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistroController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registro")
    public String showRegistrationForm(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "registro"; // Debe coincidir con el nombre de tu archivo HTML (registro.html)
    }

    @PostMapping("/registro")
    public String registerEstudiante(Estudiante estudiante) {
        estudiante.setPassword(passwordEncoder.encode(estudiante.getPassword()));
        estudianteRepository.save(estudiante);
        return "redirect:/login"; // Redirige después de registrar al formulario de login
    }
}
