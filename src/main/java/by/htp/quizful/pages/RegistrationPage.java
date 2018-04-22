package by.htp.quizful.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {

	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "http://www.quizful.net/LoginAction.registration";

	@FindBy(xpath = "//input[@name='registrationForm.login']")
	private WebElement createLoginInputField;

	@FindBy(xpath = "//input[@name='registrationForm.password']")
	private WebElement createPasswordInputField;

	@FindBy(xpath = "//input[@name='registrationForm.repassword']")
	private WebElement repeatPasswordInputField;

	@FindBy(xpath = "//input[@name='registrationForm.email']")
	private WebElement enterEmailInputField;

	@FindBy(xpath = "//input[@name='registrationForm.corporate']")
	private WebElement corporateCheckBox;

	@FindBy(xpath = "//input[@name='registrationForm.captcha']")
	private WebElement captchaInputField;

	@FindBy(xpath = "//input[@value='Завершить']")
	private WebElement submitButton;

	public RegistrationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		logger.info("Navigating to " + BASE_URL);
	}

	public void fillCreateFormLoginField(String login) {
		createLoginInputField.sendKeys(login);
	}

	public void fillCreateFormPasswordField(String password) {
		createPasswordInputField.sendKeys(password);
	}

	public void fillRepeatPasswordField(String password) {
		repeatPasswordInputField.sendKeys(password);
	}

	public void fillEmailField(String email) {
		enterEmailInputField.sendKeys(email);
	}

	public void clickCorporateCheckBox() {
		corporateCheckBox.click();
	}

	public void enterCaptcha(String captcha) {
		captchaInputField.sendKeys(captcha);
	}

	public void clickSubmitButton() {
		submitButton.click();
	}

	public WebElement getCreateLoginInputField() {
		return createLoginInputField;
	}

	public void setCreateLoginInputField(WebElement createLoginInputField) {
		this.createLoginInputField = createLoginInputField;
	}

	public WebElement getCreatePasswordInputField() {
		return createPasswordInputField;
	}

	public void setCreatePasswordInputField(WebElement createPasswordInputField) {
		this.createPasswordInputField = createPasswordInputField;
	}

	public WebElement getRepeatPasswordInputField() {
		return repeatPasswordInputField;
	}

	public void setRepeatPasswordInputField(WebElement repeatPasswordInputField) {
		this.repeatPasswordInputField = repeatPasswordInputField;
	}

	public WebElement getEnterEmailInputField() {
		return enterEmailInputField;
	}

	public void setEnterEmailInputField(WebElement enterEmailInputField) {
		this.enterEmailInputField = enterEmailInputField;
	}

	public WebElement getCorporateCheckBox() {
		return corporateCheckBox;
	}

	public void setCorporateCheckBox(WebElement corporateCheckBox) {
		this.corporateCheckBox = corporateCheckBox;
	}

	public WebElement getCaptchaInputField() {
		return captchaInputField;
	}

	public void setCaptchaInputField(WebElement captchaInputField) {
		this.captchaInputField = captchaInputField;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public void setSubmitButton(WebElement submitButton) {
		this.submitButton = submitButton;
	}

	public Logger getLogger() {
		return logger;
	}

	public String getBASE_URL() {
		return BASE_URL;
	}



	
	
}
