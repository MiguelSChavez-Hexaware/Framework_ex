package pageElements;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import tools.ReadData;

public class NewAccountPage {
	
	private static By genderM = By.id("id_gender1");
	private static By c_name = By.id("customer_firstname");
	private static By c_lastname = By.id("customer_lastname");
	private static By password = By.id("passwd");
	private static By name = By.id("firstname");
	private static By lastname = By.id("lastname"); 
	private static By company = By.id("company");
	private static By address1 = By.id("address1");
	private static By address2 = By.id("address2"); 
	private static By city = By.id("city");	
	private static By postcode = By.id("postcode");
	private static By other = By.id("other");
	private static By phone = By.id("phone");
	private static By phoneMobile = By.id("phone_mobile");
	private static By alias = By.id("alias");
	private static By submit = By.xpath("//button[@id=\'submitAccount\']/span");
	
	private static void selectBirth(WebDriver driver) {
		//day
		driver.findElement(By.xpath("//div[@id='uniform-days']")).click();
		driver.findElement(By.xpath("//option[@value='13']")).click();
		//month
		driver.findElement(By.xpath("//div[@id='uniform-months']")).click();
		driver.findElement(By.xpath("//select[@id=\"months\"]/option[5]")).click();
		//year
		driver.findElement(By.xpath("//div[@id='uniform-years']")).click();
		driver.findElement(By.xpath("//option[@value='1997']")).click();
	}
	
	private static void selectState(WebDriver driver) {
		driver.findElement(By.id("id_state"));
		driver.findElement(By.xpath("//select[@id=\'id_state\']/option[20]")).click();
	}
	
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
	
	public static void submitData(WebDriver driver, String fileName, String testName, String dpassword) {
		
		String[] array = ReadData.readData(fileName,testName);
		//d is for data
		for(int i=0; i<array.length; i++) {
			//System.out.println(array[i]);
			if (array[i].equals("x")) {
				array[i] = "";
				//System.out.println("1");
			}
		}
		String dname = array[2];
		String dlastname = array[3];
		String ddate = array[5];
		String dcompany = array[6];
		String daddress1 = array[7];
		String daddress2 = array[8];
		String dcity = array[9];
		String dpostcode = array[10];
		String dother = array[11];
		String dphone = array[12];
		String dphoneMobile = array[13];
		String dalias = array[14];
		String dstate = array[15];
		
		driver.findElement(genderM).click();
		driver.findElement(c_name).sendKeys(dname);
		driver.findElement(c_lastname).sendKeys(dlastname); 
		driver.findElement(password).sendKeys(dpassword);
		if (!ddate.equals("")) {
			selectBirth(driver);
		}
		driver.findElement(name).sendKeys(dname);
		driver.findElement(lastname).sendKeys(dlastname); 
		driver.findElement(company).sendKeys(dcompany);
		driver.findElement(address1).sendKeys(daddress1);
		driver.findElement(address2).sendKeys(daddress2); 
		driver.findElement(city).sendKeys(dcity);
		if (!dstate.equals("")) {
			selectState(driver);
		}
		driver.findElement(postcode).sendKeys(dpostcode);
		driver.findElement(other).sendKeys(dother);
		driver.findElement(phone).sendKeys(dphone);
		driver.findElement(phoneMobile).sendKeys(dphoneMobile);
		driver.findElement(alias).clear();;
		driver.findElement(alias).sendKeys(dalias);
		driver.findElement(submit).click();
		
		
		
	}
	

}
