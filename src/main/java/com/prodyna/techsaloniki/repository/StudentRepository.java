package com.prodyna.techsaloniki.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.prodyna.techsaloniki.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	// Basic CRUD is AUTO IMPLEMENTED by Spring into a Bean created during
	// deployment.
	// CRUD refers Create, Read, Update, Delete

	List<Student> findByNameIsLikeOrSurnameIsLike(String name, String surname);
}
