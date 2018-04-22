package by.htp.quizful.pages;

import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailInboxPage extends BasePage{
	
	private static final String baseEmail = "tathtp7";
	private static final String baseEmailPassword = "Epam12345N";
	private static final String BASE_URL = "https://mail.google.com";
	
	private final static Logger logger = org.apache.logging.log4j.LogManager.getRootLogger();
	
	@FindBy(xpath ="//span[1][@class='zF' and text()='Quizful']")
	private WebElement firstUnread;
	
	@FindBy(xpath="//a[contains(@href, 'LoginAction.verifyEmail')]")
	private WebElement verificationLink;
	
	@FindBy(xpath="//input[@type='email']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//span[@class='RveJvd snByac']/preceding::div[@id='identifierNext']")
	private WebElement nextLoginButton;
	
	@FindBy(xpath="//span[@class='RveJvd snByac']/preceding::div[@id='passwordNext']")
	private WebElement nextPasswordButton;
	
	@FindBy(xpath="")
	private WebElement submitButton;
	
	public GmailInboxPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		(new GmailLoginPage(driver)).openPage();
		fillEmailField();
		clickNextLoginButton();
		fillPasswordField();
		clickNextPasswordButton();
		logger.info("Navigating to " + BASE_URL);
	}
	
	public void fillEmailField(){
		emailField.sendKeys(baseEmail);
	}
	
	public void fillPasswordField(){
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(baseEmailPassword);
//		passwordField.sendKeys(baseEmailPassword);
	}
	
	public void clickNextLoginButton(){
		nextLoginButton.click();
	}
	
	public void clickNextPasswordButton(){
		nextPasswordButton.click();
	}
	
	public WebElement waitForUnreadMessage(){
		return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(firstUnread));
	}
	
	public WebElement getVerificationLink(){
		return verificationLink;
	}

}
