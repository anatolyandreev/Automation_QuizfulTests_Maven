package by.htp.quizful.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
	
	protected WebDriver driver;

	public abstract void openPage();

	public BasePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
}
