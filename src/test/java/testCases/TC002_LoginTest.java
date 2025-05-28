package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(priority=1, groups={"Sanity","Master"})
	public void verify_login() throws IOException
	{
		logger.info("**Starting TC_002 LoginTest**");
		
		try
		{		
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetPage=macc.isMyAccountPageExists();
			
			Assert.assertEquals(targetPage, true, "Login failed");
			//or Assert.assertTrue(targetPage);		
		}
		catch(Exception e)
		{			
			logger.error("Login Failed ");
			Assert.fail();
		}		
		logger.info("**TC_002 LoginTest completed**");
	}
	
	@Test(priority=2, groups={"Sanity","Master"}, dependsOnMethods= {"verify_login"})
	public void skip_test()
	{
		System.out.println("this is an executed skip test");
	}

}
