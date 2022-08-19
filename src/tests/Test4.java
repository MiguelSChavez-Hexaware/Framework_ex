package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import tools.Steps;

public class Test4 extends Test0{
	@Test
	public void incorrectValues(){
		//Error incorrect values
		String email = Steps.randEmail();
		String password = "password";
		String testName = "Incorrect Values";
		Steps.createNewAccount(driver, email, password, testName);
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText(), "There are 5 errors\n"
				+ "lastname is invalid.\n"
				+ "firstname is invalid.\n"
				+ "phone is invalid.\n"
				+ "phone_mobile is invalid.\n"
				+ "The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
        }
	
}
