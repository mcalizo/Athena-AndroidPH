package screens;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import base.ScreenBase;
import base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @author magagan@olx.ph
 *         Date: 03.20.17
 */
public class OnFailure extends TestListenerAdapter {
	
	private ScreenBase base;
	WebDriver driver;
	Object obj;
	TestBase androidSetup;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void onTestFailure(ITestResult testResult){
		obj = testResult.getInstance();
		driver =  ((TestBase)obj).driver;
		base = new ScreenBase((AppiumDriver<MobileElement>) driver);
		//base = new ScreenBase(driver);
		try {
		System.out.println("***** Error "+testResult.getName()+" test has failed *****");
		base.getAttachment("FailedOn_"+testResult.getTestClass().getName()+"_"+testResult.getMethod().getMethodName()+".png");
		System.out.println("FailedOn_"+testResult.getTestClass().getName()+"_"+testResult.getMethod().getMethodName()+".png");
		} catch (Exception e) {
            System.out.print("-->Unable to screen capture");
            e.printStackTrace();	
		}
	}
}
