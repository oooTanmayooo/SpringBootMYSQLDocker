package com.example.springbootmysqldocker.entity.controller;

import com.example.springbootmysqldocker.entity.Student;
import com.example.springbootmysqldocker.repository.repo.StudentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController{

    @Autowired
    private StudentRepo studentRepo;

    Logger logger= LoggerFactory.getLogger(StudentController.class);
    @GetMapping("/findAll")
    private List<Student> getAllStudents()
    {
        logger.info("calling get method to fetch");
        List<Student> student=studentRepo.findAll();
        logger.info("students: {} 123",student); //create a obj, studentrepo.findall, print the onj in logs and return
        return student;
    }

    @PostMapping("/create")
    private Student insert(@RequestBody Student student)
    {
        return studentRepo.save(student);
    }
}
