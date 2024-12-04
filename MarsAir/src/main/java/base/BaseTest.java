package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.DriverManager;
import utils.ReadConfigDetails;

public class BaseTest {
	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
        ReadConfigDetails config = new ReadConfigDetails();
		driver = DriverManager.createDriverInstance(config.getConfigValue("browser"));
		String url=config.getConfigValue("baseUrl")+config.getConfigValue("user");
		driver.navigate().to("https://marsair.recruiting.thoughtworks.net/mr.nirajkrsingh19@gmail.com");;
	}
	@AfterMethod
	public void cleanUp() {
		DriverManager.quitDriver();
	}
}
