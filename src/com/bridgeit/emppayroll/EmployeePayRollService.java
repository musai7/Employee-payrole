package com.bridgeit.emppayroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayRollService {
	
	List<EmployeePayRoll> employeeList;
	
	public EmployeePayRollService() {
		
	}
	
	public EmployeePayRollService(List<EmployeePayRoll> employeeList) {

		this.employeeList = employeeList;
	}



	public static void main(String[] args) {
		
		ArrayList<EmployeePayRoll> arrayList = new ArrayList<>();
		EmployeePayRollService employeePayRollService = new EmployeePayRollService(arrayList);
		Scanner consoleInputReader = new Scanner(System.in);
		employeePayRollService.readEmployeeData(consoleInputReader);
		employeePayRollService.writeEmployeeData();
	}

	private void writeEmployeeData() {

		System.out.println("writing employee pay roll into consol \n " + employeeList);
	}

	private void readEmployeeData(Scanner consoleInputReader) {

		System.out.println("enter employee ID : ");
		int id = consoleInputReader.nextInt();
		System.out.println("enter employee name : ");
		String name = consoleInputReader.next();
		System.out.println("enter empoyee salary ");
		double salary = consoleInputReader.nextDouble();
		employeeList.add(new EmployeePayRoll(id, name, salary));
	}
}
