package resources;

import java.io.File;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class Signup extends Base {
	WebDriver driver;
	
	
	public Signup(WebDriver driver)
	{
		this.driver=driver;
		
	}
	 By MyAccountbtn=By.xpath("//div[@class='dropdown dropdown-login dropdown-tab']");
	 By Signupbtn=By.xpath("//a[@class='dropdown-item tr']");
	
	 
	 
	By fname=By.xpath("//input[@placeholder='First Name']");
	By lname=By.xpath("//input[@placeholder='Last Name']");
	By monumber=By.xpath("//input[@placeholder='Mobile Number']");
	By email=By.xpath("//input[@placeholder='Email']");
	By Password=By.xpath("//input[@placeholder='Password']");
	By Conpassword=By.xpath("//input[@placeholder='Confirm Password']");
	By Cookie = By.xpath("//button[@class='cc-btn cc-dismiss']");
	By btn=By.xpath("//button[@class='signupbtn btn_full btn btn-success btn-block btn-lg']");


public void Registerpage() throws IOException{
	
	
	driver.findElement(MyAccountbtn).click();
	driver.findElement(Signupbtn).click();
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.findElement(fname).sendKeys(prop.getProperty("fname"));
	driver.findElement(lname).sendKeys(prop.getProperty("lname"));
	driver.findElement(monumber).sendKeys(prop.getProperty("monumber"));
	driver.findElement(email).sendKeys(prop.getProperty("email"));
	driver.findElement(Password).sendKeys(prop.getProperty("Password"));
	driver.findElement(Conpassword).sendKeys(prop.getProperty("Conpassword"));
	driver.findElement(Cookie).click();
	driver.findElement(btn).click();
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C:\\Users\\Online Test\\Documents\\automated screenshot\\base1\\signup.jpg"));
    
	
}
}