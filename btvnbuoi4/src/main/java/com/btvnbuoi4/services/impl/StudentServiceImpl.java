package com.btvnbuoi4.services.impl;

import com.btvnbuoi4.domain.dtos.requests.CreateStudentRequest;
import com.btvnbuoi4.domain.dtos.requests.UpdateStudentRequest;
import com.btvnbuoi4.domain.dtos.responses.StudentResponse;
import com.btvnbuoi4.domain.models.AClass;
import com.btvnbuoi4.domain.models.Student;
import com.btvnbuoi4.mapper.StudentMapper;
import com.btvnbuoi4.repositories.AClassRepository;
import com.btvnbuoi4.repositories.StudentRepository;
import com.btvnbuoi4.services.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {

    private final StudentRepository studentRepository;
    private final AClassRepository aClassRepository;
    private final StudentMapper studentMapper;


    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(student -> studentMapper.toResponse(student))
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponse getStudentById(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("not found student with id :" + id ));
        return studentMapper.toResponse(student);

    }

    @Override
    public StudentResponse createStudent(CreateStudentRequest request) {
        AClass aClass = aClassRepository.findById(request.getClassId())
                .orElseThrow(()->new RuntimeException("Not found student with id : " + request.getClassId()));
        Student student = studentMapper.toEntity(request);
        student.setAclass(aClass);

        Student savedStudent = studentRepository.save(student);

        return studentMapper.toResponse(savedStudent);
    }

    @Override
    public StudentResponse updateStudent(Integer id, UpdateStudentRequest request) {
        Student student =studentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Not found student with id : "+id));

        studentMapper.updateEntity(request, student);

        if (request.getClassId() != null) {
            AClass aClass = aClassRepository.findById(request.getClassId())
                    .orElseThrow(() -> new RuntimeException("Class not found with id: " + request.getClassId()));
            student.setAclass(aClass);
        }

        return studentMapper.toResponse(studentRepository.save(student));
    }

    @Override
    public StudentResponse deleteStudent(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Not found student with id : " + id));
        studentRepository.delete(student);
        return studentMapper.toResponse(student);
    }


}
