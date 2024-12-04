package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;

    // Page Elements
    @FindBy(id = "departing")
    private WebElement departureDropdown;

	@FindBy(id = "returning")
    private WebElement returnDropdown;

    @FindBy(id = "promotional_code")
    private WebElement promoCodeInput;

    @FindBy(xpath = "//input[@type='submit' and @value='Search']")
    private WebElement searchButton;
    
    @FindBy(xpath ="//div[@id=\"content\"]/h2/following-sibling::p[1]")
    private WebElement message;
    
    @FindBy(tagName ="h3")
    private WebElement bookYourTicketMessage;
    
    @FindBy(xpath ="//a[contains(text(),'MarsAir')]")
    private WebElement marsAirHome;
    
    @FindBy(tagName ="strong")
    private WebElement promoPercentage;
    
    @FindBy(xpath = "//p[text()='Sorry, code ']")
    private WebElement promoError;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Page Actions
    public void selectDepartureMonth(String month) {
        departureDropdown.sendKeys(month);
    }

    public void selectReturnMonth(String month) {
        returnDropdown.sendKeys(month);
    }

    public void enterPromoCode(String promoCode) {
        promoCodeInput.sendKeys(promoCode);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
    
    public String getMessageText() {
    	return message.getText();
    }
    
    public WebElement getDepartureDropdown() {
 		return departureDropdown;
 	}

 	public WebElement getReturnDropdown() {
 		return returnDropdown;
 	}

 	public WebElement getPromoCodeInput() {
 		return promoCodeInput;
 	}

 	public WebElement getSearchButton() {
 		return searchButton;
 	}
 	
 	public WebElement getBookYourTicketMessage() {
 		return bookYourTicketMessage;
 	}
 	
	public WebElement getMarsAirHomeButton() {
 		return marsAirHome;
 	}
	
	public WebElement getPromoPercentage() {
		return promoPercentage;
	}
	
	public WebElement getPromoError() {
		return promoError;
	}

	
}
