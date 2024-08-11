package hr.edu.sfps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hr.edu.sfps.model.Student;
import hr.edu.sfps.service.StudentService;

// ctr+shitft+f = autoformat code
// ctr+o = auto import

@RestController
public class HRControllerRestEndPoints {

	@Autowired
	private StudentService studentService;

	@GetMapping("hi")
	public List<Student> helloMethod() {
		return studentService.getAllUsers();
	}
	
	
	@GetMapping("demo")
	public String demo() {
		return "demo game";
	}
	
	


}
