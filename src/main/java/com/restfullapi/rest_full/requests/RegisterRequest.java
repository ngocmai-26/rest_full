package com.restfullapi.rest_full.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "Username required")
    private String username;
    @NotBlank(message = "Password required")
    private String password;

    @Email(message = "Email invalid")
    @NotBlank(message = "Email required")
    private String email;

    @NotBlank(message = "Fullname required")
    private String fullName;

    @Length(max = 12, min = 10)
    private String phone;

    @NotNull
    private Long managerId;
}
