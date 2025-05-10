package my_computer.spring_exam.service;

import my_computer.spring_exam.domain.dto.request.CreateCategoryRequestDTO;
import my_computer.spring_exam.domain.dto.response.CategoryResponseDTO;

public interface ICategoryService {

    CategoryResponseDTO create (CreateCategoryRequestDTO createCategoryRequestDTO);

    CategoryResponseDTO delete (Integer id);

    CategoryResponseDTO GetById(Integer id);

    CategoryResponseDTO GetAll();
}
