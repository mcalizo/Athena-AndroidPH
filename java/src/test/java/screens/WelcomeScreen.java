package screens;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ru.yandex.qatools.allure.annotations.Step;


public class WelcomeScreen extends ScreenBase {
	
	//@WithTimeout(time = 35, unit = TimeUnit.SECONDS)
	@AndroidFindBy(id="ph.com.sulit.app:id/tutStart")
	public MobileElement skipWelcome;

	public WelcomeScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit.SECONDS), this);
	}
	
	@Step("User click skip welcome button in welcome screen")
	public void skipWelcomeScreen () {
		clickElements(skipWelcome);
	}
	
	@Step("Verify skip welcome button in welcome screen")
	public void validateSkipWelcomeButton () {
		Assert.assertTrue(skipWelcome.isDisplayed());
	}

}
