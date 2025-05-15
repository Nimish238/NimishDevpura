package com.techeazy.may_batch4.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @Column(name = "UserName")
    private String name;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "role",nullable = false)
    private String role;

    @Column(name = "password",nullable = false)
    private String password;

    public UserEntity(Integer id, String name, String email, String encode) {
    }
}
