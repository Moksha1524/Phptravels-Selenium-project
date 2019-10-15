package resources;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Myaccount {
	WebDriver driver;
	
	public Myaccount(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	By Bookings=By.xpath("//li[@class='active']//a[1]");
	
	By Myprofile=By.xpath("//div[@id='body-section']//li[2]//a[1]");
		
	By phone=By.xpath("//input[@placeholder='Phone']");
		
		By emailfield=By.xpath("//input[@placeholder='Email']");
		By pw=By.xpath("//input[@placeholder='Password']");
		By cpw=By.xpath("//input[@placeholder='Confirm Password']");
		
		By add1=By.xpath("//input[@placeholder='Address']");
		By add2=By.xpath("//input[@placeholder='Address 2']");
		By city=By.xpath("//input[@placeholder='City']");
		By state=By.xpath("//input[@placeholder='State/Region']");
		By postal=By.xpath("//input[@placeholder='Postal/Zip Code']");
		By country=By.xpath("//select[@name='country']");
	
	By submitbtn=By.xpath("//button[@class='btn btn-action btn-block updateprofile']");
	
	By Wishlist=By.xpath("//span[@class='wishlist-icon']");
	
	By Currency=By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//strong[contains(text(),'USD')]");
	
	By language=By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//ul[@class='nav navbar-nav']//li[@class='dropdown']");
	
	public void Myaccountpage() throws IOException
	{
		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement button=driver.findElement(Bookings);
		button.click();
		driver.findElement(Myprofile).click();
		driver.findElement(phone).clear();
		driver.findElement(phone).sendKeys("moksha");
		
		//email
		driver.findElement(emailfield).clear();
		driver.findElement(emailfield).sendKeys("moksha@gmail.com");
		driver.findElement(pw).sendKeys("123456");
		driver.findElement(cpw).sendKeys("123456");
		
		//address field
		driver.findElement(add1).sendKeys("goa");
		driver.findElement(add2).sendKeys("munar");
		driver.findElement(city).sendKeys("thiruvanthapuram ");
		driver.findElement(state).sendKeys("kerala");
		driver.findElement(postal).sendKeys("5600012");
		
		Select s=new Select(driver.findElement(country));
		s.selectByVisibleText("India");
		
		driver.findElement(submitbtn).click();
	
		driver.findElement(Wishlist).click();
		
		driver.findElement(Currency).click();
		
		driver.findElement(language).click();
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Online Test\\Documents\\automated screenshot\\base1\\accounts.jpg"));
	
		
	}

}
