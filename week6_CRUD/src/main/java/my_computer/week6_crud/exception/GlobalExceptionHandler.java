package my_computer.week6_crud.exception;

import my_computer.week6_crud.domain.dto.response.ApiResponse;
import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ApiResponse<String>> resourceNotFound(NoResourceFoundException ex) {
        ApiResponse<String> response = new ApiResponse<>(404, "Not Found", null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFound.class)
    public ResponseEntity<ApiResponse<String>> notFound(NotFound ex) {
        ApiResponse<String> response = new ApiResponse<>(404, ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
