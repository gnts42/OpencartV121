package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}	
	
	@FindBy(xpath="//input[@id='input-firstname']") 
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']") 
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']") 
	WebElement txtEmail;
		
	@FindBy(xpath="//input[@id='input-telephone']") 
	WebElement txtPhone;
	
	@FindBy(xpath="//input[@id='input-password']") 
	WebElement txtPWD;
	
	@FindBy(xpath="//input[@id='input-confirm']") 
	WebElement txtPWDconfirm;
	
	@FindBy(xpath="//input[@name='agree']") 
	WebElement chkdAgree;
	
	@FindBy(xpath="//input[@value='Continue']") 
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") 
	WebElement msgConfirmation;
	
	
	public void setFirstName(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPhone(String phone)
	{
		txtPhone.sendKeys(phone);
	}
		
	public void setPWD(String pwd)
	{
		txtPWD.sendKeys(pwd);
	}
	
	public void setConfirmPWD(String pwd)
	{
		txtPWDconfirm.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy()
	{
		chkdAgree.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmationMsg()
	{
	try {
		return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
		
	}
		
}
