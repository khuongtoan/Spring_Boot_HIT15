package my_computer.week6_crud.service.impl;

import lombok.RequiredArgsConstructor;
import my_computer.week6_crud.domain.dto.request.CreateUserRequestDTO;
import my_computer.week6_crud.domain.dto.request.UpdateUserRequestDTO;
import my_computer.week6_crud.domain.dto.response.UserDTO;
import my_computer.week6_crud.domain.entity.User;
import my_computer.week6_crud.domain.mapper.UserMapper;
import my_computer.week6_crud.repository.UserRepository;
import my_computer.week6_crud.service.IUserService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO create(CreateUserRequestDTO dto) {
        User user = userMapper.toEntity(dto);
        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public UserDTO update(Long id, UpdateUserRequestDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO getById(Long id) {
        return userMapper.toDTO(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }
}
