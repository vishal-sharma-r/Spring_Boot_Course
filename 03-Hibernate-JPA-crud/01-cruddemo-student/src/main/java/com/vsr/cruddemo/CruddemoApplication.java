package com.vsr.cruddemo;

import com.vsr.cruddemo.dao.StudentDAO;
import com.vsr.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	// Bean for cmd line application
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner->{
			//createStudent(studentDAO);
			createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			// read multiple students
			//queryForStudent(studentDAO);
			// read the student whose lastName
			//findingByLastName(studentDAO);
			// Updating the student
			//updateStudent(studentDAO);
			// delete the student
			//deleteStudent(studentDAO);
			// delete all students
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleting "+numRowsDeleted +" rows");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 4;
		System.out.println("Deleting student " + studentId);
		studentDAO.delete(studentId);
		System.out.println("Deleted student ...💔💔");
	}

	private void updateStudent(StudentDAO studentDAO) {
		
		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with student Id " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		// change first name to "scooby"
		System.out.println("Updating student ...");
		myStudent.setFirstName("Scooby");
		// Update the student
		studentDAO.update(myStudent);
		// display the updated Student
		System.out.println("Updated student: "+myStudent);
	}

	private void findingByLastName(StudentDAO studentDAO) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the last name of the student: ");
		String lastName = sc.next();
		List<Student> students = studentDAO.findByLastName(lastName);
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		List<Student> theStudentList = studentDAO.findAll();
		for(Student student : theStudentList) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO)
	{
		System.out.println("Creating new Student Object ....");
		Student tempStudent = new Student("Abhi","sharma","abhi123@gmail.com");

		// save the student object in DB
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);
		// display the id of the save Student
		System.out.println("Saved Student. Generated id: "+tempStudent.getId());
		// Reading the student based on id
		Student myStudent= studentDAO.findById(tempStudent.getId());
		System.out.println("Found the student: "+myStudent);
	}
	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating three students...");
		Student tempStudent1 = new Student("Hit","sha","hiti1@gmail.com");
		Student tempStudent2 = new Student("Hol","sha","hiti2@gmail.com");
		Student tempStudent3 = new Student("Hitiii","sha","hiti3@gmail.com");

		// save the student objects
		System.out.println("Saving student objects...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}
	private  void createStudent(StudentDAO studentDAO) {
		// create the student Object
		System.out.println("Creating new Student Object ....");
		Student tempStudent = new Student("Hiti","sha","hiti@gmail.com");

		// save the student object in DB
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);
		// display the id of the save Student
		System.out.println("Saved Student. Generated id: "+tempStudent.getId());
	}

}