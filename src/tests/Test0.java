package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import tools.DriverManager;
import tools.DriverManagerFactory;
import tools.DriverType;

public abstract class Test0 {

	DriverManager driverManager;
	WebDriver driver;
	
	@BeforeMethod
	public void initiateDriver() {
		driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
		driver = driverManager.getWebDriver();
	}
	
	@AfterMethod 
	public void closeWindow() {
		driver.close();
	}
}
