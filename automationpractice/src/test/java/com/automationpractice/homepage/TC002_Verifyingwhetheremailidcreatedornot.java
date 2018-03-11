package com.automationpractice.homepage;

import org.testng.annotations.Test;

public class TC002_Verifyingwhetheremailidcreatedornot extends TC001_verifyingLoginpageInvalidCredentials {
	
	@Test
    public void verifyingaccountcreation(){
    	homepage.createanaccount("kousalyak1017@gmail.com");
    	log.info("entered mailid");
    
    }

}
