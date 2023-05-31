package com.spring.demo.model;

import java.sql.Date;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "Emp_tbl")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String first_name;
	private String last_name;
	private String gender;
	private String company;
	private String post;
	private int salary;
//	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private Date dob;
//	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private Date join_date;
	private String email;
	private String phone;
	private String image;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	@ElementCollection
	@CollectionTable
	private Set<String> project;
	public int getId() {
		return id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public String getGender() {
		return gender;
	}
	public String getCompany() {
		return company;
	}
	public String getPost() {
		return post;
	}
	public int getSalary() {
		return salary;
	}
	public Date getDob() {
		return dob;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getImage() {
		return image;
	}
	public Address getAddress() {
		return address;
	}
	public Set<String> getProject() {
		return project;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setProject(Set<String> project) {
		this.project = project;
	}
	
	

}
