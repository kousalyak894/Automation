package com.automationpractice.homepage;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.uiactions.Homepage;

public class TC003_VerifyingRegistrationPage extends TC002_Verifyingwhetheremailidcreatedornot {
	public static final Logger log=Logger.getLogger(Homepage.class.getName());
	@Test
	public void VerifyinguserRegistration(){
		homepage.userregistraton("kouslaya", "k", "koushi@1994","kousalya", "k", "marathalli,banglore", "banglore","570036", "990141012", "banglore,marathalli");
		log.info("User information entered successfully");
		Assert.assertEquals(homepage.errormsgafterregis(), "There are 2 errors");
		log.info("Error msg generated successfully");
		
		
		
		
	}

}
