package com.btvnbuoi4.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name ="classes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String subject;

    @OneToMany(mappedBy = "aclass" )
    @JsonBackReference
    private List<Student> studentsList;
}
