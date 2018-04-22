package by.htp.quizful.pages;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

	private final Logger logger = LogManager.getRootLogger();
	private static final String BASE_URL = "http://quizful.net";
	
	@FindBy(xpath = "//li/a[text()='зарегистрироваться']")
	private WebElement registerButton;
	
	@FindBy(xpath = "//ul[@id='user-panel']//a[@rel='nofollow']")
	private WebElement userPanelNikcname;
	
	@FindBy(xpath = "//a[text()='Профиль']")
	private WebElement profileButton;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);	
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		logger.info("Navigating to " + BASE_URL);
	}
	
	public WebElement getUserNicknameElement(){
		return userPanelNikcname;
	}
	
	public void clickProfileButton(){
		profileButton.click();
	}

}
