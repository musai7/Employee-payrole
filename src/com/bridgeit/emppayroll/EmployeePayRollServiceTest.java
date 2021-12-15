package com.bridgeit.emppayroll;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

public class EmployeePayRollServiceTest {

	@Test
	public void givenThreeEmployyeEntriesMAtchTest() throws IOException {
		EmployeePayRoll[] arrEmps = {
				new EmployeePayRoll(1, "musai", 25000),
				new EmployeePayRoll(2, "mani", 35000),
				new EmployeePayRoll(1, "gana", 45000),
		};
		EmployeePayRollService employeePayRollService;
		employeePayRollService = new EmployeePayRollService(Arrays.asList(arrEmps));
		employeePayRollService.writeEmployeeData(IOService.fILE_IO);
		employeePayRollService.printTheFile();
		long entries = employeePayRollService.countEntries();
		assertEquals(3, entries);
	}
}
