package tools;

import java.time.Duration;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class FirefoxDriverManager extends DriverManager {
	@Override
	public void createWebDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mchvz\\Documents\\Work\\Hexaware\\Training\\Selenium\\Drivers\\geckodriver.exe");
		
		FirefoxOptions options = new FirefoxOptions();
		
		this.driver= new FirefoxDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
}
