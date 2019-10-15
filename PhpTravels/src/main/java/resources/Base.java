package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Base {
	 public static WebDriver driver;
	 public static Properties prop =new Properties();
	@Test
	public static void launch() throws IOException, InterruptedException
	{
		
	System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
	driver = new ChromeDriver();
	FileInputStream fis=new FileInputStream("C:\\Users\\Online Test\\Documents\\PhpTravels\\src\\main\\java\\resources\\Demo.properties");
	prop.load(fis);
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//a[@class='dropdown-toggle go-text-right'][contains(text(),'My Account')]")).click();		
    driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[2]/ul[1]/li[1]/ul[1]/li[2]/a[1]")).click();
	//driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]")).click();
   
	// for Signup page
	Signup gu=new Signup(driver);
    gu.Registerpage();
    
    
    //For Login Page
	/*Login lu=new Login(driver);
	lu.Loginpage();*/
	
	//For Hotel search page
    /*Hotelsearch  hs=new Hotelsearch (driver);
    hs.hotels();*/
    
    
    Thread.sleep(5);
	Myaccount ma=new Myaccount(driver);
	ma.Myaccountpage();
	
	
		
	}
	
	
	
	

}
