package com.example.SpringHibernateJPACRUED.dao;

import com.example.SpringHibernateJPACRUED.entity.Student;

import java.util.List;

public interface StudentDao {

    void save(Student student);
    Student FindById(Integer id);

    List<Student> findAllStudent();
    List<Student> FindByLastName(String lastname);

    void updateStudent(Student students);

    void deleteStduent(Integer id);
}
