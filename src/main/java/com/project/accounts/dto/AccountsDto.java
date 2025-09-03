package com.project.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Schema(  // For Swagger documentation
        name = "Accounts",
        description = "Schema to hold Account Information"
)
@Data
public class AccountsDto {

    @Schema(  // For Swagger documentation
            description = "Account Number of the Bank Account"
    )
    @NotEmpty(message = "Account number must not be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits")
    private Long accountNumber;

    @Schema(  // For Swagger documentation
            description = "Account Type of the Bank Account",
            example = "Savings"
    )
    @NotEmpty(message = "Account Type cannot be null or Empty")
    private String accountType;

    @Schema(  // For Swagger documentation
            description = "Branch Address of the Bank"
    )
    @NotEmpty(message = "Branch Address cannot be null or Empty")
    private String branchAddress;

}
