package by.htp.quizful.data;

import java.util.ArrayList;
import java.util.List;

import by.htp.quizful.pages.ProfileActionPage;
import by.htp.quizful.utils.Utils;

public class RandomDataSet {
	public static final String RANDOM_NAME = "name" + Utils.getRandomString(4);
	public static final String RANDOM_SURNAME = "surname" + Utils.getRandomString(4);
	public static final String RANDOM_YEAR = Utils.getRandomNumber(4);
	public static final String RANDOM_SITE = "site" + Utils.getRandomString(4);
	public static final String RANDOM_COMPANY = "company" + Utils.getRandomString(4);
	public static final String RANDOM_ABOUT = "about" + Utils.getRandomString(4);
	private static List<String> expectedDataList;
	
	public static List<String> getExpectedDataList() {
		expectedDataList = new ArrayList<String>();
		expectedDataList.add(RANDOM_NAME+ " " + RANDOM_SURNAME);
		expectedDataList.add(RANDOM_YEAR);
		expectedDataList.add(RANDOM_SITE);
		expectedDataList.add(RANDOM_ABOUT);
		expectedDataList.add(ProfileActionPage.getRandomCity() + " (" + ProfileActionPage.getRandomCountry() + ")");
		expectedDataList.add(ProfileActionPage.getRandomTimeZone());
		return expectedDataList;
	}
}
