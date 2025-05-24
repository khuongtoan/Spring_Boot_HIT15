package my_computer.springsecurity.exception;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import my_computer.springsecurity.domain.dto.response.ApiResponseDTO;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<ApiResponseDTO<?>> handleError(HttpServletRequest request) {
        Object statusObj = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        int status = (statusObj != null) ? Integer.parseInt(statusObj.toString()) : 500;

        String message;
        if (status == 404) {
            message = "Đường dẫn không tồn tại";
        } else if (status == 401) {
            message = "Không được phép truy cập";
        } else {
            message = "Lỗi hệ thống";
        }

        return ResponseEntity.status(status)
                .body(new ApiResponseDTO<>(false, message));
    }
}
