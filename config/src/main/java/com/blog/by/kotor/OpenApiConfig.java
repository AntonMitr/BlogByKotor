package com.blog.by.kotor;

import com.blog.by.kotor.dto.error.ErrorResponseDTO;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "BlogByKotor OpenAPI спецификация",
                description = "Блоговая платформа by Kotor",
                version = "1.0.0"
        ),
        servers = {
                @Server(
                        description = "Local INV",
                        url = "http://localhost:8080"
                )
        },
        security = @SecurityRequirement(
                name = "BearerAuth"
        )
)
@SecurityScheme(
        name = "BearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().requestMatchers(
                "/swagger-ui/**", "/v3/api-docs/**"
        );
    }

    @Bean
    public OpenApiCustomizer openApiCustomizer() {
        return openApi -> {
            var sharedErrorSchema = ModelConverters.getInstance()
                    .read(ErrorResponseDTO.class).get(ErrorResponseDTO.class.getSimpleName());
            if (sharedErrorSchema == null) {
                throw new IllegalStateException(
                        "Не удалось сгенерировать ответ для ошибок 4xx и 5xx, поскольку отсутствует схема ошибки");
            }

            openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation ->
                    operation.getResponses().forEach((status, response) -> {
                        if (status.startsWith("4") || status.startsWith("5")) {
                            response.getContent().forEach((code, mediaType) -> mediaType.setSchema(sharedErrorSchema));
                        }
                    })));
        };
    }

}
