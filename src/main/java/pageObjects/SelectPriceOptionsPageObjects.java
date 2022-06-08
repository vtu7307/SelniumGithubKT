package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.Testbase;

public class SelectPriceOptionsPageObjects extends Testbase {

	public SelectPriceOptionsPageObjects() {
		PageFactory.initElements(driver,this);
	}
	
	  @FindBy(xpath = "//*[@id=\"nextsendquote\"]")
	  WebElement btn_price_next;
	 
	public String getpriceforselectedoption(String plan) {
		String dataxpath = "//table[@id='priceTable']//tr[1]//td[@data-label='"+plan+"']//span";
		return driver.findElement(By.xpath(dataxpath)).getText();
	}
	
	public void selectPriceOption (String plan) {
		
		String Selectpricexpath = "//input[@name='Select Option' and @value='"+plan+"']/parent::label";
		driver.findElement(By.xpath(Selectpricexpath)).click();
	}
	public void pricenext() {
		  WebDriverWait waits= new WebDriverWait(driver, Duration.ofSeconds(5));
		  waits.until(ExpectedConditions.elementToBeClickable(btn_price_next));
		  btn_price_next.click();		 
	}

}
