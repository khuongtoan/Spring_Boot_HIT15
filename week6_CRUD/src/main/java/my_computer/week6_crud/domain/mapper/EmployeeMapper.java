package my_computer.week6_crud.domain.mapper;

import my_computer.week6_crud.domain.dto.request.CreateEmployeeRequestDTO;
import my_computer.week6_crud.domain.dto.request.UpdateEmployeeRequestDTO;
import my_computer.week6_crud.domain.dto.response.EmployeeDTO;
import my_computer.week6_crud.domain.entity.Employee;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {UserMapper.class, DepartmentMapper.class, PositionMapper.class})
public interface EmployeeMapper {

    @Mapping(target = "salary", numberFormat = "#0.00")
    EmployeeDTO toDTO(Employee employee);

    @Mapping(target = "salary", numberFormat = "#0.00")
    Employee toEntity(CreateEmployeeRequestDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(UpdateEmployeeRequestDTO dto, @MappingTarget Employee employee);
}
