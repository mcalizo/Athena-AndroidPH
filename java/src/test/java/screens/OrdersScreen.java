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

public class OrdersScreen extends ScreenBase {
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@index='0']")
	public MobileElement BackButton;
	@AndroidFindBy(id="ph.com.sulit.app:id/webView")
	public MobileElement Orders;
	@AndroidFindBy(xpath="//*[@text='OLX Philippines']")
	public MobileElement OlxPH;
	@AndroidFindBy(id="ph.com.sulit.app:id/action_bar")
	public MobileElement TopBar;


	public OrdersScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit.SECONDS), this);
	}
	
	@Step("verify if Back button is Tappable")
	public void TapBackButton() throws Throwable{
		Thread.sleep(5000);
		BackButton.click();

	}
	
	@Step("Verify Order Form is Displayed")
	public void validateOrdersisPresent(){
		assert Orders.isDisplayed();
	}
	
	@Step("Verify Order Form is Displayed")
	public void validatetextPresent(){
		assert OlxPH.isDisplayed();

	}	
	
	@Step("Verify Order Form is Displayed")
	public void validateTopBarPresent(){
		assert TopBar.isDisplayed();
	
	}	
}

	
