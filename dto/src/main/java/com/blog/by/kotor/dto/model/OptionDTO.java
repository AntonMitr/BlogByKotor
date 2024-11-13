package com.blog.by.kotor.dto.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Варианты ответов для опроса")
public class OptionDTO {

    @Schema(
            description = "Вариант ответа на опрос"
    )
    @NotBlank
    private String optionText;

    @Schema(
            description = "Id вопроса"
    )
    @NotNull
    private Integer questionId;

}
