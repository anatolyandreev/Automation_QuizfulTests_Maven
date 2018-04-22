package by.htp.quizful.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

	private final Logger logger = LogManager.getRootLogger();
	private static final String BASE_URL = "http://www.quizful.net/LoginAction.loginForm";
	
	@FindBy(xpath = "//input[@name='loginForm.login']")
	private WebElement loginFormLoginField;
	
	@FindBy(xpath = "//input[@name='loginForm.password']")
	private WebElement loginFormPasswordField;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Войти']")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.get(BASE_URL);
		logger.info("Navigating to " + BASE_URL);	
	}
		
	public void fillLoginFormLoginField(String login) {
		loginFormLoginField.sendKeys(login);
	}
	
	public void fillLoginFormPasswordField(String password) {
		loginFormPasswordField.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginButton.click();		
	}
}
