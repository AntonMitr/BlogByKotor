package com.blog.by.kotor.dto.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Premium подписка")
public class PremiumSubscriptionDTO {

    @Schema(
            description = "Id пользователя с премиум подпиской"
    )
    @NotNull
    private Integer userId;

}
