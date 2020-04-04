package screens;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class AccountLoginScreen extends ScreenBase {
	
	//@WithTimeout(time = 35, unit = TimeUnit.SECONDS)
	@AndroidFindBy(id="ph.com.sulit.app:id/edtEmail")
	public MobileElement loginUserMain;
	//@WithTimeout(time = 35, unit = TimeUnit.SECONDS)
	@AndroidFindBy(xpath="//*[@content-desc='loginUser']")
	public MobileElement loginUser;
	//@WithTimeout(time = 35, unit = TimeUnit.SECONDS)
	@AndroidFindBy(xpath="//*[@content-desc='loginPassword']")
	public MobileElement loginPassword;
	//@WithTimeout(time = 35, unit = TimeUnit.SECONDS)
	@AndroidFindBy(id="ph.com.sulit.app:id/btnLogInNew")
	public MobileElement btnLogInNew;
	//@WithTimeout(time = 35, unit = TimeUnit.SECONDS)
	@AndroidFindBy(id="ph.com.sulit.app:id/txtForgetPassword")
	public MobileElement txtForgetPassword;
	//@WithTimeout(time = 35, unit = TimeUnit.SECONDS)
	@AndroidFindBy(id="ph.com.sulit.app:id/btnCreateAccount")
	public MobileElement btnCreateAccount;
	@AndroidFindBy(id="ph.com.sulit.app:id/errorMsg")
	public MobileElement errorMessage;
	@AndroidFindBy(xpath="//*[@content-desc='Navigate up']")
	public MobileElement backToLoginMain;
	
	public String mobileNumber = "09218943165";
	public String password = "#1234qwer";
	public String buyerMobileNumber = "09157694429";
	

	public AccountLoginScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit.SECONDS), this);
	}
	
	@Step("User enter valid mobile number")
	public void enterMobileEmail () {
		loginUser.clear();
		sendKeysElements(loginUser, mobileNumber);
	}
	
	@Step("User enter valid password")
	public void enterPassword () {
		loginPassword.clear();
		sendKeysElements(loginPassword, password);
	}
	
	@Step("User tap Login To My Account button")
	public void clickLoginToMyAccount () {
		clickElements(btnLogInNew);
		
	}
	
	@Step("User tap forgot passwordd ")
	public void clickForgotPassword () {
		clickElements(txtForgetPassword);
	}
	
	@Step("User tap Create account button")
	public void clickCreateAccount () {
		clickElements(btnCreateAccount);
		
	}
	
	@Step("Verify input mobile element is displayed")
	public void validateAcctLogginMobileEmailElement() {
		Assert.assertTrue(loginUser.isDisplayed());
	}
	
	@Step("User enter invalid password")
	public void enterInvalidPassword() {
		loginPassword.clear();
		sendKeysElements(loginPassword, "1234qwer");
	}
	
	@Step("Verify error message display for invalid credentials")
	public void errorMessageDisplayForInvalidCredentials() {
		Assert.assertEquals(errorMessage.getText(), "Invalid login or password");
	}
	
	@Step("User enter invalid email format")
	public void enterInvalidEmailFormat() {
		loginUser.clear();
		sendKeysElements(loginUser, "@invalidEmailFormat.com");
	}
	
	@Step("Verify login elements is present/exists")
	public void verifyLoginElementsIsPresent () {
		Assert.assertTrue(loginUser.isDisplayed());
		Assert.assertTrue(loginPassword.isDisplayed());
	}
	
	public void backToLoginMain() {
		clickElements(backToLoginMain);
	}
	
	@Step("Buyer enter registered mobile number")
	public void enterBuyerRegisteredMobile () {
		loginUser.clear();
		sendKeysElements(loginUser, buyerMobileNumber);
	}
	
	@Step("Seller enter valid mobile number")
	public void SellerEnterMobileEmail () {
		loginUser.clear();
		sendKeysElements(loginUser, mobileNumber);
	}
	
}
