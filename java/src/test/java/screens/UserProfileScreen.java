package screens;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ru.yandex.qatools.allure.annotations.Step;

public class UserProfileScreen extends ScreenBase {

	
	@AndroidFindBy(id="ph.com.sulit.app:id/main.imageview.placeholder")
	public MobileElement ProfileBackground;	
	@AndroidFindBy(id="ph.com.sulit.app:id/profilePhoto")
	public MobileElement ProfilePhoto;
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@index='0']")
	public MobileElement UserAd1;
	//@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='5']/android.support.v7.widget.RecyclerView[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[index='1']")
	//public MobileElement AdPrice;
	//@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='5']/android.support.v7.widget.RecyclerView[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[index='2']")
	//public MobileElement AdTitle;
	@AndroidFindBy(xpath ="//android.widget.ImageButton[@index='0']")
	public MobileElement BackButton;
	@AndroidFindBy(id="ph.com.sulit.app:id/price")
	public MobileElement AdPrice;
	@AndroidFindBy(id="ph.com.sulit.app:id/adTitle")
	public MobileElement AdTitle;
	
		
	public UserProfileScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit.SECONDS), this);
	}
	
	@Step("Verify Background placeholder is displayed")
	public void validateProfileBackground () {
		ProfileBackground.isDisplayed();
	}
	
	@Step("verify User Profile Photo is Displayed")
	public void validateProfilePhoto () {
		ProfilePhoto.isDisplayed();
	
	}
	
	@Step("Verify User Ad")
	public void TapUserAd () {
		AdTitle.click();
		
	}
	
	@Step("Verify Ad Price")
	public void validateAdPrice () {
		AdPrice.isDisplayed();
	}
	
	@Step("Verify Ad Title")
	public void validateAdTitle () {
		AdTitle.isDisplayed();
	}
	
	@Step("Click Back Button")
	public void TapBackButton () {
		BackButton.click();
	}	
		
}