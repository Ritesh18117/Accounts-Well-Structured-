package com.project.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(  // For Swagger documentation
        name = "Response",
        description = "Schema to hold successfully info"
)
public class ResponseDto {

    @Schema(  // For Swagger documentation
            description = "Status code of response"
    )
    private String statusCode;
    @Schema(  // For Swagger documentation
            description = "Status message of response"
    )
    private String statusMsg;
}
