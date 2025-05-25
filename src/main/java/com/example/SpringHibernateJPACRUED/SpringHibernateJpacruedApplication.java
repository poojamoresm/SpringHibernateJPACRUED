package com.example.SpringHibernateJPACRUED;

import com.example.SpringHibernateJPACRUED.dao.StudentDao;
import com.example.SpringHibernateJPACRUED.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringHibernateJpacruedApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringHibernateJpacruedApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(StudentDao studentDao){
return runner->{

	System.out.println("Hello Word");
	//create student one
	createStudent(studentDao);

	//create multiple student
	createMultipleStudent(studentDao);

	//find student by id
	findStudentByID(studentDao);

	//get all student
	getAllStudent(studentDao);

	//find Student by last name
	findStduentbyLastName(studentDao);


	//update student
	updateStduentinfo(studentDao);

	//delete student by id
	//deleteStudent(studentDao);
		};
	}

	private void deleteStudent(StudentDao studentDao) {

		int Stduentid =2;
		System.out.println("Delete Stduent id is :-" +Stduentid);
		studentDao.deleteStduent(Stduentid);

	}

	private void updateStduentinfo(StudentDao studentDao) {

		int studId =1;
		Student updatedStduent = studentDao.FindById(studId);

		updatedStduent.setLast_name("Kamble");
		updatedStduent.setFirst_name("Yasha");
		studentDao.updateStudent(updatedStduent);
	System.out.println("Updating student is :=" + updatedStduent);

	}

	private void findStduentbyLastName(StudentDao studentDao) {

		List<Student> std = studentDao.FindByLastName("more");
		for (Student s: std)
		{
			System.out.println("Student by Last name is := "+s);
		}
	}

	private void getAllStudent(StudentDao studentDao) {

		//get list of student

		List<Student> allStudent = studentDao.findAllStudent();
		for(Student stud: allStudent){
			System.out.println("List of Student:- "+stud);
		}
		//display student
	}

	private void findStudentByID(StudentDao studentDao) {

		//create student object
		System.out.println("create Student object ");
		Student student5 = new Student("yash@gmail.com","yash","more");

		//save student

		studentDao.save(student5);

		int newid = student5.getId();
		//display student by id
		System.out.println("New Student create is :- "+studentDao.FindById(newid));
	}

	private void createMultipleStudent(StudentDao studentDao) {
		//create student object
		System.out.println("create 3 Student object ");
		Student student1 = new Student("yash@gmail.com","yash","more");
		Student student2 = new Student("Pranju@gmail.com","Pranju","more");
		Student student3 = new Student("ansh@gmail.com","Ansh","more");


		//save student object
		System.out.println("Save Student objects :- ");
		studentDao.save(student1);
		studentDao.save(student2);
		studentDao.save(student3);
	}

	private void createStudent(StudentDao studentDao) {

		//create student object
		System.out.println("Student persist ");
		Student student = new Student("more@gmail.com","Pooja","more");

		//save object
		System.out.println("Save student object");
		studentDao.save(student);
		//display the id of student
		System.out.println("Student data is save :-"+student.getId());
	}


}
