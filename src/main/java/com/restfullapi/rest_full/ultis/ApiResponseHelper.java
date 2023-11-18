package com.restfullapi.rest_full.ultis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponseHelper {
    private static ApiResponseHelper I;

    public static ApiResponseHelper gI() {
        if (I == null) {
            I = new ApiResponseHelper();
        }
        return I;
    }

    @Data
    @AllArgsConstructor
    private static class ApiResponse {
        private String message;
        private Object response;
    }

    public ResponseEntity<ApiResponse> resp(Object entity, HttpStatus status, String message) {
        return new ResponseEntity<>(new ApiResponse(message, entity), status);
    }

    public ResponseEntity<?> fallback(Exception e) {
        return new ResponseEntity<>(new ApiResponse(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
