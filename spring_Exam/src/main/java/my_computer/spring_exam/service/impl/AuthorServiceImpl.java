package my_computer.spring_exam.service.impl;

import lombok.RequiredArgsConstructor;
import my_computer.spring_exam.domain.dto.request.CreateAuthorRequestDTO;
import my_computer.spring_exam.domain.dto.request.UpdateAuthorRequestDTO;
import my_computer.spring_exam.domain.dto.response.AuthorResponseDTO;
import my_computer.spring_exam.domain.entity.Author;
import my_computer.spring_exam.domain.mapper.AuthorMapper;
import my_computer.spring_exam.repository.AuthorRepository;
import my_computer.spring_exam.service.IAuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements IAuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public AuthorResponseDTO create(CreateAuthorRequestDTO createAuthorRequestDTO) {
        Author author = authorMapper.createAuthor(createAuthorRequestDTO);
        authorRepository.save(author);
        return authorMapper.toResponse(author) ;
    }

    @Override
    public AuthorResponseDTO update(UpdateAuthorRequestDTO dto, Integer id) {
        Author author = authorRepository.findById(id).orElseThrow( ()-> new RuntimeException("Author not found"));;
        authorMapper.updateAuthor(dto, author);
        authorRepository.save(author);
        return authorMapper.toResponse(author) ;
    }

    @Override
    public AuthorResponseDTO delete(Integer id) {
        Author author = authorRepository.findById(id).orElseThrow( ()-> new RuntimeException("Author not found"));
        authorRepository.delete(author);
        return authorMapper.toResponse(author) ;
    }

    @Override
    public AuthorResponseDTO getById(Integer id) {
        Author author = authorRepository.findById(id).orElseThrow( ()-> new RuntimeException("Author not found"));
        return authorMapper.toResponse(author) ;
    }

    @Override
    public List<AuthorResponseDTO> getAll() {
        return authorRepository.findAll()
                .stream()
                .map(author -> authorMapper.toResponse(author))
                .collect(Collectors.toList());
    }
}
