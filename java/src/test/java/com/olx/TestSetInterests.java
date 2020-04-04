package com.olx;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;
import screens.AccountLoginScreen;
import screens.LandingMain;
import screens.LoginScreen;
import screens.WelcomeScreen;

@Features("Interest Screen")
public class TestSetInterests extends TestBase {
	
	WelcomeScreen welcome;
	//LoginScreen login;
	//AccountLoginScreen acctlogin;
	//LandingMain landingPage;
	
//	@BeforeTest
//	public void init () {
//		welcome = new WelcomeScreen(driver);
//		login = new LoginScreen(driver);
//		acctlogin = new AccountLoginScreen(driver);
//		landingPage = new LandingMain(driver);
//	}
	
    @Test(priority=1)
    @Stories("As A User I Want to be Able to set my interests ad posting")
    @TestCaseId("TC_INTERESTS_001")
    @Title("Verify user is able to set Interests ad posting")    
    public void i_am_not_login_to_olx_app() throws Throwable {
    	welcome = new WelcomeScreen(driver);
    	welcome.validateSkipWelcomeButton();
    	welcome.skipWelcomeScreen();
  	
    }
	
	

}
