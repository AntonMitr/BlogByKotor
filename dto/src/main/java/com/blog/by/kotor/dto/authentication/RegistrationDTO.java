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
    @NotBlank(message = "Имя пользователя не должно быть пустым")
    private String username;

    @Schema(description = "Электронная почта", example = "user1@gmail.com")
    @Email
    @NotBlank(message = "Электронная почта не должна быть пустой")
    private String email;

    @Schema(description = "Пароль должен содержать от 6 до 32 символов " +
            "и как минимум одну букву, одну цифру и один специальный символ")
    @Size(min = 6, max = 32)
    @NotBlank(message = "Пароль не должен быть пустым")

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?^&])[A-Za-z\\d@$!%*#?^&]{6,32}$")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Schema(description = "Список ролей пользователя, где каждая роль является объектом типа String и начинается с ROLE_...", example = "[\"ROLE_USER\"]")
    private ArrayList<String> stringRoles;

    @Schema(description = "Список ролей пользователя, где каждая роль является объектом типа Role (сюда ничего не передаём)", example ="[]")
    private ArrayList<Role> roles;

}
