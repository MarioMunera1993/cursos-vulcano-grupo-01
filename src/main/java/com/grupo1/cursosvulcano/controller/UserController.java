package com.grupo1.cursosvulcano.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.grupo1.cursosvulcano.model.entity.User;

import java.util.List;

import com.grupo1.cursosvulcano.service.UserService;

@RestController
@RequestMapping("/api/users")// Ruta base para las operaciones relacionadas con usuarios
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Crear un usuario: POST http://localhost:8080/api/users
    @PostMapping
    public ResponseEntity<User> crear(@RequestBody User user) {
        User nuevoUsuario = userService.registrarUsuario(user);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    // Listar usuarios: GET http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<User>> listar() {
        List<User> usuarios = userService.obtenerTodos();
        return ResponseEntity.ok(usuarios);
    }

    // Obtener uno: GET http://localhost:8080/api/users/{id}
    @GetMapping("/{id}")
    public ResponseEntity<User> obtenerUno(@PathVariable Long id) {
        return ResponseEntity.ok(userService.obtenerPorId(id));
    }

}
