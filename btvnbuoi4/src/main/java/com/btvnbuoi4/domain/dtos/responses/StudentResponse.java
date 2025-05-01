package com.btvnbuoi4.domain.dtos.responses;

import com.btvnbuoi4.domain.enums.Gender;

import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentResponse {

    private int id;

    private String name;

    private LocalDate dob;

    private Gender gender;

    private String email;

    private String phone;

    private AClassResponse aclass;
}
