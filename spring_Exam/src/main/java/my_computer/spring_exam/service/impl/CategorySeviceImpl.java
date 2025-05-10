package my_computer.spring_exam.service.impl;

import lombok.RequiredArgsConstructor;
import my_computer.spring_exam.domain.dto.request.CreateCategoryRequestDTO;
import my_computer.spring_exam.domain.dto.response.CategoryResponseDTO;
import my_computer.spring_exam.service.ICategoryService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategorySeviceImpl implements ICategoryService {

    @Override
    public CategoryResponseDTO create(CreateCategoryRequestDTO createCategoryRequestDTO) {
        return null;
    }

    @Override
    public CategoryResponseDTO delete(Integer id) {
        return null;
    }

    @Override
    public CategoryResponseDTO GetById(Integer id) {
        return null;
    }

    @Override
    public CategoryResponseDTO GetAll() {
        return null;
    }
}
