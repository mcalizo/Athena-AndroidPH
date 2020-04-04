package screens;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ru.yandex.qatools.allure.annotations.Step;

public class AdListingScreen extends ScreenBase {
	
	@AndroidFindBys({	
		@AndroidFindBy(id="ph.com.sulit.app:id/recycler"),
		@AndroidFindBy(id="ph.com.sulit.app:id/root_layout"),
	})
	
	public List<AndroidElement> AdCount;
	
	@AndroidFindBys({	
		@AndroidFindBy(id="ph.com.sulit.app:id/recycler"),
		@AndroidFindBy(id="ph.com.sulit.app:id/buynowbadge"),
	})
	
	public List<AndroidElement> BuynowAds;

	public String searchKeyword2 = "honda";
	public String countCheck;

		
	@AndroidFindBy(id="ph.com.sulit.app:id/toolbar_title")
	public MobileElement SearchField;	
	@AndroidFindBy(id="ph.com.sulit.app:id/filtersButton")
	public MobileElement FiltersButton;	
	@AndroidFindBy(id="ph.com.sulit.app:id/categoryButton")
	public MobileElement CategoryButton;
	@AndroidFindBy(id="ph.com.sulit.app:id/sponsored_ribbon")
	public MobileElement sponsored_ribbon;
	@AndroidFindBy(id="ph.com.sulit.app:id/sell_button")
	public MobileElement sell_button;
	//@AndroidFindBy(id="ph.com.sulit.app:id/action_search")
	@AndroidFindBy(id="ph.com.sulit.app:id/toolbar_title")
	public MobileElement search_button;
	@AndroidFindBy(id="ph.com.sulit.app:id/imageView_clear")
	public MobileElement clear_button;
	@AndroidFindBy(id="ph.com.sulit.app:id/searchEditText_input")
	public MobileElement searchText_input;
	//@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='1' and @text='iphone']")
	@AndroidFindBy(xpath="//*[@text='iphone']")
	public MobileElement dropdown_item;
	@AndroidFindBy(id="ph.com.sulit.app:id/errorImage")
	public MobileElement MagnifyingImage;
	@AndroidFindBy(id="ph.com.sulit.app:id/errorDetails")
	public MobileElement Noresultsfound;
	@AndroidFindBy(id="ph.com.sulit.app:id/navigation_icon")
	public MobileElement leftNavWidget;
	//@AndroidFindBy(xpath="//android.support.v7.widget.RecyclerView[@index='0']/android.widget.FrameLayout[@index='3']/android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='0']")
	@AndroidFindBy(id="ph.com.sulit.app:id/image")
	public MobileElement clickOrganicAd;
	//@AndroidFindBy(xpath="//android.support.v7.widget.RecyclerView[@index='0']/android.widget.FrameLayout[@index='3']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
	@AndroidFindBy(id="ph.com.sulit.app:id/price")
	public MobileElement organicAdPrice;
	//@AndroidFindBy(xpath="//android.support.v7.widget.RecyclerView[@index='0']/android.widget.FrameLayout[@index='3']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='2']")
	@AndroidFindBy(id="ph.com.sulit.app:id/title")
	public MobileElement organicAdTitle;
	@AndroidFindBy(id="ph.com.sulit.app:id/buynowfeeds")
	public MobileElement Tapbuynowfeeds;
	@AndroidFindBy(id="ph.com.sulit.app:id/buynowbanner")
	public MobileElement Banner;
	@AndroidFindBy(xpath="//*[@text='Home']")
	public MobileElement tapHome;
	@AndroidFindBy(id="ph.com.sulit.app:id/price")
	public MobileElement Adprice;
	@AndroidFindBy(id="ph.com.sulit.app:id/title")
	public MobileElement Adtitle;
	@AndroidFindBy(id="ph.com.sulit.app:id/buynowbadge")
	public MobileElement buynowbadge;
	@AndroidFindBy(id="ph.com.sulit.app:id/categoryButton")
	public MobileElement AllCategories;
	@AndroidFindBy(id="ph.com.sulit.app:id/filtersButton")
	public MobileElement Filtersbutton;
	@AndroidFindBy(id="ph.com.sulit.app:id/overflow")
	public MobileElement MoreOption;
	@AndroidFindBy(xpath="//*[@text='Price: Most Expensive First']")
	public MobileElement MostExpensive;
	@AndroidFindBy(xpath="//*[@text='Price: Cheapest First']")
	public MobileElement CheapestFirst;
	@AndroidFindBy(xpath="//*['Relevance']")
	public MobileElement Relevance;
	
	
	public AdListingScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit.SECONDS), this);
		
	}
		
	@Step("Verify Search Field is displayed")
	public void validateSearchTextFieldPresent () {
		SearchField.isDisplayed();
	}
	
	@Step("Verify Filters Button is displayed")
	public void validateFiltersButtonPresent () {
		FiltersButton.isDisplayed();
	}
	
	@Step("Verify Category Button is displayed")
	public void validateCategoryButtonPresent () {
		CategoryButton.isDisplayed();
	}
	
	@Step("Verify Sponsored ads is displayed")
	public void validateSponsoredAdsPresent () {
		sponsored_ribbon.isDisplayed();
	}
	
	@Step("Verify Sell Button is Displayed")
	public void validateSellButtonPresent () {
		sell_button.isDisplayed();
	}	
	
	@Step("Tap Search Button")
	public void TapSearch () {
		search_button.click();
		
	}
	
	@Step("Tap Clear Button")
	public void TapClear () {
		clear_button.click();
	}
	
	@Step("User Search an Ad")
	public void SearchKeyword () {
		searchText_input.click();
		sendKeysElements(searchText_input, "honda");
		((AndroidDriver<?>)driver).pressKeyCode(AndroidKeyCode.ENTER);
	}
	
	@Step("User Tap one of the previous Search")
	public void TapDropDown () {
		dropdown_item.click();
	}

	@Step("User search ad with No Results")
	public void NoResults () {
		searchText_input.click();
		sendKeysElements(searchText_input, "zzzzzxxx");
		((AndroidDriver<?>)driver).pressKeyCode(AndroidKeyCode.ENTER);
    }
	
	@Step("Verify No Result Image is displayed")
	public void validateNoResultImageisPresent () {
		MagnifyingImage.isDisplayed();
	}

	@Step("Verify No Result Found is displayed")
	public void validateNoResultFoundTextisPresent () {
		Noresultsfound.isDisplayed();
	}
	
	@Step("Verify the search keyword displayed at search input bar")
	public void verifyTheSearchKeywordDisplayedAtSearchInputBar (String searchKeyword) {
		Assert.assertEquals(SearchField.getText(), searchKeyword);
	}
	
	@Step("User Click an ad")
	public void clickFirstOrganiclAd() throws Throwable {
//		Thread.sleep(3000);
//		System.out.println("Tap Left Nav");
//		leftNavWidget.click();
//		Thread.sleep(2000);
//		System.out.println("Tap on screen");
//		new TouchAction(driver).tap(1000, 300).waitAction(2000).perform();	
//		Thread.sleep(2000);
		clickOrganicAd.click();
	}
	
	@Step("User search an Ad")
	public void userSearchAnAdNoActualStepForReporting () {
		
	}
	
	@Step("User Click the buy now feeds")
	public void tapbuynowfeeds () {
		Tapbuynowfeeds.click ();
	}	
	
	@Step("Verify buynow banner is displayed")
	public void validatebuynowbanner () {
		Banner.isDisplayed();
		
	}	
	
	@Step("User Tap the left drawer")
	public void Tapleftnavigation () throws Exception{
		leftNavWidget.click();
	}
	
	@Step("User Tap Home in the left drawer")
	public void TapHome () {
		tapHome.click();
	}	
	
	@Step("User Tap Buy now Ad")
	public void TapBuynowAd () {
		Adtitle.click();
	}	
	
	@Step("Verify lightning badge is displayed")
	public void validatebuynowbadge () {
		buynowbadge.isDisplayed();
	}	
	
	public int BuynowAdsCount () {
		return BuynowAds.size();
	}
	
	public int Adscount () {
		return AdCount.size();	
	}
	
	@Step("Validate Buy Now Ad is equal to displayed ad In Ad Listing")
	public void verifyBuyNowAdsinListing (int buynowcount, int Adcount) {
		countCheck = adCountAndBuyNowAd_checking(buynowcount,Adcount);
		
		Assert.assertEquals(countCheck, "Ad count is greater than buy now badge count");
	}
	
	public String adCountAndBuyNowAd_checking(int buynow, int adcount){
		if (adcount >= buynow){ 
			return "Ad count is greater than buy now badge count";
		} else {
			return "Ad count is less than buy now badge count";
		} 
	}
	
	public void Tapleftdrawer () throws Exception{
		leftNavWidget.click();
		
	}
	
	public void Taphome () {
		tapHome.click();
		
	}	
	
	public void clickfirstOrganiclAd() throws Throwable {
//		Thread.sleep(3000);
//		System.out.println("Tap Left Nav");
//		leftNavWidget.click();
//		Thread.sleep(2000);
//		System.out.println("Tap on screen");
//		new TouchAction(driver).tap(1000, 300).waitAction(2000).perform();	
//		Thread.sleep(2000);
		clickOrganicAd.click();
	}
	
	@Step("User Tap All Categories")
	public void tapAllCategories () {
		AllCategories.click();
		
	}
	
	@Step("User Tap Filters")
	public void tapFilters () {
		Filtersbutton.click();
	}
	
	public void TapleftNavigation () throws Exception{
		leftNavWidget.click();
	}
	
	@Step("User Tap more Option Button")
	public void TapOption () {
		MoreOption.click();
		
	}
	
	@Step("User Tap Most Expensive Option Button")
	public void TapMostExpensive () {
		MostExpensive.click();
		
	}
	
	@Step("User Tap Cheapest First in More Option")
	public void TapCheapestFirst () {
		CheapestFirst.click();
		
	}
	
}
	
	