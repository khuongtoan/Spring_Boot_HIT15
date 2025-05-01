package com.btvnbuoi4.domain.dtos.responses;

import java.util.List;

import com.btvnbuoi4.domain.models.Student;

import jakarta.persistence.Column;

import jakarta.persistence.OneToMany;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AClassResponse {

    private int id;

    private String name;

    private String subject;
}
