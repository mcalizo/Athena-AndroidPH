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
import screens.ManageAdsScreen;
import screens.OrderFormScreen;
import screens.OrdersScreen;
import screens.RefreshScreen;
import screens.LeftNavigation;
import screens.WelcomeScreen;
import screens.UserProfileScreen;
import screens.AdListingScreen;
import screens.EditScreen;

@Features("Manage Ad")
public class TestManageAd extends TestBase {
	
	WelcomeScreen welcome;
	LoginScreen login;
	AccountLoginScreen acctlogin;
	LeftNavigation leftnav;
	LandingMain landingPage;
	UserProfileScreen Profile;
	AdDetailsScreen adDetails;
	AdListingScreen searchResults;
	LeftNavigation leftnavdrawer;
	ManageAdsScreen ManageAds;
	EditScreen EditAd;
	RefreshScreen Refresh;
	OrderFormScreen Orderform;
	OrdersScreen Orders;
	public String title;
	public String price;
	public String titleOrganicLanding;
	public String priceOrganicLanding;
	public String LeftNavigation;
	
	@BeforeMethod
	public void init(){
		welcome = new WelcomeScreen(driver);
		login = new LoginScreen(driver);
		landingPage = new LandingMain(driver);
		searchResults = new AdListingScreen(driver);
		adDetails= new AdDetailsScreen(driver);
		Orderform= new OrderFormScreen(driver);
		Orders= new OrdersScreen(driver);
		ManageAds=new ManageAdsScreen(driver);
		EditAd=new EditScreen(driver);
		Refresh=new RefreshScreen(driver);
		leftnavdrawer = new LeftNavigation(driver);
	}
	
	@Test(priority=1)
	@Stories("As a user I Should be able to access Manage Ads Page")
    @TestCaseId("TC_MANAGE_AD_001")
	@Severity(SeverityLevel.CRITICAL)
	@Title("Verify user is able to access Manage Ads Page")    
	public void userIsAbletoAccessManageAdScreen() throws Throwable {
		System.out.println("Verify user is able to access Manage Ads Page");

		landingPage.givenStepforReporting();
		landingPage.tapLeftDrawerMenu();
		
		leftnavdrawer.tapManageAds();
		ManageAds.validateManageAdsisPresent();
		leftnavdrawer.leftMenuNavIco.click();
		leftnavdrawer.leftNavOption(leftnavdrawer.navHome);
	}   

	@Test(priority=2)
	@Stories("As a user I must able to access edit ad page in manage ads page")
	@TestCaseId("TC_MANAGE_AD_002")
	@Severity(SeverityLevel.NORMAL)
	@Title("Verify if the user is able to access edit ad page in manage ads page")    
	public void userIsAbleToEditinManageAdsScreen() throws Throwable {
	System.out.println("Verify if the user is able to access edit ad page in manage ads page");

		landingPage.givenStepforReporting();
		landingPage.tapLeftDrawerMenu();
		leftnavdrawer.tapManageAds();
		ManageAds.MoreactionButton();
		ManageAds.TapEdit();
		EditAd.validateadPhotoisPresent();
		EditAd.tapbackButton();
		leftnavdrawer.leftMenuNavIco.click();
		leftnavdrawer.leftNavOption(leftnavdrawer.navHome);
	}
	
	@Test(priority=3)
	@Stories("As a user I must able to refresh ad in manage ads page")
	@TestCaseId("TC_MANAGE_AD_003")
	@Severity(SeverityLevel.CRITICAL)
	@Title("Verify if the user is able refresh ad in manage ads page")    
	public void userIsAbleToAccessAdListingScreen() throws Throwable {
		System.out.println("Verify if the user is able to access refresh ad in manage ads page");
	
		landingPage.givenStepforReporting();
		landingPage.tapLeftDrawerMenu();
		leftnavdrawer.tapManageAds();
		ManageAds.TapRefresh();
		Refresh.userClickOlxGoldAsPaymentOption();
		Refresh.verifyOlxGoldCurrentBalanceElementIsDisplayed();
		Refresh.TapContinueButton();
		Refresh.verifyRefreshConfirmationMessage();
		Refresh.TapConfirmButton();
		Refresh.verifyRefreshPurchasedMessageTitle();
		Refresh.TapOKButton();
		leftnavdrawer.leftMenuNavIco.click();
		leftnavdrawer.leftNavOption(leftnavdrawer.navHome);
	}		
	
}	
