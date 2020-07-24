package com.crudwebservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudwebservice.dao.StudentRepo;
import com.crudwebservice.model.Student;


@RestController
public class StudentController 
{
	@Autowired
	StudentRepo repo;
	
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
	
	
	@GetMapping(path="/student/{sid}")
	public Optional<Student> getStudent(@PathVariable int sid)
	{
		return repo.findById(sid);
		
	}
	
	@GetMapping(path="/students") 
	public List<Student> getStudents()
	{
		return repo.findAll();
		
	}
	
	@PostMapping(path= "/student")
	public Student addStudent(@RequestBody Student student)

	{
		repo.save(student);
		return student;
	}
	
	@PutMapping(path= "/student")
	public Student updateStudent(@RequestBody Student student)

	{
		repo.save(student);
		return student;
	}
	
	@DeleteMapping(path="/student/{sid}")
	public String deleteStudent(@PathVariable int sid)
	{
		Student student = repo.getOne(sid);
		repo.delete(student);
		return "deleted";
	}

}
