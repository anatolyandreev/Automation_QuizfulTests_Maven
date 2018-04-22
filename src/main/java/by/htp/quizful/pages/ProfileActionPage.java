package by.htp.quizful.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.htp.quizful.utils.Utils;

public class ProfileActionPage extends BasePage {

	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "http://www.quizful.net/ProfileAction.settings";
	private static String randomCountry;
	private static String randomCity;
	private static String randomTimeZone;

	@FindBy(xpath = "//div[@id='profile-personal-form']/div[2]")
	private WebElement personalInfoBar;

	@FindBy(xpath = "//div[@class='title']/b[text()='Уведомления']")
	private WebElement notificationsBar;
	
	@FindBy(xpath = "//div[@class='title']/b[text()='Конфиденциальность']")
	private WebElement privacyBar;

	@FindBy(xpath = "//input[@name='personalForm.name']")
	private WebElement firstNameInputField;

	@FindBy(xpath = "//input[@name='personalForm.surname']")
	private WebElement surnameInputField;

	@FindBy(xpath = "//input[@name='personalForm.birthyear']")
	private WebElement birthYearInputField;

	@FindBy(xpath = "//input[@name='personalForm.site']")
	private WebElement siteInputField;

	@FindBy(xpath = "//input[@name='personalForm.company']")
	private WebElement companyInputField;

	@FindBy(xpath = "//textarea[@name='personalForm.about']")
	private WebElement aboutInputField;

	@FindBy(xpath = "//input[@name='personalForm.save']")
	private WebElement personalDataSaveButton;
	
	@FindBy(xpath = "//input[@name='notificationsForm.save']")
	private WebElement notificationsSaveButton;
	
	@FindBy(xpath = "//input[@name='privacyForm.save']")
	private WebElement privacySaveButton;	

	@FindBy(xpath = "//select[@name='personalForm.countryId']")
	private WebElement countrySelectField;

	@FindBy(xpath = "//select[@name='personalForm.countryId']/*")
	private List<WebElement> countryOptionsList;

	@FindBy(xpath = "//select[@name='personalForm.cityId']")
	private WebElement citySelectField;

	@FindBy(xpath = "//select[@name='personalForm.cityId']/*")
	private List<WebElement> cityOptionsList;

	@FindBy(xpath = "//select[@name='personalForm.zone']")
	private WebElement timeZoneSelectField;

	@FindBy(xpath = "//select[@name='personalForm.zone']/*")
	private List<WebElement> timeZoneOptionsList;
	
	@FindBy(xpath = "//div[@id='profile-notifications-form']//*[contains(@name, '.notifications')]")
	private WebElement notificationsCheckbox;
	
	@FindBy(xpath = "//div[@id='profile-notifications-form']//*[contains(@name, '.delivery')]")
	private WebElement deliveryCheckbox;
	
	@FindBy(xpath = "//input[@name='privacyForm.profileVisibility' and @value='closed']")
	private WebElement onlyMeRadioButton;
	
	@FindBy(xpath="//a[@href='/LoginAction.doLogout']")
	private WebElement logoutButton;
	
	private String countryOptionRegExp = "//select[@name='personalForm.countryId']/option[text()='%s']";
	private String cityOptionRegExp = "//select[@name='personalForm.cityId']/option[text()='%s']";
	private String timeZoneOptionRegExp = "//select[@name='personalForm.zone']/option[text()='%s']";

	public ProfileActionPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		logger.info("Navigating to " + BASE_URL);
	}

	public void expandPersonalInfo() {
		personalInfoBar.click();
	}

	public void expandNotifications() {
		notificationsBar.click();
	}
	
	public void expandPrivacy() {
		privacyBar.click();
	}

	public void fillNameField(String name) {
		firstNameInputField.sendKeys(name);
	}

	public void fillSurnameField(String surname) {
		surnameInputField.sendKeys(surname);
	}

	public void fillBirthYearField(String birthYear) {
		birthYearInputField.sendKeys(birthYear);
	}

	public void fillSiteField(String site) {
		siteInputField.sendKeys(site);
	}

	public void fillCompanyField(String company) {
		companyInputField.sendKeys(company);
	}

	public void fillAboutField(String about) {
		aboutInputField.sendKeys(about);
	}

	public void clickPersonalDataSaveButton() {
		personalDataSaveButton.click();
	}
	
	public void clickNotificationosFormSaveButton() {
		notificationsSaveButton.click();
	}
	
	public void clickPrivacyFormSaveButton() {
		new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(privacySaveButton)).click();
	}

	public void clickCountrySelect() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(countrySelectField)).click();
	}

	public void clickCitySelect() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(citySelectField)).click();
	}

	public void clickTimeZoneSelect() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(timeZoneSelectField)).click();
	}

	public List<String> getOptionsList(List<WebElement> optionsList) {
		List<String> optionsNamesList = new ArrayList<String>();
		for (WebElement option : optionsList) {
			if (!option.getText().equals("- выберите страну -") && !option.getText().equals("- другой -")) {
				optionsNamesList.add(option.getText());
			}
		}
		return optionsNamesList;
	}

	public String getRandomOption(List<WebElement> optionsList) {
		return Utils.getRandomOptionFromSelect(getOptionsList(optionsList));
	}

	public String clickRandomCountry() {
		String randomCountry = getRandomOption(countryOptionsList);
		driver.findElement(By.xpath(String.format(countryOptionRegExp, randomCountry))).click();
		clickCountrySelect();
		this.randomCountry = randomCountry;
		return randomCountry;
	}

	public String clickRandomCity() {
		String randomCity = getRandomOption(cityOptionsList);
		driver.findElement(By.xpath(String.format(cityOptionRegExp, randomCity))).click();
		clickCitySelect();
		this.randomCity = randomCity;
		return randomCity;
	}

	public String clickRandomTimeZone() {
		String randomTimeZone = getRandomOption(timeZoneOptionsList);
		driver.findElement(By.xpath(String.format(timeZoneOptionRegExp, randomTimeZone))).click();
		clickCitySelect();
		this.randomTimeZone = randomTimeZone;
		return randomTimeZone;
	}

	public static String getRandomCountry() {
		return randomCountry;
	}

	public static String getRandomCity() {
		return randomCity;
	}

	public static String getRandomTimeZone() {
		return randomTimeZone;
	}

	public void clearProfile() {
		new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(firstNameInputField)).clear();
		surnameInputField.clear();
		birthYearInputField.clear();
		siteInputField.clear();
		companyInputField.clear();
		companyInputField.clear();
		aboutInputField.clear();
	}

	public void clickNotificationsCheckbox(){
		new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(notificationsCheckbox)).click();
	}
	
	public void clickDeliveryCheckbox(){
		new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(deliveryCheckbox)).click();
	}
	
	public boolean isCheckboxEnabled(WebElement checkbox){
		if (checkbox.getAttribute("checked") != null){
			return true;
		}
		return false;
	}
	
	public boolean isNotificationsCheckboxEnabled(){
		return isCheckboxEnabled(notificationsCheckbox);
	}
	
	public boolean isDeliveryCheckboxEnabled(){
		return isCheckboxEnabled(deliveryCheckbox);
	}
	
	public boolean isOnlyMeRadioButtonEnabled(){
		if (onlyMeRadioButton.getAttribute("checked") != null){
			return true;
		}
		return false;
	}
	
	public void clickOnlyMeRadioButton(){
		new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(onlyMeRadioButton)).click();

	}
	
	public void clickLogoutButton(){
		logoutButton.click();
	}

}
