package by.htp.quizful.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePage{
	
	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "http://www.quizful.net/user/";

	@FindBy(xpath = "//a[@href='/ProfileAction.settings']")
	private WebElement editProfileButton;
	
	@FindBy(xpath = "//dl[@id='personal-contacts']/dd[2]")
	private WebElement nameLabel;
	
	@FindBy(xpath = "//dl[@id='personal-contacts']/dd[3]/span")
	private WebElement countryLabel;
	
	@FindBy(xpath = "//dl[@id='personal-contacts']/dd[3]")
	private WebElement cityLabel;
	
	@FindBy(xpath = "//dl[@id='personal-contacts']/dd[4]")
	private WebElement birthYearLabel;
	
	@FindBy(xpath = "//dl[@id='personal-contacts']/dd[5]")
	private WebElement siteLabel;
	
	@FindBy(xpath = "//dl[@id='personal-contacts']/dd[6]")
	private WebElement timeZoneLabel;
	
	@FindBy(xpath = "//dl[@id='personal-contacts']/dd[7]")
	private WebElement aboutLabel;
	
	public ProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		logger.info("Navigating to " + BASE_URL);		
	}
	
	public void openPage(String login) {
		driver.navigate().to(BASE_URL + login);
		logger.info("Navigating to " + BASE_URL);		
	}
	
	public ProfileActionPage clickEditProfileButton(){
		editProfileButton.click();
		return new ProfileActionPage(driver);
	}
	
	public String getName(){
		return nameLabel.getText();
	}
	
	public String getCityName(){
		return cityLabel.getText();
	}
	
	public String getCountryName(){
		return countryLabel.getText();
	}
	
	public String getBirthYear(){
		return birthYearLabel.getText();
	}
	
	public String getSite(){
		return siteLabel.getText().replaceAll("^http://", "");
	}
	
	public String getAbout(){
		return aboutLabel.getText();
	}
	
	public String getTimeZone(){
		return timeZoneLabel.getText();
	}
}
