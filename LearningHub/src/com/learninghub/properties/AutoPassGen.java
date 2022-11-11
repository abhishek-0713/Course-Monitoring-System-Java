package com.learninghub.properties;

import java.util.Random;

public class AutoPassGen {
	
	public static String generatepass(int p) {
		String s = generatepassword(p);
		return s;
	}

	private static String generatepassword(int plength) {
		// TODO Auto-generated method stub
		String lowerCase = "abcdefghijklmnopqrstuvwxyz";
		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String specialCase = "!@#$%^&*";
		String nums = "1234567890";
		String combinations = lowerCase + upperCase + specialCase + nums;
		Random random = new Random();
		char[] password = new char[plength];
		
		password[0] = lowerCase.charAt(random.nextInt(lowerCase.length()));
		password[1] = upperCase.charAt(random.nextInt(upperCase.length()));
		password[2] = specialCase.charAt(random.nextInt(specialCase.length()));
		password[3] = nums.charAt(random.nextInt(nums.length()));

		for(int i=4; i < plength; i++) {
			password[i] = combinations.charAt(random.nextInt(combinations.length()));
		}
		
		String pwd = new String(password);
		
		return pwd;
	}

}
