package com.example.springboot.service.student;

import com.example.springboot.model.Student;
import com.example.springboot.repository.student.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository iStudentRepository;
    @Override
    public List<Student> showList() {
        return iStudentRepository.findAll();
    }

    @Override
    public void addNewStudent(Student student) {
        iStudentRepository.save(student);
    }
}
