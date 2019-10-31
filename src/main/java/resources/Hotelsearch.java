package resources;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class Hotelsearch extends Base 
{
	WebDriver driver;
	Properties prop =new Properties();
   

//hotel name search
	 By Hotelbtn=By.xpath("//a[@class='text-center hotels active']");
     By Hotels=By.xpath("//span[contains(text(),'Search by Hotel or City Name')]");
     By Hotelselect=By.xpath("/html[1]/body[1]/div[4]/div[1]/input[1]");
     By Hotelselect1=By.xpath("//div[contains(text(),'Iberia, United States')]");
      
     By checkin=By.xpath("//input[@id='checkin']");
     By checkout=By.xpath("//input[@id='checkout']");
     
     By adultbtn=By.xpath("//div[contains(@class,'col o2')]//button[contains(@class,'btn btn-white bootstrap-touchspin-up')][contains(text(),'+')]");
     By childbtn=By.xpath("//div[contains(@class,'col 01')]//button[contains(@class,'btn btn-white bootstrap-touchspin-up')][contains(text(),'+')]");
     By searchbtn=By.xpath("//div[contains(@class,'col-md-2 col-xs-12 o1')]//button[contains(@class,'btn btn-primary btn-block')][contains(text(),'Search')]");



    public Hotelsearch(WebDriver driver)
    {
	this.driver=driver;
    }

    public void hotels() throws Exception
    {
    	FileInputStream fis=new FileInputStream("C:\\Users\\Online Test\\git\\Phptravels-Selenium-project-\\PhpTravels\\src\\main\\java\\resources\\Demo.properties");
		prop.load(fis);
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
	//hotel name

	driver.findElement(Hotelbtn).click();
	driver.findElement(Hotels).click();
	driver.findElement(Hotelselect).sendKeys(prop.getProperty("Hotelname"));
	driver.findElement(Hotelselect1).click();
	
	
	//Check in
	driver.findElement(checkin).click();
	while(!driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/nav[1]/div[2]")).getText().contains("November"))
    {
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/nav[1]/div[3]/*")).click();
        break;
    }
    int count = driver.findElements(By.xpath("//div[1]//div[1]//div[1]//div[2]//div[26]")).size();
    System.out.println(count);
    for(int i=0;i<count;i++)
    {
        String text = driver.findElements(By.xpath("//div[1]//div[1]//div[1]//div[2]//div[26]")).get(i).getText();
        if(text.equalsIgnoreCase("21"))
        {
            driver.findElements(By.xpath("//div[1]//div[1]//div[1]//div[2]//div[26]")).get(i).click();
        }
    }
   
    driver.findElement( checkout).click();
    //checkout
    while(!driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/nav[1]/div[2]")).getText().contains("November"))
    {
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/nav[1]/div[3]/*")).click();
        break;
    }
  
    int count1 = driver.findElements(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[33]")).size();
    for(int i=0;i<count1;i++)
    {
        String text = driver.findElements(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[33]")).get(i).getText();
        if(text.equalsIgnoreCase("28"))
        {
            driver.findElements(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[33]")).get(i).click();
        }
    }
   
            
            driver.findElement(adultbtn).click();
            
            driver.findElement(childbtn).click();
            
            Assert.assertTrue(driver.findElement(searchbtn).isDisplayed());
            driver.findElement(searchbtn).click();
            
            
        
    File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C:\\Users\\Online Test\\Documents\\automated screenshot\\hotel.jpg"));
}
}
