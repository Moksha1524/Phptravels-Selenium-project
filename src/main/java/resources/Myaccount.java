package resources;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Myaccount extends Base{
	WebDriver driver;
	
	public Myaccount(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	
	By Cookie = By.xpath("//button[@class='cc-btn cc-dismiss']");
	By Bookings=By.xpath("//a[@class='nav-link go-text-right active']");
	By Myprofile=By.xpath("//a[contains(text(),'My Profile')]");
		

		
		By emailfield=By.xpath("//input[@placeholder='Email']");
		By pw=By.xpath("//input[@placeholder='Password']");
		
		
		By add1=By.xpath("//input[@placeholder='Address']");
		By add2=By.xpath("//input[@placeholder='Address 2']");
		By city=By.xpath("//input[@placeholder='City']");
		By state=By.xpath("//input[@placeholder='State/Region']");
		By postal=By.xpath("//input[@placeholder='Postal/Zip Code']");
		By country=By.xpath("//div[@class='chosen-container chosen-container-single']");
		By Searchcountry=By.xpath("//input[@class='chosen-search-input']");
	
		By phone=By.xpath("//input[@placeholder='Phone']");
	
		
	By submitbtn=By.xpath("//button[@class='btn btn-block updateprofile btn-primary']");
	
	
	By Wishlist=By.xpath("//a[contains(text(),'Wishlist')]");
	By Currency=By.xpath("//div[@class='dropdown dropdown-currency']");
	By language=By.xpath("//a[@id='dropdownLangauge']");
	
	public void Myaccountpage() throws IOException, InterruptedException
	{
		
	
		
		driver.findElement(Cookie).click();
		driver.findElement(Myprofile).click();		
		//email
		driver.findElement(emailfield).clear();
		driver.findElement(emailfield).sendKeys(prop.getProperty("emailfield"));
		driver.findElement(pw).sendKeys(prop.getProperty("pw"));

		
		//address field
		driver.findElement(add1).sendKeys(prop.getProperty("add1"));
		driver.findElement(add2).sendKeys(prop.getProperty("add2"));
		driver.findElement(city).sendKeys(prop.getProperty("city"));
		driver.findElement(state).sendKeys(prop.getProperty("state"));
		driver.findElement(postal).sendKeys(prop.getProperty("postal"));
		
		
		driver.findElement(country).click();
		driver.findElement(Searchcountry).sendKeys(prop.getProperty("Searchcountry"));
		driver.findElement(Searchcountry).sendKeys(Keys.ENTER);
		
		driver.findElement(phone).clear();
		driver.findElement(phone).sendKeys(prop.getProperty("phone"));
		
		driver.findElement(submitbtn).click();
		log.error("Submit button not working in My Profile Page");
	
	    driver.findElement(Wishlist).click();
		
		Thread.sleep(3000);
		driver.findElement(Currency).click();
		driver.findElement(By.linkText("USD")).click();
		
		Thread.sleep(3000);
		driver.findElement(language).click();
		driver.findElement(By.linkText("English")).click();
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Online Test\\Documents\\automated screenshot\\base1\\accounts.jpg"));
	
		
	}

}
