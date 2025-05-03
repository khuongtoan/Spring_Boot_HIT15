package my_computer.week6_crud.controller;

import lombok.RequiredArgsConstructor;
import my_computer.week6_crud.domain.dto.request.CreateDepartmentRequestDTO;
import my_computer.week6_crud.domain.dto.request.UpdateDepartmentRequestDTO;
import my_computer.week6_crud.domain.dto.response.ApiResponse;
import my_computer.week6_crud.domain.dto.response.DepartmentDTO;
import my_computer.week6_crud.service.IDepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final IDepartmentService departmentService;

    @PostMapping
    public ResponseEntity<ApiResponse<DepartmentDTO>> create(@RequestBody CreateDepartmentRequestDTO request) {
        DepartmentDTO created = departmentService.create(request);
        return ResponseEntity.created(URI.create("/api/departments/" + created.getId()))
                .body(new ApiResponse<>(201, "Department created", created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<DepartmentDTO>> update(@PathVariable Long id, @RequestBody UpdateDepartmentRequestDTO request) {
        DepartmentDTO updated = departmentService.update(id, request);
        return ResponseEntity.ok(new ApiResponse<>(200, "Department updated", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        departmentService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "Department deleted", null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DepartmentDTO>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponse<>(200, "Department fetched", departmentService.getById(id)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<DepartmentDTO>>> getAll() {
        return ResponseEntity.ok(new ApiResponse<>(200, "Departments fetched", departmentService.getAll()));
    }
}
