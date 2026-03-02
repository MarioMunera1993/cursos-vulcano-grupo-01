package com.grupo1.cursosvulcano.repository;
import com.grupo1.cursosvulcano.model.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // aqui se puede agregar métodos personalizados
}
