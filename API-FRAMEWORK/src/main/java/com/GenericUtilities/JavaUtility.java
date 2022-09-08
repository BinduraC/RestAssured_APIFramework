package com.GenericUtilities;

import java.util.Date;
import java.util.Random;


/**
 * 
 * @author Bindura
 *
 */
public class JavaUtility {

	/**
	 * This method is used to create a random number
	 * 
	 * @return format
	 */
	public int getRandomNum() {
		Random random = new Random();
		int randomNum = random.nextInt(1000);
		return randomNum;
	}
	/**
	 * Used to get date in MM YYYY DATE DAY TIME format
	 * @return
	 */
	public String getSystemDate() {
		Date date = new Date();
		String dateTime = date.toString();
		
		String[] dateArr = dateTime.split(" ");
		String MM = dateArr[1];
		String YYYY = dateArr[5];
		String DATE = dateArr[2];
		String DAY = dateArr[0];
		String TIME = dateArr[3];
		
		String format = MM+" "+YYYY+" "+DATE+" "+DAY+" "+TIME;
		return format;
	}
	
	
}
