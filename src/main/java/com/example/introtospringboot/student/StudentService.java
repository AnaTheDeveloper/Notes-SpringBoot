package com.example.introtospringboot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//@Component allows the controller to know that this service is the spring bean.
//But we can have more specific annotations @Service is specifically a service component.

@Service
public class StudentService {
    @Autowired
    private  StudentRepository studentRepository;



    public List<StudentModel> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(StudentModel studentModel) {

        Optional<StudentModel> studentModelOptional = studentRepository.findStudentModelByEmail(studentModel.getEmail());

        if(studentModelOptional.isPresent()){
            throw new IllegalStateException("Email Taken");
        }
        studentRepository.save(studentModel);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);

        if (!exists){
            throw new IllegalStateException("student with id " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email){

        StudentModel studentModel = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(studentModel.getName(), name)){
            studentModel.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(studentModel.getEmail(), email)){

            //Check if email ahs been taken
            Optional<StudentModel> studentModelOptional = studentRepository.findStudentModelByEmail(email);

            if(studentModelOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            studentModel.setEmail(email);
        }


    }
}

