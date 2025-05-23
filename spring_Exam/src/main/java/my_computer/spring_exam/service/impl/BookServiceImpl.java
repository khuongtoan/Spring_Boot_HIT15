package my_computer.spring_exam.service.impl;

import lombok.RequiredArgsConstructor;
import my_computer.spring_exam.domain.dto.response.BookResponseDTO;
import my_computer.spring_exam.domain.dto.resquest.BookRequestDTO;
import my_computer.spring_exam.domain.entity.Author;
import my_computer.spring_exam.domain.entity.Book;
import my_computer.spring_exam.domain.entity.Category;
import my_computer.spring_exam.domain.mapper.BookMapper;
import my_computer.spring_exam.respository.AuthorRepository;
import my_computer.spring_exam.respository.BookRepository;
import my_computer.spring_exam.respository.CategoryRepository;
import my_computer.spring_exam.service.IBookService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements IBookService {

    private final BookRepository repo;
    private final BookMapper mapper;
    private final AuthorRepository authorRepo;
    private final CategoryRepository categoryRepo;

    @Override
    public BookResponseDTO createBook(BookRequestDTO bookRequestDTO) {
        if(repo.existsByName(bookRequestDTO.getName())) {
            throw new RuntimeException("Name of book already existed");
        }
        Author author = authorRepo.findById(bookRequestDTO.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found") );
        Category category = categoryRepo.findById(bookRequestDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found") );

        Book book = mapper.toEntity(bookRequestDTO);
        book.setAuthor(author);
        book.setCategory(category);
        return mapper.toDto(repo.save(book));
    }

    @Override
    public BookResponseDTO updateBook(BookRequestDTO bookRequestDTO, Long id) {

        Book book = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found") );

        if(repo.existsByName(bookRequestDTO.getName())) {
            throw new RuntimeException("Name of book already existed");
        }

        Author author = authorRepo.findById(bookRequestDTO.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found") );
        Category category = categoryRepo.findById(bookRequestDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found") );

        mapper.updateBook(bookRequestDTO, book);
        book.setAuthor(author);
        book.setCategory(category);
        return mapper.toDto(repo.save(book));

    }

    @Override
    public BookResponseDTO deleteBook(Long id) {
        Book book = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found") );
        repo.deleteById(id);
        return mapper.toDto(book);
    }

    @Override
    public BookResponseDTO getBookById(Long id) {
        Book book = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found") );
        return mapper.toDto(book);
    }

    @Override
    public List<BookResponseDTO> filterBooks(String name, Double price, String authorName, String categoryName) {
        List<Book> books = repo.filterBooks(name, price, authorName, categoryName);
        return books.stream()
                .map(mapper::toDto)
                .toList();
    }

}
