package com.POJOclasses;

public class Employee {
	
	String empID;
	String empName;
	int salary;
	
	public Employee(String empID, String empName, int salary) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.salary = salary;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	

}
