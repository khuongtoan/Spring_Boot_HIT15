package com.btvnbuoi4.services;

import com.btvnbuoi4.domain.dtos.requests.CreateStudentRequest;
import com.btvnbuoi4.domain.dtos.requests.UpdateStudentRequest;
import com.btvnbuoi4.domain.dtos.responses.StudentResponse;
import com.btvnbuoi4.domain.models.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

    List<StudentResponse> getAllStudents();

    StudentResponse getStudentById(Integer id);

    StudentResponse createStudent(CreateStudentRequest request);

    StudentResponse updateStudent(Integer id, UpdateStudentRequest request);

    StudentResponse deleteStudent(Integer id);

}
