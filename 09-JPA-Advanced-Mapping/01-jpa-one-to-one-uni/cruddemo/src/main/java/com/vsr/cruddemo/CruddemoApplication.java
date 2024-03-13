package com.vsr.cruddemo;

import com.vsr.cruddemo.dao.AppDAO;
import com.vsr.cruddemo.entity.Instructor;
import com.vsr.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {

        return runner -> {
            // Create an Instructor and the detail of Instructor
            // createInstructor(appDAO);
            // Finding the Instructor by the id
            // findInstructor(appDAO);
            // deleting the Instructor and Instructor_details
            deleteInstructor(appDAO);


        };
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