package my_computer.spring_exam.domain.mapper;

import my_computer.spring_exam.domain.dto.response.AuthorResponseDTO;
import my_computer.spring_exam.domain.dto.resquest.AuthorRequestDTO;
import my_computer.spring_exam.domain.entity.Author;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author toEntity(AuthorRequestDTO authorRequesDTO);
    AuthorResponseDTO toDto(Author author);

    void updateAuthor(AuthorRequestDTO dto, @MappingTarget Author author);

}
