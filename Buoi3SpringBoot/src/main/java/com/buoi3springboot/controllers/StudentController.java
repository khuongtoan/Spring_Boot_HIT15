package com.buoi3springboot.controllers;

import com.buoi3springboot.enities.Student;
import com.buoi3springboot.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Hiển thị danh sách sinh viên
    @GetMapping
    public String listStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        model.addAttribute("newStudent", new Student()); // Form thêm sinh viên
        return "index";
    }

    // Thêm hoặc cập nhật sinh viên
    @PostMapping("/add")
    public String addOrUpdateStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    // Xóa sinh viên
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    // Hiển thị form sửa sinh viên
    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        Optional<Student> studentOpt = studentService.getStudentById(id);
        if (studentOpt.isPresent()) {
            model.addAttribute("newStudent", studentOpt.get()); // Gán dữ liệu sinh viên vào form
            List<Student> students = studentService.getAllStudents();
            model.addAttribute("students", students);
            return "index"; // Vẫn dùng cùng file index.html
        } else {
            return "redirect:/students";
        }
    }
}
