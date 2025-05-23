package my_computer.spring_exam.service.impl;

import lombok.RequiredArgsConstructor;
import my_computer.spring_exam.domain.dto.response.CategoryResponseDTO;
import my_computer.spring_exam.domain.dto.resquest.CategoryRequestDTO;
import my_computer.spring_exam.domain.entity.Category;
import my_computer.spring_exam.domain.mapper.CategoryMapper;
import my_computer.spring_exam.respository.BookRepository;
import my_computer.spring_exam.respository.CategoryRepository;
import my_computer.spring_exam.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository repo;
    private final BookRepository bookRepository;

    @Override
    public List<CategoryResponseDTO> getAllCategory() {
        List<Category> categories = repo.findAll();
        List<CategoryResponseDTO> dtos = categories.stream()
                .map(category -> {
                    CategoryResponseDTO dto = categoryMapper.toDto(category);
                    Long bookCount = bookRepository.countByCategoryId(category.getId());
                    dto.setBookCount(bookCount);
                    return dto;
                }).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public CategoryResponseDTO deleteCategory(Long id) {
        Category category = repo.findById(id).orElseThrow((() -> new RuntimeException("Category not found")));
        repo.deleteById(id);
        return categoryMapper.toDto(category);
    }

    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO) {
        Category category = categoryMapper.toEntity(categoryRequestDTO);
        Category savedCategory = repo.save(category);
        return categoryMapper.toDto(savedCategory);
    }

    @Override
    public CategoryResponseDTO getCategoryById(Long id) {
        CategoryResponseDTO category = categoryMapper.toDto(repo.findById(id).orElseThrow((() -> new RuntimeException("Category not found"))));
        Long count = bookRepository.countByCategoryId(id);
        category.setBookCount(count);
        return category;
    }
}
