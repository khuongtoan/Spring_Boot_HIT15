package my_computer.week6_crud.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePositionRequestDTO {

    @NotBlank(message = "Position title is required")
    @Size(min = 3, max = 100, message = "Position title must be between 3 and 100 characters")
    private String title;

    @Size(max = 500, message = "Description cannot be longer than 500 characters")
    private String description;
}
