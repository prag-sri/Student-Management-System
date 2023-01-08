package com.codewallah.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    String addStudent(Student student){
        String result= studentRepository.addStudentToDB(student);
        return result;
    }

    Student getStudentById(Integer id){
        return studentRepository.getStudentById(id);
    }

    Student getStudentByName(String searchname){
        Student result= studentRepository.getStudentByName(searchname);
        return result;
    }

    Student updateStudent(Student student){
        Student result= studentRepository.updateStudent(student);
        return result;
    }

    String deleteStudent(Integer id){
        String result= studentRepository.deleteStudent(id);
        return result;
    }
}
