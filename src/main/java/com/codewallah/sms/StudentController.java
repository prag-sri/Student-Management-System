package com.codewallah.sms;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add_student")
    public ResponseEntity<String> addStudent(@RequestBody() Student student){
        String response= studentService.addStudent(student);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
        }

    //Get a student by id
    @GetMapping("get_student_by_id")
    public ResponseEntity<Student> getStudentById(@RequestParam("id")Integer id){
        Student result= studentService.getStudentById(id);
        if(result==null)
            return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    //Get a Student by name
    @GetMapping("get_student_by_name")
    public ResponseEntity<Student> getStudentByName(@RequestParam("name")String searchname){
        Student result= studentService.getStudentByName(searchname);
        if(result!=null)
                return new ResponseEntity<>(result,HttpStatus.OK);
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    //get a student by path
    @GetMapping("/get_student_by_path/{id}")
    public ResponseEntity<Student> getByPath(@PathVariable("id")Integer id){
        //resuing the code from function getStudentById()- reutilizing functions
        Student result= studentService.getStudentById(id);
        if(result==null)
            return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    //Update a student
    @PutMapping("/update_student")
    public ResponseEntity<Student> updateStudent(@RequestBody() Student student){
        Student result= studentService.updateStudent(student);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    //Delete a student
    @DeleteMapping("/delete_student")
    public ResponseEntity<String> deleteStudent(@RequestParam("id")Integer id){
        String result= studentService.deleteStudent(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
