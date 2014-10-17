package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {
	
	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
	}
	
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}
		@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}
		@Test
	public void testOneTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testMultipleNumber1(){
		assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test
	public void testMultipleNumbers2(){
		assertEquals(10, Calculator.add("1,1,1,1,1,1,1,1,1,1"));
	}

	@Test
	public void testHandleNewLines() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}

	@Test
	public void testHandleDifferentDelimiter() {
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	@Test
	public void testNegativeNubersException1() {
		try {
			Calculator.add("-1,2");
		}
		catch (RuntimeException e){
			assertEquals("Negatives not allowed: -1", e.getMessage());
		}
	}

	@Test
	public void testNegativeNubersException2() {
		try {
			Calculator.add("2,-4,3,-5");
		}
		catch (RuntimeException e){
			assertEquals("Negatives not allowed: -4,-5", e.getMessage());
		}
	}

}