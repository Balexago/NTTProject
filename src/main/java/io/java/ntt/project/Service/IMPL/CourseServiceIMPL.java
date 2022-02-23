package io.java.ntt.project.Service.IMPL;

import java.util.List;

import org.springframework.stereotype.Service;

import io.java.ntt.project.Entities.Course;
import io.java.ntt.project.Service.CourseService;
import io.java.ntt.project.repo.CourseRepo;

@Service
public class CourseServiceIMPL implements CourseService{
	
	CourseRepo courserepo;

	public CourseServiceIMPL(CourseRepo courserepo) {
		super();
		this.courserepo = courserepo;
	}

	@Override
	public List<Course> getAllCourses() {
		return courserepo.findAll();
	}

	@Override
	public Course saveCourse(Course course) {
		// TODO Auto-generated method stub
		return courserepo.save(course);
	}

	@Override
	public Course getCourseById(Long id) {
		// TODO Auto-generated method stub
		return courserepo.findById(id).get();
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		return courserepo.save(course);
	}

	@Override
	public void deleteCourseById(Long id) {
		// TODO Auto-generated method stub
		courserepo.deleteById(id);
	}

}
