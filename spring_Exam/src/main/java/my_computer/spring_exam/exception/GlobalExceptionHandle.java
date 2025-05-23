package my_computer.spring_exam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> resourseNotFound(ResourceNotFoundException ex, WebRequest request) {
        Map<String,Object> body = new HashMap<>();
        body.put("timestamp", LocalTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", "Not Found");
        body.put("message", ex.getMessage());
        body.put("patch", request.getDescription(false).replace("uri=",""));
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Object> notFound(NoResourceFoundException ex, WebRequest request) {
        Map<String,Object> body = new HashMap<>();
        body.put("timestamp", LocalTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", "Not Found");
        body.put("message", ex.getMessage());
        body.put("patch", request.getDescription(false).replace("uri=",""));
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
