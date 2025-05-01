package my_computer.week6_crud.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Positions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;
}
