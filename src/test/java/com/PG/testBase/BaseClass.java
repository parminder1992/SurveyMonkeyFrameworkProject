package com.PG.testBase;

import java.io.File;
import java.io.FileInputStream;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.utils.FileUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	
	

	private static final WebDriver TakesScreenshot = null;

	//defining a web driver
    public WebDriver driver;
  
    //defining properties
     public Properties prop;
     
   //log4j code to use in test cases
 	//defining logger - to maintain the logs for all test cases
    public Logger logger = LogManager.getLogger(this.getClass());
     
     
	//1 launching an application
	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browserName) throws IOException {
		//use properties
	    prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\kaurp\\eclipse-workspace\\framework_project20Nov\\resources\\config.properties");
		prop.load(fis);
				
		//code to run script on browser of user need
		if (browserName.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		}else if (browserName.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else 
		{
          logger.info("please pass parameter as edge/chrome/firefox");
		}
		
    	
    	//implicitly wait
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();	
    	
    	//System.out.println("Application url is ---> " +  prop.getProperty("url"));
    	logger.info("Application is launched successfully with url---->" +  prop.getProperty("url"));
    	driver.get(prop.getProperty("url"));
		
	}
	
	
	//3 closing an application
		@AfterMethod
		public void tearDown() {
			driver.quit();	
			logger.info("Application is closed successfully with url---->" +  prop.getProperty("url"));
		}
		
		
		//Method to capture screenshots
		public void CaptureScreen(WebDriver driver, String testname) throws IOException 
		{
			TakesScreenshot ts = (TakesScreenshot)driver; 
			//where i want to capture and in which format it has to come
			File source = ts.getScreenshotAs(OutputType.FILE);
			
			//now we will decide target where and how we want to paste it
			File target = new File("C:\\Users\\kaurp\\eclipse-workspace\\framework_project20Nov\\screenshorts\\"+testname+".png");
		    FileUtils.copyFile(source, target);
		    logger.info("Screenshots captured successfully");
		}
}











