package my_computer.springsecurity.exception;

import my_computer.springsecurity.domain.dto.response.ApiResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExHandler {

    @ExceptionHandler(UsernameExistsEx.class)
    public ResponseEntity<ApiResponseDTO<?>> handleUsernameExists(UsernameExistsEx ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponseDTO<>(false, ex.getMessage()));
    }

    @ExceptionHandler(BadLoginEx.class)
    public ResponseEntity<ApiResponseDTO<?>> handleBadLogin(BadLoginEx ex) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(new ApiResponseDTO<>(false, ex.getMessage()));
    }

    @ExceptionHandler(org.springframework.web.servlet.NoHandlerFoundException.class)
    public ResponseEntity<ApiResponseDTO<?>> handleNoHandler(NoHandlerFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ApiResponseDTO<>(false, "Đường dẫn không tồn tại"));
    }
}
