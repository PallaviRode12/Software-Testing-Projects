package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.Baseclass;
public class TC002_LoginTest extends Baseclass{
	
	@Test(groups={"Sanity","Master"})
	public void verify_Login()
	{
	   
	   //Homepage.................
	   try {
	   HomePage Hp=new HomePage(driver);
	   Hp.clickMyAccount();
	   Hp.clickLogin();
	   
	   //LoginPage................................
	   
	   LoginPage lp=new LoginPage(driver);
			   
	   lp.setEmail(p.getProperty("email"));
	   lp.setPassword(p.getProperty("password"));
	   lp.clickLogin();
	   
	   
	   MyAccountPage mcc =new MyAccountPage(driver);
	   boolean targetPage =mcc.isMyAccountPageExists();
	   
	 Assert.assertTrue(targetPage);
	 
	   }

	   catch(Exception e)
	   {
		  Assert.fail();  
	   
	   }
	   logger.info("Finished TC_002_logintest");
	  
	}

		
	
}
