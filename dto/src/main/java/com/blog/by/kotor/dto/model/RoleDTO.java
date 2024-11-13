package com.blog.by.kotor.dto.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Роли пользователей")
public class RoleDTO {

    @Schema(
            description = "Название роли пользователя",
            example = "ROLE_USER"
    )
    @NotBlank
    private String roleName;

}
