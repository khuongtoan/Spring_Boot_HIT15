package my_computer.spring_exam.domain.dto.response;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import my_computer.spring_exam.domain.entity.Author;
import my_computer.spring_exam.domain.entity.Category;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookResponseDTO {

    @NotNull
    private Integer id;

    private String description;

    @NotNull
    private String name;

    private double price;

    @NotNull
    private String categoryName;

    @NotNull
    private String authorName;

}
