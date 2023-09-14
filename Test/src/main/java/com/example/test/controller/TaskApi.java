package com.example.test.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Map;

@RequestMapping("/test")
@Validated
public interface TaskApi {

    @Operation(summary = "Get the frequency of occurrence of characters in a string")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Result",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Map.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input: empty string",
                    content = @Content)
    })
    @GetMapping
    Map<Character, Integer> countStringChars(@Parameter(description = "String for parsing") @RequestParam(value = "string") @Valid @NotBlank String string);
}
