package testBase;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.EnterInsurancePageObjects;
import pageObjects.EnterProductdataPageObjects;
import pageObjects.EnterVehilePagedataObjects;
import pageObjects.HomePageObjects;
import pageObjects.SelectPriceOptionsPageObjects;
import reusableComponents.propertiesOperations;

public class Testbase extends ObjectsRepo{
	
	public void LaunchBrowserandnavigate() throws Exception {
		String browser = propertiesOperations.getPropertyValueByKey("browser");
		String URL = propertiesOperations.getPropertyValueByKey("url");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
	}
	
	  @BeforeMethod 
	  public void SetUpMethod() throws Exception {
	  LaunchBrowserandnavigate();
	  homepage = new HomePageObjects();
	  vehData = new EnterVehilePagedataObjects();
	  insData = new EnterInsurancePageObjects();
	  prodData = new EnterProductdataPageObjects();
	  priceoptions = new SelectPriceOptionsPageObjects();
	  }
	  
	  @AfterMethod 
	  public void ClosureMethod() throws InterruptedException {
	  Thread.sleep(1000); 
	  driver.quit();
	  }
	  
	 
}
