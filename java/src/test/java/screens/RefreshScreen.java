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

public class RefreshScreen extends ScreenBase {
	
	
	@AndroidFindBy(id="ph.com.sulit.app:id/currentPostingDateContainer")
	public MobileElement AdDate;
	@AndroidFindBy(xpath="//*[text='Express Refresh']")
	public MobileElement RefreshText;
	@AndroidFindBy(id="ph.com.sulit.app:id/btnExpressRefresh")
	public MobileElement ContinueButton;
	@AndroidFindBy(id="ph.com.sulit.app:id/currentBalanceContainer")
	public MobileElement CurrentBalance;
	@AndroidFindBy(id="ph.com.sulit.app:id/optionOlxGold")
	public MobileElement UseOLXGold;
	@AndroidFindBy(id="ph.com.sulit.app:id/sdl_button_positive")
	public MobileElement confirmButton;
	@AndroidFindBy(id="ph.com.sulit.app:id/sdl_button_negative")
	public MobileElement cancelButton;
	@AndroidFindBy(id="ph.com.sulit.app:id/sdl_message")
	public MobileElement refreshConfirmTextElement;
	@AndroidFindBy(id="ph.com.sulit.app:id/sdl_title")
	public MobileElement refreshPurchasedTitleElement;
	@AndroidFindBy(id="ph.com.sulit.app:id/optionOlxGold")
	public MobileElement optionOlxGold;
	@AndroidFindBy(id="ph.com.sulit.app:id/currentBalanceContainer")
	public MobileElement currentBalanceContainer;
	
	public String refreshPurchased = "Refresh Purchased!";
	public String refreshConfirmMsg = "Refreshing this ad will deduct 50 OLX Gold Credits from your balance. Tap confirm to proceed.";
	//@AndroidFindBy(xpath="//*[text='OK']")
	//public MobileElement okButton;


	public RefreshScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit.SECONDS), this);
	}
	
	@Step("verify Refresh text is Displayed")
	public void validateRefreshTextisPresent(){
		assert RefreshText.isDisplayed();


	}
	
	@Step("Verify Ad date is Displayed")
	public void validateAdDateisPresent(){
		assert AdDate.isDisplayed();
	}
	
	@Step("Verify OLX Gold Option is Displayed")
	public void validateUseOLXGoldisPresent(){
		assert UseOLXGold.isDisplayed();
	
	}
	
	@Step("Verify user can tap Continue Button")
	public void TapContinueButton(){
		ContinueButton.click();
	}
	
	@Step("Verify user can tap Confirm Button")
	public void TapConfirmButton(){
		confirmButton.click();
	}
	
	@Step("Verify user can tap Cancel Button")
	public void TapCancelButton(){
		cancelButton.click();
	}
	
	@Step("Verify user can tap OK Button")
	public void TapOKButton(){
		confirmButton.click();
	}
	
	@Step("Verify refresh confirmation message.")
	public void verifyRefreshConfirmationMessage(){
		Assert.assertEquals(refreshConfirmTextElement.getText(), refreshConfirmMsg);
	}
	
	@Step("Verify refresh purchased message title.")
	public void verifyRefreshPurchasedMessageTitle(){
		Assert.assertEquals(refreshPurchasedTitleElement.getText(), refreshPurchased);
	}
	
	@Step("User click/tap OLX Gold as payment option")
	public void userClickOlxGoldAsPaymentOption(){
		clickElements(optionOlxGold);
	}
	
	@Step("Verify OLX Gold Current Balance element is displayed")
	public void verifyOlxGoldCurrentBalanceElementIsDisplayed(){
		Assert.assertTrue(currentBalanceContainer.isDisplayed());
	}
		
}