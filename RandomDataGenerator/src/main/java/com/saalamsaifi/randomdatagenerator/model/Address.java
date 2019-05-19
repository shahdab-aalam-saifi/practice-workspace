package com.saalamsaifi.randomdatagenerator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
public class Address {
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;
	
	private String city;
	private String country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Address() {
		super();
	}

	@Override
	public String toString() {
		return String.format("Address [id=%s, city=%s, country=%s]", id, city, country);
	}

}
