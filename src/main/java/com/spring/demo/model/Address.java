package com.spring.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "address_tbl")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String country;
	private String city;
	private String state;
	private String zip_code;
	public int getId() {
		return id;
	}
	public String getCountry() {
		return country;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	
	
	

}
