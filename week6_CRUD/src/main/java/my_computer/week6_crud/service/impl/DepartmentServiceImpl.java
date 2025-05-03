package my_computer.week6_crud.service.impl;

import lombok.RequiredArgsConstructor;
import my_computer.week6_crud.domain.dto.request.CreateDepartmentRequestDTO;
import my_computer.week6_crud.domain.dto.request.UpdateDepartmentRequestDTO;
import my_computer.week6_crud.domain.dto.response.DepartmentDTO;
import my_computer.week6_crud.domain.entity.Department;
import my_computer.week6_crud.domain.mapper.DepartmentMapper;
import my_computer.week6_crud.repository.DepartmentRepository;
import my_computer.week6_crud.service.IDepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements IDepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public DepartmentDTO create(CreateDepartmentRequestDTO request) {
        Department department = departmentMapper.toEntity(request);
        return departmentMapper.toDTO(departmentRepository.save(department));
    }

    @Override
    public DepartmentDTO getById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        return departmentMapper.toDTO(department);
    }

    @Override
    public List<DepartmentDTO> getAll() {
        return departmentRepository.findAll().stream()
                .map(departmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO update(Long id, UpdateDepartmentRequestDTO request) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        departmentMapper.updateEntity(request, department);
        return departmentMapper.toDTO(departmentRepository.save(department));
    }

    @Override
    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }
}
