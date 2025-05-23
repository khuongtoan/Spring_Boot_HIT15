package my_computer.spring_exam.service.impl;

import lombok.RequiredArgsConstructor;
import my_computer.spring_exam.domain.dto.response.AuthorResponseDTO;
import my_computer.spring_exam.domain.dto.resquest.AuthorRequestDTO;
import my_computer.spring_exam.domain.entity.Author;
import my_computer.spring_exam.domain.mapper.AuthorMapper;
import my_computer.spring_exam.respository.AuthorRepository;
import my_computer.spring_exam.respository.BookRepository;
import my_computer.spring_exam.service.IAuthorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements IAuthorService {
    private final AuthorRepository repo;
    private final AuthorMapper mapper;
    private final BookRepository bookRepository;

    @Override
    public AuthorResponseDTO createAuthor(AuthorRequestDTO dto) {
        Author author = mapper.toEntity(dto);
        repo.save(author);
        return mapper.toDto(author);
    }

    @Override
    public AuthorResponseDTO updateAuthor(AuthorRequestDTO dto, Long id) {
        Author author = repo.findById(id).orElseThrow( () -> new RuntimeException("Author not found"));
        mapper.updateAuthor(dto,author);
        return mapper.toDto(author);
    }

    @Override
    public AuthorResponseDTO deleteAuthor(Long id) {
        Author author = repo.findById(id).orElseThrow((() -> new RuntimeException("Author not found")));
        repo.deleteById(id);
        return mapper.toDto(author);
    }

    @Override
    public List<AuthorResponseDTO> getAllAuthor() {
       List<Author> authors = repo.findAll();
       List<AuthorResponseDTO> dtos = authors.stream()
               .map( author -> {
                   AuthorResponseDTO dto = mapper.toDto(author);
                   Long count = bookRepository.countByAuthorId(author.getId());
                   dto.setBookCount(count);
                   return dto;
               }).collect(Collectors.toList());
       return dtos;
    }

    @Override
    public AuthorResponseDTO getAuthorById(Long id) {
        Author author = repo.findById(id).orElseThrow( () -> new RuntimeException("Author not found"));
        AuthorResponseDTO dto = mapper.toDto(author);
        Long count = bookRepository.countByAuthorId(author.getId());
        dto.setBookCount(count);
        return dto;
    }
}
