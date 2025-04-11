package com.btvnbuoi4.domain.dtos.responses;

import com.btvnbuoi4.domain.enums.Gender;
import com.btvnbuoi4.domain.models.AClass;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentResponse {

    private int id;

    private String name;

    private LocalDate dob;

    private Gender gender;

    private String email;

    private String phone;

    private String className;
}
