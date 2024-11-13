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
@Schema(description = "Комментраий")
public class CommentDTO {

    @Schema(
            description = "Текст комментария",
            example = "Хорошая статья"
    )
    @NotBlank
    private String content;

    @Schema(
            description = "Id поста под которым оставили комментарий"
    )
    @NotNull
    private Integer postId;

    @Schema(
            description = "Id пользовател оставившего комментарий"
    )
    @NotNull
    private Integer userId;

}
