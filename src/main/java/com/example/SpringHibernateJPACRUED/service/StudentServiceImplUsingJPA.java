package com.example.SpringHibernateJPACRUED.service;

import com.example.SpringHibernateJPACRUED.entity.Student;
import com.example.SpringHibernateJPACRUED.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StudentServiceImplUsingJPA implements StudentServiceUsingJPA{

    private StudentRepository repository;


    @Autowired
    public StudentServiceImplUsingJPA(StudentRepository studentRepository){
        this.repository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Student findStudentById(int theId) {
        Optional<Student> result  = repository.findById(theId);

        Student theStudent = null;
        if(result.isPresent()){
            theStudent = result.get();
        }
        else {
            throw new RuntimeException("Not save :-" +theId);
        }

        return theStudent ;

    }

    @Override
    public Student saveStduent(Student student) {
        return repository.save(student);
    }

    @Override
    public void deteleStudentById(int theId) {
      repository.deleteById(theId);
    }
}
