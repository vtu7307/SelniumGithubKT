package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Testbase;

public class EnterInsurancePageObjects extends Testbase {
	
	@FindBy(id="firstname")
	WebElement txt_firstname;
	@FindBy(id="lastname")
	WebElement txt_lastname;
	@FindBy(id="birthdate")
	WebElement date_birthdate;
	@FindBy(xpath = "//input[@name='Gender']/parent::label")
	List<WebElement> rdo_Gender;
	
	@FindBy(id="streetaddress")
	WebElement txt_streetaddress;
	@FindBy(id="country")
	WebElement dd_country;
	@FindBy(id="zipcode")
	WebElement txt_zipcode;
	@FindBy(id="city")
	WebElement txt_city;
	@FindBy(id="occupation")
	WebElement dd_occupation;
	@FindBy(xpath = "//input[@name='Hobbies']/parent::label")
	List<WebElement> chk_Hobbies;
	@FindBy(id="website")
	WebElement txt_website;
	@FindBy(id="picturecontainer")
	WebElement btn_picturecontainer;
	@FindBy(id="nextenterproductdata")
	WebElement btn_nextenterproductdata;
	//initialize driver
	public EnterInsurancePageObjects() {
		PageFactory.initElements(driver, this);
	}
	// Enter the Insurance data
	public void EnterInsurancedata(HashMap<String, String> testData) throws Exception {
		txt_firstname.sendKeys(testData.get("Insurant_FirstName"));
		txt_lastname.sendKeys(testData.get("Insurant_LastName"));
		date_birthdate.sendKeys(testData.get("Insurant_birthdate"));
		cm.SelectRadioButtonValue(rdo_Gender, testData.get("Insurant_gender"));
		txt_streetaddress.sendKeys(testData.get("Insurant_StreetAddress"));
		cm.SelectDropDownButton(dd_country, testData.get("Insurant_country"));
		txt_zipcode.sendKeys(testData.get("Insurant_zipcode"));
		txt_city.sendKeys(testData.get("Insurant_City"));
		cm.SelectDropDownButton(dd_occupation, testData.get("Insurant_occupation"));
		txt_website.sendKeys(testData.get("Insurant_Website"));
		cm.selectChecBoxes(chk_Hobbies, testData.get("Insurant_Hobby"));
	}
	public void ClickonnextButton() {
		btn_nextenterproductdata.click();
	}

}
