package my_computer.spring_exam.domain.dto.resquest;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AuthorRequestDTO {

    @NotNull
    private String name;

    @NotNull
    private String dob;

    private String bio;
}
