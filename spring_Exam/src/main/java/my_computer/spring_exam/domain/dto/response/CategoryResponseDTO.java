package my_computer.spring_exam.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryResponseDTO {
    @NotNull
    private Long id;
    @NotNull
    private String name;

    private Long bookCount;
}
