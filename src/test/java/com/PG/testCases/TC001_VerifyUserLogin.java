package com.PG.testCases;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PG.pageObjects.dashboardPage;
import com.PG.pageObjects.loginPage;
import com.PG.testBase.BaseClass;


public class TC001_VerifyUserLogin extends BaseClass {

	
	//2 Verify login
	@Test
	public void VerifyLogin() throws IOException 
	{
		loginPage lp = new loginPage(driver);
		lp.setUserName(prop.getProperty("username"));
		logger.info("username entered  is--->" + prop.getProperty("username"));
		//System.out.println("username enetered  is--->" + prop.getProperty("username"));
		
		lp.setPassword(prop.getProperty("password"));
		logger.info("password entered  is--->" + prop.getProperty("username"));
		//System.out.println("password enetered  is--->" + prop.getProperty("password"));
		
		lp.ClickOnLoginBtn();
		
	     //calling dashboard class to complete login verification
		dashboardPage dp = new dashboardPage(driver);
		boolean status = dp.isDashboardDisplay();
		Assert.assertEquals(status, true ,  "dashboard link is not displayed..try again");
		logger.info("<---user has logged in successfully--->");

		//System.out.println("<---user has logged in successfully--->");
	    
		//calling capture screen short method of base class
		BaseClass bs = new BaseClass();
		bs.CaptureScreen(driver, "VerifyLogin");	
	}
	
	

}

















