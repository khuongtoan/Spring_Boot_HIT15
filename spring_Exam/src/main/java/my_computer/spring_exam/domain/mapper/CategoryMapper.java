package my_computer.spring_exam.domain.mapper;

import my_computer.spring_exam.domain.dto.request.CreateAuthorRequestDTO;
import my_computer.spring_exam.domain.dto.request.CreateCategoryRequestDTO;
import my_computer.spring_exam.domain.dto.request.UpdateCategoryRequestDTO;
import my_computer.spring_exam.domain.dto.response.CategoryResponseDTO;
import my_computer.spring_exam.domain.entity.Category;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CategoryResponseDTO toResponse (Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category createCategory(CreateCategoryRequestDTO createCategoryRequestDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCategory(UpdateCategoryRequestDTO dto, @MappingTarget Category category);
}
