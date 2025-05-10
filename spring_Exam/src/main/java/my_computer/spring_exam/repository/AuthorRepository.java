package my_computer.spring_exam.repository;

import lombok.AllArgsConstructor;
import my_computer.spring_exam.domain.dto.response.AuthorResponseDTO;
import my_computer.spring_exam.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
