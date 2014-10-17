package is.ru.stringcalculator;

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
		return numbers.split(",|\n");
	}
	
	private static int sum(String[] numbers){
		int total = 0;
		for(String number : numbers) {
			total += toInt(number);
		}
		return total;
	}
}