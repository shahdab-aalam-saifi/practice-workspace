package com.saalamsaifi.randomdatagenerator.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
public class Person {
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;

	private String firstName;
	private String lastName;
	private String dateOfBirth;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@ManyToOne(targetEntity = Address.class)
	private Address address;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Person() {
		super();
	}

	@Override
	public String toString() {
		return String.format("Person [id=%s, firstName=%s, lastName=%s, dateOfBirth=%s, gender=%s, address=%s]", id,
				firstName, lastName, dateOfBirth, gender, address);
	}

}
