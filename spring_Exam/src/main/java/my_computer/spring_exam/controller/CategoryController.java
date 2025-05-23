package my_computer.spring_exam.controller;

import lombok.RequiredArgsConstructor;
import my_computer.spring_exam.domain.dto.response.CategoryResponseDTO;
import my_computer.spring_exam.domain.dto.resquest.CategoryRequestDTO;
import my_computer.spring_exam.service.ICategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final ICategoryService categoryService;

    @PostMapping()
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO category) {
        CategoryResponseDTO categoryResponseDTO = categoryService.createCategory(category);
        return new ResponseEntity<>(categoryResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<CategoryResponseDTO>> getCategoryById() {
        List<CategoryResponseDTO> categoryResponseDTO = categoryService.getAllCategory();
        return new ResponseEntity<>(categoryResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> deleteCategory(@PathVariable Long id) {
        CategoryResponseDTO categoryResponseDTO = categoryService.deleteCategory(id);
        return new ResponseEntity<>(categoryResponseDTO, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable Long id) {
        CategoryResponseDTO categoryResponseDTO = categoryService.getCategoryById(id);
        return new ResponseEntity<>(categoryResponseDTO, HttpStatus.OK);
    }

}
