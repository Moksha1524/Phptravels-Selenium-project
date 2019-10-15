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


public class Hotelsearch extends Base 
{

	WebDriver driver;
    By Cookie = By.cssSelector("button[id='cookyGotItBtn']");

//hotel name search
    By hotelbtn=By.xpath("//a[@title='Hotels']");
    By hotelsname=By.xpath("//div[@id='s2id_location']//a[@class='select2-choice select2-default']");
    By hotelselect = By.xpath("//div[contains(text(),'chester, United Kingdom')]");

//check in and out
    By checkin=By.xpath("//div[@id='dpd1']");
    By checkout=By.xpath("//input[@placeholder='Check out']");
    By Noofpassengers=By.xpath("//input[@name='travellers']");
    By adultbtn=By.xpath("//input[@id='hadultInput']");
    By child=By.xpath("//input[@id='hchildInput']");

//search button
    By searchbtn=By.xpath("//button[@class='btn btn-lg btn-block btn-primary pfb0 loader']");

    public Hotelsearch(WebDriver driver)
    {
	this.driver=driver;
    }

    public void hotels() throws IOException
    {
	Properties prop =new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\Online Test\\Documents\\PhpTravels\\src\\main\\java\\resources\\Demo.properties");
	prop.load(fis);
	
	driver.findElement(Cookie).click();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
	//hotel name
	driver.findElement(hotelbtn).click();
	driver.findElement(hotelsname).click();
	driver.findElement(hotelsname).sendKeys(prop.getProperty("hotelsname"));
	driver.findElement(hotelselect).click();
	
	
	//Check in
	driver.findElement(checkin).click();
	while(!driver.findElement(By.xpath("//div[14]//div[1]//tr[1]//th[2]")).getText().contains("November 2019"))
{
	driver.findElement(By.xpath("//div[14]//div[1]//tr[1]//th[3]")).click();
}
	int count= driver.findElements(By.className("day")).size();
	for(int i=0;i<count;i++)
	{
		String text1 = driver.findElements(By.className("day")).get(i).getText();
		if(text1.equalsIgnoreCase("13"))
		{
			driver.findElements(By.className("day")).get(i).click();
		}
	}
	
	
	//Check out
	driver.findElement(checkout).click();
	while(!driver.findElement(By.xpath("//div[15]//div[1]//tr[1]//th[2]")).getText().contains("November 2019"))
			{
		driver.findElement(By.xpath("//div[15]//div[1]//tr[1]//th[3]")).click();
			}
	
	int count1= driver.findElements(By.className("day")).size();
	
	for(int i=0;i<count1;i++)
	{
		String text1 = driver.findElements(By.className("day")).get(i).getText();
		if(text1.equalsIgnoreCase("20"))
		{
			driver.findElements(By.className("day")).get(i).click();
		}
	}
	
	driver.findElement(Noofpassengers).click();
	driver.findElement(adultbtn).clear();
	driver.findElement(adultbtn).sendKeys("3");
	
	driver.findElement(child).clear();
	driver.findElement(child).sendKeys("1");
	
	driver.findElement(searchbtn).click();
	
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C:\\Users\\Online Test\\Documents\\automated screenshot\\hotel.jpg"));
}
}
