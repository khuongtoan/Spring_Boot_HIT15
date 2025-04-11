package com.btvnbuoi4.controllers;

import com.btvnbuoi4.domain.dtos.requests.CreateStudentRequest;
import com.btvnbuoi4.domain.dtos.requests.UpdateStudentRequest;
import com.btvnbuoi4.domain.dtos.responses.ApiResponse;
import com.btvnbuoi4.domain.dtos.responses.StudentResponse;
import com.btvnbuoi4.services.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService studentService;

    @GetMapping("getAll")
    public ResponseEntity<ApiResponse<List<StudentResponse>>> getAllStudents() {
        List<StudentResponse> students = studentService.getAllStudents();
        return ResponseEntity
                .ok(new ApiResponse<>(HttpStatus.OK.value(), "Lấy danh sách sinh viên thành công", students));
    }

    @GetMapping("get/{id}")
    public ResponseEntity<ApiResponse<StudentResponse>> getStudentById(@PathVariable Integer id) {
        StudentResponse student = studentService.getStudentById(id);
        return ResponseEntity
                .ok(new ApiResponse<>(HttpStatus.OK.value(), "Lấy sinh viên thành công", student));
    }

    @PostMapping("create")
    public ResponseEntity<ApiResponse<StudentResponse>> createStudent(
                @Valid @RequestBody CreateStudentRequest request) {
        StudentResponse student = studentService.createStudent(request);
        return new ResponseEntity<>(
                new ApiResponse<>(HttpStatus.CREATED.value(), "Tạo sinh viên thành công", student),
                HttpStatus.CREATED
        );
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ApiResponse<StudentResponse>> updateStudent(
            @PathVariable Integer id,
            @Valid @RequestBody UpdateStudentRequest request) {
        StudentResponse student = studentService.updateStudent(id, request);
        return ResponseEntity
                .ok(new ApiResponse<>(HttpStatus.OK.value(), "Cập nhật sinh viên thành công", student));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ApiResponse<StudentResponse>> deleteStudent(@PathVariable Integer id) {
        StudentResponse deletedStudent = studentService.deleteStudent(id);
        return new ResponseEntity<>(
                new ApiResponse<>(HttpStatus.OK.value(), "Xóa sinh viên thành công", deletedStudent),
                HttpStatus.OK
        );
    }
}
