package by.htp.quizful.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPage extends BasePage{
	
	private static final String BASE_URL = "https://mail.google.com";
	
	private final static Logger logger = org.apache.logging.log4j.LogManager.getRootLogger();

	public GmailLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		logger.info("Navigating to " + BASE_URL);		
	}

}
