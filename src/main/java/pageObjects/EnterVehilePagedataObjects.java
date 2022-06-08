package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Testbase;

public class EnterVehilePagedataObjects  extends Testbase{
	//Make drop down
	@FindBy(name="Make")
	WebElement dd_make;
	@FindBy(xpath = "//*[@id=\"insurance-form\"]/div/section[1]/div[1]/span")
	WebElement error_Makedropdown;
	//Model drop down
	@FindBy(id="model")
	WebElement dd_model;
	@FindBy(xpath = "//*[@id=\"insurance-form\"]/div/section[1]/div[2]/span")
	WebElement error_Modeldropdown;
	//Cylinder Capacity Text
	@FindBy(xpath = "//input[@id=\'cylindercapacity\']")
	WebElement txt_cylindercapacity;
	//Capture the error message
	@FindBy(xpath = "//input[@id='cylindercapacity']/following-sibling::span[@class='error']")
	WebElement error_CyclinderCapacity;
	//Engine Performance Text
	@FindBy(id="engineperformance")
	WebElement txt_engineperformance;
	// Date of Manufacture Date format
	@FindBy(id="dateofmanufacture")
	WebElement date_dateofmanufacture;
	@FindBy(xpath = "//*[@id=\"insurance-form\"]/div/section[1]/div[5]/span")
	WebElement error_datemanufacture;
	//Number of seats DropDown
	@FindBy(id="numberofseatsmotorcycle")
	WebElement dd_numberofseatsmotorcycle;
	//Price list Text
	@FindBy(id="listprice")
	WebElement txt_listprice;
	//Annual Mileage Text
	@FindBy(id="annualmileage")
	WebElement txt_annualmileage;
	//NextButton
	@FindBy(name="Next (Enter Insurant Data)")
	WebElement btn_next;
	
	public EnterVehilePagedataObjects() {
		PageFactory.initElements(driver, this);
	}
	//Passing the input value inside CyclinderCapacity
	public void enterCylinderCapacity(String CylinderCapacityValue) {
		txt_cylindercapacity.sendKeys(CylinderCapacityValue);
	}
	//Get Error Message on the CylinderCapacity
	public String getErrorMessageOnCylinderCapacity() {
		return error_CyclinderCapacity.getText();
	}
	//click on MakeDropdown
	public void ClickOnMakedropdown() {
		dd_make.click();	
	}
	//Get Error Message on the MakeDropDown	
	public String getErrorMessageOnMakeDropdown() {
		return error_Makedropdown.getText();
	}
	//click on MakeDropdown
		public void ClickOnModeldropdown() {
			dd_model.click();	
		}
		//Get Error Message on the MakeDropDown	
		public String getErrorMessageOnModelDropdown() {
			return error_Modeldropdown.getText();
		}
		
		public void DateofManufacture(String Dateformat) {
			date_dateofmanufacture.sendKeys(Dateformat);		
		}
		public String geterroronManufacturedate() {
			return error_datemanufacture.getText();	
		}
		public List<String> getDropdownOption_model() {
			return cm.getdropDownasalist(dd_model);
		}
		public List<String> getDropdownOption_make() {
			return cm.getdropDownasalist(dd_make);
		}
		
		//Enter Vehicle Data:
		
		public void enterVehicleData(HashMap<String, String> testData) throws Exception {
			cm.SelectDropDownButton(dd_make,testData.get("Vehicle_Make"));
			cm.SelectDropDownButton(dd_model, testData.get("Vehicle_Model"));
			txt_cylindercapacity.sendKeys(testData.get("Vehicle_CylinderCapacity"));
			txt_engineperformance.sendKeys(testData.get("Vehicle_Engine Performance"));
			date_dateofmanufacture.sendKeys(testData.get("Vehicle_Date of Manufacture"));
			cm.SelectDropDownButton(dd_numberofseatsmotorcycle, testData.get("Vehicle_No of Seats_motorcycle"));
			txt_listprice.sendKeys(testData.get("Vehicle_List_Price"));
			txt_annualmileage.sendKeys(testData.get("Vehicle_Annual_Mileage"));
		}
		// Click on Next button After entering vehicle data
		public void ClickonNextbuttonAfterVehicldata() {
			btn_next.click();
			
		}
		
}
