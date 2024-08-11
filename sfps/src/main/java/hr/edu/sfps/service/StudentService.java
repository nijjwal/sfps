package hr.edu.sfps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.edu.sfps.model.Student;
import hr.edu.sfps.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllUsers() {
		return studentRepository.findAll();
	}
	
	
	public List<Student> getSearchedUsers(String name){
		String regexName = ".*" + name + ".*";
		return studentRepository.findByNameIgnoreCaseRegex(regexName);
	}

}
