package by.htp.quizful.steps;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.htp.quizful.driver.DriverSingleton;
import by.htp.quizful.pages.GmailInboxPage;
import by.htp.quizful.pages.GmailLoginPage;
import by.htp.quizful.pages.LoginPage;
import by.htp.quizful.pages.MainPage;
import by.htp.quizful.pages.ProfileActionPage;
import by.htp.quizful.pages.ProfilePage;
import by.htp.quizful.pages.RegistrationPage;

public class Steps {
	
	private WebDriver driver;
	private MainPage mainPage;
	private RegistrationPage registrationPage;
	private GmailInboxPage gmailInbox;
	private ProfilePage profilePage;
	private ProfileActionPage profileActionPage;
	private LoginPage loginPage;
	private final Logger logger = LogManager.getRootLogger();

	public WebDriver initBrowser()
	{
		driver = DriverSingleton.getDriver();
		return driver;
	}

	public void closeDriver()
	{
		DriverSingleton.closeDriver();
	}
		
	public void fillRegistrationForm(String login, String password, String email, boolean isCorporate) {
		registrationPage = new RegistrationPage(driver);
		registrationPage.openPage();
		logger.info("Filling Login with value = " + login);
		registrationPage.fillCreateFormLoginField(login);
		logger.info("Filling Password with value = " + password);
		registrationPage.fillCreateFormPasswordField(password);
		logger.info("Filling Repeat Password with value = " + password);
		registrationPage.fillRepeatPasswordField(password);
		logger.info("Filling Email with value = " + email);
		registrationPage.fillEmailField(email);
		if (isCorporate == true)
			logger.info("Selecting Corporate check box");
			registrationPage.clickCorporateCheckBox();
		logger.info("waiting for the captcha");
		registrationPage.clickSubmitButton();
		logger.info("Registration form submitted");
	}
	
	public MainPage loginToTheSystem(String login, String password) {
		loginPage = new LoginPage(driver);
		loginPage.openPage();
		logger.info("Filling Login with value = " + login);
		loginPage.fillLoginFormLoginField(login);
		logger.info("Filling Password with value = " + password);
		loginPage.fillLoginFormPasswordField(password);
		loginPage.clickLoginButton();
		logger.info("Registration form submitted");
		return mainPage = new MainPage(driver);
	}
	
	public void confirmEmail(){
		gmailInbox = new GmailInboxPage(driver);
		gmailInbox.openPage();
		gmailInbox.waitForUnreadMessage().click();
		gmailInbox.getVerificationLink().click();
	}
	
	public String getUserNicknameFromUserPanel(){
		mainPage = new MainPage(driver);
		String nickname = mainPage.getUserNicknameElement().getText();
		logger.info("Found nickname \"" + nickname + "\" in User Panel");
		return nickname;
	}
	
	public void openUserProfile(String login, String password){
		mainPage = loginToTheSystem(login, password);
		mainPage.clickProfileButton();
	}
	
	public void openUserProfile(){
		mainPage.clickProfileButton();
	}
	
	public MainPage getMainPage(){
		return mainPage;
	}
	
	public ProfilePage getProfilePage(){
		return profilePage;
	}
	
	public void expandPersonalInfoSection(){
		profileActionPage = new ProfileActionPage(driver);
		profileActionPage.expandPersonalInfo();
	}
	
	public String selectRandomCountry(){
		profileActionPage = new ProfileActionPage(driver);
		profileActionPage.clickCountrySelect();
		String randomCountry = profileActionPage.clickRandomCountry();
		return randomCountry;
	}
	
	public String selectRandomCity(){
		profileActionPage = new ProfileActionPage(driver);
		profileActionPage.clickCitySelect();
		String randomCity = profileActionPage.clickRandomCity();
		return randomCity;
	}
	
	public String selectRandomTimeZone(){
		profileActionPage = new ProfileActionPage(driver);
		profileActionPage.clickTimeZoneSelect();
		String randomTimeZone = profileActionPage.clickRandomTimeZone();
		return randomTimeZone;
	}
	
	public void openEditProfileScreen(){
		profilePage = new ProfilePage(driver);
		profilePage.clickEditProfileButton();
	}
	
	public void fillPersonalDataSection(String name, String surname, String birthYear, String site, String company, String about){
		profileActionPage = new ProfileActionPage(driver);
		List<String> returnedValues = new ArrayList<String>();
		profileActionPage.fillNameField(name);
		profileActionPage.fillSurnameField(surname);
		profileActionPage.fillBirthYearField(birthYear);
		profileActionPage.fillSiteField(site);
		profileActionPage.fillCompanyField(company);
		profileActionPage.fillAboutField(about);
		selectRandomCountry();
		selectRandomCity();
		selectRandomTimeZone();
		profileActionPage.clickSaveButton();
	}
	
	public List<String> getActualPersonalData(){
		List<String> actualData = new ArrayList<String>();
		profilePage = new ProfilePage(driver);
		actualData.add(profilePage.getName());
		actualData.add(profilePage.getBirthYear());
		actualData.add(profilePage.getSite());
		actualData.add(profilePage.getAbout());
		actualData.add(profilePage.getCityName());
		actualData.add(profilePage.getTimeZone());
		return actualData;
	}
	
	public void clearPersonalData(){
		profileActionPage = new ProfileActionPage(driver);
		profileActionPage.clearProfile();
		profileActionPage.clickSaveButton();
	}
}
