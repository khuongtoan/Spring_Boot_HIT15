package my_computer.week6_crud.service.impl;

import lombok.RequiredArgsConstructor;
import my_computer.week6_crud.domain.dto.request.CreateEmployeeRequestDTO;
import my_computer.week6_crud.domain.dto.request.UpdateEmployeeRequestDTO;
import my_computer.week6_crud.domain.dto.response.EmployeeDTO;
import my_computer.week6_crud.domain.entity.*;
import my_computer.week6_crud.domain.mapper.EmployeeMapper;
import my_computer.week6_crud.repository.*;
import my_computer.week6_crud.service.IEmployeeService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;
    private final PositionRepository positionRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeDTO create(CreateEmployeeRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Department department = departmentRepository.findById(dto.getDepartmentId()).orElse(null);
        Position position = positionRepository.findById(dto.getPositionId()).orElse(null);

        Employee employee = Employee.builder()
                .fullName(dto.getFullName())
                .dateOfBirth(dto.getDateOfBirth())
                .hiredDate(dto.getHiredDate())
                .salary(dto.getSalary())
                .user(user)
                .department(department)
                .position(position)
                .build();

        return employeeMapper.toDTO(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDTO update(Long id, UpdateEmployeeRequestDTO dto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Department department = departmentRepository.findById(dto.getDepartmentId()).orElse(null);
        Position position = positionRepository.findById(dto.getPositionId()).orElse(null);

        employee.setFullName(dto.getFullName());
        employee.setDateOfBirth(dto.getDateOfBirth());
        employee.setHiredDate(dto.getHiredDate());
        employee.setSalary(dto.getSalary());
        employee.setDepartment(department);
        employee.setPosition(position);

        return employeeMapper.toDTO(employeeRepository.save(employee));
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDTO getById(Long id) {
        return employeeMapper.toDTO(employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found")));
    }

    @Override
    public List<EmployeeDTO> getAll() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> searchEmployees(String fullName, Long departmentId, Long positionId) {
        return employeeRepository.searchEmployees(fullName, departmentId, positionId)
                .stream().map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }
}
