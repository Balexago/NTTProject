package io.java.ntt.project.Service;

import java.util.List;

import io.java.ntt.project.Entities.Students;


public interface StudentService {

	List<Students> getAllStudents();
	Students saveStudent(Students student);
	Students getStudentById(Long id);
	Students updateStudent(Students student);
	void deleteStudentById(Long id);

}
