package my_computer.spring_exam.service;

import my_computer.spring_exam.domain.dto.response.BookResponseDTO;
import my_computer.spring_exam.domain.dto.resquest.BookRequestDTO;
import my_computer.spring_exam.domain.entity.Book;

import java.util.List;

public interface IBookService {

    BookResponseDTO createBook(BookRequestDTO bookRequestDTO);
    BookResponseDTO updateBook(BookRequestDTO bookRequestDTO, Long id);
    BookResponseDTO deleteBook(Long id);
    BookResponseDTO getBookById(Long id);
    List<BookResponseDTO> filterBooks(String name, Double price, String authorName, String categoryName);

}
