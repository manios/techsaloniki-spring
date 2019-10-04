package com.prodyna.techsaloniki.dto;

public class StudentDTO {

	private Long id;
	private String name;
	private String surname;

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public StudentDTO() {
	}

	public StudentDTO(final Long id, final String name, final String surname) {

		this.id = id;
		this.name = name;
		this.surname = surname;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

}
