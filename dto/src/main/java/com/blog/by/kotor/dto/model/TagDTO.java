package com.blog.by.kotor.dto.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Тэг для фильтрации статей")
public class TagDTO {

    @Schema(
            description = "Название тега"
    )
    @NotBlank
    private String tagName;

}
