package my_computer.spring_exam.repository;

import my_computer.spring_exam.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
