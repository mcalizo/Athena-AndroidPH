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

public class SelectCategoryScreen extends ScreenBase {
	
	@AndroidFindBy(xpath="//*[@text='Computers']")
	public MobileElement Computers;
	@AndroidFindBy(xpath="//*[@text='Desktops']")
	public MobileElement Desktops;


	public SelectCategoryScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit.SECONDS), this);
	}
	
	@Step("User tap Computers Category")
	public void tapComputers(){
		Computers.click();
		
	}
	
	@Step("User tap Desktop Category")
	public void tapDesktop() {
		Desktops.click();
		
	}	

}	
