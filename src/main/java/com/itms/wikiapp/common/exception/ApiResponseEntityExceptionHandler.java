package com.itms.wikiapp.common.exception;

import com.itms.wikiapp.common.exception.types.AlreadyExistsException;
import com.itms.wikiapp.common.exception.types.InternalServerException;
import com.itms.wikiapp.common.exception.types.NotFoundException;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Configuration
@ControllerAdvice
public class ApiResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(value = NotFoundException.class)
  protected ResponseEntity<CustomErrorResponse> handleNotFound(Exception ex) {
    CustomErrorResponse response = CustomErrorResponse.builder()
        .statusCode(HttpStatus.NOT_FOUND.value())
        .message(ex.getMessage())
        .build();

    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = AlreadyExistsException.class)
  protected ResponseEntity<CustomErrorResponse> handleAlreadyExists(Exception ex) {
    CustomErrorResponse response = CustomErrorResponse.builder()
        .statusCode(HttpStatus.CONFLICT.value())
        .message(ex.getMessage())
        .build();

    return new ResponseEntity<>(response, HttpStatus.CONFLICT);
  }

  @ExceptionHandler(value = InternalServerException.class)
  protected ResponseEntity<CustomErrorResponse> handleException(Exception ex) {
    CustomErrorResponse response = CustomErrorResponse.builder()
        .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
        .message(ex.getMessage())
        .build();

    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
