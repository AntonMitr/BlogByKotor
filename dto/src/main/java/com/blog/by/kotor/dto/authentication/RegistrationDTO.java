package com.blog.by.kotor.dto.authentication;

import com.blog.by.kotor.model.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Пользователь для регистрации")
public class RegistrationDTO {

    @Schema(description = "Имя пользователя", example = "user1")
    @NotBlank
    private String username;

    @Schema(description = "Электронная почта", example = "user1@gmail.com")
    @Email
    @NotBlank
    private String email;

    @Schema(description = "Пароль должен содержать от 6 до 32 символов " +
            "и как минимум одну букву, одну цифру и один специальный символ")
    @Size(min = 6, max = 32)
    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\\\\\\\d)(?=.*[@$!%*#?^&amp;])[A-Za-z\\\\d@$!%*#?^&amp;]$")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Schema(description = "Список ролей пользователя, где каждая роль является объектом типа String и начинается с ROLE_...", example = "[\"ROLE_USER\"]")
    private ArrayList<String> stringRoles;

    @Schema(description = "Список ролей пользователя, где каждая роль является объектом типа Role (сюда ничего не передаём)", example ="[]")
    private ArrayList<Role> roles;

}
