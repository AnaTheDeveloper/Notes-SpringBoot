package com.example.introtospringboot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//RestController annotation is applied to a class to mark it as a request handler, and Spring will do the building and provide the RESTful web service at runtime.
@RestController

//This annotation maps HTTP requests to handler methods of MVC and REST controllers
@RequestMapping(path = "/api/v1/student")

public class StudentController {



//We want java to know that StudentService is a spring bean
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentModel> getStudents(){
        return studentService.getStudents();

    }

}
