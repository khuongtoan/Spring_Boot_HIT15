package my_computer.week6_crud.domain.mapper;

import my_computer.week6_crud.domain.dto.request.CreateEmployeeRequestDTO;
import my_computer.week6_crud.domain.dto.request.UpdateEmployeeRequestDTO;
import my_computer.week6_crud.domain.dto.response.EmployeeDTO;
import my_computer.week6_crud.domain.entity.Employee;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = {UserMapper.class, DepartmentMapper.class, PositionMapper.class})
public interface EmployeeMapper {
    EmployeeDTO toDTO(Employee employee);
    Employee toEntity(CreateEmployeeRequestDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(UpdateEmployeeRequestDTO dto, @MappingTarget Employee employee);
}
