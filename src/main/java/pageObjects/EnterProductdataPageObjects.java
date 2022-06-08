package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Testbase;

public class EnterProductdataPageObjects extends Testbase {
	
	@FindBy(id="startdate")
	WebElement date_startdate;
	@FindBy(id="insurancesum")
	WebElement dd_insurancesum;
	@FindBy(id="damageinsurance")
	WebElement dd_damageinsurance;
	
	@FindBy(xpath = "//input[@name='Optional Products[]']/parent::label")
	List<WebElement> chk_Optionalproducts;
	@FindBy(id="nextselectpriceoption")
	WebElement btn_next;
	
	public EnterProductdataPageObjects() {
		PageFactory.initElements(driver, this);
		
	}
	public void enterProductData(HashMap<String, String> testData) throws Exception {
		date_startdate.sendKeys(testData.get("Product_startdate"));
		cm.SelectDropDownButton(dd_insurancesum, testData.get("Product_Insurancesum"));
		cm.SelectDropDownButton(dd_damageinsurance, testData.get("Product_Damageinsurance"));
		cm.selectChecBoxes(chk_Optionalproducts,testData.get("Product_OptionalProducts"));
	}
	public void ClickOnNextButton() {
		btn_next.click();
		
	}

}
