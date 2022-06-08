package insuranceCalculation_Motorcycle;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testBase.Testbase;

public class errortests_motor_cycle extends Testbase{
	//@Test(priority = 1)
	@Test(enabled = false)
	public void errorMessageCylinder_Capacity() throws Exception {
		//Click on Motorcycle tab.
		homepage.ClickOnMotorCycle();
		vehData.enterCylinderCapacity("3333");
		test.log(Status.PASS, "Cyclinder capacity is filled with :3333");
		String ActualErrorMessage = vehData.getErrorMessageOnCylinderCapacity();
		String ExpectedErrorMessage = "Must be a number between 1 and 2000";
		Assert.assertEquals(ActualErrorMessage, ExpectedErrorMessage,"Error message is:CyclinderCapacity is not as expected");
		}

	@Test(priority = 2)
	//@Test(enabled = false)
	public void errorMessageMakeDropDown() {
		homepage.ClickOnMotorCycle();
		vehData.ClickOnMakedropdown();
		test.log(Status.PASS, "No option is selected for Make dropdown");
		String ActualErrorMessage = vehData.getErrorMessageOnMakeDropdown();
		String  ExpectedErrorMessage = "Select an option";
		Assert.assertEquals(ActualErrorMessage, ExpectedErrorMessage,"Error message:");
	}
	@Test(priority = 3)
	//@Test(enabled = false)
	public void errorMessageModelDropDown() {
		homepage.ClickOnMotorCycle();
		vehData.ClickOnModeldropdown();
		test.log(Status.PASS, "No option is selected for Model dropdown");
		String ActualErrorMessage1 = vehData.getErrorMessageOnModelDropdown();
		String  ExpectedErrorMessage1 = "Select atleast one option";
		Assert.assertEquals(ActualErrorMessage1, ExpectedErrorMessage1,"Error message is:");
	}
	@Test (priority = 4)
	//@Test(enabled = false)
	public void errorMessageManufacturedateformat() {
		homepage.ClickOnMotorCycle();
		vehData.DateofManufacture("12/34/3454");
		test.log(Status.PASS, " Date is entered as : 12/34/3454");
		String ActualErrorMessage2 = vehData.geterroronManufacturedate();
		String ExpectedErroressage2 = "Must be a valid date format";
		Assert.assertEquals(ActualErrorMessage2, ExpectedErroressage2,"Error message is :");
	}
	@Test(priority = 6)
	//@Test(enabled = true)
	public void VerifyModeldropdownOptions() {
		homepage.ClickOnMotorCycle();
		List<String> actualValues= vehData.getDropdownOption_model();
		test.log(Status.INFO, "Actual dropdowncontents for Model dd is :" +actualValues);
		List<String> expectedValues = Arrays.asList("– please select –","Scooter","Three-Wheeler","Moped","Motorcycle");
		test.log(Status.INFO, "Expectd dropdowncontents for Model dd is :" +expectedValues);
		Assert.assertEquals(actualValues, expectedValues,"Error in drop downoptions on Model dropdown:");

	}
	@Test(priority = 5)
	//@Test(enabled = true)
public void VerifyMakedropdownOptions() {
		homepage.ClickOnMotorCycle();
		List<String> actualvalues = vehData.getDropdownOption_make();
		List<String> actualvalueslist = actualvalues;
		Collections.sort(actualvalueslist);
		test.log(Status.INFO, "Actual dropdowncontents for Make dd is :" +actualvalueslist);
		List<String> expectedValues = Arrays.asList("– please select –","Audi","BMW","Ford","Honda","Mazda","Mercedes Benz","Nissan","Porsche","Opel","Renault","Skoda","Suzuki","Toyota","Volkswagen","Volvo");
		List<String> expectedvalueslist = expectedValues;
		Collections.sort(expectedvalueslist);
		test.log(Status.INFO,"Expected dropdowncontents for Make dd is : " +expectedvalueslist);
		Assert.assertEquals(actualvalueslist, expectedvalueslist,"Error in drop downoptions on Make dropdown:");
	}
	
	
	

}
