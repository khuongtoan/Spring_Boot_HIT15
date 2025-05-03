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
    public EmployeeDTO create(CreateEmployeeRequestDTO request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Department department = departmentRepository.findById(request.getDepartmentId()).orElseThrow(() -> new RuntimeException("Department not found"));
        Position position = positionRepository.findById(request.getPositionId()).orElseThrow(() -> new RuntimeException("Position not found"));

        Employee employee = Employee.builder()
                .fullName(request.getFullName())
                .dateOfBirth(request.getDateOfBirth())
                .hiredDate(request.getHiredDate())
                .salary(request.getSalary())
                .user(user)
                .department(department)
                .position(position)
                .build();

        return employeeMapper.toDTO(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDTO update(Long id, UpdateEmployeeRequestDTO dto) {

        if (dto.getHiredDate().isBefore(dto.getDateOfBirth())) {
            throw new IllegalArgumentException("Hired date cannot be before date of birth");
        }

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id:"));

        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found with id:"));

        Position position = positionRepository.findById(dto.getPositionId())
                .orElseThrow(() -> new RuntimeException("Position not found with id: "));

        employeeMapper.updateEntity(dto, employee);
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
