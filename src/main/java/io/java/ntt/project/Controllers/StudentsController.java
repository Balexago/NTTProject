package io.java.ntt.project.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.java.ntt.project.Entities.Students;
import io.java.ntt.project.Service.StudentService;

@Controller
public class StudentsController {
	
	private StudentService studentservice;

	public StudentsController(StudentService studentsrervice) {
		super();
		this.studentservice = studentsrervice;
	}
	
	//handler method to handle list students
	@GetMapping("/students")
	public String listStudents(Model model)
	{
		
		model.addAttribute("students", studentservice.getAllStudents());
		return "students";
		
	}	
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		
		Students student = new Students();
		model.addAttribute("student", student);
		return "create_student";		
		
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Students student) {
		studentservice.saveStudent(student);
		return "redirect:/students";
		
	}
	
	@GetMapping("/students/edit/{id}")
	public String updateStudentForm(@PathVariable Long id,Model model) {
		
		model.addAttribute("student", studentservice.getStudentById(id));
		return "EditStudent";
	}
	
	//Update Method
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,
								@ModelAttribute("student") Students student, 
								Model model) {
 		//Get Student by id
		Students existingStudent = studentservice.getStudentById(id);
		//update data
		existingStudent.setUserid(id);
		existingStudent.setName(student.getName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setCodigoPostal(student.getCodigoPostal());
		existingStudent.setConcelho(student.getConcelho());
		existingStudent.setDataNasc(student.getDataNasc());
		existingStudent.setDistrito(student.getDistrito());
		existingStudent.setMorada(student.getMorada());
		existingStudent.setNIF(student.getNIF());
		existingStudent.setSenha(student.getSenha());
		existingStudent.setTelemovel(student.getTelemovel());
		
		//save updated data
		studentservice.updateStudent(existingStudent);		
		return "redirect:/students";
	}
	
	//Delete Method
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		
		studentservice.deleteStudentById(id);
		return "redirect:/students";
	}

}
