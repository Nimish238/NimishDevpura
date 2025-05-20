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
    private Long ID;

    @Column(name = "UserName")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @Column(name = "password")
    private String password;


}
