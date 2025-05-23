package my_computer.spring_exam.domain.mapper;

import my_computer.spring_exam.domain.dto.response.BookResponseDTO;
import my_computer.spring_exam.domain.dto.resquest.BookRequestDTO;
import my_computer.spring_exam.domain.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(source = "author.name", target = "authorName")
    @Mapping(source = "category.name", target = "categoryName")
    BookResponseDTO toDto(Book book);

    Book toEntity (BookRequestDTO requestDTO);

    void updateBook(BookRequestDTO dto, @MappingTarget Book book);
}
