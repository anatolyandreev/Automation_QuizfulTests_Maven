package by.htp.quizful.utils;

import java.util.List;
import java.util.Random;

public class Utils {
	
	private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String DIGIT = "123456789";
	private static Random rnd = new Random();

	public static String getRandomString(int len)
	{
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
		{
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}
		return sb.toString();
	}
	
	public static String getRandomNumber(int len)
	{
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
		{
			sb.append(DIGIT.charAt(rnd.nextInt(DIGIT.length())));
		}
		return sb.toString();
	}
	
	public static String getRandomOptionFromSelect(List<String> optionsList){
		return optionsList.get(rnd.nextInt(optionsList.size()));
	}

}
