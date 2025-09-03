package com.project.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(  // For Swagger documentation
        name = "Customer",
        description = "Schema to hold customer and accounts info"
)
public class CustomerDto {

    @Schema(  // For Swagger documentation
            description = "Name of the customer",
            example = "Customer Demo"
    )
    @NotEmpty(message = "Name cannot be null or empty")
    @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 to 30")
    private String name;

    @Schema(  // For Swagger documentation
            description = "Email of the customer",
            example = "customer@demo.com"
    )
    @NotEmpty(message = "email cannot be null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;

    @Schema(  // For Swagger documentation
            description = "MobileNumber of the customer",
            example = "1234567890"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digit")
    private String mobileNumber;

    @Schema(  // For Swagger documentation
            description = "Accounts detail of customer"
    )
    private AccountsDto accountsDto;
}
