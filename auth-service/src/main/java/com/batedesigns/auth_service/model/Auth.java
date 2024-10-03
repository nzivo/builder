package com.batedesigns.auth_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Setter
    @Getter
    private String firstName;
    @Setter
    @Getter
    private String lastName;
    @Setter
    @Getter
    private String username;
    @Setter
    @Getter
    private String email;
    @Getter
    @Setter
    private String password;

    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    private Role role;

}
