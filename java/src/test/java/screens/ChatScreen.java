package screens;

import java.util.Iterator;
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

public class ChatScreen extends ScreenBase {
	
	@AndroidFindBy(id="ph.com.sulit.app:id/header_user")
	public MobileElement userName;
	//@AndroidFindBy(id="ph.com.sulit.app:id/message")
	@AndroidFindBy (xpath="//*[@text='Type a message here']")
	public MobileElement textInput;
	@AndroidFindBy(id="ph.com.sulit.app:id/sendBtn")
	public MobileElement textSendButton;
	@AndroidFindBy(id="ph.com.sulit.app:id/message_body")
	public MobileElement chatMessage;
	@AndroidFindBy (xpath="//*[@text='639157694429']")
	public MobileElement buyerInboxMessage;
	@AndroidFindBy (xpath="//*[@text='Flora M']")
	public MobileElement sellerInboxMessage;
	@AndroidFindBy(xpath="//*[@content-desc='Navigate up']")
	public MobileElement backToPreviousScreen;
	@AndroidFindBy(xpath="//*[@content-desc='More options']")
	public MobileElement moreOptions;
	@AndroidFindBy (xpath="//*[@text='Delete Conversation']")
	public MobileElement deleteConversation;
	@AndroidFindBy (xpath="//*[@text='Delete messages']")
	public MobileElement confirmDelete;
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='1']/android.widget.FrameLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='0']")
	public MobileElement confirmationMessageElement;
	@AndroidFindBy(xpath="//android.widget.TextView[@index='1']")
	public MobileElement noMessageYetElement;
	@AndroidFindBy(id="ph.com.sulit.app:id/title")
	public MobileElement chatAdTitle;
	
//	@AndroidFindBys({	
//		@AndroidFindBy(id="ph.com.sulit.app:id/messages_view"),
//		@AndroidFindBy(id="ph.com.sulit.app:id/message_box"),
//		@AndroidFindBy(id="ph.com.sulit.app:id/message_body"),
//	})
	
	@AndroidFindBys({	
		@AndroidFindBy(id="ph.com.sulit.app:id/chatList"),
		@AndroidFindBy(id="ph.com.sulit.app:id/innerLayout"),
		@AndroidFindBy(id="ph.com.sulit.app:id/message"),
	})	
	
	public List<AndroidElement> chatConversation;
	
	@AndroidFindBys({	
		@AndroidFindBy(id="ph.com.sulit.app:id/swipeable_item"),
		@AndroidFindBy(id="ph.com.sulit.app:id/subtitle_name"),
	})
	
	public List<AndroidElement> chatInboxElement;
	
	@AndroidFindBys({	
		@AndroidFindBy(xpath="//*[@text='Floro M.']"),
	})
	
	public List<AndroidElement> buyerMessage;
	
	@AndroidFindBy(id="ph.com.sulit.app:id/subtitle_name")
	public MobileElement conversationSubTitle;
	
	
	public String confirmationMessage = "Do you want to delete this conversation?This will not influence messages stored on other devices or servers.";
	public String noMessageYet = "No Messages yet";
	
	
	public ChatScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit.SECONDS), this);
	}
	
	@Step("Verify name displayed in details screen and chat screen is same.")
	public void verifynameDisplayedInDetailsScreenAndChatIsSame (String name) {
		Assert.assertEquals(userName.getText(), name);
	}
	
	@Step("Verify ad title displayed in details screen and chat screen is same.")
	public void verifyAdTitleDisplayedInDetailsScreenAndChatIsSame (String title) {
		Assert.assertEquals(chatAdTitle.getText(), title);
	}
	
	@Step("Verify text input is displayed in chat screen")
	public void verifyTextInputIsDisplayed(){
		assert textInput.isDisplayed();
	}
	
	@Step("Verify text send button is displayed in chat screen")
	public void verifySendTextButtonIsDisplayed(){
		assert textSendButton.isDisplayed();
	}
	
	@Step("Buyer enter message to seller")
	public void buyerEnterMessageToSeller(String message) {
		textInput.clear();

		sendKeysElements(textInput, message);
		//textInput.sendKeys(message);
	}
	
	@Step("Buyer tap send message button")
	public void clickSendButton(){
		textSendButton.click();
	}
	
	@Step("Verify buyer message to seller")
	public void verifyBuyerMessageToSeller (String expectedMsg, String actualMsg) {
		Assert.assertEquals(actualMsg,expectedMsg);
	}
	
	@Step("Verify that seller recieved the message of buyer")
	public void verifyThatSellerRecievedTheMessageOfBuyer (String message) {
		Assert.assertEquals(getLatestChatMessage(), message);
	}
	
	@Step("Seller tap message from buyer")
	public void sellerTapMessageFromBuyer () {
		buyerInboxMessage.click();
	}
	
	@Step("Buyer tap message from seller")
	public void buyerTapMessageFromSeller () {
		sellerInboxMessage.click();
	}
	
	public void backToPrevScreen () {
		backToPreviousScreen.click();
	}
	
	@Step("Tap option of upper right of screen")
	public void tapOptionOfUpperRightOfScreen () {
		moreOptions.click();
	}
	
	@Step("Tap DELETE CONVERSATION option")
	public void tapDeleteConversationOption () {
		deleteConversation.click();
	}
	
	@Step("Tap DELETE MESSAGES to confirm deletion of message")
	public void tapDeleteMessagesToConfirmDeletionOfMessage () {
		confirmDelete.click();
	}
	
	@Step("Verify delete confirmation message")
	public void verifyDeleteConfirmationMessage () {
		String message = confirmationMessageElement.getText();
		String cleanMessage = message.replaceAll("\\n", "");
		System.out.println("Expected: " + confirmationMessage);
		System.out.println("Actual: " + cleanMessage);
		Assert.assertEquals(cleanMessage, confirmationMessage);
	}
	
	@Step("Verify message deleted in chat inbox")
	public void verifyBuyerMessageDeletedInChatInbox () {
		Assert.assertEquals(buyerMessage.size(), 0);
	}
	
	@Step("Verify chat inbox has no messages displayed")
	public void verifyChatInboxHasNoMessagesDisplayed () {
		Assert.assertEquals(chatInboxElement.size(), 0);
	}
	
	public String getLatestChatMessage () {
		
		//Object[] messageChatArr = chatConversation.toArray();
		AndroidElement messagechat = chatConversation.remove(chatConversation.size() - 1);
		//messagechat.getText()
		
		return messagechat.getText();
	}
	
	//@Step("User delete chat conversation to seller")
	public void deleteChatConversaion () throws Throwable {
		
		int chatCount = getChatCount();
		System.out.println("Chat Inbox Count is " + chatCount );
		if (chatCount == 1) {
			conversationSubTitle.click();
			moreOptions.click();
			deleteConversation.click();
			confirmDelete.click();
			
			Thread.sleep(2000);
		} else {
			int counter;
			counter = 0;
			for (;counter != chatCount; ) {
				conversationSubTitle.click();
				moreOptions.click();
				deleteConversation.click();
				confirmDelete.click();
				Thread.sleep(2000);
				counter++;
			}	
		}
	}
	
	public int getChatCount() {
		return chatInboxElement.size();
	}
	
	
	
	
	
	
	
	
	
	
}
