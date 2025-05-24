package my_computer.springsecurity.service;

import my_computer.springsecurity.domain.dto.request.LoginRequestDTO;
import my_computer.springsecurity.domain.dto.request.RegisterRequestDTO;
import my_computer.springsecurity.domain.dto.response.UserResponseDTO;

import java.util.List;

public interface IUserService {

    UserResponseDTO register(RegisterRequestDTO request);

    String login(LoginRequestDTO request);

    List<UserResponseDTO> getAllUsers();
}
