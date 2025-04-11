package com.btvnbuoi4.mapper;


import com.btvnbuoi4.domain.dtos.requests.CreateStudentRequest;
import com.btvnbuoi4.domain.dtos.requests.UpdateStudentRequest;
import com.btvnbuoi4.domain.dtos.responses.StudentResponse;
import com.btvnbuoi4.domain.models.Student;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentMapper {

    private final ModelMapper modelMapper;

    public StudentResponse toResponse(Student student) {
        return modelMapper.map(student, StudentResponse.class);
    }

    public Student toEntity(CreateStudentRequest request) {
        return modelMapper.map(request, Student.class);
    }

    public void updateEntity( UpdateStudentRequest request, Student student) {
        modelMapper.map(request, student);
    }
}
