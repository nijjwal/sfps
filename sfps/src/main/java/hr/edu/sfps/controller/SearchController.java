package hr.edu.sfps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class SearchController {
//
//    @GetMapping("/search")
//    public String showSearchPage(Model model) {
//        // Add any model attributes needed for rendering the search page
//        return "search"; // This will resolve to search.html Thymeleaf template
//    }
//}
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hr.edu.sfps.model.Student;
import hr.edu.sfps.repository.StudentRepository;

import java.util.List;

@Controller
public class SearchController {

	@Autowired
	private StudentRepository studentRepository; // Assuming you have a repository for Student objects


}