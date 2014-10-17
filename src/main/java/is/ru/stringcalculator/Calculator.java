package is.ru.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	
	private final static String delimiter = ",|\n";
	
	public static int add(String text) {
		
		if (text.isEmpty()) {
			return 0;
		}
		else if (text.contains(delimiter)){
			return sum(splitNumbers(text));
		}
		return sum(splitNumbers(text));
	}

	private static int toInt(String number) {
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		if (numbers.startsWith("//")) {
			Matcher match;
			match = Pattern.compile("//(.)\n(.*)").matcher(numbers);
			match.matches();
			return match.group(2).split(match.group(1));
		}
		return numbers.split(delimiter);
	}
	
	private static int sum(String[] numbers){
		if (containsNegatives(numbers)) {
			negativeNumbersCheck(numbers);
		}
		
		int total = 0;
		for(String number : numbers) {
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