package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{

	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("**Start TC001_AccountRegistrationTest***");		
		try
			{
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickRegister();
			logger.info("Creating new registration");
			AccountRegistrationPage rp=new AccountRegistrationPage(driver);
			
			rp.setFirstName(randomString().toUpperCase());
			rp.setLastName(randomString().toUpperCase());
			rp.setEmail(randomString()+"@gmail.com");
			rp.setPhone(randomNumber());
			
			String pwdval=randomAlphaNumeric();
			rp.setPWD(pwdval);		
			rp.setConfirmPWD(pwdval);
			
			rp.setPrivacyPolicy();
			rp.clickContinue();
			logger.info("Checking the account creation confirmation message");
			String confirmation=rp.getConfirmationMsg();
			if(confirmation.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("**Test failed***");
				logger.debug("Debug logs...");
				Assert.assertFalse(true);
			}			
		}
		catch(Exception e)
		{			
			Assert.fail();
		}
		
		logger.info("**Completed TC001_AccountRegistrationTest***");		
				
	}
		
		
}
