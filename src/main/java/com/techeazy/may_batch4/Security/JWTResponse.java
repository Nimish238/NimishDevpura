package com.techeazy.may_batch4.Security;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JWTResponse {
    private String token;

    private String userName;
}
