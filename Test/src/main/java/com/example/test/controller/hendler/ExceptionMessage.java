package com.example.test.controller.hendler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionMessage {
    private String endpoint;

    private String message;

    private String exceptionName;
}
