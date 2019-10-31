package resources;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Login extends Base {
	WebDriver driver;
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
	}
	 By MyAccountbtn=By.xpath("//div[@class='dropdown dropdown-login dropdown-tab']");
	 By Loginbtn=By.xpath("//a[@class='dropdown-item active tr']");
	
	 By requiredemail=By.xpath("//input[@placeholder='Email']");
	 By requiredpassword=By.xpath("//input[@placeholder='Password']");
	
	 By loginbtn=By.xpath("//button[@class='btn btn-primary btn-lg btn-block loginbtn']");
	
	public void Loginpage() throws IOException
	{
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(MyAccountbtn).click();
		driver.findElement(Loginbtn).click();
		driver.findElement(requiredemail).sendKeys(prop.getProperty("email"));
		driver.findElement(requiredpassword).sendKeys(prop.getProperty("Password"));
		driver.findElement(loginbtn).click();
		
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Online Test\\Documents\\automated screenshot\\base1.jpg"));
		
		
		
	}
}
