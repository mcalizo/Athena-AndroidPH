package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

/**
 * @author magagan@olx.ph
 */

public class CommonUtils {
	
	public static int IMPLICIT_WAIT_TIME;
	public static int EXPLICIT_WAIT_TIME;
	public static String APP_PACKAGE;
	public static String APP_PATH;
	public static String APP_PATH2;
	public static String APP_ACTIVITY;
	public static String BROWSER_NAME;
	public static String PLATFORM_NAME;
	public static String PLATFORM_VERSION;
	public static String DEVICE_NAME;
	public static String AUTOMATION_NAME;
	public static String APPIUM_PORT;
	public static String SCREENSHOT_DIR;
	public static URL serverUrl;
		
	private static Properties prop = new Properties();
	private static DesiredCapabilities capabilities = new DesiredCapabilities();
	
	private static AppiumDriver<MobileElement> driver;
	
	//public static JSONArray array;
	
	public static void loadAndroidConfProp(String propertyFileName) throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/" + propertyFileName);
		prop.load(fis);
		
		IMPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("implicit.wait"));
		EXPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("explicit.wait"));
		APP_PATH = prop.getProperty("application.path");
		APP_PATH2 = prop.getProperty("application.path2");
		APP_PACKAGE = prop.getProperty("app.pkg");
		APP_ACTIVITY = prop.getProperty("application.activity");
		BROWSER_NAME = prop.getProperty("browser.name");
		PLATFORM_NAME = prop.getProperty("platform.name");
		PLATFORM_VERSION = prop.getProperty("platform.version");
		AUTOMATION_NAME = prop.getProperty("automation.name");
		DEVICE_NAME = prop.getProperty("devicen.name");
		APPIUM_PORT = prop.getProperty("appium.server.port");
		SCREENSHOT_DIR = prop.getProperty("screenshot.dir");
		
	}
	
	public static void setAndroidCapabilities(){
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		//capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_NAME);
		capabilities.setCapability(MobileCapabilityType.APP, APP_PATH2);
		
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
        
        capabilities.setCapability(AndroidMobileCapabilityType.ANDROID_DEVICE_READY_TIMEOUT, 120);
        capabilities.setCapability("newCommandTimeout", 300);
        capabilities.setCapability("autoGrantPermissions", true);
		
        //No Reset Apps
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        
        //driver = new AndroidDriver(new URL("http://athena-appium:4723/wd/hub"), capabilities);
        //driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);		
		
		
	}
		
	public static AppiumDriver<MobileElement> getAndroidDriver() throws MalformedURLException{
		
		//serverUrl = new URL("http://athena-appium:" + APPIUM_PORT + "/wd/hub");
		//serverUrl = new URL("http://localhost:" + "4729" + "/wd/hub");
		//serverUrl = new URL("http://127.0.0.1:" + "4444" + "/wd/hub");
		//serverUrl = new URL("http://localhost:" + "4723" + "/wd/hub");
		serverUrl = new URL("http://athena-selenium-hub:" + "4444" + "/wd/hub");
		driver = new AndroidDriver<MobileElement>(serverUrl,capabilities);
		//driver.manage().timeouts().implicitlyWait(200L, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public static void takeScreenshot() throws Exception{
		DateTimeFormatter.ofPattern("yyyy-MM-dd");
		TimeZone.getTimeZone("UTC");
		
		final SimpleDateFormat dateFormatLocal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
		dateFormatLocal.setTimeZone(TimeZone.getTimeZone("UTC"));
		final String timeStamp = dateFormatLocal.format(new Date());
		
		
		String screenshotDate = LocalDate.now() + "-" + SCREENSHOT_DIR;
		
    	File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	
    	new File(SCREENSHOT_DIR + screenshotDate).mkdirs();
    	//FileUtils.copyFile(file, new File(SCREENSHOT_DIR + screenshotDate + new Timestamp(System.currentTimeMillis())+".png"));
    	FileUtils.copyFile(file, new File(SCREENSHOT_DIR + screenshotDate + timeStamp +".png"));
    
	}
	
	public static void takeScreenshot2() throws Exception{
		DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//TimeZone.getTimeZone("PST");
		
		SimpleDateFormat dateFormatLocal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
		String localTime = dateFormatLocal.format(new Date());
		Date date = dateFormatLocal.parse(localTime);
		TimeZone tz = TimeZone.getDefault();
		
		SimpleDateFormat sdfPh = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
		TimeZone tzInPh = TimeZone.getTimeZone("Asia/Manila");
		sdfPh.setTimeZone(tzInPh);
		
		String timeStamp = sdfPh.format(date);
				
		String screenshotDate = LocalDate.now() + "-" + SCREENSHOT_DIR;
		
    	File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	
    	new File(SCREENSHOT_DIR + screenshotDate).mkdirs();
    	//FileUtils.copyFile(file, new File(SCREENSHOT_DIR + screenshotDate + new Timestamp(System.currentTimeMillis())+".png"));
    	FileUtils.copyFile(file, new File(SCREENSHOT_DIR + screenshotDate + timeStamp +".jpg"));
    
	}
	

}
