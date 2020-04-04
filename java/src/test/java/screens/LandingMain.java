package screens;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ScreenBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import ru.yandex.qatools.allure.annotations.Step;

public class LandingMain extends ScreenBase {
	
	LeftNavigation leftnav;
	public String searchKeyword1 = "iphone";
	public String buyerSearchKeyword = "Breast pump slightly use used only for 3 months by OLX";
	
	@AndroidFindBy(id="ph.com.sulit.app:id/searchEditText_input")
	public MobileElement searchEditText_input;	
	@AndroidFindBy(id="ph.com.sulit.app:id/sell_button")
	public MobileElement sell_button;	
	@AndroidFindBy(id="ph.com.sulit.app:id/sponsored_ribbon")
	public MobileElement sponsored_ribbon;	
	@AndroidFindBy(id="ph.com.sulit.app:id/button_skip")
	public MobileElement skipLocation;
	@AndroidFindBy(id="ph.com.sulit.app:id/imageView_arrow_back")
	public MobileElement leftDrawerIntro;
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='2']")
	public MobileElement clickHome;	
	//@AndroidFindBy(xpath="//android.support.v7.widget.RecyclerView[@index='0']/android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='0']")
	@AndroidFindBy(id="ph.com.sulit.app:id/image")
	public MobileElement clickOrganicAd;
	//@AndroidFindBy(xpath="//android.support.v7.widget.RecyclerView[@index='0']/android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
	@AndroidFindBy(id="ph.com.sulit.app:id/price")
	public MobileElement organicAdPrice;
	//@AndroidFindBy(xpath="//android.support.v7.widget.RecyclerView[@index='0']/android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='2']")
	@AndroidFindBy(id="ph.com.sulit.app:id/title")
	public MobileElement organicAdTitle;
	//@AndroidFindBy(xpath="//android.support.v7.widget.RecyclerView[@index='0']/android.widget.FrameLayout[@index='2']/android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='0']")
	@AndroidFindBy(id="ph.com.sulit.app:id/image")
	public MobileElement clickOrganicAd2;
	//@AndroidFindBy(xpath="//android.support.v7.widget.RecyclerView[@index='0']/android.widget.FrameLayout[@index='2']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
	@AndroidFindBy(id="ph.com.sulit.app:id/price")
	public MobileElement organicAd2Price;
	//@AndroidFindBy(xpath="//android.support.v7.widget.RecyclerView[@index='0']/android.widget.FrameLayout[@index='2']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='2']")
	@AndroidFindBy(id="ph.com.sulit.app:id/title")
	public MobileElement organicAd2Title;
	@AndroidFindBy(id="ph.com.sulit.app:id/imageView_arrow_back")
	public MobileElement leftDrawer;
	@AndroidFindBy(xpath="//*[@content-desc='Content Description']")
	public MobileElement leftNavWidget;
	@AndroidFindBy(xpath="//*[@text='Mobile Phones and Tablets']")
	public MobileElement cateMobilePhoneAndTablets;
	@AndroidFindBy(xpath="//*[@text='home'")
	public MobileElement tapHome;
	@AndroidFindBy(id="ph.com.sulit.app:id/buynowfeeds")
	public MobileElement tapviewbuynow;
	@AndroidFindBy(xpath="//*[@text='Buy Now Ads']")
	public MobileElement tapBuyNowAds;
	@AndroidFindBy(xpath="//*[@text='Orders']")
	public MobileElement tapOrders;
	@AndroidFindBy(xpath="//*[@text='Manage Ads']")
	public MobileElement tapManage;
	@AndroidFindBy (xpath="//*[@text='Chat']")
	public MobileElement leftDrawerChat;
	@AndroidFindBy(xpath="//*[@text='Browse ads']")
	public MobileElement BrowseAds;
	
	public LandingMain(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit.SECONDS), this);
	}
	
	@Step("Verify skip welcome button in welcome screen")
	public void validateSearchTextInputPresent () {
		//searchEditText_input.isDisplayed();
		Assert.assertTrue(searchEditText_input.isDisplayed());
	}
	
	@Step("Verify Sell Button is displayed")
	public void validateSellButtonPresent () {
		Assert.assertTrue(sell_button.isDisplayed());
	}
	
	@Step("Verify Sponsored ads is displayed")
	public void validateSponsoredAdsPresent () {
		Assert.assertTrue(sponsored_ribbon.isDisplayed());
	}
	
	@Step("User tap an Ad")
	public void clickFirstOrganiclAd() throws Exception {
//		Thread.sleep(3000);
//		System.out.println("Tap Left Nav");
//		leftNavWidget.click();
//		Thread.sleep(2000);
//		System.out.println("Tap on screen");
//		new TouchAction(driver).tap(1000, 300).waitAction(2000).perform();	
//		Thread.sleep(2000);
		organicAdPrice.click();
	}

	@Step("User Click the No Thanks Button")
	public void clickNoThanksButton(){
		skipLocation.click();
	}
	
	@Step("User Click the Left Drawer")
	public void clickLeftDrawerIntro() throws Throwable {
		Thread.sleep(2000);
		leftDrawerIntro.click();
				
	}
	
	@Step("User Click the Home in Menu")
	public void clickHomeMenu(){
		clickHome.click();
	}
	
	
	@Step("User tap an Ad")
	public void clickSecondOrganiclAd() throws Throwable {
		Thread.sleep(3000);
		clickOrganicAd2.click();	
	}
		
	@Step("User Click the Left Drawer Menu")
	public void tapLeftDrawerMenu() throws Exception{
		leftDrawer.click();
		Thread.sleep(2000);
	}
	
	@Step("User Search an Ad")
	public void enterSearchKeyword () {
		searchEditText_input.click();
		sendKeysElements(searchEditText_input, searchKeyword1);
		((AndroidDriver<?>)driver).pressKeyCode(AndroidKeyCode.ENTER);
	}	

	@Step("Tap left navigation widget")
	public void tapLeftNavigationWidget() throws Throwable {
		//Thread.sleep(2000);
		leftNavWidget.click();
//		System.out.println("Tap on screen");
//		new TouchAction(driver).tap(1000, 300).waitAction(2000).perform();
//		leftNavWidget.click();
//		Thread.sleep(2000);
//		swipingTopToBottom();
		
		//driver.swipe(700, 280, 700, 1900, 5000);
		//Thread.sleep(2000);	
	}
	
	public void skipTutorialInLanding () throws Throwable {
		Thread.sleep(5000);
		leftNavWidget.click();
		Thread.sleep(2000);
		System.out.println("Tap on screen");
		new TouchAction(driver).tap(1000, 1600).waitAction(2000).perform();
		Thread.sleep(2000);

		miniSwipingBottomToTop();
	}
	
	@Step("User navigate to Home via left drawer")
	public void userNavigateToHomeViaLeftDrawer () throws Throwable {
		
		leftNavWidget.click();
		Thread.sleep(2000);
		swipingTopToBottom();
		
		leftnav = new LeftNavigation(driver);
		leftnav.tapHome.click();
		Thread.sleep(2000);
	}

	@Step("Get out left navigation")
	public void tapLeftNavigationWidgetThenOut() throws Throwable {
		Thread.sleep(3000);
		leftNavWidget.click();
		Thread.sleep(2000);
		System.out.println("Tap on screen");
		new TouchAction(driver).tap(1018, 330).waitAction(2000).perform();
	}
	
	@Step("Tap Left navigation")
	public void Tapleftnavigation() throws Throwable {
		Thread.sleep(3000);
		leftDrawer.click();	
	}	
	
	@Step("User access the app and already logged in")
	public void givenStepforReporting () {
		//System.out.println("User access the app and not logged in");
	}
	
	@Step ("tap buy now")
	public void tapbanner() {
		tapviewbuynow.click();
	
	}	
	
	@Step ("tap buy now")
	public void buynowDrawer() {
		tapBuyNowAds.click();
		
	}	
	
	@Step ("Tap Orders")
	public void tapOrdersDrawer() {
		tapOrders.click();
		
	}
	
	@Step ("Tap ManageAds")
	public void tapManageAds() {
		tapManage.click();
		
	}
	
	public void buynowdrawer() {
		tapBuyNowAds.click();
		
	}	
	
	public void tapleftdrawermenu() throws Exception{
		leftDrawer.click();
		Thread.sleep(2000);
	}	
	
	public void tapBanner() {
		tapviewbuynow.click();
	
	}
	
	@Step("Buyer Search an Ad")
	public void buyerEnterSearchKeyWord () {
		searchEditText_input.click();
		sendKeysElements(searchEditText_input, buyerSearchKeyword);
		((AndroidDriver<?>)driver).pressKeyCode(AndroidKeyCode.ENTER);
	}	

	@Step ("Tap Browse in Left Drawer")
	public void tapBrowseAds() {
		BrowseAds.click();	
	}
}