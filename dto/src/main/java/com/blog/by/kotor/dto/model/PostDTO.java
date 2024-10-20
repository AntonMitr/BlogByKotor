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
@Schema(description = "Статья")
public class PostDTO {

    @Schema(
            description = "Заголовок статьи"
    )
    @NotBlank
    private String title;

    @Schema(
            description = "Текст статьи"
    )
    private String content;

    @Schema(
            description = "Id пользователя создавшего статью"
    )
    @NotNull
    private Integer userId;

    @Schema(
            description = "Статья доступна только для премиум пользователей? (да/нет)"
    )
    @NotNull
    private boolean isPremium;

    @Schema(
            description = "Статья уже опубликована? (да/нет)"
    )
    @NotNull
    private boolean isPublished;

}
