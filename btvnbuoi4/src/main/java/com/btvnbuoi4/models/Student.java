package com.btvnbuoi4.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name ="users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100 )
    private String name;

    @Column()
    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    private Gender gender ;

    @Column(length = 100)
    private String email;

    @Column(length = 15)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    @JsonBackReference
    private AClass aclass;

}
