package my_computer.spring_exam.domain.dto.resquest;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookRequestDTO {

    @NotNull
    private String name;

    private String description;

    @DecimalMin(value = "0.01")
    private Double price;

    @NotNull
    private Long authorId;

    @NotNull
    private Long categoryId;
}
