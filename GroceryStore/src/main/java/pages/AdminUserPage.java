package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utility.PageUtility;

public class AdminUserPage {
		PageUtility page=new PageUtility();
		public WebDriver driver;
		public AdminUserPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(linkText="New") WebElement New;
		@FindBy(id="username") WebElement username;
		@FindBy(id="password") WebElement password;
		@FindBy(id="user_type") WebElement user_Type;
		@FindBy(name="Create") WebElement save;
		@FindBy(xpath="//h1[text()='Admin Users']") WebElement NewTab;
		@FindBy(className ="col-sm-6") WebElement reset;
		@FindBy(xpath="//h4[text()='Admin Users']") WebElement resetText;
		@FindBy(linkText = "Search") WebElement search;
		@FindBy(className ="form-control") WebElement userName;
		@FindBy(name="ut") WebElement userType;
		@FindBy(name="Search") WebElement searchButton;
		@FindBy(xpath="//h4[text()='Search Admin Users']") WebElement searchAdmin;
		@FindBy(name="user_type") WebElement dropDown1;
		@FindBy(name="ut") WebElement dropDown2;
		
		
		public AdminUserPage clickSearch()
		{
			search.click();
			return this;
		}
		public AdminUserPage enterUsername1(String value)
		{
			userName.sendKeys(value);
			return this;
		}
		public AdminUserPage enterUserType(String value)
		{
			userType.sendKeys(value);
			return this;
		}
		public AdminUserPage clickSearchButton()
		{
			searchButton.click();
			return this;
		}
		public boolean searchAdminText()
		{
			return searchAdmin.isDisplayed();
		}
		public AdminUserPage clickReset()
		{
			reset.click();
			return this;
		}
		public boolean resetTextFind()
		{
			return resetText.isDisplayed();
		}
		
		public AdminUserPage clickNew()
		{
			New.click();
			return this;
		}
		
		public AdminUserPage enterUsername(String value)
		{
			username.sendKeys(value);
			return this;
		}
		public AdminUserPage enterPassword(String value)
		{
			password.sendKeys(value);
			return this;
		}
		
		public AdminUserPage enteruserType(String value)
		{
			user_Type.sendKeys(value);
			return this;
		}
		public AdminUserPage clickSave()
		{
			save.click();
			return this;
		}
		public boolean newTabDisplay()
		{
			return NewTab.isDisplayed();
		}
		public AdminUserPage clickDropDown()
		{	PageUtility.selectVAlueByVisibleText(dropDown1,"Staff");
			return this;
		}
		public AdminUserPage clickDropDown1()
		{	
			PageUtility.selectVAlueByVisibleText(dropDown2,"Staff");
			return this;
			
		}
		
		
		
	}

