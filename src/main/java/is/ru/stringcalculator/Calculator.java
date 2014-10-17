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
		int total = 0;
		for(String number : numbers) {
			total += toInt(number);
		}
		return total;
	}
}