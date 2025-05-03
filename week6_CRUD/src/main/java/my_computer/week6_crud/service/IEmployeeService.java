package my_computer.week6_crud.service;

import my_computer.week6_crud.domain.dto.request.CreateEmployeeRequestDTO;
import my_computer.week6_crud.domain.dto.request.UpdateEmployeeRequestDTO;
import my_computer.week6_crud.domain.dto.response.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {
    EmployeeDTO create(CreateEmployeeRequestDTO request);
    EmployeeDTO getById(Long id);
    List<EmployeeDTO> getAll();
    EmployeeDTO update(Long id, UpdateEmployeeRequestDTO request);
    void delete(Long id);

    List<EmployeeDTO> searchEmployees(String fullName, Long departmentId, Long positionId);
}
