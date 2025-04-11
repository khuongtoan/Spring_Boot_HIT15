package com.btvnbuoi4.domain.dtos.requests;

import com.btvnbuoi4.domain.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UpdateStudentRequest {

    @Size(max = 100)
    private String name;

    private LocalDate dob;

    private Gender gender;

    @Email
    @Size(max = 100)
    private String email;

    @Pattern(regexp = "^[0-9]{10,15}$")
    private String phone;

    private Integer classId;
}