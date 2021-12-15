
package com.bridgeit.emppayroll;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
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
		if (num == 1) {
			employeePayRollService.writeEmployeeData(IOService.CONSOLE_IO);
		} else {
			employeePayRollService.writeEmployeeData(IOService.fILE_IO);
		}
		System.out.println("no of entries are : "+employeePayRollService.countEntries());
	}

	private void writeEmployeeData(IOService ioService) throws IOException {

		if (ioService.equals(IOService.CONSOLE_IO))
			System.out.println("writing employee pay roll into consol \n " + employeeList);
		else
			writeEmployeeDataToIOFile();
	}

	private void writeEmployeeDataToIOFile() throws IOException {

		// write the data into file
		StringBuffer stringBuffer = new StringBuffer();
		employeeList.stream().forEach(e -> {
			String emp = e.toString().concat("\n");
			stringBuffer.append(emp);
		});

		PrintWriter printWriter = new PrintWriter(HOME);
		printWriter.write(stringBuffer.toString());
		printWriter.close();
		@SuppressWarnings("resource")
		FileReader fileReader = new FileReader(HOME);
		int ch;
		while ((ch = fileReader.read()) != -1) {
			System.out.print((char) ch);
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

	public long countEntries() throws IOException {

		long entries = 0;
		entries = Files.lines(new File("data/abc/demo.txt").toPath()).count();
		return entries;
	}
}
