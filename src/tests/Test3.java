package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import tools.Steps;

public class Test3 extends Test0{
	@Test
	public void invalidFields(){
		//Error in mandatory fields
		String email = Steps.randEmail();
		String testName = "Invalid Fields";
		String password = "";
		Steps.createNewAccount(driver, email, password, testName);
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText(), "There are 8 errors\n"
				+ "lastname is required.\n"
				+ "firstname is required.\n"
				+ "passwd is required.\n"
				+ "alias is required.\n"
				+ "address1 is required.\n"
				+ "city is required.\n"
				+ "The Zip/Postal code you've entered is invalid. It must follow this format: 00000\n"
				+ "This country requires you to choose a State.");		
		}
	
}
