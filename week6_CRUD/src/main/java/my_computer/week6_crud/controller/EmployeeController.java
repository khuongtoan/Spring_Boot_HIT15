package my_computer.week6_crud.controller;

import lombok.RequiredArgsConstructor;
import my_computer.week6_crud.domain.dto.request.CreateEmployeeRequestDTO;
import my_computer.week6_crud.domain.dto.request.UpdateEmployeeRequestDTO;
import my_computer.week6_crud.domain.dto.response.ApiResponse;
import my_computer.week6_crud.domain.dto.response.EmployeeDTO;
import my_computer.week6_crud.service.IEmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final IEmployeeService employeeService;

    @PostMapping
    public ResponseEntity<ApiResponse<EmployeeDTO>> create(@RequestBody CreateEmployeeRequestDTO request) {
        EmployeeDTO created = employeeService.create(request);
        return ResponseEntity.created(URI.create("/api/employees/" + created.getId()))
                .body(new ApiResponse<>(201, "Employee created", created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<EmployeeDTO>> update(@PathVariable Long id, @RequestBody UpdateEmployeeRequestDTO request) {
        EmployeeDTO updated = employeeService.update(id, request);
        return ResponseEntity.ok(new ApiResponse<>(200, "Employee updated", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "Employee deleted", null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EmployeeDTO>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponse<>(200, "Employee fetched", employeeService.getById(id)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<EmployeeDTO>>> getAll() {
        return ResponseEntity.ok(new ApiResponse<>(200, "Employees fetched", employeeService.getAll()));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<EmployeeDTO>>> search(
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false) Long departmentId,
            @RequestParam(required = false) Long positionId) {
        List<EmployeeDTO> results = employeeService.searchEmployees(fullName, departmentId, positionId);
        return ResponseEntity.ok(new ApiResponse<>(200, "Search results", results));
    }
}
