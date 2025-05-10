package my_computer.spring_exam.domain.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateAuthorRequestDTO {


    @NotNull
    private String name;

    @NotNull
    private LocalDate dob;

    private String bio;

}


