package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ManageNewsPage {
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText ="New") WebElement New;
	@FindBy(className="form-control") WebElement News;
	@FindBy(name="create") WebElement save;
	@FindBy(linkText="Search") WebElement searchNews;
	@FindBy(name="un") WebElement enterNews;
	@FindBy(name="Search") WebElement searchButton;
	@FindBy(xpath="//h3[text()='Enter News Informations']") WebElement newTab;
	@FindBy(xpath="//h4[text()='Search Manage News']") WebElement searchTab;
	
	public ManageNewsPage clickNew()
	{
		New.click();
		return this;
	}
	public ManageNewsPage enterNews(String value)
	{
		News.sendKeys(value);
		return this;
	}
	public ManageNewsPage clicksave()
	{
		save.click();
		return this;
	}
	public ManageNewsPage clickSearchNews()
	{
		searchNews.click();
		return this;
	}
	public ManageNewsPage enterNewsSearch(String value)
	{
		enterNews.sendKeys(value);
		return this;
	}
	public ManageNewsPage clickSearchButton()
	{
		searchButton.click();
		return this;
	}
	public boolean locateNewTab()
	{
		return newTab.isDisplayed();
	}
	public boolean locatesearchTab()
	{
		return searchTab.isDisplayed();
	}
}
