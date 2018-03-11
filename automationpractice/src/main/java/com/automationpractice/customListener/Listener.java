package com.automationpractice.customListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.automationpractice.testbase.Testbase;

public class Listener extends Testbase implements ITestListener {
	/*public Listener(WebDriver driver){
		this.driver=driver;
		
	}*/

	public void onTestStart(ITestResult result) {
		Reporter.log("Test started running"+result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		String Methodname=result.getName();
		// when test fails we want to capture the screenshot on the runtime.
		Calendar cal=Calendar.getInstance();//calendar is a class in java,we are creating the instance of calendar by using getInstance method.
		SimpleDateFormat formater=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");//this is for ,i need to save my screen in this format
		if(result.isSuccess()){
		//In driver directly we dont get the getscreenshot,so we need to caste the websdriver with TakesScreenshot class
		File srcfile= ((TakesScreenshot)driver). getScreenshotAs(OutputType. FILE);//want to capture the screenshot in terms of file.
		//since i need the image file ,so i will create an object for the file
		try {
		String reportDirectory=new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/automationpractice";//inside this folder we wont to keep the screen shot.
		//now will create one destination file with what format we need.
		File destfile=new File((String)reportDirectory+"/successceenshots/"+ Methodname + "_"+".png");
		//the screen shot capture will happen in the run time,but we need to copy in one dest file
		
			FileUtils.copyFile(srcfile, destfile);
			//below will help us to link the screen shot in testNG report
			Reporter.log("<a herf ='"+destfile.getAbsolutePath()+"'><img src='"+destfile.getAbsolutePath()+"' height='100',width='100'/></a>");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		}
		
	}

	public void onTestFailure(ITestResult result) {
		String Methodname=result.getName();
		// when test fails we want to capture the screenshot on the runtime.
		Calendar cal=Calendar.getInstance();//calendar is a class in java,we are creating the instance of calendar by using getInstance method.
		SimpleDateFormat formater=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");//this is for ,i need to save my screen in this format
		if(!result.isSuccess()){
		//In driver directly we dont get the getscreenshot,so we need to caste the websdriver with TakesScreenshot class
		File srcfile= ((TakesScreenshot)driver). getScreenshotAs(OutputType. FILE);//want to capture the screenshot in terms of file.
		//since i need the image file ,so i will create an object for the file
		try {
		String reportDirectory=new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/automationpractice";//inside this folder we wont to keep the screen shot.
		//now will create one destination file with what format we need.
		File destfile=new File((String)reportDirectory+"/successceenshots/"+Methodname + "_"+".png");
		//the screen shot capture will happen in the run time,but we need to copy in one dest file
		
			FileUtils.copyFile(srcfile, destfile);
			//below will help us to link the screen shot in testNG report
			Reporter.log("<a herf ='"+destfile.getAbsolutePath()+"'><img src='"+destfile.getAbsolutePath()+"' height='100',width='100'/></a>");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		}
	}
		
	

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
