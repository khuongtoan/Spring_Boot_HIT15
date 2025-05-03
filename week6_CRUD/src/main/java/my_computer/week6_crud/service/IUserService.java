package my_computer.week6_crud.service;

import my_computer.week6_crud.domain.dto.request.CreateUserRequestDTO;
import my_computer.week6_crud.domain.dto.request.UpdateUserRequestDTO;
import my_computer.week6_crud.domain.dto.response.UserDTO;

import java.util.List;

public interface IUserService {
    UserDTO create(CreateUserRequestDTO dto);
    UserDTO update(Long id, UpdateUserRequestDTO dto);
    void delete(Long id);
    UserDTO getById(Long id);
    List<UserDTO> getAll();
}
