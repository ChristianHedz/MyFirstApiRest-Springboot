package org.chris.myfirstapirest.api.exceptions;

import org.chris.myfirstapirest.api.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest webRequest){
        ApiResponse response = new ApiResponse(ex.getMessage(), HttpStatus.NOT_FOUND, webRequest.getDescription(false));
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
