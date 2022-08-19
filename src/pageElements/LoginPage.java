package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import tools.ReadData;
import tools.UrlManager;

public class LoginPage {
	
	private static String url = UrlManager.getUrl("Account Options");
	private static By emailCreate = By.name("email_create");
	private static By create = By.id("SubmitCreate");
	private static By email = By.id("email");
	private static By password = By.id("passwd");
	private static By login = By.xpath("//button[@id=\'SubmitLogin\']/span");
	
	public static void login(WebDriver driver, String mail, String passwd) {
		driver.get(url);
		driver.findElement(email).sendKeys(mail);
		driver.findElement(password).sendKeys(passwd);
		driver.findElement(login).click();
	}
	
	public static void newAccount(WebDriver driver, String mail) {
		driver.get(url);
		driver.findElement(emailCreate).sendKeys(mail);
		driver.findElement(create).click();
	}
	

	
}
