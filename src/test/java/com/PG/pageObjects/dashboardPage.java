package com.PG.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class dashboardPage {

	//1 creating public web driver
    public WebDriver driver;
	
	//2 creating constructor
    public dashboardPage(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver,this);	
	}
    
	
    //3
    @FindBy(linkText="Dashboard")
    WebElement Dashboardlink;
    
    //4 create method to verify if dashboard is displayed - return true or false
    public boolean isDashboardDisplay() 
    {
    	boolean status = Dashboardlink.isDisplayed();
    	return status;
	}
    
	
}
