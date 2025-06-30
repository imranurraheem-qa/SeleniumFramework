package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TestUtils extends BaseClass 
{
	public static String path1;
	public static String path2;

	

	/**
	 * Method used to log in console
	 * @return log
	 */
	public static Logger log() {

		// return LogManager.getLogger(BaseTest.class.getName());

		return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
	}

	public static String getGlobalValue(String key)
	{
		String value = null;
		try {
			String title = driver.getTitle();
			if(title.contains("sandbox"))
			{
				path1 = System.getProperty("user.dir") + "/src/test/resources/data/globalSandbox.properties";
			}else if(title.contains("qa"))
			{
				path1 = System.getProperty("user.dir") + "/src/test/resources/data/globalQA.properties";
			}
			
			FileInputStream file = new FileInputStream(path1);
			Properties prop = new Properties();
			prop.load(file);
			value = prop.get(key).toString();
		} catch (Exception e) {
			log().error("Exception Occured while loading the Properties file" + e);
		}
		return value;
	}
	
	public static String getURL(String key) 
	{
		String value = null;
		try {
			path1 = System.getProperty("user.dir") + "/src/test/resources/data/global.properties";
			
			FileInputStream file = new FileInputStream(path1);
			Properties prop = new Properties();
			prop.load(file);
			value = prop.get(key).toString();
		} catch (Exception e) {
			log().error("Exception Occured while loading the Properties file" + e);
		}
		return value;
	}
	

	public static void updateProperties(String  tolalTime,String  totalCases,String totalPassed,String totalFailedCases){
		try {
			String filePath= System.getProperty("user.dir")+File.separator+"testResult.properties";
			Properties prop = new Properties();
			prop.setProperty("Total_Execution_Time", tolalTime);
			prop.setProperty("Total_TestCases", totalCases);
			prop.setProperty("Total_PassedCases", totalPassed);
			prop.setProperty("Total_Failed_TestCases", totalFailedCases);
			OutputStream os = new FileOutputStream(new File(filePath));
			prop.store(os, "");
			os.close();
		}catch(Exception e) {
			System.out.println("Exception Occured while updating the Testresults"+e);
		}

	}


}
