package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegitrationPage extends BasePage
{
	public AccountRegitrationPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//*[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//*[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//*[@id='input-telephone']")
	WebElement txtTelephoneno;
	
	@FindBy(xpath="//*[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//*[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//*[@name='agree']")
	WebElement chkdPolicy;
	
	@FindBy(xpath="//*[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement Confirmationmsg;
	
	//Actions .......
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String Lname)
	{
		txtLastName.sendKeys(Lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tel)
	{
		txtTelephoneno.sendKeys(tel);
	}
	
	public void setPassword(String pwd)
	{
		 txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd)
	{
		txtConfirmPassword.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy()
	{
		 chkdPolicy.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmationMsg() 
	{
		try
		{
			return(Confirmationmsg.getText());
		}
		catch(Exception e) 
		{
			return(e.getMessage());
		}
	
	
		
	}
	
	
	
}
