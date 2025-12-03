package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;

public class HomeTest extends Base {
	HomePage homepage;
	@Test(description= "User is trying to logout")
	public void verifyWhetherTHeUSerAbleToSuccessfullyLogout() throws IOException {
		String usernamevalue= ExcelUtility.readStringData(1,0,"LoginPage");
		String passwordvalue= ExcelUtility.readStringData(1,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterPasswordKeys(passwordvalue).enterUsernameField(usernamevalue);
		homepage=loginpage.loginButtonPage();
		homepage.clickadmin();
		loginpage=homepage.clicklogout();
		Boolean value=homepage.locateHomePage();
		Assert.assertTrue(value, Constants.LOGOUTERROR);
		//do not pass driver two times
	}
}
