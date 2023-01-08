package com.codewallah.sms;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class StudentRepository {
    HashMap<Integer,Student> studentDb= new HashMap<>();

    String addStudentToDB(Student student){
        int key= student.getId();
        studentDb.put(key,student);
        return "Successfully Added!";
    }

    Student getStudentById(Integer id){
        if(studentDb.containsKey(id))
            return studentDb.get(id);
        return null;
    }

    Student getStudentByName(String name){
        for(Student s: studentDb.values())
        {
            if(s.getName().equals(name)) {
                return s;
            }
        }
        return null;
    }

    Student updateStudent(Student student){
        int key= student.getId();
        studentDb.put(key,student);
        return student;
    }

    String deleteStudent(Integer id){
        studentDb.remove(id);
        return "Student deleted successfully!";
    }
}
