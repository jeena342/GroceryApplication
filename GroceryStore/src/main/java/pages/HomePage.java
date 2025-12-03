package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
		public WebDriver driver;
		public HomePage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//p[text()='Manage News']/parent::div/following-sibling::a[text()[contains(.,'More info')]]") WebElement manNews;
		@FindBy(className ="img-circle") WebElement adminlink;
		@FindBy(linkText = "Logout") WebElement logout;
		@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement homePage;
		@FindBy(className ="small-box-footer") WebElement moreInfo;
		public HomePage clickadmin()
		{
			adminlink.click();
			return this;
		}
		public LoginPage clicklogout()
		{
			logout.click();
			return new LoginPage(driver);
		}
		public boolean locateHomePage()
		{
			return homePage.isDisplayed();
		}
		public AdminUserPage clickMoreInfo()
		{
			moreInfo.click();
			return new AdminUserPage(driver);
		}
		public ManageNewsPage clickmanNewsMoreInfo()
		{
			manNews.click();
			return new ManageNewsPage(driver);
		}
	}

