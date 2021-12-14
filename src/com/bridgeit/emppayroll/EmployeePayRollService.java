
package com.bridgeit.emppayroll;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayRollService {

	private static final String HOME = "data/abc/demo.txt";

	static List<EmployeePayRoll> employeeList;

	public EmployeePayRollService() {

	}

	public EmployeePayRollService(List<EmployeePayRoll> employeeList) {

		EmployeePayRollService.employeeList = employeeList;
	}

	public static void main(String[] args) throws IOException {

		ArrayList<EmployeePayRoll> arrayList = new ArrayList<>();
		EmployeePayRollService employeePayRollService = new EmployeePayRollService(arrayList);
		Scanner consoleInputReader = new Scanner(System.in);
		employeePayRollService.readEmployeeData(consoleInputReader);
		System.out.println("enter 1 : to consol \n enter 2 : to file ");
		int num = consoleInputReader.nextInt();
		if(num==1)
			employeePayRollService.writeEmployeeData(IOService.CONSOLE_IO);
		else
			employeePayRollService.writeEmployeeData(IOService.fILE_IO);
	}

	private void writeEmployeeData(IOService ioService) throws IOException {

		if (ioService.equals(IOService.CONSOLE_IO))
			System.out.println("writing employee pay roll into consol \n " + employeeList);
		else
			writeEmployeeDataToIOFile();
	}

	private void writeEmployeeDataToIOFile() throws IOException {

		//write the data into file
		FileOutputStream fileOutputStream = new FileOutputStream(HOME);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

		StringBuffer stringBuffer = new StringBuffer();

		employeeList.stream().forEach(e -> {
			String emp = e.toString().concat("\n");
			stringBuffer.append(emp);
		});
		
		objectOutputStream.writeObject(stringBuffer);
		objectOutputStream.close();
		
		//to read the data from file
		FileInputStream fileInputStream = new FileInputStream(HOME);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		try {
			Object object = objectInputStream.readObject();
			objectInputStream.close();
			System.out.println(object);
		} catch (Exception e1) {
		}
	}

	private void readEmployeeData(Scanner consoleInputReader) {

		System.out.println("enter employee ID : ");
		int id = consoleInputReader.nextInt();
		System.out.println("enter employee name : ");
		String name = consoleInputReader.next();
		System.out.println("enter empoyee salary ");
		double salary = consoleInputReader.nextDouble();
		employeeList.add(new EmployeePayRoll(id, name, salary));
		employeeList.add(new EmployeePayRoll(id, name, salary));
	}
}
