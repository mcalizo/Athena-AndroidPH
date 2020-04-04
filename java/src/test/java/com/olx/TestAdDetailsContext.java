package com.olx;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
import screens.AccountLoginScreen;
import screens.LandingMain;
import screens.LeftNavigation;
import screens.LoginScreen;
import screens.WelcomeScreen;
import screens.AdDetailsScreen;
import screens.AdListingScreen;
import screens.BaseHelper;
import screens.ChatScreen;
import screens.FavoritesScreen;

import org.testng.annotations.*;

import base.TestBase;

@Features ("Ad Details Page")
public class TestAdDetailsContext extends TestBase {
	
	WelcomeScreen welcome;
	LoginScreen login;
	AccountLoginScreen acctlogin;
	LandingMain landingPage;
	AdDetailsScreen adDetails;
	LeftNavigation leftnavdrawer;
	FavoritesScreen favoritesScreen;
	ChatScreen chatScreen;
	AdListingScreen searchResults;
	public String title;
	public String price;
	public String titleOrganicLanding;
	public String priceOrganicLanding;
	public String titleFavorites;
	public String priceFavorites;
	public String userName;
	BaseHelper base;
	
	@BeforeMethod
	public void init(){
		login = new LoginScreen(driver);
		welcome = new WelcomeScreen(driver);
		acctlogin = new AccountLoginScreen(driver);
		landingPage = new LandingMain(driver);
 		adDetails = new AdDetailsScreen(driver);
 		leftnavdrawer = new LeftNavigation(driver);
 		favoritesScreen = new FavoritesScreen(driver);
 		chatScreen = new ChatScreen(driver);
 		searchResults = new AdListingScreen(driver);
 		
 		base = new BaseHelper(driver);
	}
		 	 
 	@Test(priority=1)
    @Stories("As a user i must able to see details of the ad")
    @TestCaseId("TC_ADDETAILS_001")
 	@Severity(SeverityLevel.BLOCKER)
    @Title("Verify if the user is able to access ad details Screen")    
    public void userIsAbleToAccessAdDetailsScreen() throws Throwable {
 		System.out.println("Verify if the user is able to access ad details Screen");

// 		welcome.skipWelcomeScreen();
// 		login.clickLoginToMyAccountButton();
//	 	acctlogin.enterMobileEmail();
//	 	acctlogin.enterPassword();
//	 	acctlogin.clickLoginToMyAccount();
//	 	
//	 	landingPage.skipTutorialInLanding(); 
 		landingPage.enterSearchKeyword();
 		titleOrganicLanding = landingPage.organicAdTitle.getText(); 
 		priceOrganicLanding = landingPage.organicAdPrice.getText(); 
 		
 		landingPage.givenStepforReporting();
 		landingPage.clickFirstOrganiclAd();
 		adDetails.verifyAdTitleInFavoritesAdScreen(titleOrganicLanding); 
 		adDetails.verifyAdPriceInFavoritesAdScreen(priceOrganicLanding);
 		adDetails.tapBackButtonNoStep();
 	}
 	
 	@Test(priority=2)
    @Stories("As a user i must able to contact the seller")
    @TestCaseId("TC_ADDETAILS_001")
 	@Severity(SeverityLevel.BLOCKER)
    @Title("Verify if the user is allow to contact the seller")    
    public void userIsAllowToContactSeller() throws Throwable {
 		System.out.println("Verify if the user is allow to contact the seller");
 		
// 		adDetails.tapReturnToAdListingButton();
// 		landingPage.userNavigateToHomeViaLeftDrawer();
 		landingPage.givenStepforReporting();
 		searchResults.TapSearch();
 		Thread.sleep(3000);
 		searchResults.TapClear();
 		Thread.sleep(3000);
 		searchResults.SearchKeyword();
 		landingPage.clickFirstOrganiclAd();
 		
 		userName = adDetails.userName.getText();
 		title = adDetails.AdDetailsTitle.getText();
 		
 		adDetails.tapContactSellerButton();
 		adDetails.validateChatButtonPresent();
 		adDetails.tapChatButton();
 		
 		chatScreen.verifyAdTitleDisplayedInDetailsScreenAndChatIsSame(title);
 		
 		adDetails.tapReturnToAdDetailsButtonNoStep();
 		adDetails.tapBackButtonNoStep();
 		
 	}
	 	
 	@Test(priority=3)
    @Stories("As a user i must able to bookmark the seller ad")
    @TestCaseId("TC_ADDETAILS_002")
 	@Severity(SeverityLevel.NORMAL)
    @Title("Verify if the user is allow to bookmark/favorite the seller ad")    
    public void userIsAllowToBookmarkAds() throws Throwable {
 		System.out.println("Verify if the user is allow to bookmark/favorite the seller ad");
 		
 		landingPage.givenStepforReporting();
 		searchResults.TapSearch();
 		Thread.sleep(3000);
 		searchResults.TapClear();
 		Thread.sleep(3000);
 		searchResults.SearchKeyword();
 		landingPage.clickSecondOrganiclAd();
 		
 		adDetails.tapBookmark();
 		
 		title = adDetails.AdDetailsTitle.getText();
 		price = adDetails.AdDetailsPrice.getText();
 		
 		adDetails.tapReturnToAdListingButton();
 		
 		searchResults.Tapleftnavigation();
 		
 		
 		leftnavdrawer.clickFavoritesMenu();
 		
 		favoritesScreen.verifyAdTitleInFavoritesAdScreen(title);
 		favoritesScreen.verifyAdPriceInFavoritesAdScreen(price);
 		favoritesScreen.verifyAdPhotoInFavoritesAdScreenPresent();
 	}
 	
 	@Test(priority=4)
    @Stories("As a user i must able access ad details via Favorites screen")
    @TestCaseId("TC_ADDETAILS_003")
 	@Severity(SeverityLevel.NORMAL)
    @Title("Verify user able to access ad details via Favorites screen")  
 	public void verifyUserIsAbleToAccessAdDetailsViaFavoritesScreen() throws Throwable {
 		System.out.println("Verify user able to access ad details via Favorites screen");
 		leftnavdrawer.NavigateToHomeViaLeftDrawerNoStep();
 		landingPage.givenStepforReporting();
 		landingPage.tapLeftDrawerMenu();
 		
 		leftnavdrawer.clickFavoritesMenu();
 		
 		titleFavorites = favoritesScreen.favoriteAdTitle.getText();
 		priceFavorites = favoritesScreen.favoriteAdPrice.getText();
 		
 		favoritesScreen.userClickFavoritedAds();
 		
 		adDetails.verifyAdTitleInFavoritesAdScreen(titleFavorites); 
 		adDetails.verifyAdPriceInFavoritesAdScreen(priceFavorites);
 		
 		title = adDetails.AdDetailsTitle.getText();
 		price = adDetails.AdDetailsPrice.getText();
 		
 		adDetails.userTapBackArrowToGoBackAtFavoritesScreen();
 		
 		favoritesScreen.verifyAdTitleInFavoritesAdScreen(title);
 		favoritesScreen.verifyAdPriceInFavoritesAdScreen(price);
 		favoritesScreen.verifyAdPhotoInFavoritesAdScreenPresent();
 		
 		//adDetails.tapBackButtonNoStep();
 	}
 	
 	@Test(priority=5)
    @Stories("As a user i must able to removed bookmarked/favorited seller ad")
    @TestCaseId("TC_ADDETAILS_003")
 	@Severity(SeverityLevel.NORMAL)
    @Title("Verify if the user is allow to remove ad in Favorites")  
 	public void verifyUserIsAllowdToRemoveFavoriteAds() throws Throwable {
 		System.out.println("Verify if the user is allow to remove ad in Favorites");
 		
 		
 		leftnavdrawer.NavigateToHomeViaLeftDrawerNoStep();
 		landingPage.givenStepforReporting();
 		landingPage.tapLeftDrawerMenu();
 		 		
 		leftnavdrawer.clickFavoritesMenu();
 		
 		favoritesScreen.deleteFavoriteAd();
 		favoritesScreen.verifyUserAbleToDeleteFavoriteAd();
 	}
}
