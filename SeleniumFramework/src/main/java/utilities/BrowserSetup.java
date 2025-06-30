package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserSetup extends BaseClass
{
	
	public WebDriver initializeDriver()
	{
		try {
			ChromeOptions options = new ChromeOptions();
			
//			options.addArguments("--headless=new");
			
			options.addArguments("enable-automation");
			options.addArguments("disable-infobars");
			options.addArguments("--disable-notifications");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--disable-extensions");
			options.addArguments("--test-type");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--no-sandbox");
			options.addArguments("--remote-debugging-port=9222");
//				options.addArguments("--remote-allow-origins=*");
			options.addArguments("auto-open-devtools-for-tabs");
			options.addArguments("--enable-mobile-emulation");
			options.addArguments("--window-size=1920,1080");
//			options.addArguments("--window-size=360,640");
			options.addArguments("--disable-gpu");
			options.addArguments("--dns-prefetch-disable");
			options.addArguments("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36");
	
			driver = new ChromeDriver(options);
			
			driver.manage().window().maximize();
			

		} catch (Exception e) {
			System.out.println("Exception Occured while starting the browser " + e.getMessage());
		}
		
		return driver;
	}
}
