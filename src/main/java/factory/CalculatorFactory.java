package factory;

import calculation.Calculator;
import calculation.CalculatorAdd;
import calculation.CalculatorDivide;
import calculation.CalculatorMultiply;
import calculation.CalculatorSubtract;

public class CalculatorFactory {
		public static Calculator getCalculator(String operator) {
			switch(operator) {
				case "+": 
					return new CalculatorAdd();
				case "-":
					return new CalculatorSubtract();
				case "/":
					return new CalculatorDivide();
				case "*":
					return new CalculatorMultiply();
			}
			return null;
		}
}
