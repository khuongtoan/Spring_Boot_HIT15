package my_computer.week6_crud.domain.mapper;

import my_computer.week6_crud.domain.dto.request.CreatePositionRequestDTO;
import my_computer.week6_crud.domain.dto.request.UpdatePositionRequestDTO;
import my_computer.week6_crud.domain.dto.response.PositionDTO;
import my_computer.week6_crud.domain.entity.Position;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface PositionMapper {
    PositionDTO toDTO(Position position);
    Position toEntity(CreatePositionRequestDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(UpdatePositionRequestDTO dto, @MappingTarget Position position);
}
