package my_computer.spring_exam.exception;

import my_computer.spring_exam.base.ApiResponse;
import my_computer.spring_exam.base.RestStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ApiResponse<String>> NoResourceFound (NoResourceFoundException ex){
        ApiResponse<String> response = new ApiResponse<>(RestStatus.ERROR, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundEntity.class)
    public ResponseEntity<ApiResponse<String>> NotFoundEntity (NotFoundEntity ex){
        ApiResponse<String> response = new ApiResponse<>(RestStatus.ERROR, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
