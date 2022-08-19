package tools;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {
	
	@Override
	public void createWebDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mchvz\\Documents\\Work\\Hexaware\\Training\\Selenium\\Drivers\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		
		this.driver= new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}
