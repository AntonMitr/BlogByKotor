package com.blog.by.kotor.dto.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Фильтр")
public class FilterDTO {

    @Schema(
            description = "Название фильта. Может быть любым (логичным)"
    )
    @NotBlank
    private String name;

    @Schema(
            description = "Конкретное название тега или категории, " +
                    "по которой будет происходит фильтрация",
            example = "Спорт"
    )
    @NotBlank
    private String criteria;

}
