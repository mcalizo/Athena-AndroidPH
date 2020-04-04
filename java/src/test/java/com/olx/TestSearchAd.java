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
import screens.WelcomeScreen;
import screens.AdListingScreen;

@Features("Search Ad")
public class TestSearchAd extends TestBase {
	
	WelcomeScreen welcome;
	LoginScreen login;
	AccountLoginScreen acctlogin;
	LandingMain landingPage;
	AdListingScreen searchResults;
	
	@BeforeMethod
	public void init(){
		welcome = new WelcomeScreen(driver);
		login = new LoginScreen(driver);
		acctlogin = new AccountLoginScreen(driver);
		landingPage = new LandingMain(driver);
		searchResults = new AdListingScreen(driver);
	}
	
	@Test(priority=1)
	@Stories("As a user I Should be able to search an ad in OLX app")
    @TestCaseId("TC_SEARCH_AD_001")
	@Severity(SeverityLevel.CRITICAL)
    @Title("Verify user is able to see Search Field in Home Screen")    
    public void i_want_to_search_in_olx_app() throws Throwable {
		System.out.println("Verify user is able to Search Ad in Home Screen");
		
//		welcome.skipWelcomeScreen();
//		login.clickLoginToMyAccountButton();
//     	acctlogin.validateAcctLogginMobileEmailElement();
//     	acctlogin.enterMobileEmail();
//     	acctlogin.enterPassword();
//     	acctlogin.clickLoginToMyAccount();
//		landingPage.tapLeftNavigationWidgetThenOut();
//		landingPage.validateSearchTextInputPresent();
		landingPage.enterSearchKeyword();
		searchResults.verifyTheSearchKeywordDisplayedAtSearchInputBar(landingPage.searchKeyword1);
    	searchResults.validateSearchTextFieldPresent();
        searchResults.validateFiltersButtonPresent();
        searchResults.validateCategoryButtonPresent(); 
        searchResults.validateSponsoredAdsPresent();
        searchResults.validateSellButtonPresent();
	}   

	@Test(priority=2)
    @Stories("As a user I must able to change my search")
    @TestCaseId("TC_SEARCH_AD_002")
	@Severity(SeverityLevel.NORMAL)
    @Title("Verify if the user is able search ad in ad listing with existing ad results listing")    
    public void userIsAbleToAccessAdListingScreen() throws Throwable {
 		System.out.println("Verify if the user is able to access Ad Listing Screen");
		
 		searchResults.userSearchAnAdNoActualStepForReporting();
 		searchResults.TapSearch();
 		Thread.sleep(3000);
 		searchResults.TapClear();
 		Thread.sleep(3000);
 		searchResults.SearchKeyword();
 		searchResults.verifyTheSearchKeywordDisplayedAtSearchInputBar(searchResults.searchKeyword2);
 		searchResults.validateFiltersButtonPresent();
        searchResults.validateCategoryButtonPresent();
        searchResults.validateSponsoredAdsPresent();
        searchResults.validateSellButtonPresent();
 		
	}

	@Test(priority=3)
    @Stories("As a user I must able to tap my previous Search")
    @TestCaseId("TC_SEARCH_AD_003")
	@Severity(SeverityLevel.NORMAL)
    @Title("Verify if the user is able to access previous search")    
    public void userIsAbleToAccesresultssScreen() throws Throwable {
 		System.out.println("Verify if the user is able to tap previous search");
 		
 		searchResults.userSearchAnAdNoActualStepForReporting();
 		searchResults.TapSearch();
 		searchResults.TapClear();
 		searchResults.TapDropDown();
 		searchResults.verifyTheSearchKeywordDisplayedAtSearchInputBar(landingPage.searchKeyword1);
 		searchResults.validateFiltersButtonPresent();
        searchResults.validateCategoryButtonPresent();
        searchResults.validateSponsoredAdsPresent();
        searchResults.validateSellButtonPresent();
	}      

	@Test(priority=4)
    @Stories("As a user I must able to access the No Results Screen")
    @TestCaseId("TC_SEARCH_AD_004")
	@Severity(SeverityLevel.NORMAL)
    @Title("Verify if the user is able to access No Results Screen")    
    public void userIsAbleToAcccessTheNoResultsScreen() throws Throwable {
 		System.out.println("Verify if the user is able to access the No Results Screen");

 		searchResults.TapSearch();
 		searchResults.TapClear();
 		searchResults.NoResults();
 		searchResults.validateNoResultImageisPresent();
        searchResults.validateNoResultFoundTextisPresent();

	}
}	

	


