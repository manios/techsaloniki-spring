package com.prodyna.techsaloniki.service;

import java.util.List;

import com.prodyna.techsaloniki.dto.StudentDTO;

public interface StudentService {

	void addStudent(StudentDTO student);

	List<StudentDTO> getStudents();

	List<StudentDTO> searchStudents(String term);

	void removeStudent(Long studentId);

}
