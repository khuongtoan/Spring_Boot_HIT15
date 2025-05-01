package my_computer.week6_crud.domain.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {
    private Long id;
    private String fullName;
    private String dateOfBirth;
    private String hiredDate;
    private BigDecimal salary;

    private UserDTO user;
    private DepartmentDTO department;
    private PositionDTO position;
}
