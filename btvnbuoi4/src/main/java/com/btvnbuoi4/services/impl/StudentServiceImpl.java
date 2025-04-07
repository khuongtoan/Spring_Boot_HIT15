package com.btvnbuoi4.services.impl;

import com.btvnbuoi4.models.Student;
import com.btvnbuoi4.repositories.StudentRepository;
import com.btvnbuoi4.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Integer id, Student newStudent) {
        Student s = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        s.setName(newStudent.getName());
        s.setDob(newStudent.getDob());
        s.setGender(newStudent.getGender());
        s.setEmail(newStudent.getEmail());
        s.setPhone(newStudent.getPhone());
        s.setAclass(newStudent.getAclass());

        return studentRepository.save(s);
    }

    @Override
    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }
}
