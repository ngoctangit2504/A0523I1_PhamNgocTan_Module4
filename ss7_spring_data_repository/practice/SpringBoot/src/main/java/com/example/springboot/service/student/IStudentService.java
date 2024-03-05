package com.example.springboot.service.student;

import com.example.springboot.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> showList();
    void addNewStudent(Student student);
}
