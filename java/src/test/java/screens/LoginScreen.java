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

public class LoginScreen extends ScreenBase {
	
	//@WithTimeout(time = 35, unit = TimeUnit.SECONDS)
	@AndroidFindBy(id="ph.com.sulit.app:id/txtLoggingIn")
	public MobileElement txtLoggingIn;
	//@WithTimeout(time = 35, unit = TimeUnit.SECONDS)
	@AndroidFindBy(id="ph.com.sulit.app:id/facebookLogin")
	public MobileElement facebookLogin;
	//@WithTimeout(time = 35, unit = TimeUnit.SECONDS)
	@AndroidFindBy(id="ph.com.sulit.app:id/registerBtn")
	public MobileElement registerBtn;
	//@WithTimeout(time = 35, unit = TimeUnit.SECONDS)
	@AndroidFindBy(id="ph.com.sulit.app:id/loginBtn")
	public MobileElement loginBtn;	

	public LoginScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit.SECONDS), this);
	}
	
	@Step("Verify facebook button is displayed")
	public void validateFacebookButton () {
		Assert.assertTrue(facebookLogin.isDisplayed());
	}
	@Step("Verify Login to My Account button is displayed")
	public void validateLoginToMyAccountButton () throws Throwable {
		Assert.assertTrue(loginBtn.isDisplayed());
	}
	
	@Step("Verify Create Account button is displayed")
	public void validateCreateAnAccountButton () {
		Assert.assertTrue(registerBtn.isDisplayed());
	}
	
	@Step("User tap facebook button")
	public void clickFacebookButton () {
		clickElements(facebookLogin);
	}
	
	@Step("User tap Login To My Account button")
	public void clickLoginToMyAccountButton () throws Throwable {
		clickElements(loginBtn);
		Thread.sleep(2000);
	}
	
	@Step("User tap Create An Account button")
	public void clickCreateAnAccountButton () {
		clickElements(registerBtn);
	}
	
	@Step("Verify text displayed in Login screen")
	public void validateSomeTextInLoginScreen () {
		assert txtLoggingIn.getText().equals("By signing up or logging in, you accept our");
	}
	
	@Step("User access OLX app but not logged in")
	public void givenStepforReporting () {
		//System.out.println("User access the app and not logged in");
	}
}
