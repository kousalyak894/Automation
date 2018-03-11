package com.automationpractice.homepage;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automationpractice.testbase.Testbase;
import com.automationpractice.uiactions.Homepage;

public class TC001_verifyingLoginpageInvalidCredentials extends Testbase {//scripts should not be hardcoded so will convert each and evry thing into a framework.
	public static final Logger log=Logger.getLogger(TC001_verifyingLoginpageInvalidCredentials.class.getName());
	Homepage homepage;
    @BeforeTest
	public void setUp(){
		init();
	}
    
    @Test
	public void verifyingLoginpageInvalidCredentials(){
    	log.info("..........verification started..........");
    	homepage=new Homepage(driver);
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	Assert.assertEquals(homepage.signinapp(), "ALREADY REGISTERED?");
    	homepage.loginToApplication("kousalyak1017@gmail.com", "koushi@1994");
    	Assert.assertEquals(homepage.errorforunauthenticateduser(), "There is 1 error");
    	log.info("..............verification ended..............");
          
    }
  
    
    @AfterTest
	public void close(){
    	log.info("........closing the browser............");
		driver.close();
	}
}
