package reusableComponents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import testBase.ObjectsRepo;

public class ListenerImplementation extends ObjectsRepo implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		//before each testcase
		test= extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,"Test Case : "+result.getMethod().getMethodName()+ " is passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,"Test Case : "+result.getMethod().getMethodName()+ " is Failed");
		test.log(Status.FAIL, result.getThrowable());
		
		//add screenshot for failed test.
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy-HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);
		String Screenshotpath = System.getProperty("user.dir")+
				"/Reports/Screenshots/"+actualDate+".jpeg";
		File dest= new File(Screenshotpath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(Screenshotpath, "Testcase failure screenshot");
		}

	@Override
	public void onTestSkipped(ITestResult result) {
		}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
			}

	@Override
	public void onStart(ITestContext context) {
		//setup method call
		extent= ExtentSetup.SetupExtentReport();
			}

	@Override
	public void onFinish(ITestContext context) {
		//close extent
		extent.flush();
			}
	

}
