package my_computer.week6_crud.service;

import my_computer.week6_crud.domain.dto.request.CreateDepartmentRequestDTO;
import my_computer.week6_crud.domain.dto.request.UpdateDepartmentRequestDTO;
import my_computer.week6_crud.domain.dto.response.DepartmentDTO;

import java.util.List;

public interface IDepartmentService {
    DepartmentDTO createDepartment(CreateDepartmentRequestDTO request);
    DepartmentDTO getDepartmentById(Long id);
    List<DepartmentDTO> getAllDepartments();
    DepartmentDTO updateDepartment(Long id, UpdateDepartmentRequestDTO request);
    void deleteDepartment(Long id);
}
