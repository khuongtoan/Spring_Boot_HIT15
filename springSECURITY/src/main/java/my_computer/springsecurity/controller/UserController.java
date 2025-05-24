package my_computer.springsecurity.controller;

import lombok.RequiredArgsConstructor;
import my_computer.springsecurity.domain.dto.request.LoginRequestDTO;
import my_computer.springsecurity.domain.dto.request.RegisterRequestDTO;
import my_computer.springsecurity.domain.dto.response.ApiResponseDTO;
import my_computer.springsecurity.domain.dto.response.UserResponseDTO;
import my_computer.springsecurity.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponseDTO<UserResponseDTO>> register(@RequestBody RegisterRequestDTO request) {
        UserResponseDTO createdUser = userService.register(request);
        return ResponseEntity.ok(new ApiResponseDTO<>(true,"Create user successful", createdUser));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponseDTO<?>> login(@RequestBody LoginRequestDTO request) {
        String loginResult = userService.login(request);
        return ResponseEntity.ok(new ApiResponseDTO<>(true, loginResult));
    }

    @GetMapping("/user")
    public ResponseEntity<ApiResponseDTO<List<UserResponseDTO>>> getAllUsers() {
        List<UserResponseDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "List of all users", users));
    }

}

