package my_computer.spring_exam.domain.dto.resquest;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryRequestDTO {

    @NotNull
    private String name;
}
