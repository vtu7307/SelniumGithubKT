package testBase;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.EnterInsurancePageObjects;
import pageObjects.EnterProductdataPageObjects;
import pageObjects.EnterVehilePagedataObjects;
import pageObjects.HomePageObjects;
import pageObjects.SelectPriceOptionsPageObjects;
import reusableComponents.CommonMethods;

public class ObjectsRepo {
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static HomePageObjects homepage;
	public static EnterVehilePagedataObjects vehData;
	public static EnterInsurancePageObjects insData;
	public static EnterProductdataPageObjects prodData;
	public static SelectPriceOptionsPageObjects priceoptions;
	public static CommonMethods cm =new CommonMethods();
}
