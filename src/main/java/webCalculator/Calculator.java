package webCalculator;

import java.text.DecimalFormat;

public class Calculator {
	private static Calculator calculator;
	
	public static Calculator getCalculator() {
		if(calculator == null) {
			calculator = new Calculator();
		}
		return calculator;
	}
	
	public String getResult(int number1, int number2, String operator) {
		double result;
		switch(operator) {
			case "-":
				result = number2 - number1;
				break;
			case "/":
				result = number2 / number1;
				break;
			case "*":
				result = number2 * number1;
				break;
			case "C":
				return "";
			default:
				result = number2 + number1;
				break;
		}
		DecimalFormat format = new DecimalFormat("0.#");
		return format.format(result);
	}
}
