package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectDragDropWithValue(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByValue(value);
	}
	public void deselectAllValue(WebElement element, String value) {
		Select object=new Select(element);
		object.deselectAll();
	}
	public void deSelectByContainsVisibleValue(WebElement element, String value) {
		Select object=new Select(element);
		object.deSelectByContainsVisibleText(value);
	}
	public void equalsToObject(WebElement element, String value) {
		Select object=new Select(element);
		object.equals(object);
	}
	public void getAllSelectedValues(WebElement element, String value) {
		Select object=new Select(element);
		object.getAllSelectedOptions();
	}
	public void getFirstSelectedvalue(WebElement element, String value) {
		Select object=new Select(element);
		object.getFirstSelectedOption();
	}
	public void selectValueByIndex(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByIndex(0);
	}
	public void checkIsMultiple(WebElement element, String value) {
		Select object=new Select(element);
		object.isMultiple();
	}
	public static void selectVAlueByVisibleText(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByVisibleText(value);
	}
	
	
	

}
