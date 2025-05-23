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
public class AuthorResponseDTO {

    @NotNull
    private Long id ;

    @NotNull
    private String name;

    @NotNull
    private String dob;

    private String bio;

    private Long bookCount;
}
