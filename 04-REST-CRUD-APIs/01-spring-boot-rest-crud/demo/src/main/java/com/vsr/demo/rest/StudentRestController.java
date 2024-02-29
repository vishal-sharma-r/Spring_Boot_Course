package com.vsr.demo.rest;

import com.vsr.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    // define a PostConstruct to load the students data only once.
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Pulipa", "shr"));
        theStudents.add(new Student("Joornima", "sharma"));
        theStudents.add(new Student("Aksharta", "sharma Rattan"));
    }

    // define endpoint for "/student" - return list of all students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    // define the endpoint for "/students/{studentId}" - return the student by ID
    @GetMapping("/students/{studentId}")
    public Student getStudentByStudentId(@PathVariable int studentId) {

        // check the studentId against list size.
        if((studentId >= theStudents.size()) || (studentId < 0))
        {
            throw new StudentNotFoundException("Student id not found - "+studentId);
        }
        return theStudents.get(studentId);
    }




}



