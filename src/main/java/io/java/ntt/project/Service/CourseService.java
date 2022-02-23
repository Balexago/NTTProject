package io.java.ntt.project.Service;

import java.util.List;

import io.java.ntt.project.Entities.Course;

public interface CourseService {

	List<Course> getAllCourses();
	Course saveCourse(Course course);
	Course getCourseById(Long id);
	Course updateCourse(Course course);
	void deleteCourseById(Long id);

}
