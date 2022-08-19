package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageElements.LoginPage;
import tools.Steps;

public class Test6 extends Test0{
	@Test
	public void buyProduct(){
		//Buy a product
		String email = "static_account@web.com";
		String password = "password";
		LoginPage.login(driver, email, password);
		Steps.selectWomenProduct(driver);
		Steps.buyProduct(driver);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong")).getText(), 
				"Your order on My Store is complete.");
		
        }
	
}
