package base;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import utils.DataProviders;
import utils.FlightSearchDetails;

public class FlightSearchTest extends BaseTest{
	HomePage homePage;
	SoftAssert softAssert= new SoftAssert();
	
	@Test(dataProvider = "flightSearchDataProvider", dataProviderClass = DataProviders.class)
	public void flightSearchTest(FlightSearchDetails flightSearchDetails)  {
	  homePage= new HomePage(driver);
	  driver.manage().timeouts().getImplicitWaitTimeout();
	  homePage.selectDepartureMonth(flightSearchDetails.getDepartureMonth());
	  homePage.selectReturnMonth(flightSearchDetails.getReturnMonth());
	  homePage.clickSearchButton();
	  Assert.assertEquals(flightSearchDetails.getExpectedResult(), homePage.getMessageText());  
	}

	@Test
	public void redirectionOfHomePage() {
	  homePage= new HomePage(driver);
	  driver.manage().timeouts().getImplicitWaitTimeout();
	  homePage.selectDepartureMonth("July");
	  homePage.selectReturnMonth("December");
	  homePage.clickSearchButton();
	  homePage.getMarsAirHomeButton().click();
	  softAssert.assertEquals("Mars Airlines: Home", driver.getTitle());
	}
	
	@Test
	public void flightSearchWithValidPromoCode() {
	  homePage= new HomePage(driver);
	  driver.manage().timeouts().getImplicitWaitTimeout();
	  homePage.selectDepartureMonth("July");
	  homePage.selectReturnMonth("December (two years from now)");
	  homePage.enterPromoCode("AF3-FJK-418");
	  homePage.clickSearchButton();
	  Assert.assertEquals("30% discount", homePage.getPromoPercentage().getText());
	}
	
	@Test
	public void flightSearchWithInvalidPromoCode() {
	  homePage= new HomePage(driver);
	  driver.manage().timeouts().getImplicitWaitTimeout();
      homePage.selectDepartureMonth("July");
	  homePage.selectReturnMonth("December (two years from now)");
	  homePage.enterPromoCode("XXjhjhd-898");
	  homePage.clickSearchButton();
	  Assert.assertEquals("Sorry, code XXjhjhd-898 is not valid", homePage.getPromoError().getText());
	}
}
