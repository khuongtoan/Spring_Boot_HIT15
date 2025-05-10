package my_computer.spring_exam.domain.dto.response;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import my_computer.spring_exam.domain.entity.Book;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorResponseDTO {

    @NotNull
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private LocalDate dob;

    private String bio;

    @NotNull
    private Integer booksCount;

}
