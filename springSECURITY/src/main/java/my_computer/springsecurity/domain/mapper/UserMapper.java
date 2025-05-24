package my_computer.springsecurity.domain.mapper;

import my_computer.springsecurity.domain.dto.request.RegisterRequestDTO;
import my_computer.springsecurity.domain.dto.response.UserResponseDTO;
import org.mapstruct.Mapper;

import my_computer.springsecurity.domain.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity (RegisterRequestDTO requestDTO);

    UserResponseDTO toDto (User user);
}
