package com.grupo1.cursosvulcano.service;
import com.grupo1.cursosvulcano.repository.UserRepository;
import com.grupo1.cursosvulcano.model.entity.User;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Inyección de dependencias por constructor (más seguro que @Autowired)
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //metodo para registrar un nuevo usuario
    public User registrarUsuario(User user) {
        // Aquí se pueden agregar validaciones adicionales (e.g., verificar si el email ya existe)
        return userRepository.save(user);
    }

    //metodo para obetener todos los usuarios
    public List<User> obtenerTodos() {
        return userRepository.findAll();
    }

    //metodo para obtener un usuario por su id
    public User obtenerPorId(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));// Lanza excepción si no se encuentra el usuario
    }

}
