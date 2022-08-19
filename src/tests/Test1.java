package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import tools.Steps;


public class Test1 extends Test0 {
	
	@Test
	public void createAccount(){
		//Create an account	
		String email = Steps.randEmail();
		String password = "password";
		String testName = "Create Account";
		Steps.createNewAccount(driver, email, password, testName);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id=\'center_column\']/p")).getText(), "Welcome to your account. Here you can manage all of your personal information and orders.");
	}
	

}
