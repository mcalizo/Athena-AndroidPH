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
import screens.BaseHelper;
import screens.CreateAccountScreen;
import screens.LoginScreen;
import screens.WelcomeScreen;

/**
 * @author magagan@olx.ph
 */

@Features ("Create Account")
public class TestCreateAccount extends TestBase {
	
	LoginScreen login;
	CreateAccountScreen createAccount;
	WelcomeScreen welcome;
	BaseHelper base;
	
	@BeforeMethod
	public void init(){
 		welcome = new WelcomeScreen(driver);
 		login = new LoginScreen(driver);
 		createAccount = new CreateAccountScreen(driver);
		base = new BaseHelper(driver);
	}
	
 	@Test(priority=1)
    @Stories("As a user I must able to access Create Account Screen")
    @TestCaseId("TC_CRTACCT_001")
 	@Severity(SeverityLevel.BLOCKER)
    @Title("Verify if the user is able to access Create Account Screen")
 	public void verifyIfTheUserIsAbleToAccessCreateAccountScreen() throws Throwable {
 		System.out.println("Verify if the user is able to access Create Account Screen");
 		
 		//welcome.skipWelcomeScreen();
 		base.logOutUser();
 		login.givenStepforReporting();
 		login.clickCreateAnAccountButton();
 		
 		createAccount.verifyNameFieldsDisplayedInCreateAccountScreen();
 		createAccount.verifyMobileNumberFieldsDisplayedInCreateAccountScreen();
 		createAccount.verifyPasswordFieldsDisplayedInCreateAccountScreen();
 		createAccount.verifyRepeatPasswordFieldsDisplayedInCreateAccountScreen();
 		createAccount.backToPreviousScreen();
 		//base.loginToAccountUsingMobileNumber();
 	}
 	
 	@Test(priority=2)
    @Stories("As a user I should not be able to create account using registered mobile number")
    @TestCaseId("TC_CRTACCT_002")
 	@Severity(SeverityLevel.CRITICAL)
    @Title("Verify that an account is not created using a registered mobile number")
 	public void verifyThatAnAccountIsNotCreatedUsingAregisteredMobileNumber() throws Throwable {
 		System.out.println("Verify that an account is not created using a registered mobile number");
 		
 		//createAccount.backToPreviousScreen();
 		//base.logOutUser();
 		login.givenStepforReporting();
 		login.clickCreateAnAccountButton();
 		createAccount.userEnterAvalidName();
 		createAccount.userEnterAvalidRegisteredMobileNumber();
 		createAccount.userEnterPassword();
 		createAccount.userEnterRepeatPassword();
 		createAccount.userTapCreateAccountButton();
 		createAccount.verifyErrorMessageDisplayForAlreadyRegisteredMobileNumber();
 		createAccount.backToPreviousScreen();
 		//base.loginToAccountUsingMobileNumber();
 	}
 	
 	@Test(priority=3)
    @Stories("As a user I should not be able to create account using invalid mobile number")
    @TestCaseId("TC_CRTACCT_003")
 	@Severity(SeverityLevel.CRITICAL)
    @Title("Verify that an account is not created using invalid mobile number")
 	public void verifyThatAnAccountIsNotCreatedUsingInvalidMobileNumber() throws Throwable {
 		System.out.println("Verify that an account is not created using invalid mobile number");
 		
 		//base.logOutUser();
 		login.givenStepforReporting();
 		login.clickCreateAnAccountButton();
 		createAccount.userEnterAvalidName();
 		createAccount.userEnterAnInvalidMobileNumber();
 		createAccount.userEnterPassword();
 		createAccount.userEnterRepeatPassword();
 		createAccount.userTapCreateAccountButton();
 		createAccount.verifyErrorMessageDisplayForInvalidMobileNumber();
 		createAccount.backToPreviousScreen();
 		//base.loginToAccountUsingMobileNumber();
 	}
 	
 	@Test(priority=4)
    @Stories("As a user I should not be able to create account if password do not match")
    @TestCaseId("TC_CRTACCT_004")
 	@Severity(SeverityLevel.CRITICAL)
    @Title("Verify that an account is not created if password do not match")
 	public void verifyThatAnAccountIsNotCreatedIfPasswordDoNotMatch() throws Throwable {
 		System.out.println("Verify that an account is not created if password do not match");
 		
 		//base.logOutUser();
 		login.givenStepforReporting();
 		login.clickCreateAnAccountButton();
 		createAccount.userEnterAvalidName();
 		createAccount.userEnterNotRegisteredMobileNumber();
 		createAccount.userEnterPassword();
 		createAccount.userEnterDifferentPassword();
 		createAccount.userTapCreateAccountButton();
 		createAccount.verifyErrorMessageDisplayForPasswordDoNotMatch();
 		createAccount.backToPreviousScreen();
 		//base.loginToAccountUsingMobileNumber();
 	}
 	
 	@Test(priority=5)
    @Stories("As a user I should not be able to create account if Name is blank")
    @TestCaseId("TC_CRTACCT_005")
 	@Severity(SeverityLevel.TRIVIAL)
    @Title("Verify that an account is not created if Name is blank")
 	public void verifyThatAnAccountIsNotCreatedIfNameIsBlank() throws Throwable {
 		System.out.println("Verify that an account is not created if Name is blank");
 		
 		//base.logOutUser();
 		login.givenStepforReporting();
 		login.clickCreateAnAccountButton();
 		createAccount.userEnterNotRegisteredMobileNumber();
 		createAccount.userEnterPassword();
 		createAccount.userEnterRepeatPassword();
 		createAccount.userTapCreateAccountButton();
 		createAccount.verifyErrorMessageDisplayForBlankOrEmptyName();
 		createAccount.backToPreviousScreen();
 		//base.loginToAccountUsingMobileNumber();
 	}
 	
 	@Test(priority=6)
    @Stories("As a user I should not be able to create account if Mobile is blank")
    @TestCaseId("TC_CRTACCT_006")
 	@Severity(SeverityLevel.CRITICAL)
    @Title("Verify that an account is not created if Mobile is blank")
 	public void verifyThatAnAccountIsNotCreatedIfMobileIsBlank() throws Throwable {
 		System.out.println("Verify that an account is not created if Mobile is blank");
 		
 		//base.logOutUser();
 		login.givenStepforReporting();
 		login.clickCreateAnAccountButton();
 		createAccount.userEnterAvalidName();
 		createAccount.userEnterPassword();
 		createAccount.userEnterRepeatPassword();
 		createAccount.userTapCreateAccountButton();
 		createAccount.verifyErrorMessageDisplayForBlankOrEmptyMobileNumber();
 		createAccount.backToPreviousScreen();
 		base.loginToAccountUsingMobileNumber();
 	}

}
