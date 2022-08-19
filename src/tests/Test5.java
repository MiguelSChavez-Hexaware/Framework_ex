package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tools.Steps;

public class Test5 extends Test0 {
	@Test
	public void searchProduct(){
		//Search product
		Steps.selectShirtProduct(driver);
		String tshirt = driver.findElement(By.cssSelector("h5[itemprop='name'] a[title='Faded Short Sleeve T-shirts']")).getText();
		Steps.searchProduct(driver, tshirt);
        String firsttshirt = driver.findElement(By.xpath("//div[@id=\'center_column\']/ul/li/div/div[2]/h5/a")).getText();
		Assert.assertEquals(tshirt, firsttshirt);
        }
	
}
