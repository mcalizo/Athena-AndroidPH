package screens;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BaseHelper extends ScreenBase {
	
	public static String buyerMessage = "Buyer Test Message ";
	
	
	AccountLoginScreen acctlogin;
	LoginScreen login;
	LandingMain landingmain;
	LeftNavigation leftnav;
	AdListingScreen listing;
	
	public BaseHelper(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit.SECONDS), this);
	}
	
	public void loginToAccountUsingMobileNumber () {
		login = new LoginScreen(driver);
		acctlogin = new AccountLoginScreen(driver);
		landingmain = new LandingMain(driver);
		
		clickElements(login.loginBtn);
		sendKeysElements(acctlogin.loginUser, acctlogin.mobileNumber);
		sendKeysElements(acctlogin.loginPassword, acctlogin.password);
		clickElements(acctlogin.btnLogInNew);
		landingmain.searchEditText_input.isDisplayed();
	}
	
	public void logOutUser () throws Throwable {
		login = new LoginScreen(driver);
		landingmain = new LandingMain(driver);
		leftnav = new LeftNavigation(driver);
		
		clickElements(landingmain.leftNavWidget);
		//Thread.sleep(10000);
		//new TouchAction(driver).tap(829, 427).waitAction(2000).perform();
		clickElements(leftnav.settingsIcon);
		clickElements(leftnav.logOutElement);
		login.facebookLogin.isDisplayed();
	}
	
	public void logOutUser2 () throws Throwable {
		login = new LoginScreen(driver);
		landingmain = new LandingMain(driver);
		leftnav = new LeftNavigation(driver);
		listing = new AdListingScreen(driver);
		
		clickElements(listing.leftNavWidget);
		leftnav.leftNavOption(leftnav.navHome);
		//Thread.sleep(5000);
		//new TouchAction(driver).tap(829, 427).waitAction(2000).perform();
		clickElements(landingmain.leftNavWidget);
		clickElements(leftnav.settingsIcon);
		clickElements(leftnav.logOutElement);
		login.facebookLogin.isDisplayed();
	}
	
	/**
	 * Method to create random string
	 * @param length
	 * @return
	 */
	public String buyerMessageToSeller(int length) {
       final String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_+";
       StringBuilder result = new StringBuilder();
       while(length > 0) {
           Random rand = new Random();
           result.append(characters.charAt(rand.nextInt(characters.length())));
           length--;
       }
       
       String finalMessage = buyerMessage + result.toString();
       return finalMessage;
	}
}
