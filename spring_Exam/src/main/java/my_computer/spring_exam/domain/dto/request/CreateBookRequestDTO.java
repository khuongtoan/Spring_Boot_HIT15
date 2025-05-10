package my_computer.spring_exam.domain.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateBookRequestDTO {

    private String description;

    @NotNull
    private String name;

    private double price;

    @NotNull
    private Integer category_id;

    @NotNull
    private Integer author_id;
}
