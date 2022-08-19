package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import tools.DriverManagerFactory;
import tools.DriverType;
import tools.Steps;
import tools.UrlManager;

public class Test7 extends Test0{
	@Test
	public void wishlist(){
		//Wishlist only works after sing in
		String url = UrlManager.getUrl("Base");
		driver.get(url);
		Steps.exploreWomenProducts(driver);
		driver.findElement(By.cssSelector(".addToWishlist.wishlistProd_2")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector(".fancybox-error")).getText(), "You must be logged in to manage your wishlist.");
        }
	
}
