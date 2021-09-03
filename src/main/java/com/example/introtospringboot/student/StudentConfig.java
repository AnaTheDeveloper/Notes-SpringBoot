package com.example.introtospringboot.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;


import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {

            StudentModel ana = new StudentModel("Ana", "ana.student@gmail.com", LocalDate.of(2000, MARCH, 10));
            StudentModel alex = new StudentModel("Alex", "alex.student@gmail.com", LocalDate.of(2004, MARCH, 10));
            StudentModel tom = new StudentModel("Tom", "tom.student@gmail.com", LocalDate.of(1998, JANUARY, 18));

            repository.saveAll(List.of(ana, alex, tom));
        };

    }

}
