package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDataDrivenTest extends BaseClass
{
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="Datadriven") //gets the data provider from a different class
	public void verify_logonDDT(String email, String pwd, String exp) throws IOException
	{		
		logger.info("**TC003_LoginDataDrivenTest starting**");		
		try
			{
			//HomePage
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			//Login			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();
			
			//MyAccount
			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetPage=macc.isMyAccountPageExists();
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{
					logger.info("Login Success "+exp);
					macc.clicklogout();
					Assert.assertTrue(true);
				}
				else
				{
					logger.info("Login Failed "+exp);
					Assert.assertTrue(false);
				}
			}
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true)
				{
					logger.info("Login Success "+exp);
					macc.clicklogout();
					Assert.assertTrue(false);							
				}
				else
				{
					logger.info("Login Failed "+exp);
					Assert.assertTrue(true);
				}		
			}
		}
		catch(Exception e)
		{			
			logger.info("Test has failed");
			Assert.fail();
		}	
		logger.info("**TC003_LoginTest completed**");		
	}
		
}
