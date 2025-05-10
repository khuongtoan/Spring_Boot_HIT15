package my_computer.spring_exam.domain.mapper;

import my_computer.spring_exam.domain.dto.request.*;
import my_computer.spring_exam.domain.dto.response.AuthorResponseDTO;
import my_computer.spring_exam.domain.dto.response.BookResponseDTO;
import my_computer.spring_exam.domain.entity.Author;
import my_computer.spring_exam.domain.entity.Book;
import my_computer.spring_exam.domain.entity.Category;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AuthorResponseDTO toResponse (Author author);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Author createAuthor(CreateAuthorRequestDTO createAuthorRequestDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAuthor(UpdateAuthorRequestDTO dto, @MappingTarget Author author);

    List<AuthorResponseDTO> toResponseDTO(List<Author> authors);

}
