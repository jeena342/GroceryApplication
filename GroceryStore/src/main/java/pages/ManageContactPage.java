package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContactPage {
	public WebDriver driver;
	public ManageContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class =\"small-box-footer\"]/following::a[2]") WebElement moreinfo;
	
	public ManageContactPage clickMoreInfo()
	{
		moreinfo.click();
		return this;
	}
	
}
