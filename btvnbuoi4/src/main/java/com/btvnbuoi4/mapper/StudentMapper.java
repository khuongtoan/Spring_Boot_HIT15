package com.btvnbuoi4.mapper;


import com.btvnbuoi4.domain.dtos.requests.CreateStudentRequest;
import com.btvnbuoi4.domain.dtos.requests.UpdateStudentRequest;
import com.btvnbuoi4.domain.dtos.responses.AClassResponse;
import com.btvnbuoi4.domain.dtos.responses.StudentResponse;
import com.btvnbuoi4.domain.models.Student; 
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentMapper {

    private final ModelMapper modelMapper;

    public StudentResponse toResponse(Student student) {

        StudentResponse response = modelMapper.map(student, StudentResponse.class);
        if (student.getAclass() != null) {
            response.setAclass(modelMapper.map(student.getAclass(), AClassResponse.class));
        }
        return response;
    }

    public Student toEntity(CreateStudentRequest request) {
        return modelMapper.map(request, Student.class);
    }

    public void updateEntity( UpdateStudentRequest request, Student student) {
        modelMapper.map(request, student);
    }
}
