package com.vsr.cruddemo.dao;

import com.vsr.cruddemo.entity.Instructor;
import com.vsr.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl implements AppDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Transactional
    @Override
    public void deleteInstructorById(int theId) {
        // Retrieve the Instructor and then delete theInstructor from database
        Instructor theInstructor = entityManager.find(Instructor.class, theId);
        entityManager.remove(theInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailsById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        // retrieve by the id
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);
        // remove the association object reference
        // break bi-directional link
        tempInstructorDetail.getInstructor().setInstructorDetail(null);
        // delete the instructor
        entityManager.remove(tempInstructorDetail);
    }
}