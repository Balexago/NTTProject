package io.java.ntt.project.Service;

import java.util.List;

import io.java.ntt.project.Entities.Teachers;

public interface TeacherService {

	List<Teachers> getAllTeachers();
	Teachers saveTeachers(Teachers teacher);
	Teachers getTeachersById(Long id);
	Teachers updateTeachers(Teachers teacher);
	void deleteTeachersById(Long id);
}
