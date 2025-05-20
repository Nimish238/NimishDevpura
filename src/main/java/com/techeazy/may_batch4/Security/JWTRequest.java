package com.techeazy.may_batch4.Security;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JWTRequest {
    private String email;

    private String password;
}
