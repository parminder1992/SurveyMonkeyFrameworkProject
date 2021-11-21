package com.PG.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class loginPage {

	//1 creating public web driver
    public WebDriver driver;
	
	//2 creating constructor
    public loginPage(WebDriver driver)
    {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
	

    //3 
    @FindBy(id="username")
    WebElement txtUserName;
    
    //4
    @FindBy(id="password")
    WebElement txtPassword;
    
    //5
    @FindBy(xpath="//button[@type='submit']")
    WebElement btnLogin;
    
    //6 method for entering the user name
    public void setUserName(String Uname)
    {
    	//driver.findElement(By.id("username")).sendKeys(Uname);
    	txtUserName.clear();
    	txtUserName.sendKeys(Uname);
    }

    //7 method for entering the password
    public void setPassword(String Upass)
    {
    	//driver.findElement(By.id("password")).sendKeys(Uname);
    	txtPassword.clear();
    	txtPassword.sendKeys(Upass);
    }
    
    //8 method for verifying the login
    public void ClickOnLoginBtn() 
    {
		btnLogin.click();
	}
    
	
	
}
