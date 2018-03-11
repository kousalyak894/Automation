package com.automationpractice.uiactions;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {//will create all the locators seperately so that it will be easy for us if need some changes in the locators.then will create a web elements for utilisating actions performed in the application.
	public static final Logger log=Logger.getLogger(Homepage.class.getName());
	@FindBy(xpath="//a[@class='login']")
	WebElement SignIn;//WebElement is a return type.will store values in the variables.as per the use will utilise those values.
	
	@FindBy(xpath="//div/input[@type='text'][@id='email']")
	WebElement UserName;
	
	@FindBy(xpath="//div/span/input[@type='password'][@id='passwd']")
	WebElement Password;
	
	@FindBy(xpath="//button[@type='submit' and @name='SubmitLogin']")
	WebElement LogButton;
	
	@FindBy(xpath="//div/form/h3[text()='Already registered?']")
	WebElement alreadyregistered;
	
	@FindBy(xpath="//p[text()='There is 1 error']")
	WebElement errormsgforunauthentication;
	
	@FindBy(xpath="//input[@type='text'][@id='email_create']")
	WebElement createemail;
	
	@FindBy(xpath="//button[@type='submit' and @id='SubmitCreate']")
	WebElement createaccbutnclick;
	
	//page factories for registration 
	
	
	@FindBy(css="input[id*='id_gender2']")
	WebElement radiobutn;
	
	@FindBy(css="input#customer_firstname")
	WebElement firstname;
	
	@FindBy(css="input[name='customer_lastname']")
	WebElement lastname;
	
	@FindBy(id="passwd")
	WebElement passwordfield;
	
	@FindBy(xpath="//select[@id='days']")
	WebElement day;
	
	@FindBy(xpath="//select[@id='months']")
	WebElement month;
	
	@FindBy(xpath="//select[@id='years']")
	WebElement year;
	
	@FindBy(xpath="//input[@id='firstname'][@name='firstname']")
	WebElement yraddfirstname;
	
	@FindBy(xpath="//input[@id='lastname'][@name='lastname']")
	WebElement yraddlastname;
	
	@FindBy(xpath="//input[@id='company'][@name='company']")
	WebElement yraddcompany;
	
	@FindBy(xpath="//input[@id='address1'][@name='address1']")
	WebElement yraddaddress;
	
	@FindBy(id="city")
	WebElement yrcity;
	
	@FindBy(id="id_state")
	WebElement yrstate;
	
	@FindBy(xpath="//input[@id='postcode']")
	WebElement yrzipcode;
	
	@FindBy(xpath="//select[@name='id_country']")
	WebElement yrcountry;
	
	@FindBy(xpath="//input[@id='phone_mobile']")
	WebElement yrmobilephone;
	
	@FindBy(xpath="//input[@value='My address']")
	WebElement refrenceaddress;
	
	@FindBy(xpath="//button[@name='submitAccount']")
	WebElement registerbtn;
	
	@FindBy(xpath="//p[text()='There are 2 errors']")
	WebElement unsuccessfullerrormsg;
	
	
	
	//always we need to create one constructor of the class.
	public Homepage(WebDriver dri){
		PageFactory.initElements(dri, this);//since this a page factory we need to initialise the web element.so that we can get all the methods of web element.if we wont initialise will get null pointer exception.
		//this refers to the current class object.
	}
	
	public String signinapp(){
		log.info("clicked on signin"+SignIn.toString());
		SignIn.click();
		log.info("This is the heading for users"+alreadyregistered.toString());
		return alreadyregistered.getText();
	}
	
	
	public  void loginToApplication(String Emailaddress,String password){//here we can utilize those web elements for the actions performed in app.
		log.info("Entering user name"+UserName.toString());
		UserName.sendKeys(Emailaddress);
		log.info("Entering user password"+Password.toString());
		Password.sendKeys(password);
		log.info("clicking on login "+LogButton.toString());
		LogButton.click();
		
	}
	public String errorforunauthenticateduser(){
		return errormsgforunauthentication.getText();
	}
	
	
	public void createanaccount(String mailid){
		createemail.sendKeys(mailid);
		createaccbutnclick.click();
		log.info("email created successfully"+createemail.toString());
	}
	
	//public void userregistraton(String firstname,String lname,String passwd,String day,String month,String year,String yrfirstname,String yrlastname,String yraddress,String city,String state,String zipcode,String country,String mphone,String refaddress){
		public void userregistraton(String firstname,String lname,String passwd,String yrfirstname,String yrlastname,String yraddress,String city,String zipcode,String mphone ,String refaddress){
		radiobutn.click();
		this.firstname.sendKeys(firstname);//if local and global vraiables are same ,to differentiate we will use this keyword
		lastname.sendKeys(lname);
		passwordfield.sendKeys(passwd);
		yraddfirstname.sendKeys(yrfirstname);
		yraddlastname.sendKeys(yrlastname);
		yraddcompany.sendKeys(yraddress);
		yraddaddress.sendKeys(yraddress);
		yrcity.sendKeys(city);
		yrzipcode.sendKeys(zipcode);
		yrmobilephone.sendKeys(mphone);
		refrenceaddress.sendKeys(refaddress);
		registerbtn.click();
		this.day.click();
		
		
    }
		public String errormsgafterregis(){
			return unsuccessfullerrormsg.getText();
    }
		public void logindemositeusingexceldata(String username,String password){
			UserName.clear();
			UserName.sendKeys(username);
			log.info("username entered");
			Password.clear();
			Password.sendKeys(password);
			log.info("password entered");
			LogButton.click();
			log.info("clicked on login");
			
			
			
		}
		
	
	
	

}
