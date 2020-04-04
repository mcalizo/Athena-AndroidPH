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

public class FiltersScreen extends ScreenBase {
	
	@AndroidFindBy(id="ph.com.sulit.app:id/btnSubmit")
	public MobileElement SubmitButton;
	@AndroidFindBy(id="ph.com.sulit.app:id/action_clear")
	public MobileElement ClearButton;
	@AndroidFindBy(id="ph.com.sulit.app:id/sdl_button_positive")
	public MobileElement ClearModal;
	@AndroidFindBy(id="ph.com.sulit.app:id/value")
	public MobileElement Searchfield;
	@AndroidFindBy(xpath="//*[@text='Category']")
	public MobileElement ChooseCategory;
	@AndroidFindBy(xpath="//*[@text='Price (₱)']")
	public MobileElement PriceButton;
	@AndroidFindBy(xpath="//*[@text='From']")
	public MobileElement PriceRangeFrom;
	@AndroidFindBy(xpath="//*[@text='To']")
	public MobileElement PriceRangeTo;
	@AndroidFindBy(xpath="//*[@text='Ready']")
	public MobileElement ReadyButton;
	@AndroidFindBy(xpath="//*[@text='Condition']")
	public MobileElement Condition;
	@AndroidFindBy(xpath="//*[@text='2nd Hand (Used)']")
	public MobileElement SecondHand;
	@AndroidFindBy(xpath="//*[@text='Brand New']")
	public MobileElement BrandNew;
	@AndroidFindBy(xpath="//*[@text='All']")
	public MobileElement All;
	@AndroidFindBy(xpath="//*[@text='Ready']")
	public MobileElement Ready;
	


	public FiltersScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit.SECONDS), this);
	}
	
	@Step("Verify Clear button is Displayed")
	public void verifyclearbuttonisPresent () {
		Assert.assertTrue(ClearButton.isDisplayed());
		
	}
	
	@Step("Verify Submit button is Displayed")
	public void verifysubmitbuttonisPresent () {
		Assert.assertTrue(SubmitButton.isDisplayed());
		
	}
	
	public void tapClearButton () {
		ClearButton.click();
		
	}
	
	public void tapClearmodal () {
		ClearModal.click();
	}
	
	public void tapSubmitButton () {
		SubmitButton.click();
		
	}
	
	@Step("User Tap the Clear Button")
	public void tapclearbutton () {
		ClearButton.click();
		
	}
	
	@Step("User Tap the Clear Button in Modal")
	public void TapClearButtoninModal () {
		ClearModal.click();
		
	}
	
	@Step("User Tap the Submit Button")
	public void Tapsubmitbutton () {
		SubmitButton.click();
		
	}
	
	@Step("User search an ad")
	public void Searchtext () {
		Searchfield.click();
		sendKeysElements(Searchfield, "toyota");
			
	}
	
	@Step("User choose a category")
	public void SelectCategory () {
		ChooseCategory.click();
		
	}
	
	@Step("User Tap Price Button")
	public void TapPrice () {
		PriceButton.click();
		
	}
	
	@Step("User Add price value 'from' Filters")
	public void TapFrom () {
		PriceRangeFrom.click();
		sendKeysElements(PriceRangeFrom, "3000");
		
	}
	
	@Step("User Add price value 'to' Filters")
	public void TapTo () {
		PriceRangeTo.click();
		sendKeysElements(PriceRangeTo, "10000");
		
	}
	
	@Step("User Tap the ready button")
	public void TapReady () {
		ReadyButton.click();
		
	}
	
	@Step("User Tap the condition field")
	public void TapCondition () {
		Condition.click();
		
	}
	
	@Step("User choose the Secondhand condition")
	public void TapSecondhand () {
		SecondHand.click();
		
	}
	
	@Step("User choose the BrandNew condition")
	public void TapBrandNew () {
		BrandNew.click();
			
	}
	
	@Step("User choose the All condtion")
	public void TapAll () {
		All.click();
	}
}	
