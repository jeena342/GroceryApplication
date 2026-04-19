package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import Utility.ExcelUtility;
import automationcore.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;

public class ManageContactTest extends Base{
		ManageContactPage managecontactpage;
		HomePage homepage;
		@Test(description= "User is trying to logout")
		public void verifyWhetherAddressAndNamePrinting() throws IOException {
			String usernamevalue= ExcelUtility.readStringData(1,0,"LoginPage");
			String passwordvalue= ExcelUtility.readStringData(1,1,"LoginPage");
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterPasswordKeys(passwordvalue).enterUsernameField(usernamevalue);
			homepage=loginpage.loginButtonPage();
			managecontactpage.clickMoreInfo();
			
			
			//Assert.assertTrue(value, Constants.LOGOUTERROR);
			//do not pass driver two times
		}
}
