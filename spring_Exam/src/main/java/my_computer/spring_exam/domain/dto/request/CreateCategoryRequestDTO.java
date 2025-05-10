package my_computer.spring_exam.domain.dto.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import my_computer.spring_exam.domain.entity.Book;

import java.util.List;

public class CreateCategoryRequestDTO {
    private String name;
}
