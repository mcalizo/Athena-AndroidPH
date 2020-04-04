package screens;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ru.yandex.qatools.allure.annotations.Step;

public class FavoritesScreen extends ScreenBase {
	
	@AndroidFindBys({	
		@AndroidFindBy(id="ph.com.sulit.app:id/data_container"),
		@AndroidFindBy(id="ph.com.sulit.app:id/title"),
	})
	
	public List<AndroidElement> favoriteAds;
	
	@AndroidFindBy(id="ph.com.sulit.app:id/btnDelete")
	public MobileElement deleteFavoritesAd;
	@AndroidFindBy(id="ph.com.sulit.app:id/title")
	public MobileElement favoriteAdTitle;
	@AndroidFindBy(id="ph.com.sulit.app:id/price")
	public MobileElement favoriteAdPrice;
	@AndroidFindBy(id="ph.com.sulit.app:id/photo")
	public MobileElement favoriteAdPhoto;
	@AndroidFindBy(id="ph.com.sulit.app:id/message")
	public MobileElement NofavoriteAd;
	
	
	public FavoritesScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit.SECONDS), this);
	}
	
	@Step("User delete Favorite ad")
	public void deleteFavoriteAd () throws Throwable {
		
		int favCount = favoriteAdsCount();
		System.out.println("Favorites Ad Count is " + favCount );
		if (favCount == 1) {
			deleteFavoritesAd.click();
			Thread.sleep(2000);
		} else {
			int counter;
			counter = 0;
			for (;counter != favCount; ) {
				deleteFavoritesAd.click();
				Thread.sleep(2000);
				counter++;
			}	
		}
	}
	
	@Step("Verify Ad Title in Favorites Ad screen")
	public void verifyAdTitleInFavoritesAdScreen (String title) {
		Assert.assertEquals(favoriteAdTitle.getText(), title);
	}
	
	@Step("Verify Ad Price in Favorites Ad screen")
	public void verifyAdPriceInFavoritesAdScreen (String price) {
		Assert.assertEquals(favoriteAdPrice.getText(), price);
	}
	
	@Step("Verify Ad Photo in Favorites Ad screen is present")
	public void verifyAdPhotoInFavoritesAdScreenPresent () {
		favoriteAdPhoto.isDisplayed();
	}
	
	@Step("Verify user able to delete favorite ad")
	public void verifyUserAbleToDeleteFavoriteAd () {
		Assert.assertEquals(NofavoriteAd.getText(), "You don't have favorite ads");
	}
	
	@Step("User click bookmarked/favorited ad")
	public void userClickFavoritedAds () {
		favoriteAdTitle.click();
	}
	
	public int favoriteAdsCount () {
		return favoriteAds.size();
	}

}
