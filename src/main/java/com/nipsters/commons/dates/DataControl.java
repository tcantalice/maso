package com.nipsters.commons.dates;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DataControl {
public static LocalDate formatData(String data) throws IllegalArgumentException {
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		if(data.indexOf('-') != -1 || data.indexOf('.') != -1) {
			data = String.format("%s/%s/%s", data.substring(0,2), data.substring(3,5), data.substring(6));
		}
		
		LocalDate currentDate = null;;
		
		try {
			currentDate = LocalDate.parse(data, format);
		}catch(DateTimeParseException e) {
			throw new IllegalArgumentException();
		}
		
		return currentDate;
	}
	
	public static boolean compareByinterval (LocalDate data, int max) {
		
		boolean result = false;
		
		if(data.getYear() <= LocalDate.now().getYear()) {
				
				if((data.getDayOfYear() - LocalDate.now().getDayOfYear()) <= max) {
					result = true;
				}else {
					result = false;
				}
		}else {
			result = false;
		}
		return result;
	}
	
	public static int birthdayDate(LocalDate birthDate) {
		return LocalDate.now().compareTo(birthDate);
	}
}
