package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageElements.LoginPage;

public class Test2 extends Test0{
	@Test
	public void invalidEmail(){
		//Invalid email error
		LoginPage.newAccount(driver, "hola");
  		Assert.assertEquals(driver.findElement(By.xpath("//div[@id=\"create_account_error\"]/ol/li")).getText(), "Invalid email address.");
  		}
}
