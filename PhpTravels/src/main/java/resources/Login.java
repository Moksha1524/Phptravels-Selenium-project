package resources;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Login {
	WebDriver driver;
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
	}
	By requiredemail=By.xpath("//input[@placeholder='Email']");
	By requiredpassword=By.xpath("//input[@placeholder='Password']");
	By Cookie = By.cssSelector("button[id='cookyGotItBtn']");
	By loginbtn=By.xpath("//button[@class='btn btn-action btn-lg btn-block loginbtn']");
	
	public void Loginpage() throws IOException
	{
		driver.findElement(Cookie).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(requiredemail).sendKeys("megha@gmail.com");
		driver.findElement(requiredpassword).sendKeys("abc@123");
		
		driver.findElement(loginbtn).click();
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Online Test\\Documents\\automated screenshot\\base1.jpg"));
		
		
		
	}
}
