package screens;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ru.yandex.qatools.allure.annotations.Step;

public class ManageAdsScreen extends ScreenBase {
	
	@AndroidFindBy(id="ph.com.sulit.app:id/toolbar_title")
	public MobileElement ManageAdspage;
	@AndroidFindBy(xpath="//android.support.v7.app.ActionBar$Tab[@index='0']")
	public MobileElement ActiveAds;	
	@AndroidFindBy(id="ph.com.sulit.app:id/navigation_icon")
	public MobileElement Leftdrawer;
	@AndroidFindBy(xpath="//*[@text='Home']")
	public MobileElement LeftdrawerHome;
	@AndroidFindBy(id="ph.com.sulit.app:id/moreActions")
	public MobileElement tapMoreAction;
	@AndroidFindBy(xpath="//*[@text='Edit']")
	public MobileElement EditButton;
	@AndroidFindBy(id="ph.com.sulit.app:id/mainActionButton")
	public MobileElement Refreshbutton;
	@AndroidFindBy(id="ph.com.sulit.app:id/price")
	public MobileElement AdPrice;
	@AndroidFindBy(id="ph.com.sulit.app:id/title")
	public MobileElement AdTitle;
	
	String manageAdsTitle = "Manage Ads";


	public ManageAdsScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit.SECONDS), this);
	}
	
	@Step("Verify Manage Ads is Displayed")
	public void validateManageAdsisPresent(){
		Assert.assertEquals(ManageAdspage.getText(), manageAdsTitle);
	}
	
	@Step("Verify Active Ads is Displayed")
	public void validateActiveadsisPresent(){
		assert ActiveAds.isDisplayed();
	}
	
	@Step("User tap left drawer")
	public void TapLeftdrawer() {
		Leftdrawer.click();
	}
	
	@Step("Verify user can tap home")
	public void TapHome() {
		LeftdrawerHome.click();
		
	}
	
	@Step("Verify user can tap more action button")
	public void MoreactionButton() {
		tapMoreAction.click();
		
	}
	
	@Step("Verify user can tap edit")
	public void TapEdit() {
		EditButton.click();
		
	}
	
	@Step("Verify user can tap refresh")
	public void TapRefresh() {
		Refreshbutton.click();
	
	}
	
	public void Taphome() {
		LeftdrawerHome.click();
	
	}
	
	public void Tapleftdrawer() {
		Leftdrawer.click();
	}
	
}
