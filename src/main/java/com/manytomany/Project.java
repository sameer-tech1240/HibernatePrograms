package com.manytomany;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int project_id;
	@Column(name = "project_name")
	private String project_Name;
	@ManyToMany(mappedBy = "projects")
	private List<Employee> employees;
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(int project_id, String project_Name, List<Employee> employees) {
		super();
		this.project_id = project_id;
		this.project_Name = project_Name;
		this.employees = employees;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getProject_Name() {
		return project_Name;
	}
	public void setProject_Name(String project_Name) {
		this.project_Name = project_Name;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Project [project_id=" + project_id + ", project_Name=" + project_Name + ", employees=" + employees
				+ "]";
	}

}
