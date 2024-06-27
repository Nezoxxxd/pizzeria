package com.modsen.pizzeria.domain;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
@Schema(description = "User Entity")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id", example = "1")
    private Long id;

    @Column(nullable = false, length = 50)
    @Schema(description = "First Name", example = "John")
    private String firstname;

    @Column(nullable = false, length = 50)
    @Schema(description = "Last Name", example = "Doe")
    private String lastname;

    @Column(nullable = false, unique = true, length = 50)
    @Schema(description = "Email", example = "john.doe@example.com")
    private String email;

    @Column(nullable = false, length = 15)
    @Schema(description = "Password", example = "password1")
    private String password;

    @Column(nullable = false, length = 10)
    @Schema(description = "Gender", example = "Male")
    private String gender;

    @Column(nullable = false)
    @Schema(description = "Birth Date", example = "1999-01-02")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    @Schema(description = "Role Id", example = "2")
    private Role role;
}
