package com.tu_proyecto.service;

import com.tu_proyecto.model.Estudiante;
import com.tu_proyecto.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class EstudianteDetailsService implements UserDetailsService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Estudiante estudiante = estudianteRepository.findByNombre(username);
        if (estudiante == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return User.builder()
                .username(estudiante.getNombre())
                .password(estudiante.getPassword()) 
                .roles("USER")
                .build();
    }


}
