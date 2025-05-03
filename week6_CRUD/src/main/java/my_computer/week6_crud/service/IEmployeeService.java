package my_computer.week6_crud.service;

import my_computer.week6_crud.domain.dto.request.CreateEmployeeRequestDTO;
import my_computer.week6_crud.domain.dto.request.UpdateEmployeeRequestDTO;
import my_computer.week6_crud.domain.dto.response.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {
    EmployeeDTO createEmployee(CreateEmployeeRequestDTO request);
    EmployeeDTO getEmployeeById(Long id);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO updateEmployee(Long id, UpdateEmployeeRequestDTO request);
    void deleteEmployee(Long id);

    List<EmployeeDTO> searchEmployees(String fullName, Long departmentId, Long positionId);
}
