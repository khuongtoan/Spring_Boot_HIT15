package my_computer.spring_exam.domain.mapper;


import my_computer.spring_exam.domain.dto.request.CreateBookRequestDTO;
import my_computer.spring_exam.domain.dto.request.UpdateBookRequestDTO;
import my_computer.spring_exam.domain.dto.response.BookResponseDTO;
import my_computer.spring_exam.domain.entity.Book;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    BookResponseDTO toResponse (Book book);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Book createBook(CreateBookRequestDTO createBookRequestDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBook(UpdateBookRequestDTO dto, @MappingTarget Book book);
}
