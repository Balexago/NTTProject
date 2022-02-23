package io.java.ntt.project.Service.IMPL;

import java.util.List;

import org.springframework.stereotype.Service;

import io.java.ntt.project.Entities.Teachers;
import io.java.ntt.project.Service.TeacherService;
import io.java.ntt.project.repo.TeachersRepo;

@Service
public class TeacherServiceIMPL implements TeacherService{

	private TeachersRepo teacherrepo;
	
	public TeacherServiceIMPL(TeachersRepo teacherrepo) {
		super();
		this.teacherrepo = teacherrepo;
	}

	@Override
	public List<Teachers> getAllTeachers() {
		return teacherrepo.findAll();
	}

	@Override
	public Teachers saveTeachers(Teachers teacher) {
		// TODO Auto-generated method stub
		return teacherrepo.save(teacher);
	}

	@Override
	public Teachers getTeachersById(Long id) {
		// TODO Auto-generated method stub
		return teacherrepo.findById(id).get();
	}

	@Override
	public Teachers updateTeachers(Teachers teacher) {
		// TODO Auto-generated method stub
		return teacherrepo.save(teacher);
	}

	@Override
	public void deleteTeachersById(Long id) {
		// TODO Auto-generated method stub
		teacherrepo.deleteById(id);
	}

}
