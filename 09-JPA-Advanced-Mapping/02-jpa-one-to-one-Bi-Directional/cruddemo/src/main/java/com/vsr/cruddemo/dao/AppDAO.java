package com.vsr.cruddemo.dao;

import com.vsr.cruddemo.entity.Instructor;
import com.vsr.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailsById(int theId);
    void deleteInstructorDetailById(int theId);
}