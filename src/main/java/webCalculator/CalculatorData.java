package webCalculator;

public class CalculatorData {
	private Double number;
	private String operator;
	
	public void setNumber(double number) {
		this.number = number;
	}
	
	public double getNumber() {
		return number;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public String getOperator() {
		return operator;
	}
	
	public boolean hasNumber() {
		return number != null;
	}
}
