package resources;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;


public class Base {
	 public static WebDriver driver;
	 public static Properties prop;
	
	 
	 public static org.apache.logging.log4j.Logger log;
	 
	 
	 @BeforeSuite
	 public void logs() throws FileNotFoundException, IOException{
		 String Logconfig="C:\\Users\\Online Test\\git\\Phptravels-Selenium-project-\\PhpTravels\\src\\main\\java\\resources\\log4j.xml";
	     ConfigurationSource src=new ConfigurationSource(new FileInputStream(Logconfig));
	     Configurator.initialize(null,src);
	     log= LogManager.getLogger(Base.class.getName());
	 }
	 
		
	 
	  public static WebDriver launch() throws IOException, InterruptedException
	  {
		prop =new Properties();
		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		FileInputStream fis=new FileInputStream("C:\\Users\\Online Test\\git\\Phptravels-Selenium-project-\\PhpTravels\\src\\main\\java\\resources\\Demo.properties");
		prop.load(fis);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		return driver;
	  }
	  
}
	
	
	
	
	
    
    
	
	
	
	
    
	  
	
	
