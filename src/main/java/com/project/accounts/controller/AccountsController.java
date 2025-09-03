package com.project.accounts.controller;

import com.project.accounts.Constants.AccountsConstants;
import com.project.accounts.dto.CustomerDto;
import com.project.accounts.dto.ErrorResponseDto;
import com.project.accounts.dto.ResponseDto;
import com.project.accounts.service.IAccountsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(  // For Swagger documentation
        name = "CRUD REST API for Accounts in Bank",
        description = "CRUD REST API  in Bank to CREATE, UPDATE, DELETE and FETCH account details"
)
@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Validated
public class AccountsController {

    private IAccountsService iAccountsService;

    @Operation(  // For Swagger documentation
            summary = "Create account REST API",
            description = "REST API to create new customer & account inside Bank"
    )
    @ApiResponses({  // For Swagger documentation
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status Created"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto){
        iAccountsService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201,AccountsConstants.MESSAGE_201));
    }

    @Operation(  // For Swagger documentation
            summary = "Fetch Account Details REST API",
            description = "REST API to fetch details of customer & account inside Bank"
    )
    @ApiResponses({  // For Swagger documentation
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Https Status INTERNAL SERVER ERROR",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam
                                                               @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digit")
                                                               String mobileNumber){
        CustomerDto customerDto = iAccountsService.fetchAccountDetails(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDto);
    }

    @Operation(  // For Swagger documentation
            summary = "Update account REST API",
            description = "REST API to update new customer & account inside Bank"
    )
    @ApiResponses({  // For Swagger documentation
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "HTTP Status EXCEPTION FAILED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status INTERNAL SERVER ERROR",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetails(@Valid @RequestBody CustomerDto customerDto){
        boolean isUpdated = iAccountsService.updateAccount(customerDto);
        if(isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountsConstants.STATUS_417,AccountsConstants.MESSAGE_417_UPDATE));
        }
    }

    @Operation(  // For Swagger documentation
            summary = "Delete account REST API",
            description = "REST API to Delete new customer & account inside Bank"
    )
    @ApiResponses({  // For Swagger documentation
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "HTTP Status EXCEPTION FAILED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status INTERNAL SERVER ERROR",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccountDetails(@RequestParam
                                                                @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digit")
                                                                String mobileNumber){
        boolean isDeleted = iAccountsService.deleteAccount(mobileNumber);
        if(isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200));
        } else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountsConstants.STATUS_417,AccountsConstants.MESSAGE_417_DELETE));
        }
    }
}
