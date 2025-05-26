package com.example.SpringHibernateJPACRUED.dao;

import com.example.SpringHibernateJPACRUED.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{

    //define field for entity manager
    private EntityManager entityManager;


    //inject enetity manager using constructor
    @Autowired
    public StudentDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    //implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student FindById(Integer id) {
      return   entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAllStudent() {
        //create query
        TypedQuery<Student> studentTypedQuery = entityManager.createQuery("FROM Student order by last_name asc",Student.class);

        //return result
        return studentTypedQuery.getResultList();
    }

    @Override
    public List<Student> FindByLastName(String lastname) {
        TypedQuery<Student> findByLastname = entityManager.createQuery("FROM Student WHERE last_name=: thelastname", Student.class);
        findByLastname.setParameter("thelastname",lastname);

        return findByLastname.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student students) {

        entityManager.merge(students);
    }

    @Override
    @Transactional
    public void deleteStduent(Integer id) {
        Student theStudent = entityManager.find(Student.class,id);
        entityManager.remove(theStudent);
    }
}
