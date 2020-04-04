package base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utility.CommonUtils;
import ru.yandex.qatools.allure.annotations.Attachment;

/**
 * @author magagan@olx.ph
 */
public class ScreenBase {
	
	public AppiumDriver<MobileElement> driver;
	Dimension size;
	
	public ScreenBase(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(200L, TimeUnit.SECONDS);
	}
	
    protected void waitForVisibilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Assert.assertTrue(isElementPresent(locator));
    }
    protected void waitForClickabilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    protected void WaitForClickabilityOf(By locator,int time){
    	WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    protected boolean isElementPresent(By by) {
   	try {   
			if (driver.findElement(by).isDisplayed()){
		     	return true;
			}else{
				return false;
			}
		} catch (NoSuchElementException e) {
			return false;
		}
	}
    
    protected boolean isWaitElementPresent(By by){
     try {
    	 waitForVisibilityOf(by);
    	 return true;
     } catch (NoSuchElementException e){
    	 return false;
     }
    	
    }
    
    protected void clickElement(By by){
    	//waitForClickabilityOf(by);
    	waitForVisibilityOf(by);
    	driver.findElement(by).click();
    }
    
    protected void clickElement(By by, int time){
    	WaitForClickabilityOf(by, time);
    	driver.findElement(by).click();
    }
    
    protected void clickElementWithoutWait(By by){
    	driver.findElement(by).click();
    }
    
    protected void sendKeysElement(By by,String keys){
    	waitForVisibilityOf(by);
    	driver.findElement(by).clear();
    	driver.findElement(by).sendKeys(keys);
    }
    
    protected void sendKeysElements(By locator,int index, String keys){
    	waitForVisibilityOf(locator);
    	WebElement element=getTextElements(locator, index);
    	element.clear();
    	element.sendKeys(keys);
    }
    
    protected void sendKeysElements(WebElement element,String keys){
        Assert.assertTrue(element.isDisplayed());
    	element.sendKeys(keys);
    }
    
    protected void clickElements(WebElement element){
        Assert.assertTrue(element.isDisplayed());
    	element.click();
    }
    
    public String getStringText(By locator){
       return driver.findElement(locator).getText();	
    }
    
    public By getTextLocator(String locator){
    	return By.xpath("//android.widget.TextView[@text='"+locator+"']");
    }

    public By getSwitchTextLocator(String locator) {
        return By.xpath("//android.widget.Switch[@text='"+locator+"']");
    }
    
    public By getEditTextLocator(String locator){
    	return By.xpath("//android.widget.EditText[@text='"+locator+"']");
    }

    public By getEditTextResource(String locator) { return By.xpath("//android.widget.EditText[@resource-id='"+locator+"']"); }
    
    public By getIdLocator(String locator){
    	return By.id(locator);
    }

    public By getImageLocator(String locator){
    	return By.xpath("//android.widget.ImageButton[@index='"+locator+"']");
    }
    
    public By getContentLocator(String locator){
    	return By.xpath("//android.widget.ImageButton[@content-desc='"+locator+"']");
    }

    public By getResourceLocator(String locator){ return By.xpath("//android.widget.ImageButton[@resource-id='"+locator+"']"); }
    
    public By getButtonLocator(String locator){
    	return By.xpath("//android.widget.Button[@text='"+locator+"']");
    }
    
    public By getAndroidViewLocator(int index){
    	return (By.xpath("//android.view.View[@clickable='True']"));
    }

    public By getToogleTextLocator(String locator ) { return (By.xpath("//android.widget.ToggleButton[@text='"+locator+"']")); }
    
    public By getSpinnerLocator(String locator){
    	return By.xpath("//android.widget.CheckedTextView[@text='"+locator+"']");
    }
            
    protected List<MobileElement> getListElements(By locator){
    	waitForVisibilityOf(locator);
    	List<MobileElement> elements = driver.findElements(locator);
    	return elements;
    }
    
    protected MobileElement getTextElements(By locator,int index){
    	waitForVisibilityOf(locator);
    	List<MobileElement> elements = driver.findElements(locator);
    	return elements.get(index);
    }
    
    protected int getSizeElements(By locator){
    	//waitForVisibilityOf(locator);
    	List<MobileElement> elements = driver.findElements(locator);
    	return elements.size();
    }
    
    
    @Attachment("{method}")
    public String getTextAttachment(String input) throws Exception{
    	return input;
    }
	
    
    public void scrollPageUp() {
        System.out.println("Scrolling the content..");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.50);
        swipeObject.put("startY", 0.95);
        swipeObject.put("endX", 0.50);
        swipeObject.put("endY", 0.01);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }


    public void swipeLeftToRight() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.01);
        swipeObject.put("startY", 0.5);
        swipeObject.put("endX", 0.9);
        swipeObject.put("endY", 0.6);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }

    public void swipeRightToLeft() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.9);
        swipeObject.put("startY", 0.5);
        swipeObject.put("endX", 0.01);
        swipeObject.put("endY", 0.5);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }

    public void swipeFirstCarouselFromRightToLeft() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.9);
        swipeObject.put("startY", 0.2);
        swipeObject.put("endX", 0.01);
        swipeObject.put("endY", 0.2);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }

    public void performTapAction(WebElement elementToTap) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> tapObject = new HashMap<String, Double>();
        tapObject.put("x", (double) 360); // in pixels from left
        tapObject.put("y", (double) 170); // in pixels from top
        tapObject.put("element", Double.valueOf(((RemoteWebElement) elementToTap).getId()));
        js.executeScript("mobile: tap", tapObject);
    }
    
    //creating sort descending
    public int[] sortDesc(int[] intArray) { 
        int n = intArray.length;
        int temp = 0;
        for(int i=0; i < n; i++){
                for(int j=1; j < (n-i); j++){  
                        if(intArray[j-1] < intArray[j]){
                                //swap the elements!
                                temp = intArray[j-1];
                                intArray[j-1] = intArray[j];
                                intArray[j] = temp;
                        }
                }
        }
        return intArray;
    }
    
    public void swipingLefToRight() throws InterruptedException {
    	  //Get the size of screen.
    	  size = driver.manage().window().getSize();
    	  System.out.println(size);
    	  
    	  //Find swipe start and end point from screen's with and height.
    	  //Find startx point which is at right side of screen.
    	  int startx = (int) (size.width * 0.70);
    	  //Find endx point which is at left side of screen.
    	  int endx = (int) (size.width * 0.30);
    	  //Find vertical point where you wants to swipe. It is in middle of screen height.
    	  int starty = size.height / 2;
    	  System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);

    	  //Swipe from Left to Right.
    	  driver.swipe(endx, starty, startx, starty, 3000);
    	  Thread.sleep(2000);
    }
    
	public void swipingRightToLeft() throws InterruptedException {
		  //Get the size of screen.
		  size = driver.manage().window().getSize();
		  System.out.println(size);
		  
		  //Find swipe start and end point from screen's with and height.
		  //Find startx point which is at right side of screen.
		  int startx = (int) (size.width * 0.70);
		  //Find endx point which is at left side of screen.
		  int endx = (int) (size.width * 0.30);
		  //Find vertical point where you wants to swipe. It is in middle of screen height.
		  int starty = size.height / 2;
		  System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);
		
		  //Swipe from Right to Left.
		  driver.swipe(startx, starty, endx, starty, 3000);
		  Thread.sleep(2000);
	  }

	 public void swipingTopToBottom() throws InterruptedException {
		  //Get the size of screen.
		  size = driver.manage().window().getSize();
		  System.out.println(size);
		   
		  //Find swipe start and end point from screen's with and height.
		  //Find starty point which is at bottom side of screen.
		  int starty = (int) (size.height * 0.95);
		  //Find endy point which is at top side of screen.
		  int endy = (int) (size.height * 0.20);
		  //Find horizontal point where you wants to swipe. It is in middle of screen width.
		  int startx = size.width / 2;
		  System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);
		
		  //Swipe from Top to Bottom.
		  System.out.println("startx = " + startx + " ,endy = " + endy + " , starty = " + starty + " , endy = " + endy);
		  driver.swipe(startx, endy, startx, starty, 3000);
		  Thread.sleep(2000);
	 }
    	 
	 public void swipingBottomToTop() throws InterruptedException {
		  //Get the size of screen.
		  size = driver.manage().window().getSize();
		  System.out.println(size);
		   
		  //Find swipe start and end point from screen's with and height.
		  //Find starty point which is at bottom side of screen.
		  int starty = (int) (size.height * 0.95);
		  //Find endy point which is at top side of screen.
		  int endy = (int) (size.height * 0.20);
		  //Find horizontal point where you wants to swipe. It is in middle of screen width.
		  int startx = size.width / 2;
		  System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);
		
		  //Swipe from Bottom to Top.
		  driver.swipe(startx, starty, startx, endy, 3000);
		  Thread.sleep(2000);
	 }
	 
	 public void miniSwipingBottomToTop() throws InterruptedException {
		  //Get the size of screen.
		  size = driver.manage().window().getSize();
		  System.out.println(size);
		   
		  //Find swipe start and end point from screen's with and height.
		  //Find starty point which is at bottom side of screen.
		  int starty = (int) (size.height * 0.50);
		  //Find endy point which is at top side of screen.
		  int endy = (int) (size.height * 0.35);
		  //Find horizontal point where you wants to swipe. It is in middle of screen width.
		  int startx = size.width / 2;
		  System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);
		
		  //Swipe from Bottom to Top.
		  driver.swipe(startx, starty, startx, endy, 3000);
		  Thread.sleep(2000);
	 }
	 
	    @Attachment(value = "{0}", type = "image/png")
		public byte[] getAttachment(String filename) throws Exception{
	    	takeScreenShotInFile(filename);
			return attachScreenShot(filename);
		}
	    
	    protected void takeScreenShotInFile(String filename) throws Exception{
	    	File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    	new File(CommonUtils.SCREENSHOT_DIR).mkdirs();
	    	FileUtils.copyFile(file, new File(CommonUtils.SCREENSHOT_DIR+filename));
	    }
	    
	    protected byte[] attachScreenShot(String filename) throws IOException{
	    	File file = new File(CommonUtils.SCREENSHOT_DIR+filename);
	    	FileOutputStream screenshotStream = new FileOutputStream(file);
	    	byte[] bytes =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);	
	    	screenshotStream.write(bytes);
	        screenshotStream.close();
	        return bytes;
	    }
}
