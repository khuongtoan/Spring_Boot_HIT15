package my_computer.week6_crud.domain.mapper;

import my_computer.week6_crud.domain.dto.request.CreateDepartmentRequestDTO;
import my_computer.week6_crud.domain.dto.request.UpdateDepartmentRequestDTO;
import my_computer.week6_crud.domain.dto.response.DepartmentDTO;
import my_computer.week6_crud.domain.entity.Department;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentDTO toDTO(Department department);
    Department toEntity(CreateDepartmentRequestDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(UpdateDepartmentRequestDTO dto, @MappingTarget Department department);
}
