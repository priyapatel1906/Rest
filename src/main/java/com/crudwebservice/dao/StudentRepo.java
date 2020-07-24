package com.crudwebservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudwebservice.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>
{

}
