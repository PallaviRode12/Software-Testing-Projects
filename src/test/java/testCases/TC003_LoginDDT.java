package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.Baseclass;
import utilities.DataProviders;

public class TC003_LoginDDT extends Baseclass {
	
	@Test(dataProvider= "LoginData", dataProviderClass=DataProviders.class, groups="Datadriven")
	public void varify_loginDDT(String email,String pwd, String exp) throws InterruptedException
	{
		try {
		HomePage Hp=new HomePage(driver);
		   Hp.clickMyAccount();
		   Hp.clickLogin();
		   
		   //LoginPage................................
		   
		   LoginPage lp=new LoginPage(driver);
				   
		   lp.setEmail(email);
		   lp.setPassword(pwd);
		   lp.clickLogin();
		   
		   //myacc
		   MyAccountPage mcc =new MyAccountPage(driver);
		   boolean targetPage =mcc.isMyAccountPageExists();
		   
		   if(exp.equalsIgnoreCase("Valid"))
		   {
			   if(targetPage==true)
			   {
				  
				
				   Assert.assertTrue(true);
				   mcc .clickLogout();
			   }
			   else {
				  Assert.assertTrue(false); 
			   }
			   
		   }
		   if(exp.equalsIgnoreCase("Invalid"));
		   {
			   if(targetPage==true)
			   {
				   mcc.clickLogout();
				   Assert.assertTrue(false);
			   
		     }
			   else 
			   {
				  Assert.assertTrue(true); 
			   }   
	           }	
		}
		catch(Exception e)
		{
			Assert.fail();
			
		}
		Thread.sleep(3000);
	}
}
