package com.project.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @AllArgsConstructor
@Schema( // For Swagger documentation
        name = "ErrorResponse",
        description = "Schema to hold Error Response"
)
public class ErrorResponseDto {

    @Schema(  // For Swagger documentation
            description = "API path invoke by client"
    )
    private String apiPath;

    @Schema(  // For Swagger documentation
            description = "Error code representing error happened"
    )
    private HttpStatus errorCode;

    @Schema(  // For Swagger documentation
            description = "Error message representing error happened"
    )
    private String errorMessage;

    @Schema(  // For Swagger documentation
            description = "Error Time representing time of error happened"
    )
    private LocalDateTime errorTime;
}
