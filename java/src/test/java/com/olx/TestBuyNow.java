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
import screens.OrderFormScreen;
import screens.OrdersScreen;
import screens.LeftNavigation;
import screens.WelcomeScreen;
import screens.UserProfileScreen;
import screens.AdListingScreen;

@Features("Buy Now")
public class TestBuyNow extends TestBase {
	
	WelcomeScreen welcome;
	LoginScreen login;
	AccountLoginScreen acctlogin;
	LeftNavigation leftnav;
	LandingMain landingPage;
	UserProfileScreen Profile;
	AdDetailsScreen adDetails;
	AdListingScreen searchResults;
	LeftNavigation leftnavdrawer;
	OrderFormScreen Orderform;
	OrdersScreen Orders;
	public String title;
	public String price;
	public int Adcount;
	public int BuynowCount;
	
	
	@BeforeMethod
	public void init(){
		welcome = new WelcomeScreen(driver);
		login = new LoginScreen(driver);
		landingPage = new LandingMain(driver);
		searchResults = new AdListingScreen(driver);
		adDetails= new AdDetailsScreen(driver);
		Orderform= new OrderFormScreen(driver);
		Orders= new OrdersScreen(driver);
	}
	
	@Test(priority=1)
	@Stories("As a user I Should be able to see the buy now banner in homepage")
    @TestCaseId("TC_MarketPlace_001")
	@Severity(SeverityLevel.CRITICAL)
    @Title("Verify user is able to see buy now banner in Home Screen")    
    	public void i_want_to_search_in_olx_app() throws Throwable {
		System.out.println("Verify user is able to see buy now banner in home screen");

		landingPage.givenStepforReporting();
		landingPage.tapbanner();
		Adcount = searchResults.Adscount();
		System.out.println(Adcount);
		BuynowCount = searchResults.BuynowAdsCount();
		System.out.println(BuynowCount);
		searchResults.verifyBuyNowAdsinListing(BuynowCount, Adcount);
		searchResults.validatebuynowbanner();
	}   

	@Test(priority=2)
    @Stories("As a user I must able to tap the buy now banner in listing page")
    @TestCaseId("TC_MarketPlace_002")
	@Severity(SeverityLevel.NORMAL)
    	@Title("Verify if the user is able to tap the buy now banner in listing page")    
    	public void userIsAbleToAccessAdListingScreen() throws Throwable {
		System.out.println("Verify if the user is able to tap buynow banner in listing page");

		landingPage.givenStepforReporting();
		searchResults.TapSearch();
		searchResults.SearchKeyword();
		searchResults.tapbuynowfeeds();
		Adcount = searchResults.Adscount();
		System.out.println(Adcount);
		BuynowCount = searchResults.BuynowAdsCount();
		System.out.println(BuynowCount);
		searchResults.verifyBuyNowAdsinListing(BuynowCount, Adcount);
		searchResults.validatebuynowbanner();
	}

	@Test(priority=3)
	@Stories("As a user I must able to tap the buy now in left navigation")
	@TestCaseId("TC_MarketPlace_003")
	@Severity(SeverityLevel.NORMAL)
	@Title("Verify if the user able to tap the buy now in left navigation")
	public void userIsAbleToAccessAdlistingScreen() throws Throwable {
		System.out.println("Verify if the user able to tap the buy now in left navigation");

		landingPage.givenStepforReporting();
		searchResults.Tapleftnavigation();
		searchResults.TapHome();
		landingPage.validateSponsoredAdsPresent();
		landingPage.tapLeftDrawerMenu();
		landingPage.buynowDrawer();
		Adcount = searchResults.Adscount();
		System.out.println(Adcount);
		BuynowCount = searchResults.BuynowAdsCount();
		System.out.println(BuynowCount);
		searchResults.verifyBuyNowAdsinListing(BuynowCount, Adcount);
		searchResults.validatebuynowbanner();
		searchResults.Tapleftdrawer();
		searchResults.Taphome();
		landingPage.tapBanner();
		
	}
	
	@Test(priority=4)
	@Stories("As a user I must able to see buy now in ad details")
	@TestCaseId("TC_MarketPlace_004")
	@Severity(SeverityLevel.NORMAL)
	@Title("Verify if the user can see buy now in ad details page")
	public void userIsAbleToAccessAdDetailsScreen() throws Throwable {
		System.out.println("Verify if the user can see buy now in ad details page");

		landingPage.givenStepforReporting();
		title = searchResults.Adtitle.getText();
		System.out.println(title);
		price = searchResults.Adprice.getText();
		System.out.println(price);
		searchResults.clickFirstOrganiclAd();
		adDetails.verifyAdTitleInFavoritesAdScreen(title); 
		adDetails.verifyAdPriceInFavoritesAdScreen(price);
		adDetails.validateUserNamePresent();
		adDetails.validateContactSellerButtonPresent(); 
		adDetails.tapbackbutton();
		searchResults.Tapleftdrawer();
		searchResults.Taphome();
		landingPage.tapBanner();
		searchResults.clickfirstOrganiclAd();
		
	}
	
	@Test(priority=5)
	@Stories("As a User I must be able to tap the buy now in ad details page")
	@TestCaseId("TC_MarketPlace_005")
	@Severity(SeverityLevel.NORMAL)
	@Title("Verify if the user able to tap the buy now button in ad details page")
	public void userIsAbleToAccessOrderForm() throws Throwable {
		System.out.println("Verify if the user able to tap the buy now button in ad details page");

		landingPage.givenStepforReporting();
		adDetails.tapContactSellerButton();
		Orderform.validatetextPresent();
		Orderform.validateTopBarPresent();
		Orderform.tapbackButton();
	}
	
	@Test(priority=6)
	@Stories("As a User I must be able to tap the Orders in the left drawer")
	@TestCaseId("TC_MarketPlace_006")
	@Severity(SeverityLevel.NORMAL)
	@Title("Verify if the user able to tap the Orders in the left drawer")
	public void userIsAbleToAccessOrders() throws Throwable {
		System.out.println("Verify if the user able to tap the Orders in the left drawer");

		landingPage.givenStepforReporting();
		adDetails.tapReturnToAdListingButton();
		searchResults.Tapleftnavigation();
		searchResults.TapHome();
		landingPage.validateSponsoredAdsPresent();
		landingPage.tapLeftDrawerMenu();
		landingPage.tapOrdersDrawer();
		Orders.validatetextPresent();
		Orders.TapBackButton();
		
	}
		
}		
