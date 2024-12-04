package base;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;

public class MarsAirElementsTest extends BaseTest {
	
	HomePage homePage;
	SoftAssert softAssert= new SoftAssert();
	
	@Test
	public void testElementsVisibilityOnHomePage() {
		homePage= new HomePage(driver);
		
		driver.manage().timeouts().getImplicitWaitTimeout();
		softAssert.assertEquals(true, homePage.getDepartureDropdown().isDisplayed());
		softAssert.assertEquals(true, homePage.getReturnDropdown().isDisplayed());
		softAssert.assertEquals(true, homePage.getSearchButton().isDisplayed());
		softAssert.assertEquals(true, homePage.getPromoCodeInput().isDisplayed());
		softAssert.assertEquals(true, homePage.getBookYourTicketMessage().isDisplayed());
		softAssert.assertEquals("a", homePage.getBookYourTicketMessage().getTagName());
	}
	
}
