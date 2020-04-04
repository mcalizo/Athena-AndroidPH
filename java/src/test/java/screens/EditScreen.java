package screens;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

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

public class EditScreen extends ScreenBase {
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@index='0']")
	public MobileElement backButton;
	@AndroidFindBy(id="ph.com.sulit.app:id/image")
	public MobileElement photo;
	


	public EditScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit.SECONDS), this);
	}
	
	@Step("verify user can tap back button")
	public void tapbackButton (){
		backButton.click();
	
	}
	
	@Step("verify if ad photo is Displayed")
	public void validateadPhotoisPresent(){
		Assert.assertTrue(photo.isDisplayed());
		
	}	
	
}