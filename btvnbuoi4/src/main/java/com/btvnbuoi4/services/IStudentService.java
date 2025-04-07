package com.btvnbuoi4.services;

import com.btvnbuoi4.models.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    public List<Student> getAll();

    public Optional<Student> getById(Integer id);

    public Student create(Student student);

    public Student update(Integer id, Student student);

    public void delete(Integer id);
}
