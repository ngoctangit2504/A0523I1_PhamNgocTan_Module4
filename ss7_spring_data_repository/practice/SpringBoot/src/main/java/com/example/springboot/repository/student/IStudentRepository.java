package com.example.springboot.repository.student;

import com.example.springboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Long> {
}
