package Demo1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;
import resources.Login;
import resources.Myaccount;

public class ValidateMyAccountsPage extends Base{
  
		@BeforeTest
		public void conditions() throws Exception{
			driver = launch();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
		}
		@Test
		public void myAccounts() throws Exception
		{
			Login lu=new Login(driver);
			lu.Loginpage();
			Myaccount ma=new Myaccount(driver);
			ma.Myaccountpage();
			

		}
		@AfterTest
		public void closebrowser()
		{
			driver.close();
		}
}
