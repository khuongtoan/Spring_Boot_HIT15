package my_computer.week6_crud.controller;

import lombok.RequiredArgsConstructor;
import my_computer.week6_crud.domain.dto.request.CreateUserRequestDTO;
import my_computer.week6_crud.domain.dto.request.UpdateUserRequestDTO;
import my_computer.week6_crud.domain.dto.response.ApiResponse;
import my_computer.week6_crud.domain.dto.response.UserDTO;
import my_computer.week6_crud.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse<UserDTO>> create(@RequestBody CreateUserRequestDTO request) {
        return ResponseEntity.ok(new ApiResponse<>(200, "User created", userService.create(request)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> update(@PathVariable Long id, @RequestBody UpdateUserRequestDTO request) {
        return ResponseEntity.ok(new ApiResponse<>(200, "User updated", userService.update(id, request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "User deleted", null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponse<>(200, "User found", userService.getById(id)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserDTO>>> getAll() {
        return ResponseEntity.ok(new ApiResponse<>(200, "All users", userService.getAll()));
    }
}
