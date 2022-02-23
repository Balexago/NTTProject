package io.java.ntt.project.Service.IMPL;

import java.util.List;

import org.springframework.stereotype.Service;

import io.java.ntt.project.Entities.Students;
import io.java.ntt.project.Service.StudentService;
import io.java.ntt.project.repo.StudentsRepo;

@Service
public class StudentServiceIMPL implements StudentService {
	
	private StudentsRepo studentrepo;

	public StudentServiceIMPL(StudentsRepo studentrepo) {
		super();
		this.studentrepo = studentrepo;
	}

	@Override
	public List<Students> getAllStudents() {

		return studentrepo.findAll();
	}

	@Override
	public Students saveStudent(Students student) {
		// TODO Auto-generated method stub
		return studentrepo.save(student);
	}

	@Override
	public Students getStudentById(Long id) {
		return studentrepo.findById(id).get();
	}

	@Override
	public Students updateStudent(Students student) {
		// TODO Auto-generated method stub
		return studentrepo.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		// TODO Auto-generated method stub
		studentrepo.deleteById(id);
	}

}
