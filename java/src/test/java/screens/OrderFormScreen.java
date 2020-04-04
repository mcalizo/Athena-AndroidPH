package screens;

import java.util.concurrent.TimeUnit;

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

public class OrderFormScreen extends ScreenBase {
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@index='0']")
	public MobileElement backButton;
	@AndroidFindBy(id="ph.com.sulit.app:id/webView")
	public MobileElement orderForm;
	@AndroidFindBy(xpath="//*[@text='OLX Philippines']")
	public MobileElement OLXPH;
	@AndroidFindBy(id="ph.com.sulit.app:id/action_bar")
	public MobileElement TopBar;
	
	
	//@AndroidFindBy("")
	//public WebElement name;
	

	public OrderFormScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit.SECONDS), this);
	}
	
	@Step("verify if Back button is Tappable")
	public void tapbackButton() throws Throwable{
		Thread.sleep(5000);
		backButton.click();

	}
	
	@Step("Verify Order Form is Displayed")
	public void validateOrderformPresent(){
		assert orderForm.isDisplayed();
	}
	
	@Step("Verify Order Form is Displayed")
	public void validatetextPresent(){
		assert OLXPH.isDisplayed();

	}	
	
	@Step("Verify Order Form is Displayed")
	public void validateTopBarPresent(){
		assert TopBar.isDisplayed();
	
	}	
}

	