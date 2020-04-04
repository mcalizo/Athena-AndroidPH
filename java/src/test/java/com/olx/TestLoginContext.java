package com.olx;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
import screens.AccountLoginScreen;
import screens.BaseHelper;
import screens.LandingMain;
import screens.LeftNavigation;
import screens.LoginScreen;
import screens.WelcomeScreen;

import org.testng.annotations.*;

import base.TestBase;

/**
 * @author magagan@olx.ph
 */

@Features("Login User")
public class TestLoginContext extends TestBase {
	
	WelcomeScreen welcome;
	LoginScreen login;
	AccountLoginScreen acctlogin;
	LandingMain landingPage;
	LeftNavigation leftnav;
	BaseHelper base;
	
	@BeforeMethod
	public void init(){
    	welcome = new WelcomeScreen(driver);
		login = new LoginScreen(driver);	
		acctlogin = new AccountLoginScreen(driver);
		landingPage = new LandingMain(driver);
		leftnav = new LeftNavigation(driver);
		base = new BaseHelper(driver);
	}
	
	@Test(priority=1)
	@Stories("As A User I Want to be Able to Logout")
	@TestCaseId("TC_LOGIN_005")
	@Severity(SeverityLevel.CRITICAL)
	@Title("Verify User Able to Logout")
	public void userAbleToLogout() throws Throwable{
		System.out.println("Verify User Able to Logout");
		
		//base.logOutUser();
		landingPage.givenStepforReporting();
		landingPage.tapLeftNavigationWidget();
		leftnav.tapSettingsIconInLeftNavigationWidget();
		leftnav.userTapLogOut();
		login.validateSomeTextInLoginScreen();
		login.validateFacebookButton();
		login.validateCreateAnAccountButton();
		login.validateLoginToMyAccountButton();
		//base.loginToAccountUsingMobileNumber();
	}
	    	
    @Test(priority=2)
    @Stories("As A User I Want to be Able to access the app")
    @TestCaseId("TC_LOGIN_001")
    @Severity(SeverityLevel.CRITICAL)
    @Title("Verify user is able to see login screen")    
    public void verifyUserIsAbleToSeeLoginScreen() throws Throwable {
    	System.out.println("Verify user is able to see login screen");
    	//welcome = new WelcomeScreen(driver);
		//login = new LoginScreen(driver);
    	
    	//base.logOutUser();
    	//welcome.validateSkipWelcomeButton();
    	//welcome.skipWelcomeScreen();
    	login.givenStepforReporting();
        login.validateSomeTextInLoginScreen();
        login.validateFacebookButton();
        login.validateCreateAnAccountButton();
        login.validateLoginToMyAccountButton();
        //base.loginToAccountUsingMobileNumber();
    }
        
    @Test(priority=3)
    @Stories("As A User I Will not be Able to Login")
    @TestCaseId("TC_LOGIN_002")
    @Severity(SeverityLevel.CRITICAL)
    @Title("Verify User Not Able to Login with InValid Email Format") 
    public void userNotAbleToLoginWithInvalidEmailFormat () throws Throwable {
    	System.out.println("Verify User Not Able to Login with InValid Email Format");
    	
    	//base.logOutUser();
    	login.givenStepforReporting();
    	login.clickLoginToMyAccountButton();
    	acctlogin.enterInvalidEmailFormat();
    	acctlogin.enterPassword();
    	acctlogin.clickLoginToMyAccount();
    	acctlogin.verifyLoginElementsIsPresent();
    	acctlogin.backToLoginMain();
    	//base.loginToAccountUsingMobileNumber();
    }
    
	@Test(priority=4)
	@Stories("As A User I Will not be Able to Login")
	@TestCaseId("TC_LOGIN_003")
	@Severity(SeverityLevel.CRITICAL)
	@Title("Verify User Not Able to Login with InValid Credential")
	public void userNotAbleToLoginWithInvalidCredential() throws Throwable{
		System.out.println("Verify User Not Able to Login with InValid Credential");
		
		//base.logOutUser();
		login.givenStepforReporting();
		login.clickLoginToMyAccountButton();
		acctlogin.enterMobileEmail();
		acctlogin.enterInvalidPassword();
		acctlogin.clickLoginToMyAccount();
		Thread.sleep(1000);
		acctlogin.errorMessageDisplayForInvalidCredentials();
		acctlogin.backToLoginMain();
		//base.loginToAccountUsingMobileNumber();
	}    
     
    @Test(priority=5)
    @Stories("As A User I Want to be Able to Login with Valid Credential")
    @TestCaseId("TC_LOGIN_004")
    @Severity(SeverityLevel.BLOCKER)
    @Title("Verify User Able to Login with Valid Credential")
    public void i_am_in_the_login_screen() throws Throwable {
    	System.out.println("Verify User Able to Login with Valid Credential");
    	
    	//base.logOutUser();
    	login.givenStepforReporting();
    	login.clickLoginToMyAccountButton();
    	acctlogin.validateAcctLogginMobileEmailElement();
    	acctlogin.enterMobileEmail();
    	acctlogin.enterPassword();
    	acctlogin.clickLoginToMyAccount();
    	landingPage.validateSearchTextInputPresent();
    	landingPage.validateSellButtonPresent();
    	landingPage.validateSponsoredAdsPresent();
    }    
}
