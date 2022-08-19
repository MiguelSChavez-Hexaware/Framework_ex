package tools;

import java.util.Random;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pageElements.LoginPage;
import pageElements.NewAccountPage;



public class Steps  {
	
	private static String randWord()
	{
	    String randomStrings;
	    Random random = new Random();
	    char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
	    
	    for(int j = 0; j < word.length; j++){
	        word[j] = (char)('a' + random.nextInt(26));
	    }
	    randomStrings = new String(word);
	    
	    return randomStrings;
	}

	public static String randEmail() {
		Random rand = new Random();
	    int upperbound = 1000000;
	    int int_random = rand.nextInt(upperbound);
		String email = "demo_"+ int_random +"@web.com";
		return email;
	}
	
	//-------------------------------------------------------------------------------------
	
	public static void createNewAccount(WebDriver driver, String email, String password, String testName) {
		LoginPage.newAccount(driver, email);
		String fileName = "C:\\Users\\mchvz\\Documents\\Work\\Hexaware\\Training\\Selenium\\Framework_ex\\data\\account_data.xlsx";
		NewAccountPage.submitData(driver, fileName, testName, password);
	}
	
	public static void selectShirtProduct(WebDriver driver) {
		driver.get("http://automationpractice.com/index.php");
		
		WebElement women = driver.findElement(By.xpath("//div[@id=\'block_top_menu\']/ul/li[1]/a"));
        new Actions(driver).moveToElement(women).perform();
        driver.findElement(By.xpath("//div[@id=\'block_top_menu\']/ul/li[1]/a")).click();
	}
	
	public static void searchProduct(WebDriver driver, String product) {
		//looks for the first result of the search
        driver.findElement(By.id("search_query_top")).sendKeys(product, Keys.ENTER);
	}
	
	public static void exploreWomenProducts(WebDriver driver) {
		//Selects the second element in the womens section
		WebElement women = driver.findElement(By.xpath("//div[@id=\'block_top_menu\']/ul/li[1]/a"));
        new Actions(driver).moveToElement(women).perform();
        driver.findElement(By.xpath("//div[@id=\'block_top_menu\']/ul/li[1]/a")).click();
	}
	
	public static void selectWomenProduct(WebDriver driver) {
		//Selects the second element in the womens section
		exploreWomenProducts(driver);
        driver.findElement(By.xpath("//*[@id=\'center_column\']/ul/li[2]/div/div[2]/div[2]/a[2]/span")).click();
        driver.findElement(By.xpath("//*[@id=\'quantity_wanted_p\']/a[2]/span/i")).click();
        driver.findElement(By.id("group_1")).click();
        driver.findElement(By.xpath("(//option[@title='L'])[1]")).click();
        driver.findElement(By.id("color_11")).click();
        driver.findElement(By.xpath("//*[@id='add_to_cart']/button/span")).click();
	}

	public static void buyProduct(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\'layer_cart\']/div[1]/div[2]/div[4]/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\'center_column\']/p[2]/a[1]/span")).click();
        driver.findElement(By.xpath("//*[@id=\'center_column\']/form/p/button/span")).click();
        driver.findElement(By.id("cgv")).click();
        driver.findElement(By.xpath("//*[@id=\'form\']/p/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();
        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
	}
	
	public static void selectAndCheckWomenProduct(WebDriver driver, String quantity) {

		Steps.exploreWomenProducts(driver);
		driver.findElement(By.xpath("//*[@id=\'center_column\']/ul/li[2]/div/div[2]/div[2]/a[2]/span")).click();
        Assert.assertEquals(driver.findElement(By.id("quantity_wanted")).getAttribute("value"), quantity);
        driver.findElement(By.id("group_1")).click();
        driver.findElement(By.xpath("(//option[@title='M'])[1]")).click();
        driver.findElement(By.id("color_11")).click();
        driver.findElement(By.xpath("//*[@id='add_to_cart']/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\'layer_cart\']/div[1]/div[2]/div[4]/a/span")).click();	
	}
	
	
}
