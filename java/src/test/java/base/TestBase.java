package base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utility.CommonUtils;

/**
 * @author magagan@olx.ph
 */
public class TestBase {
	
	public AppiumDriver<MobileElement> driver;
	public static String loadPropertyFile = "Android.properties";
	public static String loggingProperty = "log4j.properties";
	//public static Logger log = Logger.getLogger("AndroidLogger");
	
	public static Logger log = Logger.getLogger(TestBase.class);
	
	//@BeforeTest
	//@BeforeMethod
	@BeforeClass
	public void setUp (ITestContext ctx) throws IOException, Throwable {
		
		//PropertyConfigurator.configure(loggingProperty);
		//Logger.getLogger("AndroidAppLog");
		CommonUtils.loadAndroidConfProp(loadPropertyFile);
		CommonUtils.setAndroidCapabilities();
		driver = CommonUtils.getAndroidDriver();
		ctx.setAttribute(null, this.driver);
		log.info("Starting test execution.");
		System.out.println("SESSION CREATED : "+driver.getSessionId().toString());
		driver.manage().timeouts().implicitlyWait(200L, TimeUnit.SECONDS);
		//Thread.sleep(3000);
		
	}
	
	@AfterClass
	//@AfterTest
	//@AfterMethod
	public void tearDown () {
		driver.quit();
	
	}
		

}
