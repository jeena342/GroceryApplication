package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utility.ExcelUtility;

public class ManageNewsTest extends Base {
	ManageNewsPage managenewspage;
	HomePage home;
	@Test(description= "User is able to add new news")
	public void verifyWhetherTHeUserAbleTOSuccessfullyAddNewNews() throws IOException {
		String usernamevalue= ExcelUtility.readStringData(1,0,"LoginPage");
		String passwordvalue= ExcelUtility.readStringData(1,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterPasswordKeys(passwordvalue).enterUsernameField(usernamevalue);
		home=loginpage.loginButtonPage();
		String newNews= ExcelUtility.readStringData(1,0,"ManageNews");
		managenewspage=home.clickmanNewsMoreInfo();
		managenewspage.clickNew().enterNews(newNews).clicksave();
		Boolean value=managenewspage.locateNewTab();
		Assert.assertTrue(value,Constants.ADDNEWNEWSERROR);
		// smok testing - testing critical functionality of a application
		// sanity testing - testing newly added features
		// regression testing -when a newly added or bug fix check whether all  the exicting features working fine
		
}
	@Test(description= "User is able to search news")
	public void verifyWhetherTheUserAbleToSearchNews() throws IOException {
		String usernamevalue= ExcelUtility.readStringData(1,0,"LoginPage");
		String passwordvalue= ExcelUtility.readStringData(1,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameField(usernamevalue).enterPasswordKeys(passwordvalue);
		
		home=loginpage.loginButtonPage();		
		managenewspage=home.clickmanNewsMoreInfo();
		
		String newNews= ExcelUtility.readStringData(1,0,"ManageNews");
		managenewspage.clickSearchNews().enterNews(newNews).clickSearchButton();
		Boolean value=managenewspage.locatesearchTab();
		Assert.assertTrue(value,Constants.SEARCHNEWSERROR);
	
}
}