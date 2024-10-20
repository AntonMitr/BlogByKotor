package com.blog.by.kotor.dto.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO авторизации пользователя")
public class LoginDTO {

    @Schema(description = "Имя пользователя", example = "user1")
    @NotBlank
    private String username;

    @Schema(description = "Пароль должен содержать от 6 до 32 символов " +
            "и как минимум одну букву, одну цифру и один специальный символ")
    @Size(min = 6, max = 32)
    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\\\\\\\d)(?=.*[@$!%*#?^&amp;])[A-Za-z\\\\d@$!%*#?^&amp;]$")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

}
