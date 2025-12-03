package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;

public class LoginTest extends Base {
		HomePage home;
		
		// when grouping we will not get properties of extended class
		@Test (priority=1, description="User is trying to login with valid credentials")//,groups= {"smoke"})
		public void verifyLoginWithValidCredentials() throws IOException {
			String usernamevalue= ExcelUtility.readStringData(1,0,"LoginPage");
			String passwordvalue= ExcelUtility.readStringData(1,1,"LoginPage");
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterPasswordKeys(passwordvalue).enterUsernameField(usernamevalue);
			
			home=loginpage.loginButtonPage();
			Boolean value=loginpage.locateloginload();
			Assert.assertTrue(value,Constants.VALIDCREDENTIALERROR);
		}
		@Test(priority=2,description="User is trying to login with invalid credentials",retryAnalyzer = retry.Retry.class)//,groups= {"smoke"})//,dataProvider="loginProvider")
		public void verifyLoginWithInvalidCredentials() throws IOException  {
			String usernamevalue= ExcelUtility.readStringData(2,0,"LoginPage");
			String passwordvalue= ExcelUtility.readStringData(2,1,"LoginPage");
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterPasswordKeys(passwordvalue).enterUsernameField(usernamevalue).loginButtonPage();
		/*String passwordvalue,String usernamevalue*/
			Boolean value=loginpage.locatelogoutload();
			Assert.assertTrue(value, Constants.INVALIDCREDENTIALERROR);
			
		}
		
		@Test(priority=3,description="User is trying to login with invalid password and valid username")
		public void verifyLoginWithInvalidpasswordValidusername() throws IOException  {
			String usernamevalue= ExcelUtility.readStringData(3,0,"LoginPage");
			String passwordvalue= ExcelUtility.readStringData(3,1,"LoginPage");
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterPasswordKeys(passwordvalue).enterUsernameField(usernamevalue).loginButtonPage();
			Boolean value=loginpage.locatelogoutload();
			Assert.assertTrue(value, Constants.INVALIDPASSWORDVALIDUSERNAME);
		}
		@Test(priority=4,description="User is trying to login with invalid username and valid password")
		public void verifyLoginWithInvalidUsernameValidpassword() throws IOException  {
			String usernamevalue= ExcelUtility.readStringData(4,0,"LoginPage");
			String passwordvalue= ExcelUtility.readStringData(4,1,"LoginPage");
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterPasswordKeys(passwordvalue).enterUsernameField(usernamevalue).loginButtonPage();
			Boolean value=loginpage.locatelogoutload();
			Assert.assertTrue(value, Constants.INVALIDUSERNAMEVALIDPASSWORD);
		}
		
		@DataProvider(name = "loginProvider")// we can write any name
		public Object[][] getDataFromDataProvider() throws IOException {// data provider method, alll the things inside this is  object

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
		// new Object[] {ExcelUtility.getStringData(3,
		// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
		}
		

	}

