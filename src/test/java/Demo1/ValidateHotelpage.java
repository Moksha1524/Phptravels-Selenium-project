package Demo1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;
import resources.Hotelsearch;

public class ValidateHotelpage extends Base {
	@BeforeTest
	public void conditions() throws Exception{
		driver = launch();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

}
	@Test
	public void hotelSearch() throws Exception
	{
		Hotelsearch  hs=new Hotelsearch (driver);
	    hs.hotels();
		log.info("Hotel search successfully executed");

	}
	@AfterTest
	public void closebrowser()
	{
		driver.close();
	}
}
