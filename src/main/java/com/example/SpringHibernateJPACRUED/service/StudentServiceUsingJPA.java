package com.example.SpringHibernateJPACRUED.service;

import com.example.SpringHibernateJPACRUED.entity.Student;

import java.util.List;

public interface StudentServiceUsingJPA {

    List<Student> findAll();

    Student findStudentById(int theId);
    Student saveStduent(Student student);
    void deteleStudentById(int theId);

}
