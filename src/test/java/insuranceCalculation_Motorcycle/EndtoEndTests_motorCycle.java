package insuranceCalculation_Motorcycle;

import java.util.HashMap;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import reusableComponents.ExcelOperations;
import testBase.Testbase;

public class EndtoEndTests_motorCycle extends Testbase {
	/*
	 * @BeforeMethod public void SetUpMethod() throws Exception {
	 * LaunchBrowserandnavigate();
	 * 
	 * }
	 */
	/*
	 * @Test(priority = 2) public void insuranceCalculate_volvoMotor() throws
	 * Exception { System.out.println(driver.getTitle()); }
	 * 
	 * @Test(priority = 1) public void insuranceCalculate_FordMotor() {
	 * System.out.println(driver.getCurrentUrl()); }
	 * 
	 * @AfterMethod public void CleanUp() { driver.quit(); }
	 * 
	 */ 
	
ExcelOperations excel = new ExcelOperations("InsuranceData");	
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "vehData") 
	public void insuranceCalculate(Object obj1) throws Exception {
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		test.log(Status.INFO,"Testdata used for execution is "+testData);
		
		
		
		  homepage.ClickOnMotorCycle(); 
		  vehData.enterVehicleData(testData);
		  vehData.ClickonNextbuttonAfterVehicldata();
		  insData.EnterInsurancedata(testData);
		  insData.ClickonnextButton(); 
		  prodData.enterProductData(testData);
		  prodData.ClickOnNextButton(); 
		  Assert.assertEquals(priceoptions.getpriceforselectedoption("Gold"),testData.get("PriceValidation_Gold"),"Pricing for Gold plan is not Matching.");
		  Assert.assertEquals(priceoptions.getpriceforselectedoption("Silver"),testData.get("PriceValidation_Silver"),"Pricing for Silver plan is not Matching.");
		  Assert.assertEquals(priceoptions.getpriceforselectedoption("Platinum"),testData.get("PriceValidation_Platinum"),"Pricing for Platinum plan is not Matching.");
		  Assert.assertEquals(priceoptions.getpriceforselectedoption("Ultimate"),testData.get("PriceValidation_Ultimate"),"Pricing for Ultimate plan is not Matching.");
		  priceoptions.selectPriceOption(testData.get("SelectOption"));
		  priceoptions.pricenext();
		 
	}
	 //Data provider
	 @DataProvider(name="vehData")
	 public Object[][] testdataSupplier() throws Exception {
		 Object[][] obj = new Object[excel.getrowCount()][1];	
		 for (int i = 1; i <= excel.getrowCount(); i++) {
			 HashMap<String, String> testdata = excel.getTestDatainMap(i);
			 obj[i-1][0] = testdata;
		}
				 return obj;
		 
	 }

}
