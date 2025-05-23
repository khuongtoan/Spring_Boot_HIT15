package my_computer.spring_exam.controller;

import lombok.RequiredArgsConstructor;
import my_computer.spring_exam.domain.dto.response.AuthorResponseDTO;
import my_computer.spring_exam.domain.dto.resquest.AuthorRequestDTO;
import my_computer.spring_exam.service.IAuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/v1/author")
public class AuthorController {
    private final IAuthorService authorService;


    @PostMapping()
    public ResponseEntity<AuthorResponseDTO> createAuthor(@RequestBody  AuthorRequestDTO dto) {
        AuthorResponseDTO createdAuthor = authorService.createAuthor(dto);
        return new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> getAuthor(@PathVariable Long id) {
        AuthorResponseDTO author = authorService.getAuthorById(id);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity< List<AuthorResponseDTO>> getAuthors() {
        List<AuthorResponseDTO> list = authorService.getAllAuthor();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity< AuthorResponseDTO> updateAuthor(@RequestBody AuthorRequestDTO dto,@PathVariable Long id) {
        AuthorResponseDTO author = authorService.updateAuthor(dto,id);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity< AuthorResponseDTO> deleteAuthor(@PathVariable Long id) {
        AuthorResponseDTO author = authorService.deleteAuthor(id);
        return new ResponseEntity<>( author, HttpStatus.OK);
    }

}
