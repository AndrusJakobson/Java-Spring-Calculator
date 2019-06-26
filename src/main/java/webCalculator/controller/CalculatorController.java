package webCalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import calculation.Calculator;
import factory.CalculatorFactory;
import webCalculator.CalculationResponse;
import webCalculator.CalculatorData;
import webCalculator.CalculationModel;


@Controller
@RequestMapping("/")
public class CalculatorController {
	CalculatorData calculatorData;
	
	@GetMapping
	public String getIndex() {
		calculatorData = new CalculatorData();
		return "index";
	}
	
	@PostMapping(value = "calculate")
	@ResponseBody
	public CalculationResponse getCalculation(@RequestBody CalculationModel model) {
		double result = model.getNumber();
		if(calculatorData.hasNumber()) {
			Calculator calculator = CalculatorFactory.getCalculator(calculatorData.getOperator());
			result = calculator.calculate(calculatorData.getNumber(), model.getNumber());
		}
		
		calculatorData.setNumber(result);
		calculatorData.setOperator(model.getOperator());
		
		CalculationResponse response = new CalculationResponse(result);
		return response;
	}
}
