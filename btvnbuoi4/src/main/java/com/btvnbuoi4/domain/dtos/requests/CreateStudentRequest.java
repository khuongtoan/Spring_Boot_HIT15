package com.btvnbuoi4.domain.dtos.requests;

import com.btvnbuoi4.domain.enums.Gender;
import com.btvnbuoi4.domain.models.AClass;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateStudentRequest {

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotNull
    private LocalDate dob;

    @NotNull
    private Gender gender ;

    @NotBlank
    @Email
    @Size(max = 100)
    private String email;

    @NotBlank
    @Pattern(regexp = "^[0-9]{10,15}$")
    private String phone;

    @NotNull
    private Integer classId;
}
