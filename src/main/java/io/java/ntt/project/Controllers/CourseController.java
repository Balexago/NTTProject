package io.java.ntt.project.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.java.ntt.project.Entities.Course;
import io.java.ntt.project.Service.CourseService;

@Controller
public class CourseController {
	
	CourseService courseservice;

	public CourseController(CourseService courseservice) {
		super();
		this.courseservice = courseservice;
	}
	
	@GetMapping("/Courses")
	public String listTeachers(Model model)
	{
		
		model.addAttribute("Courses", courseservice.getAllCourses());
		return "Courses";
		
	}	
	
	@GetMapping("/Courses/new")
	public String createCourseForm(Model model) {
		
		Course course = new Course();
		model.addAttribute("course", course);
		return "create_course";		
		
	}
	
	@PostMapping("/Courses")
	public String saveStudent(@ModelAttribute("course") Course course) {
		courseservice.saveCourse(course);
		return "redirect:/Courses";
		
	}
	
	@GetMapping("/Courses/edit/{id}")
	public String updateCourseForm(@PathVariable Long id,Model model) {
		
		model.addAttribute("Courses", courseservice.getCourseById(id));
		return "EditCourse";
	}
	
	//Update Method
	@PostMapping("/Courses/{id}")
	public String updateCourse(@PathVariable Long id,
								@ModelAttribute("Courses") Course course, 
								Model model) {
 		//Get Teachers by id
		Course existingCourse = courseservice.getCourseById(id);
		//update data
		existingCourse.setCourseid(id);
		existingCourse.setCouncil(course.getCouncil());
		existingCourse.setCourseEnd(course.getCourseEnd());
		existingCourse.setCourseStart(course.getCourseStart());
		existingCourse.setDistrict(course.getDistrict());
		existingCourse.setDsc(course.getDsc());
		existingCourse.setName(course.getName());
		existingCourse.setSlotsOpen(course.getSlotsOpen());
		existingCourse.setStatus(course.getStatus());
		
		//save updated data
		courseservice.updateCourse(existingCourse);		
		return "redirect:/Courses";
	}
	
	@GetMapping("/Courses/{id}")
	public String deleteTeacher(@PathVariable Long id) {
		
		courseservice.deleteCourseById(id);
		return "redirect:/Courses";
	}
	
	
}
