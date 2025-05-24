package my_computer.springsecurity.service.impl;

import lombok.RequiredArgsConstructor;
import my_computer.springsecurity.domain.dto.request.LoginRequestDTO;
import my_computer.springsecurity.domain.dto.request.RegisterRequestDTO;
import my_computer.springsecurity.domain.dto.response.UserResponseDTO;
import my_computer.springsecurity.domain.entity.User;
import my_computer.springsecurity.domain.mapper.UserMapper;
import my_computer.springsecurity.exception.BadLoginEx;
import my_computer.springsecurity.exception.UsernameExistsEx;
import my_computer.springsecurity.repository.UserRepository;
import my_computer.springsecurity.service.IUserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepo;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDTO register(RegisterRequestDTO request) {
        if (userRepo.existsByUsername(request.getUsername())) {
            throw new UsernameExistsEx("Username already exists");
        }

        User user = mapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setActive(true);
        return mapper.toDto(userRepo.save(user));
    }

    @Override
    public String login(LoginRequestDTO request) {
        User user = userRepo.findByUsername(request.getUsername());
        if (user == null || !passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadLoginEx("Invalid username or password");
        }

        user.setLastLogin(LocalDateTime.now());
        userRepo.save(user);

        return "success";
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepo.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
