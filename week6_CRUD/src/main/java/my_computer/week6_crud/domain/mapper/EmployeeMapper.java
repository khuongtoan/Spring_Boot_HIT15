package my_computer.week6_crud.domain.mapper;


import my_computer.week6_crud.domain.dto.response.DepartmentDTO;
import my_computer.week6_crud.domain.dto.response.EmployeeDTO;
import my_computer.week6_crud.domain.dto.response.PositionDTO;
import my_computer.week6_crud.domain.dto.response.UserDTO;
import my_computer.week6_crud.domain.entity.Department;
import my_computer.week6_crud.domain.entity.Employee;
import my_computer.week6_crud.domain.entity.Position;
import my_computer.week6_crud.domain.entity.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    // Entity -> DTO
    EmployeeDTO toDTO(Employee employee);
    UserDTO toDTO(User user);
    DepartmentDTO toDTO(Department department);
    PositionDTO toDTO(Position position);

    // DTO -> Entity
    Employee toEntity(EmployeeDTO employeeDTO);
    User toEntity(UserDTO userDTO);
    Department toEntity(DepartmentDTO departmentDTO);
    Position toEntity(PositionDTO positionDTO);
}
