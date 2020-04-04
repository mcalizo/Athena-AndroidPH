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

public class CreateAccountScreen extends ScreenBase{
	
	@AndroidFindBy(xpath="//*[@content-desc='registerName']")
	public MobileElement registerName;
	@AndroidFindBy(xpath="//*[@content-desc='registerNumber']")
	public MobileElement registerNumber;
	@AndroidFindBy(xpath="//*[@content-desc='registerPassword1']")
	public MobileElement registerPassword1;
	@AndroidFindBy(xpath="//*[@content-desc='registerPassword2']")
	public MobileElement registerPassword2;
	@AndroidFindBy(id="ph.com.sulit.app:id/btnRegister")
	public MobileElement registerButton;
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='2']/android.widget.LinearLayout[@index='0']/android.widget.FrameLayout[@index='1']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='1']")
	public MobileElement errorMessagingFieldName;
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='3']/android.widget.LinearLayout[@index='0']/android.widget.FrameLayout[@index='1']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='1']")
	public MobileElement errorMessagingFieldMobile;
	@AndroidFindBy(id="ph.com.sulit.app:id/errorMsg")
	public MobileElement passwordNotMatch;
	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Navigate up' and @index='0']")
	public MobileElement tapBackPrevScreen;
	
	public CreateAccountScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit.SECONDS), this);
	}
	
	@Step("User enter a valid name")
	public void userEnterAvalidName () {
		registerName.clear();
		sendKeysElements(registerName, "QA Auto");
	}
	
	@Step("User enter a registered mobile number")
	public void userEnterAvalidRegisteredMobileNumber () {
		registerNumber.clear();
		sendKeysElements(registerNumber, "09218943165");
	}
	
	@Step("User enter not registered mobile number")
	public void userEnterNotRegisteredMobileNumber () {
		registerNumber.clear();
		sendKeysElements(registerNumber, "09218943005");
	}
	
	@Step("User enter an invalid mobile number")
	public void userEnterAnInvalidMobileNumber () {
		registerNumber.clear();
		sendKeysElements(registerNumber, "09218943165--");
	}
	
	@Step("User enter password")
	public void userEnterPassword () {
		registerPassword1.clear();
		sendKeysElements(registerPassword1, "#1234qwer");
	}
	
	@Step("User enter repeat password")
	public void userEnterRepeatPassword () {
		registerPassword2.clear();
		sendKeysElements(registerPassword2, "#1234qwer");
	}
	
	@Step("User enter different password")
	public void userEnterDifferentPassword () {
		registerPassword2.clear();
		sendKeysElements(registerPassword2, "#1234qwerty");
	}
	
	@Step("User tap Create Account button")
	public void userTapCreateAccountButton () {
		clickElements(registerButton);
		
	}
	
	@Step("Verify error message display for already registered mobile number")
	public void verifyErrorMessageDisplayForAlreadyRegisteredMobileNumber() {
		Assert.assertEquals(errorMessagingFieldMobile.getText(), "Mobile already registered.");
	}
	
	@Step("Verify error message display for invalid mobile number")
	public void verifyErrorMessageDisplayForInvalidMobileNumber() {
		Assert.assertEquals(errorMessagingFieldMobile.getText(), "Please enter a valid number. E.g.: 09xxxxxxxxx, 63xxxxxxxxxx");
	}
	
	@Step("Verify error message display for password do not match")
	public void verifyErrorMessageDisplayForPasswordDoNotMatch() {
		Assert.assertEquals(passwordNotMatch.getText(), "Passwords do not match");
	}
	
	@Step("Verify error message display for blank/empty name")
	public void verifyErrorMessageDisplayForBlankOrEmptyName() {
		Assert.assertEquals(errorMessagingFieldName.getText(), "Required Field");
	}
	
	@Step("Verify error message display for blank/empty mobile number")
	public void verifyErrorMessageDisplayForBlankOrEmptyMobileNumber() {
		Assert.assertEquals(errorMessagingFieldMobile.getText(), "Required Field");
	}
	
	@Step("Verify name fields displayed in Create Account screen")
	public void verifyNameFieldsDisplayedInCreateAccountScreen() {
		registerName.isDisplayed();
	}
	
	@Step("Verify mobile number fields displayed in Create Account screen")
	public void verifyMobileNumberFieldsDisplayedInCreateAccountScreen() {
		registerNumber.isDisplayed();
	}
	
	@Step("Verify password fields displayed in Create Account screen")
	public void verifyPasswordFieldsDisplayedInCreateAccountScreen() {
		registerPassword1.isDisplayed();
	}
	
	@Step("Verify repeat password fields displayed in Create Account screen")
	public void verifyRepeatPasswordFieldsDisplayedInCreateAccountScreen() {
		registerPassword2.isDisplayed();
	}
	
	public void backToPreviousScreen() {
		clickElements(tapBackPrevScreen);
	}

}
