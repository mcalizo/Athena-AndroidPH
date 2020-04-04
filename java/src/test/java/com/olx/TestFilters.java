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
import screens.SelectCategoryScreen;
import screens.LeftNavigation;
import screens.WelcomeScreen;
import screens.UserProfileScreen;
import screens.AdListingScreen;
import screens.EditScreen;
import screens.FiltersScreen;

@Features("Filters")
public class TestFilters extends TestBase {
	
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
	SelectCategoryScreen Categories;
	FiltersScreen Filters;
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
		Categories=new SelectCategoryScreen(driver);
		Filters=new FiltersScreen(driver);
		leftnavdrawer = new LeftNavigation(driver);
	}
	
	@Test(priority=1)
	@Stories("As a user I Should be able to access Categories Filter Page")
    @TestCaseId("TC_Filters_001")
	@Severity(SeverityLevel.CRITICAL)
    @Title("Verify user is able to access Categories Filter")    
    public void userIsAbletoAccessSelectCategoryScreen() throws Throwable {
		System.out.println("Verify user is able to access Categories Filter");

		landingPage.givenStepforReporting();
		Thread.sleep(3000);
		landingPage.tapLeftDrawerMenu();
		Thread.sleep(3000);
		leftnavdrawer.tapBrowseAds();
		searchResults.tapAllCategories();
		Thread.sleep(3000);
		Categories.tapComputers();	
		Categories.tapDesktop();
		Thread.sleep(3000);
		searchResults.TapleftNavigation();
		leftnavdrawer.clickHome();
		
		
	}   

	@Test(priority=2)
	@Stories("As a user I must able to access Filters Page")
	@TestCaseId("TC_Filters_002")
	@Severity(SeverityLevel.CRITICAL)
	@Title("Verify if the user is able to access Filters Page")    
	public void userIsAbleToaccessFiltersScreen() throws Throwable {
		System.out.println("Verify if the user is able to access Filters Page");

		landingPage.givenStepforReporting();
		Thread.sleep(3000);
		landingPage.tapLeftDrawerMenu();
		Thread.sleep(3000);
		leftnavdrawer.tapBrowseAds();
		searchResults.tapFilters();
		Filters.verifyclearbuttonisPresent();
		Filters.verifysubmitbuttonisPresent();
		Filters.tapClearButton();
		Filters.tapClearmodal();
		Filters.tapSubmitButton();
		Thread.sleep(3000);
		searchResults.TapleftNavigation();
		leftnavdrawer.clickHome();
						
	}
	
	@Test(priority=3)
	@Stories("As a user I must able to Search an Ad in Filters page")
	@TestCaseId("TC_Filters_003")
	@Severity(SeverityLevel.NORMAL)
	@Title("Verify if the user is able to Search an Ad in Filters page")    
	public void userIsAbleToSearchinFiltersPage() throws Throwable {
	System.out.println("Verify if the user is able to Search an Ad in Filters page");

		landingPage.givenStepforReporting();
		Thread.sleep(3000);
		landingPage.tapLeftDrawerMenu();
		Thread.sleep(3000);
		leftnavdrawer.tapBrowseAds();
		searchResults.tapFilters();
		Filters.verifyclearbuttonisPresent();
		Filters.verifysubmitbuttonisPresent();
		Filters.tapclearbutton();
		Filters.TapClearButtoninModal();
		Filters.Searchtext();
		Filters.Tapsubmitbutton();
		searchResults.validateSponsoredAdsPresent();
		searchResults.validateSellButtonPresent();
		Thread.sleep(3000);
		searchResults.TapleftNavigation();
		leftnavdrawer.clickHome();
	
	}		
	
	@Test(priority=4)
	@Stories("As a user I must able to change the category in Filters page")
	@TestCaseId("TC_Filters_004")
	@Severity(SeverityLevel.NORMAL)
	@Title("Verify if the user is able to chage the category in Filters page")    
	public void userIsAbleToChangetheCategoryinFiltersPage() throws Throwable {
	System.out.println("Verify if the user is able to change the category in Filters page");

		landingPage.givenStepforReporting();
		Thread.sleep(3000);
		landingPage.tapLeftDrawerMenu();
		Thread.sleep(3000);
		leftnavdrawer.tapBrowseAds();
		searchResults.tapFilters();
		Filters.verifyclearbuttonisPresent();
		Filters.verifysubmitbuttonisPresent();
		Filters.tapclearbutton();
		Filters.TapClearButtoninModal();
		Filters.SelectCategory();
		Thread.sleep(3000);
		Categories.tapComputers();	
		Categories.tapDesktop();
		Filters.Tapsubmitbutton();
		searchResults.validateSponsoredAdsPresent();
		searchResults.validateSellButtonPresent();
		Thread.sleep(3000);
		searchResults.TapleftNavigation();
		leftnavdrawer.clickHome();
	
	}	
	
	@Test(priority=4)
	@Stories("As a user I must able Filter Ads by Price in Filters page")
	@TestCaseId("TC_Filters_004")
	@Severity(SeverityLevel.NORMAL)
	@Title("Verify if the user is able to Filter Ads by Price in Filters page")    
	public void userIsAbleToFilterAdsByPriceinFiltersPage() throws Throwable {
	System.out.println("Verify if the user is able to Filter Ads by Price in Filters page");

		landingPage.givenStepforReporting();
		Thread.sleep(3000);
		landingPage.enterSearchKeyword();
		Thread.sleep(3000);
		searchResults.verifyTheSearchKeywordDisplayedAtSearchInputBar(landingPage.searchKeyword1);
    	searchResults.validateSearchTextFieldPresent();
    	searchResults.tapFilters();
    	Filters.verifyclearbuttonisPresent();
		Filters.verifysubmitbuttonisPresent();
		Filters.TapPrice();
		Filters.TapFrom();
		Filters.TapTo();
		Filters.TapReady();
		Filters.Tapsubmitbutton();
		searchResults.validateSponsoredAdsPresent();
		searchResults.validateSellButtonPresent();
		searchResults.TapOption();
		searchResults.TapMostExpensive();
		Thread.sleep(3000);
 		searchResults.validateFiltersButtonPresent();
		searchResults.validateCategoryButtonPresent();
		searchResults.TapleftNavigation();
		leftnavdrawer.clickHome();
 		
	}	 
	
	@Test(priority=5)
	@Stories("As a user I must able to Sort the ads by Cheapest First")
	@TestCaseId("TC_Filters_005")
	@Severity(SeverityLevel.NORMAL)
	@Title("Verify if the user is able to Sort the ads by Cheapest First")    
	public void userIsAbleToSorttheAdsbyCheapestFirst() throws Throwable {
	System.out.println("Verify if the user is able to Sort the ads by Cheapest First");

		landingPage.givenStepforReporting();
		Thread.sleep(3000);
		landingPage.enterSearchKeyword();
		Thread.sleep(3000);
		searchResults.verifyTheSearchKeywordDisplayedAtSearchInputBar(landingPage.searchKeyword1);
    	searchResults.validateSearchTextFieldPresent();
    	searchResults.TapOption();
    	searchResults.TapCheapestFirst();
    	Thread.sleep(3000);
 		searchResults.validateFiltersButtonPresent();
		searchResults.validateCategoryButtonPresent();
		searchResults.TapleftNavigation();
		leftnavdrawer.clickHome();
		
  	}	
	
	@Test(priority=6)
	@Stories("As a user I must able to Sort the ads by Most Expensive")
	@TestCaseId("TC_Filters_006")
	@Severity(SeverityLevel.NORMAL)
	@Title("Verify if the user is able to Sort the ads by Most Expensive")    
	public void userIsAbleToSorttheAdByMostExpensive() throws Throwable {
	System.out.println("Verify if the user is able to Sort the ads by Most Expensive");

		landingPage.givenStepforReporting();
		Thread.sleep(3000);
		landingPage.enterSearchKeyword();
		Thread.sleep(3000);
		searchResults.verifyTheSearchKeywordDisplayedAtSearchInputBar(landingPage.searchKeyword1);
    	searchResults.validateSearchTextFieldPresent();
    	searchResults.TapOption();
    	searchResults.TapMostExpensive();
    	Thread.sleep(3000);
 		searchResults.validateFiltersButtonPresent();
		searchResults.validateCategoryButtonPresent();
		searchResults.TapleftNavigation();
		leftnavdrawer.clickHome();
		
	}
	
	@Test(priority=7)
	@Stories("As a user I must able to Filter Ads By Brand New Condtion")
	@TestCaseId("TC_Filters_007")
	@Severity(SeverityLevel.NORMAL)
	@Title("Verify if the user is able to Filter ads By Brand New Condition")    
	public void userIsAbleToFilterAdsByBrandNewCondition() throws Throwable {
	System.out.println("Verify if the user is able to Filter Ads By Brand New Condition");

		landingPage.givenStepforReporting();
		Thread.sleep(3000);
		landingPage.enterSearchKeyword();
		Thread.sleep(3000);
		searchResults.verifyTheSearchKeywordDisplayedAtSearchInputBar(landingPage.searchKeyword1);
    	searchResults.validateSearchTextFieldPresent();
    	searchResults.tapFilters();
    	Filters.TapCondition();
    	Filters.TapBrandNew();
		Filters.TapReady();
		Filters.Tapsubmitbutton();
		searchResults.TapleftNavigation();
		leftnavdrawer.clickHome();
		
	}	
	
	@Test(priority=8)
	@Stories("As a user I must able to Filter Ads By Secondhand Condtion")
	@TestCaseId("TC_Filters_007")
	@Severity(SeverityLevel.NORMAL)
	@Title("Verify if the user is able to Filter ads By Secondhand Condition")    
	public void userIsAbleToFilterAdsBySecondHandCondition() throws Throwable {
	System.out.println("Verify if the user is able to Filter Ads By Secondhand Condition");

		landingPage.givenStepforReporting();
		Thread.sleep(3000);
		landingPage.enterSearchKeyword();
		Thread.sleep(3000);
		searchResults.verifyTheSearchKeywordDisplayedAtSearchInputBar(landingPage.searchKeyword1);
    	searchResults.validateSearchTextFieldPresent();
    	searchResults.tapFilters();
    	Filters.TapCondition();
    	Filters.TapSecondhand();
		Filters.TapReady();
		Filters.Tapsubmitbutton();
		searchResults.TapleftNavigation();
		leftnavdrawer.clickHome();
		
	}	

}	