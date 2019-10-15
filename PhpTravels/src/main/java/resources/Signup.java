package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Signup {
	WebDriver driver;
	
	
	public Signup(WebDriver driver)
	{
		this.driver=driver;
		
	}
	By fname=By.xpath("//input[@placeholder='First Name']");
	By lname=By.xpath("//input[@name='lastname']");
	By monumber=By.xpath("//input[@name='phone']");
	By email=By.xpath("//input[@name='email']");
	By Password=By.xpath("//input[@name='password']");
	By Conpassword=By.xpath("//input[@name='confirmpassword']");
	By Cookie = By.cssSelector("button[id='cookyGotItBtn']");
	By btn=By.xpath("//div[@id='body-section']//div[9]");


public void Registerpage() throws IOException{
	Properties prop =new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\Online Test\\Documents\\PhpTravels\\src\\main\\java\\resources\\Demo.properties");
	prop.load(fis);
	driver.findElement(Cookie).click();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.findElement(fname).sendKeys(prop.getProperty("fname"));
	driver.findElement(lname).sendKeys(prop.getProperty("lname"));
	driver.findElement(monumber).sendKeys(prop.getProperty("monumber"));
	driver.findElement(email).sendKeys(prop.getProperty("email"));
	driver.findElement(Password).sendKeys(prop.getProperty("Password"));
	driver.findElement(Conpassword).sendKeys(prop.getProperty("Conpassword"));
	
	driver.findElement(btn).click();
	
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C:\\Users\\Online Test\\Documents\\automated screenshot\\base1\\signup.jpg"));
    
	
}
}