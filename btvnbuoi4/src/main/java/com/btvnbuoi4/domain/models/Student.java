package com.btvnbuoi4.domain.models;

import com.btvnbuoi4.domain.enums.Gender;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name ="students")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false )
    private String name;

    @Column(nullable = false)
    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    private Gender gender ;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 15, nullable = false)
    private String phone;
    
    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private AClass aclass;

    
}
