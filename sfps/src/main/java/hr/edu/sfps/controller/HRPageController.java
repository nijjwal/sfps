package hr.edu.sfps.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hr.edu.sfps.model.Student;
import hr.edu.sfps.service.StudentService;

@Controller
public class HRPageController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/home")
	public String home(Model model) {

		List<Student> studentList = studentService.getAllUsers();

		model.addAttribute("mockStudents", studentList);
		return "home";
	}
	
    @GetMapping("/search")
    public String searchStudent() {    	
        return "search"; // This will resolve to result.html Thymeleaf template
    }
	
    @PostMapping("/search")
    public String searchByFirstName(@RequestParam("studentName") String searchedStudent, Model model) {
    	
    	//Mock DB - Starts
    	Student s1 = new Student("idstr1", 1, "John Doe", "Doe");
    	Student s2 = new Student("idstr2", 2, "Tom Smith", "Smith");
    	Student s3 = new Student("idstr3", 3, "Tom Potter", "Potter");
    	
    	
    	List<Student> studentDbList = new ArrayList<>();
    	studentDbList.add(s1);
    	studentDbList.add(s2);
    	studentDbList.add(s3);
    	//Mock DB - Ends
    	
    	//Loop through the database and check and check and see if the searchedStudent 
    	//exists in the database
    	List<Student> resultList = studentService.getSearchedUsers(searchedStudent);
    	
    	for(Student student: studentDbList) {
    		if(student.getName().contains(searchedStudent)) {
    			resultList.add(student);
    		}
    	}
    	
    	
    	model.addAttribute("searchedStudents", resultList);
        return "searchresult"; // This will resolve to result.html Thymeleaf template
    }
    
    @PostMapping("/searchByLastName")
    public String searchByLastName(@RequestParam("studentLastName") String lastName, Model model) {
    	
    	List<Student> resultList = new ArrayList<>();
    	
    	if(lastName.length()>2) {
    		resultList = studentService.getSearchedUsers(lastName);
    		model.addAttribute("searchedStudents", resultList);
    	}else {
    		model.addAttribute("searchedStudents", List.of());
    	}
    	
        return "searchresult";
    }
    
    @GetMapping("/autocomplete")
    @ResponseBody
    public List<String> autocomplete(@RequestParam("query") String query) {
        if (query.length() > 2) {
            return studentService.getLastNameSuggestions(query);
        } else {
            return List.of();
        }
    }
	


}
