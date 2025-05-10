package my_computer.spring_exam.controller;

import lombok.RequiredArgsConstructor;
import my_computer.spring_exam.base.ApiResponse;
import my_computer.spring_exam.base.RestApiV1;
import my_computer.spring_exam.base.RestStatus;
import my_computer.spring_exam.domain.dto.request.CreateAuthorRequestDTO;
import my_computer.spring_exam.domain.dto.request.UpdateAuthorRequestDTO;
import my_computer.spring_exam.domain.dto.response.AuthorResponseDTO;
import my_computer.spring_exam.domain.entity.Author;
import my_computer.spring_exam.service.IAuthorService;
import my_computer.spring_exam.service.impl.AuthorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RequestMapping("api/v1/author")
@RequiredArgsConstructor
@RestController
public class AuthorController {

    private final IAuthorService service;

    @PostMapping()
    public ResponseEntity<ApiResponse<AuthorResponseDTO>> create(@RequestBody CreateAuthorRequestDTO author) {
        AuthorResponseDTO response = service.create(author);
        return new ResponseEntity<>(new ApiResponse<>(RestStatus.SUCCESS,"Tạo tác giả thành công", response), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<AuthorResponseDTO>> getById(@PathVariable Integer id) {
        AuthorResponseDTO response = service.getById(id);
        return new ResponseEntity<>(new ApiResponse<>(RestStatus.SUCCESS,"Lấy tác giả thành công", response), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<ApiResponse>>> getAll() {
        List<AuthorResponseDTO> response = service.getAll();
        return new ResponseEntity<>( new ApiResponse<>(RestStatus.SUCCESS, "Lấy danh sách tác giả thành công"), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<ApiResponse<AuthorResponseDTO>> update(@RequestBody UpdateAuthorRequestDTO authorRequestDTO, Integer id) {
        AuthorResponseDTO response=  service.update(authorRequestDTO,id);
        return new ResponseEntity<>( new ApiResponse<>(RestStatus.SUCCESS, "Cập nhật tác giả thành công"), HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<ApiResponse<AuthorResponseDTO>> delete(Integer id) {
        AuthorResponseDTO response = service.delete(id);
        return new ResponseEntity<>( new ApiResponse<>(RestStatus.SUCCESS, "Xóa tác giả thành công"), HttpStatus.OK);
    }
}
