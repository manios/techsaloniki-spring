package com.prodyna.techsaloniki.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodyna.techsaloniki.dto.StudentDTO;
import com.prodyna.techsaloniki.model.Student;
import com.prodyna.techsaloniki.repository.StudentRepository;
import com.prodyna.techsaloniki.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Transactional
	@Override
	public void addStudent(final StudentDTO student) {

		final Student st = new Student();
		st.setName(student.getName());
		st.setSurname(student.getSurname());

		this.studentRepository.save(st);

	}

	@Override
	public List<StudentDTO> getStudents() {

		final List<Student> st = (List<Student>) this.studentRepository.findAll();

		return this.toDTO(st);
	}

	@Override
	public void removeStudent(final Long studentId) {

		this.studentRepository.deleteById(studentId);
	}

	@Override
	public List<StudentDTO> searchStudents(final String term) {

		final String searchTerm = "%" + term + "%";

		final List<Student> st = this.studentRepository
				.findByNameIsLikeOrSurnameIsLike(searchTerm, searchTerm);

		return this.toDTO(st);
	}

	private List<StudentDTO> toDTO(final List<Student> students) {
		final List<StudentDTO> dtos = new ArrayList<StudentDTO>();

		if (students == null) {
			return dtos;

		}

		for (final Student i : students) {
			dtos.add(new StudentDTO(i.getId(), i.getName(), i.getSurname()));
		}

		return dtos;
	}
}
