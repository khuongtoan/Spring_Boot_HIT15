package my_computer.spring_exam.domain.mapper;

import my_computer.spring_exam.domain.dto.response.CategoryResponseDTO;
import my_computer.spring_exam.domain.dto.resquest.CategoryRequestDTO;
import my_computer.spring_exam.domain.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponseDTO toDto(Category category);
    Category toEntity(CategoryRequestDTO categoryRequesDTO);
}
