package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageElements.LoginPage;
import tools.DriverManagerFactory;
import tools.DriverType;
import tools.Steps;

public class Test8 extends Test0{
	@Test
	public void totalPrice() throws InterruptedException{
		//Verify total price
		//This account it was previously created
		String email = "static_account@web.com";
		String password = "password";
		LoginPage.login(driver, email, password);
		//Add product and Check quantity
		Steps.selectAndCheckWomenProduct(driver, "1");
		//Add 1
		driver.findElement(By.cssSelector(".icon-plus")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.id("total_product_price_2_9_725962")).getText(), "$54.00");
        }
	
}
