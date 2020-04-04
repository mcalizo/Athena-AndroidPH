package screens;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ru.yandex.qatools.allure.annotations.Step;

public class AdDetailsScreen extends ScreenBase{
	
	@AndroidFindBy(id="ph.com.sulit.app:id/galleryPager")
	public MobileElement adPhotos;
	@AndroidFindBy(id="ph.com.sulit.app:id/btnUserAds")
	public MobileElement userInfo;
	@AndroidFindBy(id="ph.com.sulit.app:id/userName")
	public MobileElement userName;
	@AndroidFindBy(id="ph.com.sulit.app:id/user_online")
	public MobileElement userStatus;	
	@AndroidFindBy(id="ph.com.sulit.app:id/userRegistrationDate")
	public MobileElement dateRegister;
	@AndroidFindBy(id="starRating")
	public MobileElement ratings;
	@AndroidFindBy(id="ph.com.sulit.app:id/btnContactSeller")
	public MobileElement contactSellerButton;
	@AndroidFindBy(id="ph.com.sulit.app:id/btnMap")
	public MobileElement locationMap;
	@AndroidFindBy(id="ph.com.sulit.app:id/adDescription")
	public MobileElement adDescription;
	@AndroidFindBy(id="ph.com.sulit.app:id/btnMakeAnOffer")
	public MobileElement makeOffer;
	@AndroidFindBy(id="ph.com.sulit.app:id/sdl_title")
	public MobileElement makeOfferModal;
	@AndroidFindBy(id="ph.com.sulit.app:id/value")
	public MobileElement makeOfferAmount;
	@AndroidFindBy(id="ph.com.sulit.app:id/sdl_button_positive")
	public MobileElement offerSubmit;
	@AndroidFindBy(id="ph.com.sulit.app:id/adIdText")
	public MobileElement adId;
	@AndroidFindBy(id="ph.com.sulit.app:id/btnReport")
	public MobileElement reportButton;
	@AndroidFindBy(id="ph.com.sulit.app:id/btn_chat")
	public MobileElement chatButton;
	@AndroidFindBy(xpath="//android.widget.ImageButton[@index='0']")
	public MobileElement tapReturnToDetails;	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Navigate up' and @index='0']")
	public MobileElement tapReturnToListings;
	@AndroidFindBy(id="ph.com.sulit.app:id/action_observe")
	public MobileElement clickBookmark;
	@AndroidFindBy(id="ph.com.sulit.app:id/price")
	public MobileElement AdDetailsPrice;
	@AndroidFindBy(id="ph.com.sulit.app:id/title")
	public MobileElement AdDetailsTitle;
	@AndroidFindBy(id="ph.com.sulit.app:id/userPhoto")
	public MobileElement TapUserProfile;
	@AndroidFindBy(xpath="//android.widget.ImageButton[@index='0']")
	public MobileElement backbutton;
	
	

	
	public AdDetailsScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit.SECONDS), this);
	}
	
	@Step("Verify Ad photo is displayed")
	public void validateAdPhotoPresent(){
		assert adPhotos.isDisplayed();
	}
	
	@Step("Verfiy User info is displayed")
	public void validateUserInfoPresent(){
		assert userInfo.isDisplayed();
	}
	
	@Step("Verify Username is displayed")
	public void validateUserNamePresent(){
		assert userInfo.isDisplayed();
	}
	
	@Step("Verify User status is displayed")
	public void validateUserStatusPresent(){
		assert userStatus.isDisplayed();
	}
	
	@Step("Verify Date Registered is displayed")
	public void validateDateRegisteredPresent(){
		assert dateRegister.isDisplayed();
	}
	
	@Step("Verify Contact Seller Button is displayed")
	public void validateContactSellerButtonPresent(){
		assert contactSellerButton.isDisplayed();
	}
	
	@Step("Tap Contact Seller Button")
	public void tapContactSellerButton(){
		contactSellerButton.click();
	}
	
	@Step("Verify Ad Description is displayed")
	public void validateAdDescriptionPresent(){
		assert adDescription.isDisplayed();
	}
	
	@Step("Verify Location is displayed")
	public void validateLocationPresent(){
		assert locationMap.isDisplayed();
	}
	
	@Step("Verify Make Offer Button is displayed")
	public void validateMakeanOfferButtonPresent(){
		assert makeOffer.isDisplayed();
	}
	
	@Step("Tap Make an Offer Button")
	public void tapMakeanOfferButton(){
		makeOffer.click();
	}
	
	@Step("Verify Make an OFfer Modal is displayed")
	public void validateMakeOfferModalPreset(){
		assert makeOfferModal.isDisplayed();
	}
	
	@Step("User Enter Amount to offer")
	public void enterMakeOfferAmount(){
		makeOfferAmount.sendKeys("5000");
	}
	
	@Step("User tap the OK button to submit")
	public void tapOkButtonToOffer(){
		offerSubmit.click();
	}
	
	@Step("Verify Report Button is displayed")
	public void validateReportButtonPresent(){
		assert reportButton.isDisplayed();
	}
	
	@Step("User tap the Report Button")
	public void tapReportButton(){
		reportButton.click();
	}
	
	@Step("verify Chat Button is displayed")
	public void validateChatButtonPresent(){
		assert chatButton.isDisplayed();
	}
	
	@Step("Tap chat button")
	public void tapChatButton(){
		chatButton.click();
	}
	
	@Step("Tap Return to Ad Details Page")
	public void tapReturnToAdDetailsButton(){
		tapReturnToDetails.click();
	}
	
	@Step("Tap Return to Ad Listing Page")
	public void tapReturnToAdListingButton() throws Throwable{
		Thread.sleep(2000);
		tapReturnToListings.click();
	}
	
	@Step("Tap Bookmark")
	public void tapBookmark() throws Throwable{
		Thread.sleep(2000);
		clickBookmark.click();
	}
	
	@Step("Verify Ad Title in Ad Details screen")
	public void verifyAdTitleInFavoritesAdScreen (String title) {
		Assert.assertEquals(AdDetailsTitle.getText(), title);
	}
	
	@Step("Verify Ad Price in Ad Details screen")
	public void verifyAdPriceInFavoritesAdScreen (String price) {
		Assert.assertEquals(AdDetailsPrice.getText(), price);
	}
	
	@Step("User tap back arrow to go back at favorites screen")
	public void userTapBackArrowToGoBackAtFavoritesScreen () {
		tapReturnToListings.click();
	}
	
	@Step("User tap My Profile")
	public void usertapMyProfile () {
		TapUserProfile.click();
	}
	
	public void tapBackButtonNoStep() {
		tapReturnToListings.click();
	}
	
	public void tapReturnToAdDetailsButtonNoStep(){
		tapReturnToDetails.click();
	}

	public void tapbackbutton(){
		backbutton.click();
	}
	
}
