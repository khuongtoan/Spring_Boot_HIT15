package my_computer.week6_crud.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_employee_user", foreignKeyDefinition = "FOREIGN KEY (user_id) REFERENCES Users(id) ON DELETE CASCADE"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "department_id",
            foreignKey = @ForeignKey(name = "fk_employee_department", foreignKeyDefinition = "FOREIGN KEY (department_id) REFERENCES Departments(id) ON DELETE SET NULL"))
    private Department department;

    @ManyToOne
    @JoinColumn(name = "position_id",
            foreignKey = @ForeignKey(name = "fk_employee_position", foreignKeyDefinition = "FOREIGN KEY (position_id) REFERENCES Positions(id) ON DELETE SET NULL"))
    private Position position;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "hired_date")
    private LocalDate hiredDate;

    @Column(precision = 10, scale = 2)
    private BigDecimal salary;
}
