package utilities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseClass 
{
	static WebDriver driver = null;
	
	@BeforeSuite
	public void reportGenerate() throws IOException
	{
		ExtentManager.setExtent();
	}
	
	@BeforeClass
	public void driverConfigs()
	{
		BrowserSetup bs = new BrowserSetup();
		bs.initializeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		enterURL();
	}
	
	public static void enterURL()
	{
		driver.get("https://www.google.com/");
	}
	
	@AfterClass
	public void closeDriver() 
	{
		try {
			driver.quit();
		}catch(Exception e)
		{
			driver.quit();
		}

	}
	
	@AfterSuite
	public void endReport()
	{
		ExtentManager.endReport();
	}
	

}
