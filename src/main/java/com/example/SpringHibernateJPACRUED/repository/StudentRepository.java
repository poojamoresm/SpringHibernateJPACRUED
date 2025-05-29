package com.example.SpringHibernateJPACRUED.repository;

import com.example.SpringHibernateJPACRUED.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student ,Integer> {
}
