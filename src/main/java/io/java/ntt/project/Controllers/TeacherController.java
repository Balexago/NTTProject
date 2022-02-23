package io.java.ntt.project.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.java.ntt.project.Entities.Teachers;
import io.java.ntt.project.Service.TeacherService;

@Controller
public class TeacherController {

		TeacherService teacherservice;

		public TeacherController(TeacherService teacherservice) {
			super();
			this.teacherservice = teacherservice;
		}
		

		//handler method to handle list Teachers
		@GetMapping("/Teachers")
		public String listTeachers(Model model)
		{
			
			model.addAttribute("Teachers", teacherservice.getAllTeachers());
			return "Teachers";
			
		}	
		
		@GetMapping("/Teachers/new")
		public String createTeachersForm(Model model) {
			
			Teachers Teacher = new Teachers();
			model.addAttribute("Teacher", Teacher);
			return "create_teacher";		
			
		}
		
		@PostMapping("/Teachers")
		public String saveTeachers(@ModelAttribute("Teacher") Teachers Teacher) {
			teacherservice.saveTeachers(Teacher);
			return "redirect:/Teachers";
			
		}
		
		@GetMapping("/Teachers/edit/{id}")
		public String updateTeachersForm(@PathVariable Long id,Model model) {
			
			model.addAttribute("Teachers", teacherservice.getTeachersById(id));
			return "EditTeacher";
		}
		
		//Update Method
		@PostMapping("/Teachers/{id}")
		public String updateTeachers(@PathVariable Long id,
									@ModelAttribute("Teachers") Teachers Teacher, 
									Model model) {
	 		//Get Teachers by id
			Teachers existingTeachers = teacherservice.getTeachersById(id);
			//update data
			existingTeachers.setUserid(id);
			existingTeachers.setName(Teacher.getName());
			existingTeachers.setEmail(Teacher.getEmail());
			existingTeachers.setCodigoPostal(Teacher.getCodigoPostal());
			existingTeachers.setConcelho(Teacher.getConcelho());
			existingTeachers.setDataNasc(Teacher.getDataNasc());
			existingTeachers.setDistrito(Teacher.getDistrito());
			existingTeachers.setMorada(Teacher.getMorada());
			existingTeachers.setNIF(Teacher.getNIF());
			existingTeachers.setSenha(Teacher.getSenha());
			existingTeachers.setTelemovel(Teacher.getTelemovel());
			
			//save updated data
			teacherservice.updateTeachers(existingTeachers);		
			return "redirect:/Teachers";
		}
		
		//Delete Method
		@GetMapping("/Teachers/{id}")
		public String deleteTeacher(@PathVariable Long id) {
			
			teacherservice.deleteTeachersById(id);
			return "redirect:/Teachers";
		}
}
