package io.java.ntt.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.java.ntt.project.Entities.Course;


public interface CourseRepo extends  JpaRepository<Course,Long>{

}
