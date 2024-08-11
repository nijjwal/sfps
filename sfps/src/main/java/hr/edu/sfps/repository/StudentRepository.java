package hr.edu.sfps.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import hr.edu.sfps.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

	List<Student> findByNameIgnoreCaseRegex(String name);
}