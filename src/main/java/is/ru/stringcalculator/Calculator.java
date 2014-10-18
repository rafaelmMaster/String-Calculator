package is.ru.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	
	public static int add(String text) {
		
		String regex = ",";
		
		if (text.isEmpty()) {
			return 0;
		}
		if(text.startsWith("//")){
			if(text.charAt(2) == '[') {
				for (int j = 2; j < text.length(); j++) {
					if (text.charAt(j) == ']') {
						regex = text.substring(j-3, text.indexOf(']', j));
					}
				}
			} 
			else {
				regex = String.valueOf(text.charAt(2));
			}
			
			text = text.substring(text.indexOf('\n') + 1);
			return sum(splitNumbers(text, regex));
		}
		else if (text.contains(regex)){
			return sum(splitNumbers(text, regex));
		}
		return sum(splitNumbers(text, regex));
	}

	private static int toInt(String number) {
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers, String regex){
		return numbers.split("\\Q" + regex + "\\E|\n"); 
	}
	
	private static int sum(String[] numbers){
		if (containsNegatives(numbers)) {
			negativeNumbersCheck(numbers);
		}
		
		int total = 0;
		for(String number : numbers) {
			if (toInt(number) > 1000) {
				continue;
			}
			total += toInt(number);
		}
		return total;
	}
	
	private static boolean containsNegatives(String[] numbers) {
		for(String num : numbers) {
			if (toInt(num) < 0) {
				return true;
			}
		}
		return false;
	}
	
	private static void negativeNumbersCheck(String[] numbers) {
		int[] negatives = new int[numbers.length];
		int x = 0;

		for (int i = 0; i < numbers.length; i++) {
			if (toInt(numbers[i]) < 0) {
				negatives[x] = toInt(numbers[i]);
				x++;
			}
		}
		String neg = Integer.toString(negatives[0]);
		for (int j = 1; j < x; j++) {
			neg += "," + Integer.toString(negatives[j]); 
		}
		throw new RuntimeException("Negatives not allowed: " + neg);
	}
	
	private static boolean isNegative(String numbers) {
		return toInt(numbers) < 0;
	}
}