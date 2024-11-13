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
@Schema(description = "Опрос")
public class PollDTO {

    @Schema(
            description = "Id пользователя создавшего опрос"
    )
    @NotNull
    private Integer userId;

    @Schema(
            description = "Описание для опроса"
    )
    private String description;

    @Schema(
            description = "Заголовк опроса"
    )
    @NotBlank
    private String title;

}
