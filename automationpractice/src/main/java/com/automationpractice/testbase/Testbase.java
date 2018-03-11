package com.automationpractice.testbase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

import com.automationpractice.customListener.Listener;
import com.automationpractice.excelreading.Excel_Reader;

public class Testbase {
	
	public static final Logger log=Logger.getLogger(Testbase.class.getName());//Logger is the class type and (Testbase.class.getName()) will give us the class name.
	public static WebDriver driver;//webdriver is an interface,we cannot create an object of interface so i am making webdriver as a reference.
	String browser="chrome";
	String url="http://automationpractice.com/index.php";
	Excel_Reader excel;
	//whenever test starts we have to make sure that listener class object should be created
	
	
	public void init(){
		selectbrowser(browser);
		
		geturl(url);
		String log4jconfpath="log4j.properties";//path name will be stored in the object
		PropertyConfigurator.configure(log4jconfpath);//property configurator is a class from apache log4j and configure is a method ,will pass an argument "log4jconfpath"which will configure all the properties
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
	}
	
	public void selectbrowser(String browser){
		
		if(browser.equalsIgnoreCase("chrome")){
		    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");//System.getProperty("user.dir")->this path will verify upto the project and will continue
		    driver=new ChromeDriver();  
		    log.info(".......strating the browser..........."+browser);
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");//System.getProperty("user.dir")->this path will verify upto the project and will continue
		    driver=new FirefoxDriver();  
		    log.info(".......strating the browser..........."+browser);
		}
		else if(browser.equalsIgnoreCase("InternetExplorer")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/drivers/iexploredriver.exe");//System.getProperty("user.dir")->this path will verify upto the project and will continue
			driver = new InternetExplorerDriver();  
		    log.info(".......strating the browser..........."+browser);
		}
		
	}
	public void geturl(String url){
		log.info("...........navigating to the url............"+url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	
	public String[][] getData(String excelname,String sheetname){//we are not hardcoding the name,because diff persons may use diff names
		String path=System.getProperty("user.dir")+"/src/main/java/com/automationpractice/data/"+excelname;
		excel=new Excel_Reader(path);//here we have object of excel_reader class
		String[][] data=excel.getDataFromSheet(sheetname,excelname);//here we are getting data from the excel reader class
		return data;
		
	}
	
	public void getScreenShot(String name){
		Calendar cal=Calendar.getInstance();//calendar is a class in java,we are creating the instance of calendar by using getInstance method.
		SimpleDateFormat formater=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");//this is for ,i need to save my screen in this format
		//In driver directly we dont get the getscreenshot,so we need to caste the websdriver with TakesScreenshot class
		File srcfile= ((TakesScreenshot)driver). getScreenshotAs(OutputType. FILE);//want to capture the screenshot in terms of file.
		//since i need the image file ,so i will create an object for the file
		try {
		String reportDirectory=new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/automationpractice/screenshots/";//inside this folder we wont to keep the screen shot.
		//now will create one destination file with what format we need.
		File destfile=new File((String)reportDirectory+ name + "_"+".png");
		//the screen shot capture will happen in the run time,but we need to copy in one dest file
		
			FileUtils.copyFile(srcfile, destfile);
			//below will help us to link the screen shot in testNG report
			Reporter.log("<a herf ='"+destfile.getAbsolutePath()+"'><img src='"+destfile.getAbsolutePath()+"' height='100',width='100'/></a>");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
