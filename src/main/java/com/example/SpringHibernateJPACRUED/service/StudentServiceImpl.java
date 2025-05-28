package com.example.SpringHibernateJPACRUED.service;

import com.example.SpringHibernateJPACRUED.dao.StudentDao;
import com.example.SpringHibernateJPACRUED.dao.StudentDaoImpl;
import com.example.SpringHibernateJPACRUED.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao1){
        this.studentDao=studentDao1;
    }
    @Transactional
    @Override
    public List<Student> findAll() {
        return studentDao.findAllStudent();
    }

    @Transactional
    @Override
    public Student findStudentById(int theId) {

        return studentDao.FindById(theId);
    }

    @Transactional
    @Override
    public Student saveStduent(Student student) {
        return studentDao.save(student);
    }

    @Transactional
    @Override
    public void deteleStudentById(int theId) {

        studentDao.deleteStduent(theId);
    }
}
