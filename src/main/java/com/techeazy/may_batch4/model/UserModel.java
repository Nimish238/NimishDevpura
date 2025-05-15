package com.techeazy.may_batch4.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Data
public class UserModel {

    private Integer ID;

    private String name;

    private String email;

    private String role;

    private String password;

}
