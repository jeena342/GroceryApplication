package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.WaitUtility;

//pages in main java
public class LoginPage {
	public WebDriver driver;
	WaitUtility wait=new WaitUtility();
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="username") WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(tagName ="button") WebElement login;

	@FindBy(linkText ="Dashboard") WebElement loginload;  
	@FindBy(xpath ="//h5[text()=' Alert!']")WebElement logoutload;
	
	public LoginPage enterUsernameField(String usernamevalue) {
		username.sendKeys(usernamevalue);
		return this;
	}
	public LoginPage enterPasswordKeys(String passwordvalue)
	{
		password.sendKeys(passwordvalue);
		return this;
	}
	public HomePage loginButtonPage()
	{	wait.waitUntilElementToBeClickable(driver,login);
		login.click();
		return new HomePage(driver);
		
	}
	public boolean locateloginload()
	{
		return loginload.isDisplayed();
	}
	public boolean locatelogoutload()
	{
		return logoutload.isDisplayed();
	}
	
	
}