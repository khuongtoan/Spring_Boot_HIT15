package my_computer.spring_exam.service;

import my_computer.spring_exam.domain.dto.response.CategoryResponseDTO;
import my_computer.spring_exam.domain.dto.resquest.CategoryRequestDTO;
import my_computer.spring_exam.domain.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<CategoryResponseDTO> getAllCategory();
    CategoryResponseDTO deleteCategory(Long id);
    CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO);
    CategoryResponseDTO getCategoryById(Long id);
}
