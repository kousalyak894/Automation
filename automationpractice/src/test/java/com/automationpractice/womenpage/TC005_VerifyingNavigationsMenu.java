package com.automationpractice.womenpage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automationpractice.testbase.Testbase;
import com.automationpractice.uiactions.Homepage;
import com.automationpractice.uiactions.Womenpage;

public class TC005_VerifyingNavigationsMenu extends Testbase{
	public static final Logger log=Logger.getLogger(TC005_VerifyingNavigationsMenu.class.getName());
	Womenpage womenpage;
	@BeforeTest
	public void setUp(){
		init();
	}
	@Test
	public void navigationmenu(){
		womenpage=new Womenpage(driver);//we are calling the womenpage constructor here.so for that constructor we are passing an argument for the Webdriver
		womenpage.womenbtnClick();//now by using the object of womenpage class we can all all the methods in that class.
		
		
		log.info("user selected product has been clicked");
		////a[starts-with(@href,'http://automationpractice.com/index.php?id_category')][text()='Tops']
		
	}
	
	@AfterTest     
	public void close(){
		driver.close();
	}

}
