package automationcore;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ScreenShotUtility;

public class Base {
		Properties pro;
		FileInputStream file;// uses for stroeing url with out hardcoding
		public WebDriver driver;
		
		//parameterization= to give different values
		@Parameters("browsers")
		@BeforeMethod(alwaysRun= true)// to get the class when grouping, then the run and debug will not work
		public void browserInitialisation(String browers) throws IOException 	 {
			pro= new Properties();
			file=new FileInputStream(Constants.CONFIGFILE);
			pro.load(file);//to load the file
			if( browers.equalsIgnoreCase("chrome"))
			{
				driver=new ChromeDriver();	
			}
			else if(browers.equalsIgnoreCase("firefox"))
			{
				driver=new FirefoxDriver();
			}
			else if(browers.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver();
				driver=new EdgeDriver();
			}
			driver.get(pro.getProperty("url"));
			//driver.get("https://groceryapp.uniqassosiates.com//admin//login");
			driver.manage().window().maximize();
			
			
		}
		/*@AfterMethod(alwaysRun= true)
		public void closeBrowser()
		{
			
			if (iTestResult.getStatus() == ITestResult.FAILURE) {

				ScreenShotUtility screenShot = new ScreenShotUtility();
				screenShot.getScreenshot(driver, iTestResult.getName());//passes driver and method name
				}
			

				
			//driver.close();//current tab closes
			//driver.quit();// closes all the tab
		}*/
		@AfterMethod(alwaysRun = true)
		public void closeBrowser(ITestResult iTestResult) throws IOException {
		    
		    if (iTestResult.getStatus() == ITestResult.FAILURE) {

		        ScreenShotUtility screenShot = new ScreenShotUtility();
		        screenShot.getScreenshot(driver, iTestResult.getName());
		    }

		    //driver.quit();
		}
		}
		// to run through pom rightclick pom execute pom clean and pom install
		//maven compiler , maven su
		//lombok- dependency to execute with pom
		//to execute with cammand prompt-right click with project , show in, system explorer, open project, copy the path , type cmd, in cmd type mvn clean, and mvn install  
	


