package Demo1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import resources.Base;
import resources.Login;

public class ValidateLoginPage extends Base {
	
	By msg=By.xpath("//h3[@class='text-align-left']");
	@BeforeTest
	public void conditions() throws Exception{
		driver = launch();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	

}
	@Test
	public void login() throws IOException
	{
		Login lu=new Login(driver);
		lu.Loginpage();
		Assert.assertEquals("Hi, moksha lakshmi",driver.findElement(msg).getText());
		log.info("Successfuly logged in");

	}
	@AfterTest
	public void closebrowser()
	{
		driver.close();
	}
}