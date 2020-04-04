package com.olx;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
import screens.AccountLoginScreen;
import screens.AdDetailsScreen;
import screens.LandingMain;
import screens.LoginScreen;
import screens.LeftNavigation;
import screens.WelcomeScreen;
import screens.UserProfileScreen;
import screens.AdListingScreen;
import base.ScreenBase;

@Features("User Profile")
public class TestUserProfile extends TestBase {
	
	WelcomeScreen welcome;
	LoginScreen login;
	AccountLoginScreen acctlogin;
	LeftNavigation leftnav;
	LandingMain landingPage;
	UserProfileScreen Profile;
	AdDetailsScreen adDetails;
	AdListingScreen searchResults;
	public String title;
	public String price;
	public String titleOrganicLanding;
	public String priceOrganicLanding;
	ScreenBase Swipe;
	
	@BeforeMethod
	public void init(){
		welcome = new WelcomeScreen(driver);
		login = new LoginScreen(driver);
		acctlogin = new AccountLoginScreen(driver);
		leftnav = new LeftNavigation(driver);
		landingPage = new LandingMain(driver);
		Profile = new UserProfileScreen(driver);
		adDetails = new AdDetailsScreen(driver);
		searchResults = new AdListingScreen(driver);
		Swipe = new ScreenBase(driver);
	}
	
	@Test(priority=1)
	@Stories("As a user I Should be able to access My User Profile via left drawer")
    @TestCaseId("TC_USER_PROFILE_001")
	@Severity(SeverityLevel.CRITICAL)
    @Title("Verify user is able to access user profile using the Left Drawer")    
    public void userIsAbleToAccessMyOwnProfileScreen() throws Throwable {
		System.out.println("Verify user is able to access user profile using the Left Drawer");
		
//		welcome.skipWelcomeScreen();
//		login.clickLoginToMyAccountButton();
//     	acctlogin.validateAcctLogginMobileEmailElement();
//     	acctlogin.enterMobileEmail();
//     	acctlogin.enterPassword();
//     	acctlogin.clickLoginToMyAccount();
		landingPage.givenStepforReporting();
     	landingPage.tapLeftNavigationWidget();
     	leftnav.TapUserProfile();
     	Profile.validateProfileBackground();
     	Profile.validateProfilePhoto();
	}
	
	@Test(priority=2)
    @Stories("As a user I must able to see my ad details via User Profile Screen")
    @TestCaseId("TC_USER_PROFILE_002")
	@Severity(SeverityLevel.CRITICAL)
    @Title("Verify if the user is able to see ad details via User Profile Screen")    
    public void userIsAbleToAccessUserProfileScreen() throws Throwable {
 		System.out.println("Verify if the user is able to see ad details via User Profile Screen");
				
		Profile.TapBackButton();
		landingPage.Tapleftnavigation();
		leftnav.TapUserProfile();
		title = Profile.AdTitle.getText();
		System.out.println(title);
 		price = Profile.AdPrice.getText();
 		System.out.println(price);
     	Profile.TapUserAd();
     	adDetails.verifyAdTitleInFavoritesAdScreen(title); 
 		adDetails.verifyAdPriceInFavoritesAdScreen(price);
		adDetails.usertapMyProfile();
		Profile.validateProfileBackground();
     	Profile.validateProfilePhoto();
	
	}

	@Test(priority=3)
    @Stories("As a user I must able to see other User Profile")
    @TestCaseId("TC_USER_PROFILE_003")
	@Severity(SeverityLevel.NORMAL)
    @Title("Verify if the user is able to access other User Profile Screen")    
    public void userIsAbleToAccessotherUserProfileScreen() throws Throwable {
 		System.out.println("Verify if the user is able to access other User Profile Screen");
		
		Profile.TapBackButton();
		adDetails.tapReturnToAdListingButton();
		Swipe.swipingTopToBottom();
		Profile.TapBackButton();
		landingPage.validateSearchTextInputPresent();
		landingPage.enterSearchKeyword();
 		searchResults.clickFirstOrganiclAd(); 
 		adDetails.usertapMyProfile();
		Profile.validateProfileBackground();
     	Profile.validateProfilePhoto();

	}	
}
