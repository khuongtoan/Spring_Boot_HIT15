package my_computer.week6_crud.domain.dto.response;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {
    private Long id;
    private String fullName;

    private LocalDate dateOfBirth;
    private LocalDate hiredDate;

    private Double salary;

    private UserDTO user;
    private DepartmentDTO department;
    private PositionDTO position;
}
