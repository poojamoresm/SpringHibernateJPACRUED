package com.example.SpringHibernateJPACRUED.controller;

import com.example.SpringHibernateJPACRUED.dao.StudentDao;
import com.example.SpringHibernateJPACRUED.entity.Student;
import com.example.SpringHibernateJPACRUED.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.antlr.v4.runtime.atn.SemanticContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StudentsController {

    private StudentService studentService;

    private ObjectMapper objectMapper;
    @Autowired
    public StudentsController(StudentService thestudentService,
                              ObjectMapper objectMapper1){
        this.studentService = thestudentService;
        this.objectMapper = objectMapper1;
    }


    @GetMapping("/allStudent")
    public List<Student> getAllStudent(){
        return studentService.findAll();
    }

    @GetMapping("/studentid/{id}")
    public Student getStudentById(@PathVariable  int id){

        Student student = studentService.findStudentById(id);
        if(student == null){
            throw new RuntimeException("Student not found :- "+id);
        }
        return student;
    }



    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student thestudent){
        thestudent.setId(0);
        Student dbStudent = studentService.saveStduent(thestudent);
        return dbStudent;
    }

    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student thestudent){
        Student dbStudent = studentService.saveStduent(thestudent);
        return dbStudent;
    }

    //patch for partial update operation

    /*@PatchMapping("/student/{id}")
    public Student patchStudent(@PathVariable int studentId,
                                @RequestBody Map<String, Object> payload){
        Student theStudent = studentService.findStudentById(studentId);
        if(theStudent == null){
            throw  new RuntimeException("Student id not found: -" +theStudent);
        }
        if(payload.containsKey(theStudent))
            throw new RuntimeException("Student id not found in request body:- "+theStudent);
        
        Student patchStudent = apply(payload,theStudent);

        Student dbStudent = studentService.saveStduent(patchStudent);

        return dbStudent;
    }

    private Student apply(Map<String, Object> payload, Student theStudent) {

        //convert student object to json object node
        ObjectNode studentNode = objectMapper.convertValue(theStudent, ObjectNode.class);

        //convert patchpayload map to json object
        ObjectNode patchNode = objectMapper.convertValue(payload, ObjectNode.class);

        //marge patch update into the student node
        studentNode.setAll(patchNode);

        return objectMapper.convertValue(studentNode, Student.class);
    }*/
   @DeleteMapping("/deleteStudentById/{id}")
    public String deleteStudById(@PathVariable int studentId){
        Student tempStudent =studentService.findStudentById(studentId);

        if( tempStudent == null)
            throw  new RuntimeException("Student is not found :-" +studentId);

       studentService.deteleStudentById(studentId);
        return "Student deleted :-" +studentId;
    }
}
