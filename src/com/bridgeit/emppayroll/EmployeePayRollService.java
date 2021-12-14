package com.bridgeit.emppayroll;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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



	public static void main(String[] args) throws IOException {
		
//		ArrayList<EmployeePayRoll> arrayList = new ArrayList<>();
//		EmployeePayRollService employeePayRollService = new EmployeePayRollService(arrayList);
//		Scanner consoleInputReader = new Scanner(System.in);
//		employeePayRollService.readEmployeeData(consoleInputReader);
//		employeePayRollService.writeEmployeeData();
		
		String home = "data/abc/abc.txt";
		Path path = Paths.get(home);
		System.out.println(Files.exists(path));
		//Files.delete(path);
		System.out.println(Files.exists(path));
		
		//Files.createDirectories(path);
		Files.createFile(path);
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
