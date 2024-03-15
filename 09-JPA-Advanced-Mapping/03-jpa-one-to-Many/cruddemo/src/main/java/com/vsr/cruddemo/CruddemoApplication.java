package com.vsr.cruddemo;

import com.vsr.cruddemo.dao.AppDAO;
import com.vsr.cruddemo.entity.Course;
import com.vsr.cruddemo.entity.Instructor;
import com.vsr.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {

        return runner -> {
            // Create an Instructor and the detail of Instructor
            //createInstructor(appDAO);

            // Finding the Instructor by the id
            // findInstructor(appDAO);

            // deleting the Instructor and Instructor_details
            //deleteInstructor(appDAO);

            // find the instructor Details
            //findInstructorDetail(appDAO);

            // deleting the Instructor details
            //deleteInstructorDetail(appDAO);

            // create instructor with courses
             //createInstructorWithCourses(appDAO);

            //Finding the Instructor with courses.
            //findInstructorWithCourses(appDAO);

            // using Fetch type = Lazy
            //findCoursesForInstructor(appDAO);

            // Single query to find theInstructor and the associated Courses
            findInstructorWithCoursesJoinFetch(appDAO);


        };
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int theId = 1;
        // find the Instructor
        System.out.println("Finding instructor id: "+theId);
        Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
        System.out.println("Temp instructor: "+tempInstructor);
        System.out.println("The associated courses: "+tempInstructor.getCourses());
        System.out.println("The instructor Details: "+tempInstructor.getInstructorDetail());
        System.out.println("Done......!");
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding the Instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("temp Instructor: " + tempInstructor);
        // find courses for instructor
        System.out.println("Finding the courses for Instructor id: " + theId);
        List<Course> courses = appDAO.findCoursesByInstructorId(theId);
        // associate the Object
        tempInstructor.setCourses(courses);
        System.out.println("The associated Courses: "+tempInstructor.getCourses());
        System.out.println("Done!..");
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding the Instructor ID : " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("Temp Instructor: "+tempInstructor);
        System.out.println("The Associated courses: "+tempInstructor.getCourses());
        System.out.println("Done !..");
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        Instructor tempInstructor = new Instructor("Vishal", "Sharma", "vishal@luv2code.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.github.com/vishal-sharma-rattan", "cricket");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // create some course
        Course tempCourse1 = new Course("The Ultimate JS Course");
        Course tempCourse2 = new Course("The Python Course");
        Course tempCourse3 = new Course("The React Course");

        // add courses to instructor
        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);
        tempInstructor.add(tempCourse3);

        // save the instructor
        // this will also save the course
        System.out.println("saving the Instructor: " +tempInstructor);
        System.out.println("The courses: " +tempInstructor.getCourses());
        appDAO.save(tempInstructor);
    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int theId = 3;
        System.out.println("Deleting the Instructor Details...");
        appDAO.deleteInstructorDetailById(theId);
        System.out.println("Done....!");
    }

    private void findInstructorDetail(AppDAO appDAO) {
        // get theInstructor details object
        int theId = 2;
        InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailsById(theId);
        // print the Instructor Details
        System.out.println("tempInstructorDetail: " + tempInstructorDetail);
        // print the associated instructor
        System.out.println("The associated Instructor: "+tempInstructorDetail.getInstructor());
        System.out.println("Done !");
    }
    private void deleteInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("DeletingInstructor having the id " + theId);
        appDAO.deleteInstructorById(theId);
        System.out.println("Instructor has been deleted ");
    }
    private void findInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding the Instructor for " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("Temp Instructor : " + tempInstructor);
        System.out.println("Temp Instructor  detail : " + tempInstructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {

		/*
		// create the instructor
		Instructor tempInstructor =
				new Instructor("Madhu", "Patel", "madhu@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.github.com/vishal-sharma-r",
						"Guitar");
		*/

        Instructor tempInstructor = new Instructor("Vishal", "Sharma", "vishal@luv2code.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.github.com/vishal-sharma-rattan", "cricket");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // save the instructor
        //
        // NOTE: this will ALSO save the details object
        // because of CascadeType.ALL

        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);
        System.out.println("Done!");
    }
}