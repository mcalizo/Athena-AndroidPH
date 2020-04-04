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
import screens.AdListingScreen;
import screens.BaseHelper;
import screens.ChatScreen;
import screens.LandingMain;
import screens.LeftNavigation;
import screens.LoginScreen;

@Features("Chat")
public class TestChat extends TestBase {
	
	BaseHelper base;
	LoginScreen login;
	AccountLoginScreen acctlogin;
	AdListingScreen searchResults;
	LandingMain landingPage;
	AdDetailsScreen adDetails;
	ChatScreen chatScreen;
	LeftNavigation leftnavdrawer;
	public String latestBuyerMessage;
	public String chatMessage;
	
	@BeforeMethod
	public void init(){
		base = new BaseHelper(driver);
		login = new LoginScreen(driver);
		acctlogin = new AccountLoginScreen(driver);
		searchResults = new AdListingScreen(driver);
		landingPage = new LandingMain(driver);
		adDetails = new AdDetailsScreen(driver);
		chatScreen = new ChatScreen(driver);
		leftnavdrawer = new LeftNavigation(driver);
	}
	
 	@Test(priority=1)
    @Stories("As a buyer I must able to send message to Seller")
    @TestCaseId("TC_CHAT_001")
 	@Severity(SeverityLevel.BLOCKER)
    @Title("Verify if the buyer is able to chat seller")
 	public void verifyIfTheUserIsAbleToAccessCreateAccountScreen() throws Throwable {
 		System.out.println("Verify if the buyer is able to send message to seller");
 		chatMessage = base.buyerMessageToSeller(10);
 		base.logOutUser();
 		login.clickLoginToMyAccountButton();
 		acctlogin.enterBuyerRegisteredMobile();
 		acctlogin.enterPassword();
 		acctlogin.clickLoginToMyAccount();
 		
 		Thread.sleep(3000);
 		landingPage.buyerEnterSearchKeyWord();
 		searchResults.clickFirstOrganiclAd();
 		adDetails.tapContactSellerButton();
 		Thread.sleep(2000);
 		adDetails.tapChatButton();

 		chatScreen.buyerEnterMessageToSeller(chatMessage);
 		chatScreen.clickSendButton();
 		latestBuyerMessage = chatScreen.getLatestChatMessage();
 		System.out.println("Message to send: " + chatMessage);
 		System.out.println("Sent message: " + latestBuyerMessage);
 		chatScreen.verifyBuyerMessageToSeller(chatMessage, latestBuyerMessage);
 		adDetails.tapReturnToAdDetailsButtonNoStep();
 		adDetails.tapBackButtonNoStep();
 		base.logOutUser2();
 	}
 	
	@Test(priority=2)
	@Stories("As a seller I must able to received message from buyer")
	@TestCaseId("TC_CHAT_002")
	@Severity(SeverityLevel.BLOCKER)
	@Title("Verify seller able to received message from buyer")
 	public void verifySellerAbleToReceivedMessageFromBuyer() throws Throwable {
 		System.out.println("Verify seller able to received message from buyer");
 		
 		login.clickLoginToMyAccountButton();
 		acctlogin.SellerEnterMobileEmail();
 		acctlogin.enterPassword();
 		acctlogin.clickLoginToMyAccount();
 		Thread.sleep(3000);
 		landingPage.clickLeftDrawerIntro();
 		leftnavdrawer.tapChatInLeftDrawer("Chat");
 		
 		chatScreen.sellerTapMessageFromBuyer();
 		chatScreen.verifyThatSellerRecievedTheMessageOfBuyer(chatMessage);
 		chatScreen.backToPrevScreen();
 		chatScreen.backToPrevScreen();
 	}
	
// 	@Test(priority=3)
// 	@Stories("As a seller I must able to delete conversation from buyer")
// 	@TestCaseId("TC_CHAT_003")
// 	@Severity(SeverityLevel.NORMAL)
// 	@Title("Verify seller is able to delete conversation from buyer")
// 	public void verifySellerIsAbleToDeleteConversationFromBuyer() throws Throwable {
		
// 		landingPage.givenStepforReporting();
// 		landingPage.clickLeftDrawerIntro();
// 		leftnavdrawer.tapChatInLeftDrawer("Chat");
// 		chatScreen.sellerTapMessageFromBuyer();
// 		chatScreen.tapOptionOfUpperRightOfScreen();
// 		chatScreen.tapDeleteConversationOption();
// 		chatScreen.verifyDeleteConfirmationMessage();
// 		chatScreen.tapDeleteMessagesToConfirmDeletionOfMessage();
// 		Thread.sleep(3000);
// 		chatScreen.verifyBuyerMessageDeletedInChatInbox();
// 		chatScreen.backToPrevScreen();
// 		base.logOutUser();
// 	}
 	
	//@Test(priority=4)
	//@Stories("As a buyer I must able to delete conversation from seller")
	//@TestCaseId("TC_CHAT_004")
	//@Severity(SeverityLevel.NORMAL)
	//@Title("Verify buyer is able to delete conversation from seller")
	//public void verifyBuyerIsAbleToDeleteConversationFromSeller() throws Throwable {
		//System.out.println("Verify buyer is able to delete conversation from seller");
		
		//login.clickLoginToMyAccountButton();
		//acctlogin.enterBuyerRegisteredMobile();
		//acctlogin.enterPassword();
		//acctlogin.clickLoginToMyAccount();
		//landingPage.clickLeftDrawerIntro();
		//leftnavdrawer.tapChatInLeftDrawer("Chat");
		//chatScreen.buyerTapMessageFromSeller();
		//chatScreen.tapOptionOfUpperRightOfScreen();
		//chatScreen.tapDeleteConversationOption();
		//chatScreen.verifyDeleteConfirmationMessage();
		//chatScreen.tapDeleteMessagesToConfirmDeletionOfMessage();
		//Thread.sleep(5000);
		//chatScreen.verifyChatInboxHasNoMessagesDisplayed();
		//chatScreen.backToPrevScreen();
		//base.logOutUser();
		//login.loginBtn.click();
		//acctlogin.loginUser.clear();
		//acctlogin.loginUser.sendKeys(acctlogin.mobileNumber);
		//acctlogin.loginPassword.sendKeys(acctlogin.password);
		//acctlogin.btnLogInNew.click();
		//Thread.sleep(3000);		
	//} 	
}
