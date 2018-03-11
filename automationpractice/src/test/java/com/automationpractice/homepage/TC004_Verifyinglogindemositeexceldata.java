package com.automationpractice.homepage;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationpractice.testbase.Testbase;
import com.automationpractice.uiactions.Homepage;

public class TC004_Verifyinglogindemositeexceldata extends Testbase {
	public static final Logger log=Logger.getLogger(TC004_Verifyinglogindemositeexceldata.class.getName());
	Homepage homepage;
	/*String emailaddress="kousalya@gmail.com";
	String password="kousalya";*/
    @DataProvider(name="logindata")//data provider will help us to run the scripts with multiple set of data.
	public String[][] getTestdata(){
		String[][] testrecords = getData("Testdata.xlsx","LoginTestdata");//will get from the test base.which will return a 2D object.
		return testrecords;
		
	}
	
    @BeforeTest
	public void setUp(){
		init();
	}
    
    @Test(dataProvider="logindata")
    public void loginsiteusingexceldata(String emailaddress,String password,String runmode){
    	homepage=new Homepage(driver);
    	homepage.signinapp();
    	homepage.logindemositeusingexceldata(emailaddress,password);
    	getScreenShot("Login with"+emailaddress);
    	Assert.assertEquals(homepage.errorforunauthenticateduser(), "There is 1 error");
    	log.info("assertion successfull");
    	
    	
    	
    }
    @AfterTest
    public void close(){
    	driver.close();
    }

}
