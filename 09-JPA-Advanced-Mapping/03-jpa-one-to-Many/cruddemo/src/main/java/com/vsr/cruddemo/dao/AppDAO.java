package com.vsr.cruddemo.dao;

import com.vsr.cruddemo.entity.Course;
import com.vsr.cruddemo.entity.Instructor;
import com.vsr.cruddemo.entity.InstructorDetail;
import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailsById(int theId);
    void deleteInstructorDetailById(int theId);

    List<Course>findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor tempInstructor);
}