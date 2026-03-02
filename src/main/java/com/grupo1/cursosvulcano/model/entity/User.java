package com.grupo1.cursosvulcano.model.entity;

import java.time.LocalDateTime;
import jakarta.persistence.CascadeType;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único del usuario autoincremental

    @Column(nullable = false, unique = true, length = 50)
    private String username; // Nombre de usuario único y obligatorio

    @Column(nullable = false, unique = true , length = 100)
    private String email; // Correo electrónico único y obligatorio

    @Column(nullable = false)
    private String password; // Contraseña del usuario, se recomienda almacenar de forma segura (hash)

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt; // Fecha y hora de creación del usuario, se establece automáticamente al crear el registro

    @UpdateTimestamp
    private LocalDateTime updatedAt; // Fecha y hora de la última actualización del usuario, se actualiza automáticamente

    // Relaciones: Un usuario puede tener muchas revisiones y muchos progresos
    // FetchType.LAZY: Solo carga las listas cuando se necesitan (evita N+1 queries)
    // CascadeType.ALL: Si se borra un User, se borran sus reviews y progresos
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnoreProperties({ "user", "hibernateLazyInitializer", "handler" })
    private List<Review> reviews;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnoreProperties({ "user", "hibernateLazyInitializer", "handler" })
    private List<AcademicProgress> progressRecords;

}
