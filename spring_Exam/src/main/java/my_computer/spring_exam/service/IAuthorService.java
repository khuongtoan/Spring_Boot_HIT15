package my_computer.spring_exam.service;

import my_computer.spring_exam.domain.dto.response.AuthorResponseDTO;
import my_computer.spring_exam.domain.dto.resquest.AuthorRequestDTO;
import my_computer.spring_exam.domain.entity.Author;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IAuthorService {

    AuthorResponseDTO createAuthor(AuthorRequestDTO dto);
    AuthorResponseDTO updateAuthor(AuthorRequestDTO dto, Long id);
    AuthorResponseDTO deleteAuthor(Long id);
    List<AuthorResponseDTO> getAllAuthor();
    AuthorResponseDTO getAuthorById(Long id);
}
