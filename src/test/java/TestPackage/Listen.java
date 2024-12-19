package TestPackage;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Listen extends Baseclass implements ITestListener{

	WebDriver w;
	ExtentReports extent = getExtentReportObject();
	ExtentTest test ;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		System.out.println("Test started");
		test =extent.createTest(result.getMethod().getMethodName());
		test.pass("Test staretd");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		System.out.println("Test finished successfully");
		try {
			w=(WebDriver)result.getTestClass().getRealClass().getField("w").get(result.getInstance());
			//getScreenshot(w);
			
			test.addScreenCaptureFromPath(getScreenshot(w,result.getMethod().getMethodName()).getAbsolutePath());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extent.flush();
	} 

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		System.out.println("test failed");
		
		
		extent.flush();
	}
	
	

}
