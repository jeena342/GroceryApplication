package testscript;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constants;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;
//import utility.RandomDataUtility;
import utility.RandomDataUtility;




public class AdminUserTest extends Base{
	AdminUserPage adminuserpage;
	HomePage home;
	@Test( description="User is trying to create a  new user")
	public void verifyWhetherTheAdminAbleToAddNewUser() throws IOException {
		String usernamevalue= ExcelUtility.readStringData(1,0,"LoginPage");
		String passwordvalue= ExcelUtility.readStringData(1,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterPasswordKeys(passwordvalue).enterUsernameField(usernamevalue);
		home=loginpage.loginButtonPage();	
		
		adminuserpage=home.clickMoreInfo();
		
		RandomDataUtility randomdatautility=new RandomDataUtility();		
		String usernamevalue1= randomdatautility.randomUsername();
		String passwordvalue1= randomdatautility.randomPassword();
		adminuserpage.clickNew().enterUsername(usernamevalue1).enterPassword(passwordvalue1).clickDropDown().clickSave();
		Boolean value=adminuserpage.newTabDisplay();
		Assert.assertTrue(value, Constants.ADMINNEWPAGEERROR);
		//for report - test-output - index.html - open with - web browser
		//extend report- testng frame helps for report generation
		//first configure testng.xml it is a file 
	}
	
	@Test( description="User is trying to search the user")
	public void verifyWhetherTheUserAbleToSearchTheNewlyAddedUser() throws IOException {
		String usernamevalue= ExcelUtility.readStringData(1,0,"LoginPage");
		String passwordvalue= ExcelUtility.readStringData(1,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterPasswordKeys(passwordvalue).enterUsernameField(usernamevalue);
		home=loginpage.loginButtonPage();
		adminuserpage=home.clickMoreInfo();
		
		String usernamevalue1= ExcelUtility.readStringData(1,0,"NewAdmin");
		adminuserpage.clickSearch().enterUsername1(usernamevalue1).clickDropDown1().clickSearchButton();
		Boolean adminText=adminuserpage.searchAdminText();
		Assert.assertTrue(adminText,Constants.ADMINSEARCHERROR);
	
}
	
	@Test( description="User is trying to reset")
	public void verifyWhetherTheAdminAbleToreset() throws IOException {
		String usernamevalue= ExcelUtility.readStringData(1,0,"LoginPage");
		String passwordvalue= ExcelUtility.readStringData(1,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterPasswordKeys(passwordvalue).enterUsernameField(usernamevalue);
		home=loginpage.loginButtonPage();	
		
		adminuserpage=home.clickMoreInfo();
		adminuserpage.clickReset();
		Boolean value=adminuserpage.resetTextFind();
		Assert.assertTrue(value, Constants.ADMINRESETERROR);
		

}
}
