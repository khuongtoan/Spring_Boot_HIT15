package my_computer.week6_crud.service;

import my_computer.week6_crud.domain.dto.request.CreateDepartmentRequestDTO;
import my_computer.week6_crud.domain.dto.request.UpdateDepartmentRequestDTO;
import my_computer.week6_crud.domain.dto.response.DepartmentDTO;

import java.util.List;

public interface IDepartmentService {
    DepartmentDTO create(CreateDepartmentRequestDTO request);
    DepartmentDTO getById(Long id);
    List<DepartmentDTO> getAll();
    DepartmentDTO update(Long id, UpdateDepartmentRequestDTO request);
    void delete(Long id);
}
