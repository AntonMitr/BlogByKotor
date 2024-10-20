package com.blog.by.kotor.dto.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Голоса в опросе")
public class VoteDTO {

    @Schema(
            description = "Id ответа за который проголосовал пользователь"
    )
    @NotNull
    private Integer OptionId;

    @Schema(
            description = "Id поста с которым связан опрос"
    )
    @NotNull
    private Integer PostId;

    @Schema(
            description = "Id пользователя поучавствовавшего в опросе"
    )
    @NotNull
    private Integer UserId;

}
