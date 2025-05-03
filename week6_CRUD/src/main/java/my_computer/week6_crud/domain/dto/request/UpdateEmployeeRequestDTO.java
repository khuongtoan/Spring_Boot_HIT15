package my_computer.week6_crud.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateEmployeeRequestDTO {

    @Size(min = 5, max = 100, message = "Full name must be between 5 and 100 characters")
    private String fullName;

    @NotNull(message = "Date of birth is required")
    private LocalDate dateOfBirth;

    @NotNull(message = "Hired date is required")
    private LocalDate hiredDate;

    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be a positive value")
    private Double salary;

    @NotNull(message = "Department ID is required")
    private Long departmentId;

    @NotNull(message = "Position ID is required")
    private Long positionId;
}
