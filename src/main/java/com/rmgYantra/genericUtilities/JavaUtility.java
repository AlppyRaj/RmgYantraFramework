package com.rmgYantra.genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber() {
		
		Random rNumber = new Random();
		int ranNumber = rNumber.nextInt(10000);
		return ranNumber;
		
	}
	
	public String getRandomAlphabet(int length) {
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
	        sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
	    }

		return sb.toString();
		
	}
	
	
	public String getCurrentDate() {
		
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
		String currentDate = sim.format(date);
		return currentDate;
		
	}
	
	public String toGetReqDate(int days)
	{
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
		sim.format(date);
		Calendar cal = sim.getCalendar();
		cal.add(cal.DAY_OF_MONTH, days);
		String reqDate = sim.format(cal.getTime());
		return reqDate;
		
		
	}

}
