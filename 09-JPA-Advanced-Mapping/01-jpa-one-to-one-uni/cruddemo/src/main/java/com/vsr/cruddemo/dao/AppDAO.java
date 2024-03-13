package com.vsr.cruddemo.dao;

import com.vsr.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
}