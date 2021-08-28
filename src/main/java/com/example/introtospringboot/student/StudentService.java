package com.example.introtospringboot.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//@Component allows the controller to know that this service is the spring bean.
//But we can have more specific annotations @Service is specifically a service component.

@Service
public class StudentService {

    public List<StudentModel> getStudents(){
        return List.of(new StudentModel(1L, "Ana", "ana.student@gmail.com", LocalDate.of(2000, Month.MARCH, 10), 21));
    }
}
