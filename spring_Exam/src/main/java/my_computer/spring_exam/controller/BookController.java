package my_computer.spring_exam.controller;

import lombok.RequiredArgsConstructor;
import my_computer.spring_exam.domain.dto.response.BookResponseDTO;
import my_computer.spring_exam.domain.dto.resquest.BookRequestDTO;
import my_computer.spring_exam.service.IBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
@Validated
public class BookController {

    private final IBookService bookService;

    @PostMapping()
    public ResponseEntity<BookResponseDTO> createBook(@RequestBody BookRequestDTO bookRequestDTO) {

        BookResponseDTO bookResponseDTO = bookService.createBook(bookRequestDTO);
        return new ResponseEntity<>(bookResponseDTO, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable Long id) {
        BookResponseDTO bookResponseDTO = bookService.getBookById(id);
        return new ResponseEntity<>(bookResponseDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(@PathVariable Long id, @RequestBody BookRequestDTO bookRequestDTO) {
        BookResponseDTO responseDTO = bookService.updateBook(bookRequestDTO, id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookResponseDTO> deleteBook(@PathVariable Long id) {
        BookResponseDTO responseDTO = bookService.deleteBook(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<BookResponseDTO>> filterBooks(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) String authorName,
            @RequestParam(required = false) String categoryName) {

        List<BookResponseDTO> filteredBooks = bookService.filterBooks(name, price, authorName, categoryName);
        return new ResponseEntity<>(filteredBooks, HttpStatus.OK);
    }


}
