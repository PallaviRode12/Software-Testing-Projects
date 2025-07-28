package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegitrationPage;
import pageObjects.HomePage;
import testBase.Baseclass;

public class TC001_Accregitrationtest extends Baseclass

{	
	
	@Test(groups={"Regression","Master"})
	public void varify_account_registration()
	{
		logger.info("***Starting TC_001_AccountegistrationTest");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on Registration link.");
		hp.clickRegister();
		
		logger.info("Providing customer details....");
		AccountRegitrationPage regpage=new AccountRegitrationPage(driver);
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");//random emil we have to create...
		
		regpage.setTelephone(randomeNumber());
		
		String password=randomeAlphaNumberic();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		
		logger.info("Validating expected msg...");
		
		String confmsg = regpage.getConfirmationMsg();
		Assert.assertEquals( confmsg , "Your Account Has Been Created!");	
   	 }	
       catch(Exception e)
      {
	     logger.error("test failed..");
	     logger.debug("Debug logs");   
	     
	     
	     
	     Assert.fail();     
         }
       }
	}
