package by.htp.quizful;

import static org.testng.Assert.assertEquals;
import static by.htp.quizful.data.RandomDataSet.*;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.htp.quizful.data.RandomDataSet;
import by.htp.quizful.driver.DriverSingleton;
import by.htp.quizful.pages.GmailInboxPage;
import by.htp.quizful.pages.MainPage;
import by.htp.quizful.steps.Steps;
import by.htp.quizful.utils.Utils;

public class QuizfulTests {
	
	private final static String RANDOM_LOGIN = "testLogin" + Utils.getRandomString(4);
	private final static String RANDOM_PASSWORD = "password" + Utils.getRandomString(3);
	private final static String RANDOM_EMAIL = "tathtp7+" + Utils.getRandomString(3) + "@gmail.com";
	private boolean isCorporate = true;
	private final String testLogin = "testUser7";
	private final String testPassword = "Epam12345N";
	
	private WebDriver driver;
	private Steps steps;
	
	@BeforeTest
	public void testSetup() {
		steps = new Steps();
		driver = steps.initBrowser();
	}
	
	@AfterTest
	public void afterTest(){
		steps.closeDriver();
	}
	
  @Test
  public void checkRegistrationPassed(){
	  steps.fillRegistrationForm(RANDOM_LOGIN, RANDOM_PASSWORD, RANDOM_EMAIL, isCorporate);
	  steps.confirmEmail();
	  ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	  driver.switchTo().window(tabs.get(1));
	  assertEquals(steps.getUserNicknameFromUserPanel(), RANDOM_LOGIN);
  }
  
  @Test
  public void checkPersonalDataSaved(){
	  steps.loginToTheSystem(testLogin, testPassword);
	  assertEquals(steps.getUserNicknameFromUserPanel(), testLogin);
	  steps.openUserProfile();
	  steps.openEditProfileScreen();
	  steps.expandPersonalInfoSection();
	  steps.fillPersonalDataSection(RANDOM_NAME, RANDOM_SURNAME, RANDOM_YEAR, RANDOM_SITE, RANDOM_COMPANY, RANDOM_ABOUT);
	  assertEquals(steps.getActualPersonalData(), getExpectedDataList());
	  steps.openEditProfileScreen();
	  steps.expandPersonalInfoSection();
	  steps.clearPersonalData();
  }
  
}