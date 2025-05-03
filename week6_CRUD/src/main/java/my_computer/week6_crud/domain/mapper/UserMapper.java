package my_computer.week6_crud.domain.mapper;

import my_computer.week6_crud.domain.dto.request.CreateUserRequestDTO;
import my_computer.week6_crud.domain.dto.request.UpdateUserRequestDTO;
import my_computer.week6_crud.domain.dto.response.UserDTO;
import my_computer.week6_crud.domain.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);
    User toEntity(CreateUserRequestDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(UpdateUserRequestDTO dto, @MappingTarget User user);
}
