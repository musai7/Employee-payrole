package com.bridgeit.emppayroll;

import java.io.Serializable;
import java.util.List;

public class EmployeePayRoll implements Serializable {

	private static final long serialVersionUID = 1L;
	public int id;
	public String employeeName;
	public double salary;

	public EmployeePayRoll(int id, String employeeName, double salary) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeePayRoll [id=" + id + ", employeeName=" + employeeName + ", salary=" + salary + "]";
	}
}
