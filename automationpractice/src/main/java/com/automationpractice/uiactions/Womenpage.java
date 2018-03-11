package com.automationpractice.uiactions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.testbase.Testbase;

public class Womenpage extends Testbase {
	public final String tops="Tops";
	public final String dresses="Dresses";
	
	@FindBy(xpath="//a[@title='Women']")
	WebElement womenbtn;
	
	@FindBy(xpath="//div[@class='product-image-container']/a/img")
	List<WebElement> selectpro;
	
	
	
	public Womenpage(WebDriver dri){
		PageFactory.initElements(dri, this);//we need to initialise webelements.so will create constructor to initialise
	}
	
	public void womenbtnClick(){
		womenbtn.click();
	}
		
	public void clickonnavigationmenu(String product){//this is the product what we will supply
		//we cannot convert this into a page factory because this product will keep on changing.
	driver.findElement(By.xpath("//a[@class='product-name'][starts-with(@href,'http://automationpractice.com/index.php?id_product')][@title='"+product+"']"));
	}
		
	//when i want to select from the list of elements,then for that perticular list i need to create one dynamic xpath .
	public List<WebElement> selectproduct(){//this is the product what you want to select
		List<WebElement> ele=selectpro;
		return ele;
		
	}

	
}
