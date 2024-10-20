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
@Schema(description = "Вопрос для опроса")
public class QuestionDTO {

    @Schema(
            description = "Id опроса, которому принадлежит вопрос"
    )
    @NotNull
    private Integer pollId;

    @Schema(
            description = "Главный вопрос для опроса"
    )
    @NotBlank
    private String question;

}
