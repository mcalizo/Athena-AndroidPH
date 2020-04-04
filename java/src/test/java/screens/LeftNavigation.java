package screens;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ru.yandex.qatools.allure.annotations.Step;

public class LeftNavigation extends ScreenBase {
	
	LandingMain landing;
	
	@AndroidFindBy(id="ph.com.sulit.app:id/overflow")
	public MobileElement settingsIcon;
	@AndroidFindBy(xpath="//*[@text='Log Out']")
	public MobileElement logOutElement;
	@AndroidFindBy(xpath="//*[@text='Favorites']")
	public MobileElement tapFavorites;
	@AndroidFindBy(xpath="//*[@text='Home']")
	public MobileElement tapHome;
	@AndroidFindBy(id="ph.com.sulit.app:id/navigation_icon")
	public MobileElement leftMenuNavIco;	
	@AndroidFindBy(id="ph.com.sulit.app:id/login_username")
	public MobileElement tapUserProfile;
	//@AndroidFindBy (xpath="//*[@text='Chat']")
	@AndroidFindBy(id="ph.com.sulit.app:id/messages_counter")
	public MobileElement leftDrawerChat;
	@AndroidFindBy(xpath="//android.support.v4.widget.DrawerLayout[@index='0']/android.widget.FrameLayout[@index='2']/android.widget.ListView[@index='0']/android.widget.LinearLayout[@index='8']/android.widget.TextView[@index='1']")
	public MobileElement chatLeftDrawer;
	@AndroidFindBy(xpath="//*[@text='Manage Ads']")
	public MobileElement ManageAds;
	@AndroidFindBy(xpath="//*[@text='Browse ads']")
	public MobileElement BrowseAds;
	
	public String navHome = "Home";
	public String navMyProfile = "My Profile";
	public String navManageAds = "Manage Ads";
	public String navBrowseAds = "Browse ads";
	public String navChat = "Chat";
	public String navFavorites = "Favorites";
	
	@AndroidFindBys({	
		@AndroidFindBy(id="ph.com.sulit.app:id/drawer_layout"),
		@AndroidFindBy(id="ph.com.sulit.app:id/navigation_drawer"),
		@AndroidFindBy(xpath="//android.widget.ListView[@index='0']"),
		@AndroidFindBy(id="ph.com.sulit.app:id/text"),
	})
	
	public List<AndroidElement> leftNaviOption;

	public LeftNavigation(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit.SECONDS), this);
	}
	
	@Step("User Tap settings icon in left navigation widget")
	public void tapSettingsIconInLeftNavigationWidget() {
		settingsIcon.click();
		//new TouchAction(driver).tap(829, 427).waitAction(2000).perform();
	}
	
	@Step("User Tap Log Out")
	public void userTapLogOut () {
		logOutElement.click();
		//620 , 720
	}
	
	@Step("User Click the Favorites")
	public void clickFavoritesMenu() throws Exception{
		//swipingTopToBottom();
		leftNavOption(navFavorites);
	}
	
	@Step("User tap Manage Ads")
	public void tapManageAds() {
		leftNavOption(navManageAds);
	}
	
	@Step("User tap Browse Ads")
	public void tapBrowseAds() {
		leftNavOption(navBrowseAds);
	}
	
	@Step("User tap Home in left Drawer")
	public void clickHome() throws Exception{
		//swipingTopToBottom();
		leftNavOption(navHome);
	}
	
	@Step("User navigate to Home via left drawer")
	public void NavigateToHomeViaLeftDrawer () throws Throwable {
		
		leftMenuNavIco.click();
		Thread.sleep(2000);
		swipingTopToBottom();
		leftNavOption(navHome);
		Thread.sleep(2000);
	}
	
	@Step("User Tap User Profile")
	public void TapUserProfile() {
		tapUserProfile.click();	
	}
	
	public void NavigateToHomeViaLeftDrawerNoStep () throws Throwable {
		
		leftMenuNavIco.click();
		Thread.sleep(2000);
		leftNavOption(navHome);
	}
	
	public void NavigateToHomeViaLeftDrawerNoStep1 () throws Throwable {
		
		landing = new LandingMain(driver);
		
		landing.leftDrawerIntro.click();
		//leftMenuNavIco.click();
		Thread.sleep(2000);
		leftNavOption(navHome);
	}
	
	@Step("Tap Chat in Left drawer")
	public void tapChatInLeftDrawer(String param) {
		leftNavOption(param);
	
	}
	
	@Step("Tap Home in Left Navigation Drawer")
	public void tapHomeInLeftNavigationDrawer(String param) {
		leftNavOption(param);
	}
	
	public int getLeftNavOptionCount () {
		return leftNaviOption.size();
	}
	
	public void leftNavOption (String option) {
				
		int count = leftNaviOption.size();
		
		for (int i=0;i < count; i++) {
			AndroidElement objecElement = leftNaviOption.get(i);
			String elementText = objecElement.getText();
			//String cleanString = elementText.replaceAll("\\s+", "");
			if (option.equals(elementText)) {
				System.out.println("********* Match Condition Parameter (" + elementText + ") *********");
				objecElement.click();
				break;
			}
		}		
	}
}