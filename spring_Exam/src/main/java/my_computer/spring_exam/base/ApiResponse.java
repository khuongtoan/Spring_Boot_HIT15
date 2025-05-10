package my_computer.spring_exam.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private RestStatus status;
    private String message;
    private T data;

    public ApiResponse(RestStatus status, String message) {
        this.status = status;
        this.message = message;
    }

}
