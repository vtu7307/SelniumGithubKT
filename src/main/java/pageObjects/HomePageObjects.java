package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Testbase;

public class HomePageObjects extends Testbase {
	@FindBy(id="nav_automobile")
	WebElement link_Automobile;
	@FindBy(id="nav_truck")
	WebElement link_truck;
	@FindBy(id="nav_motorcycle")
	WebElement link_motorcycle;
	@FindBy(id="nav_camper")
	WebElement link_camper;

public HomePageObjects() {
	PageFactory.initElements(driver,this);
}
public void ClickOnMotorCycle() {
	link_motorcycle.click();
}
}

