package com.ourMenu.backend.global.util;

import com.ourMenu.backend.global.common.ApiResponse;
import com.ourMenu.backend.global.exception.ErrorResponse;
import org.springframework.http.ResponseEntity;

public class ApiUtils {

    private ApiUtils() {
    }

    public static <T> ApiResponse<T> success(T response) {
        return ApiResponse.create(true, response, null);
    }

    public static ResponseEntity<?> error(ErrorResponse errorResponse) {
        return ResponseEntity
                .status(errorResponse.getStatus())
                .body(ApiResponse.create(false, null, errorResponse));
    }

}
